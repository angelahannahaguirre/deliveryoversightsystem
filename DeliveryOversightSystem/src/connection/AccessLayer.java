/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import deliveryoversightsystem.loginModule;
import deliveryoversightsystem.systemAdmin.LogDetails;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.OptionPane;

/**
 *
 * @author Administrator
 */
public class AccessLayer {
    
    private static AccessLayer instance;

    //parameters/values that will be used to create the connection to the database
    
    public String database = "dos_db", host = "localhost", port = "3306"; //used inside Configurations.class
    //public final String user = "username", password = "password";
    
    Connection connect = null;
    Statement statement = null;
    
    /**
     * get the instance of this class, if it is null, a new AccessLayer is called
     * @return the instance of this class
     */
    public static AccessLayer getInstance(){
        if(instance == null)
            instance = new AccessLayer();
        return instance;
    }
    
    

    /** Creates a new connection to the database using the given host, port number, database, user and password then produces a statement
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException */
    public void createConnection() throws ClassNotFoundException, SQLException {
      
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();  
            connect = DriverManager.getConnection("jdbc:mysql://localhost/dos_db","root","password");  
            statement = connect.createStatement();
            System.out.println("Connected to the database");
            
        }catch (Exception e) {
              System.out.println("NO CONNECTION...");
              
        }
        
    }
    
    /**
     * insert, update, and delete something in a database in MySQL
     * @param update
     * @throws SQLException 
     */
    public void update(String update) throws SQLException
    {
        statement.executeUpdate(update);
    }

    /**
     * connect to the database to get the resultset of the query
     * @param query
     * @return the resultset produces by the query
     * @throws SQLException 
     */
    public ResultSet Retrieve(String query) throws SQLException
    {     
        ResultSet rs = statement.executeQuery(query);
        return rs;
    }


    /**
     * close the connection to MySQL
     */
    public void closeConnection()
    {
        try
        {
            if(connect != null)
                connect.close();
        }
        catch(SQLException error)
        {
            addToERRORLog(error.getLocalizedMessage());
        }
    }
    
    /**
     * a transaction update where if the update fails, it will rollback to the previous state of the database and if not,
     * the changes will be committed.
     * @param update
     * @return true if the update was successful and false if not
     */
    public boolean makeUpdate(String update){
        
        try {
            createConnection();
            connect.setAutoCommit(false);
            update(update);
            connect.commit();
            closeConnection();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            if(connect != null){
                try {
                    connect.rollback();
                } catch (SQLException ex1) {
                    addToERRORLog(ex.getLocalizedMessage());
                }
            }
            addToERRORLog(ex.getLocalizedMessage());
        }
        return false;
    }
    
    /**
     * add the localizedMessage of the error to the local file error_log.err 
     * @param localizedMessage 
     */
    public void addToERRORLog(String localizedMessage) {
        Date date = new Date();
        Format dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String curDate = dateFormat.format(date);
        File file = new File("error_log.err");
        if(!file.exists())
            try {
                file.createNewFile();
            } catch (IOException ex) {
                return;
            }
        FileWriter write;
        BufferedWriter out;
        try {
            write = new FileWriter(file, true);
            out = new BufferedWriter(write);
            out.append("\n"+curDate+": "+localizedMessage);
            out.close();
            write.close();
        } catch (IOException ex) {
            Logger.getLogger(AccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * just a method for the logger of netbeans with a prompt
     * @param msg
     * @param ex 
     */
    private void Logger(String msg, Object ex){
        Logger.getLogger(AccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        OptionPane.error(msg);
    }
    
    /**
     * compose a query based on the given parameters and return the resultset given by the Retrieve method
     * @param employeeCondition the condition for the Employee table
     * @param consultationCondition the condition for the Consultation table
     * @param i the type of search; if i == 0 then the query is getting all the reports else if i != 0 then a query is produced based on the employeeCondition and consultationCondition
     * @return the result set of the query for the report
     */
    public ResultSet getReport(String employeeCondition, String consultationCondition, int i){
        String finalQuery = "select E.employee_id, E.Last_Name, E.First_Name, C.Consultant_ID, "
                + "E.division, E.Gender, C.date, C.time, C.Diagnosis, C.Prescription, C.Symptoms, C.vital_signs from employee as E join consultation as C on E.employee_id = C.employee_id "+(i==1?" where "+
                (!employeeCondition.isEmpty()?employeeCondition:"")+(!employeeCondition.isEmpty() && !consultationCondition.isEmpty()?" AND ":"")+consultationCondition:";");
        try {
            createConnection();
            return Retrieve(finalQuery);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AccessLayer.class.getName()).log(Level.SEVERE, null, ex);
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }

    /**
     * inserts backslash before the symbols " ' " , "\" and ";" to avoid SQL syntax error and SQL injection
     * @param str input string
     * @return the output string with backslash
     */
    private String insertBackslash(String str){
        String output = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='\'' || str.charAt(i)=='\\' || str.charAt(i)==';')
                output+="\\";
            output+=str.charAt(i);
        }
        return output;
    }

    
    /**
     * get the user/consultant from the database using the username, password and usertype<br>
     * this method is used when logging in
     * @param password
     * @param userID
     * @return the resultset of the consultants with the usertype, password and username
     */
    public ResultSet getUser(String password, String userID){
        String status = "active";
        try {
            
            String credentials="SELECT * FROM user_account WHERE employeePword = '" +insertBackslash(password)+ "' and " + "employeeID = '"+insertBackslash(userID)+"' and " + "userStatus = '"+insertBackslash(status)+"'";
            createConnection();
            ResultSet rs = Retrieve(credentials);
            return rs;
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            addToERRORLog(ex.getLocalizedMessage());
            Logger("Something went wrong. Failed to check if the user exists.", ex);
            
        }
        return null;
    }
    
    /**
     * USE THIS FOR THE CHANGE PASSWORD FUNCTION - ANGELA OCT.27
     * get the user/consultant from the database using the username, question and answer<br>
     * this method is used when a user forgot his/her password
     * @param username
     * @param question
     * @param answer
     * @param i used to differentiate this method with the other getUser method since they have the same parameter types
     * @return the resultset of the consultants with the username, question and answer
     */
    public ResultSet getUser2(String username, String question, String answer, int i) {
        try {
            String credentials="SELECT * FROM consultant WHERE username='"+insertBackslash(username)+"' and question = '" +insertBackslash(question)
                    + "' and Answer = PASSWORD('" + insertBackslash(answer)+ "')";
            createConnection();
            ResultSet rs = Retrieve(credentials);
            return rs;
        } catch (ClassNotFoundException | SQLException ex) {
            addToERRORLog(ex.getLocalizedMessage());
            Logger("Something went wrong. Failed to check if the user exists.", ex);
        }
        return null;
    }
    
    /*******************************
     * end of Consultant methods
     *******************************/
    
    
    /**************************************
     * Start of Create User Account methods
     *************************************/
    
    /**
     * add data into user_account
     * @param empID
     * @param empPword
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param position
     * @param status
     * @return 
     */

    public boolean addNewUser(String empID, String firstName, String lastName, String empPword, 
            String birthDate, String position, String status) {
        
      
       
            boolean success = makeUpdate("insert into user_account values ('"+insertBackslash(empID)+"',"
                        + "'"+insertBackslash(firstName)+"','"+insertBackslash(lastName)+"','"+insertBackslash(empPword)+"',"
                        + "'"+insertBackslash(birthDate)+"','"+insertBackslash(position)+"','"+insertBackslash(status)+"');");
       
                    if(success)
                        //LogDetails.addToDatabase(loginModule.userType+" "+loginModule.currentUser+" added New User Account Details with Employee ID : "+empID+".");
                        JOptionPane.showMessageDialog(null,"Successfully Created User Account, "+empID);
                        return success;
    
    }
    
    /**
     * get the resultset of all the users found in the database
     * @return the resultset of all the users in the database
     */
    
    
    public ResultSet getAllUsers() {
        try {
            createConnection();
            return Retrieve("select * from user_account");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }

    
    /**
     * added by angela 11.9.16
     * @param optionValue
     * @param searchData
     * @return 
     */
    public ResultSet getAllUsersWithSearch(String optionValue, String searchData) {
        try {
            createConnection();
            
            //currently added 12-6-16 @ 12AM by angela
            return Retrieve("select * from user_account where "+optionValue+" = '"+insertBackslash(searchData)+"' ");
            //ends here
        }catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        
        return null;
    }
    
    
    /*****************
     * Log Details
     *****************/
    
    /**
     * add a new log detail to the database with the corresponding date, time and the log info
     * @param date
     * @param time
     * @param log 
     */
    public void addLog(String date, String time, String log) {
        makeUpdate("insert into log_details(`log`, `date`, `time`) values ('"+insertBackslash(log)+"','"+insertBackslash(date)+"','"+insertBackslash(time)+"');");
    }
    
    /**
     * get the resultset of all the logs inside the database
     * @return the resultset of all the logs inside the database
     */
    public ResultSet getAllLogs() {
        try {
            createConnection();
            return Retrieve("select * from log_details");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    /**
     * get the resultset of all the logs that satisfies the condition
     * @param condition the date and time of the log
     * @return the resultset of all the logs that satisfies the condition
     */
    public ResultSet searchLogs(String condition) {
        try {
            createConnection();
            return Retrieve("select * from log_details where "+condition);
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    /******************
     * Back Up Details
     *****************/
    
    /**
     * add a new backup detail to the database with the corresponding date, time and the file path.<br>
     * @param date
     * @param time
     * @param path
     * @return true if the operation was successful otherwise false
     */
    public boolean addBackup(String date, String time, String path) {
        time = time.replace("-", ":");
        boolean success = makeUpdate("insert into backup_details values('"+insertBackslash(date)+"','"+insertBackslash(time)+"','"+insertBackslash(path)+"');");
        if(success)
            model.LogDetails.addToDatabase("A backup was saved in "+getComputerName()+"-"+path);
        return success;
    }
    
    /**
     * get the computer name of the computer being used
     * @return the name of the computer
     */
    private String getComputerName() {
        String hostname = "Unknown";
        try
        {
            InetAddress addr;
            addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            addToERRORLog("Hostname can not be resolved");
        }
        return hostname;
    }
    
    /**
     * get resultset of all the backup details from the database
     * @return the resultset of all the backup details from the database
     */
    public ResultSet getAllBackups() {
        try {
            createConnection();
            return Retrieve("select * from backup_details");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    /** 
     * get the resultset of the backup details that satisfies the condition
     * @param condition the date and time of the backup
     * @return the resultset of the backup details that satisfies the condition
     */
    public ResultSet searchBackups(String condition) {
        try {
            createConnection();
            return Retrieve("select * from backup_details where "+condition);
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    /***********************************************
     * Start of Add Item to Delivery List methods
     ***********************************************/
    
    /**
     * add data into delivery
     * @param purchaseNo
     * @param purchaserName
     * @param suppName
     * @param faxedDate
     * @param deliveryStat
     * @param followUpFlag
     * @return 
     */

    public boolean addNewItem(String purchaseNo, String purchaserName, String suppName, String faxedDate, 
            String deliveryStat, String followUpFlag) {
        
      
       
            boolean success = makeUpdate("insert into delivery values ('"+insertBackslash(purchaseNo)+"',"
                        + "'"+insertBackslash(purchaserName)+"','"+insertBackslash(suppName)+"','"+insertBackslash(faxedDate)+"',"
                        + "'"+insertBackslash(deliveryStat)+"','"+insertBackslash(followUpFlag)+"');");
       
                    if(success)
                        //LogDetails.addToDatabase(loginModule.userType+" "+loginModule.currentUser+" added New User Account Details with Employee ID : "+empID+".");
                        JOptionPane.showMessageDialog(null,"Successfully Added Item#"+purchaseNo+" To Delivery List!");
                            return success;
    
    }
    
    /**
     * added by angela 12.6.16
     * @param optionValue
     * @param searchData
     * @return 
     */
    public ResultSet getAllDeliveryUpdatesWithSearch(String optionValue, String searchData) {
        try {
            createConnection();
            
            //currently added 12-6-16 @ 12AM by angela
            return Retrieve("select * from delivery where "+optionValue+" = '"+insertBackslash(searchData)+"' ");
            //ends here
        }catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        
        return null;
    }
    
    
    /**
     * get the resultset of all the delivery found in the database
     * @return the resultset of all the delivery in the database
     */
    
    
    public ResultSet getAllInvoiceInDB() { //displays the delivery added items in PH
        try {
            createConnection();
            return Retrieve("select * from delivery");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    /**
     * add data into invoice
     * @param invoiceNo
     * @param purchaseNo
     * @param invoiceDate
     * @param dateDelivered
     * @param manualDate
     * @param electronicDate
     * @param referenceRRNo
     * @param dateForwarded
     * @return 
     */

    public boolean addNewInvoice(String invoiceNo, String purchaseNo, String invoiceDate, String dateDelivered, String manualDate, 
            String electronicDate, String referenceRRNo, String dateForwarded) {
        
      
       
            boolean success = makeUpdate("insert into invoice values ('"+insertBackslash(invoiceNo)+"','"+insertBackslash(purchaseNo)+"',"
                        + "'"+insertBackslash(invoiceDate)+"','"+insertBackslash(dateDelivered)+"','"+insertBackslash(manualDate)+"',"
                        + "'"+insertBackslash(electronicDate)+"','"+insertBackslash(referenceRRNo)+"','"+insertBackslash(dateForwarded)+"');");
       
                    if(success)
                        //LogDetails.addToDatabase(loginModule.userType+" "+loginModule.currentUser+" added New User Account Details with Employee ID : "+empID+".");
                        JOptionPane.showMessageDialog(null,"Successfully Added Item/s with Invoice#"+invoiceNo+" To Delivery List!");
                            return success;
    
    }
    
    /**
     * add data into invoice_list 
     * @param purchaseOrderNo
     * @param invoiceNo
     * @return 
     */

    public boolean addNewBridge(String purchaseOrderNo, String invoiceNo) {
        
      
       
            boolean success = makeUpdate("insert into invoice_list values ('"+insertBackslash(purchaseOrderNo)+"',"
                        + "'"+insertBackslash(invoiceNo)+"');");
       
                    if(success)
                        //LogDetails.addToDatabase(loginModule.userType+" "+loginModule.currentUser+" added New User Account Details with Employee ID : "+empID+".");
                        JOptionPane.showMessageDialog(null,"Successfully Added Invoice#"+invoiceNo+" To Bridge List!");
                            return success;
    
    }
    
    
    
    /**
     * get the resultset of all the delivery and invoice found in the database
     * @return the resultset of all the delivery and invoice in the database
     */
    
    
    public ResultSet getAllUpdatesInDB() { //displays the delivery and invoices added
        try {
            createConnection();
            return Retrieve("select d.*, i.* from invoice i right join delivery d on d.purchaseOrderNo = i.purchaseOrderNo");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    /*************************
     * Edit User Account
     *************************/
    
    /**
     * @param empID
     * @return 
     */
    public ResultSet getPassword(String empID) {
        try {
            createConnection();
            return Retrieve("select employeePword from user_account where employeeID = '"+insertBackslash(empID)+"'");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    /**
     * @param empID
     * @return 
     */
    public ResultSet getLastname(String empID) {
        try {
            createConnection();
            return Retrieve("select lastName from user_account where employeeID = '"+insertBackslash(empID)+"'");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    /**
     * @param empID
     * @return 
     */
    public ResultSet getFirstname(String empID) {
        try {
            createConnection();
            return Retrieve("select firstName from user_account where employeeID = '"+insertBackslash(empID)+"'");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    /**
     * @param empID
     * @return 
     */
    public ResultSet getBdate(String empID) {
        try {
            createConnection();
            return Retrieve("select birthDate from user_account where employeeID = '"+insertBackslash(empID)+"'");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    /**
     * @param empID
     * @return 
     */
    public ResultSet getPosition(String empID) {
        try {
            createConnection();
            return Retrieve("select userType from user_account where employeeID = '"+insertBackslash(empID)+"'");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    /**
     * update the user's account detail with the given values
     
     * @param employeeID
     * @param firstName
     * @param lastName
     * @param emPword
     * @return true if the operation was successful otherwise false
     */
    
    public boolean updateUserAccountInDB(String employeeID, String firstName, String lastName, String emPword) {
        boolean success = makeUpdate("update user_account set firstName = '"+insertBackslash(firstName)+"'"
                + " where employeeID = '"+insertBackslash(employeeID)+"';");
                
        if(success)
            model.LogDetails.addToDatabase("Employee ID#"+employeeID+"'s information has been updated");
        return success;
        
    }
    
    /***
     * Deactivate Account
     */
    
     /**
     * update the user's account status with the given value "inactive"
     * @param empID
     * @return true if the operation was successful otherwise false
     */
    
    public boolean updateAccountStatusInDB(String empID) {
        
        String status = "inactive";
        
        boolean success = makeUpdate("update user_account set userStatus = '"+insertBackslash(status)+"' where employeeID = '"+insertBackslash(empID)+"';");
                
        if(success)
            model.LogDetails.addToDatabase("Employee ID#"+empID+"' has been deactivated"); 
        return success;
        
    }
    
    /**
     * get the resultset of all the delivery and invoice found in the database
     * @return the resultset of all the delivery and invoice in the database
     */
    
    
    //displays the delivery and invoices w/ respect to search
    /**
     * @param optionValue
     * @param searchData
     * @return 
     */
    
    public ResultSet getAllInvoiceUpdatesWithSearch(String optionValue, String searchData) { 
        try {
            createConnection();
            //fix to match the PurchaseOrderNo and InvoiceNo search functionality
            return Retrieve("select d.*, i.* from invoice i right join delivery d on d.purchaseOrderNo = i.purchaseOrderNo where i."+optionValue+" = '"+insertBackslash(searchData)+"' ");
        } catch (SQLException | ClassNotFoundException ex) {
            addToERRORLog(ex.getLocalizedMessage());
        }
        return null;
    }
    
    
}