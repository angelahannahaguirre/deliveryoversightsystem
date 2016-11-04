/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package others;

import connection.AccessLayer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.ini4j.Wini;
import view.OptionPane;
//import org.ini4j.Wini;
//import view.OptionPane;

/**
 *
 * @author Administrator
 */
public class Configurations {
    
    private static Configurations instance;
    
    /**
     * get the instance of Configurations
     * @return instance
     */
    public static Configurations getInstance(){
        if(instance == null)
            instance = new Configurations();
        return instance;
    }
    
    /**
     * create the config file if it does not exist then the database config
     */
    public void checkMyConfigs(){
        try {
            createConfigFile();
            checkDatabaseConfig();
        } catch (IOException ex) {
        }
    }
    
    /**
     * get the values of the attribute inside the config file's section
     * @param section
     * @param attribute
     * @return an array of string
     */
    public String[] getConfigValues(String section, String attribute){
        try {
            ArrayList<String> list = new ArrayList<>();
            File file = new File("dosdb_config.ini");
            if(!file.exists())
                createConfigFile();
            FileReader read;
            BufferedReader in;
            Wini ini = new Wini(new File("dosdb_config.ini-Copy"));
            String v = ini.get(section, attribute);
            String values[] = v.split(";");
            for (String value : values)
                if (!value.trim().isEmpty())
                    list.add(value.trim());
            if(list.isEmpty())
                return new String[]{""};
            String status[] = new String[list.size()];
            for(int i = 0; i < list.size(); i++)
                status[i] = list.get(i);
            return status;
        } catch (IOException ex) {
        }
        return new String[]{""};
    }
    
    /**
     * retrieves the values from the config and store it to the variables in the AccessLayer. 
     * After that, a test connection is carried out to determine if the application can
     * connect to the database using the values found in the config file.
     */
    private void checkDatabaseConfig() throws IOException{
        getDatabaseConfigValues(new Wini(new File("dosdb_config.ini")));
        if(!testConnectionSuccess()){
            OptionPane.error("Can't connect to the database. The program will now exit.");
            System.exit(0);
        }
    }
    
    /**
     * store the database config values to the access layer
     * @param file 
     */
    private void getDatabaseConfigValues(Wini ini) throws UnknownHostException, IOException {
        String section = "Database";
        String attributes[] = {"host IP","port number","database name"};
        String defaultValues[] = {Inet4Address.getLocalHost().toString().split("/")[1], "3306", "dos_db"};
        for(int i = 0; i < attributes.length; i++){
            String str = ini.get(section, attributes[i]);
            if(str == null || str.trim().isEmpty())
                ini.put(section, attributes[i], defaultValues[i]);
        }
        ini.store();
        AccessLayer.getInstance().host = ini.get(section, "host IP");
        AccessLayer.getInstance().port = ini.get(section, "port number");
        AccessLayer.getInstance().database = ini.get(section, "database name");
    }

    /**
     * test the connection to the database
     * @return true if successful else false
     */
    private boolean testConnectionSuccess() {
        try {
            AccessLayer.getInstance().createConnection();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * create the config file if it does not exist and populates it with default values
     */
    private void createConfigFile() {
        File file = new File("dosdb_config.ini-Copy");
        if(!file.exists()){
            String configs =
                            "# do not modify this unless authorized\n" +
                            "\n" +
                            "[Database]\n" +
                            "host IP = \n" +
                            "port number = 3306\n" +
                            "database name = dos_db\n" +
                            "\n" +
                            "# back up times\n" +
                            "[Backup-Times]\n" +
                            "times = 12:00\n" +
                            "\n" +
                            "# user types\n" +
                            "[User-Types]\n" +
                            "types = PH;WM;SA\n" +
                            "\n" +
                            "# employee status\n" +
                            "[Employee-Status]\n" +
                            "status = Active;Inactive\n" +
                            "\n" +
                            "# default picture location\n" +
                            "[Photo-Path]\n" +
                            "path = \\\\sphceb8000\\public\\_ProfessionalServices\\";
            createFile(file, configs);
        }
    }

    /**
     * creates the file and stores the content to the file
     * @param file
     * @param content 
     */
    private void createFile(File file, String content) {
        try {
            file.createNewFile();
            FileWriter out;
            BufferedWriter writer;
            out = new FileWriter(file, false);
            writer = new BufferedWriter(out);
            writer.write(content);
            writer.close();
            out.close();
        } catch (IOException ex) {}
    }

}
