/**
 * Julian A. P.
 * customer
 * */
package bis;
import java.sql.*;
public class customer {
    //var
    private String id;
    private String pwd;
    private String fName;
    private String lName;
    private String state;
    private String eMail;
    public userAccs accList = new userAccs();
    //default var
    public customer(){
        id = "";
        pwd = "";
        fName = "";
        lName = "";
        state = "";
        eMail = "";
    }
    //getter and setter for all var
    public String getId(){
        return id;
    }
    public void setId(String custId){
        id = custId;
    }
    
    public String getPwd(){
        return pwd;
    }
    public void setPwd(String custPwd){
        pwd = custPwd;
    }
    
    public String getFName(){
        return fName;
    }
    public void setFName(String custFName){
        fName = custFName;
    }
    
    public String getLName(){
        return lName;
    }
    public void setLName(String custLName){
        lName = custLName;
    }
    
    public String getState(){
        return state;
    }
    public void setState(String custState){
        state = custState;
    }
    
    public String getEMail(){
        return eMail;
    }
    public void setEMail(String custEMail){
        eMail = custEMail;
    }
    //gets the next customer id for a new customer that will be added to the database. limit 10000
    public void getUnusedID(){
        try{
		//load driver
            String file = "jdbc:ucanaccess://C:/Users/GhostBit/Desktop/git/schoolBankWebApp/Database/BlankBank.mdb";
            Connection con = DriverManager.getConnection(file);
		//statement
            Statement stmt = con.createStatement();
            String sql;
            sql = ("SELECT CustID FROM Customers Where CustID = (SELECT MAX(CustID) FROM Customers)");
            System.out.println(sql);
            ResultSet rs;
		//excute
            rs = stmt.executeQuery(sql);
		//process
            while(rs.next()){
                id = rs.getString("CustID");
		}
		//close
                con.close();
	}
	catch(SQLException e){
            System.out.println("PP: "+e);
        }
        //converts result from string to int. adds 1 and converts back into a string.
        int i = 0;
        i = Integer.parseInt(id) + 1;
        id = Integer.toString(i);
        System.out.println(i);
    }
    //display var to make user everything is right, when testing 
    public void display(){
        System.out.println("Customer's id: "+id);
        System.out.println("Customer's password: "+pwd);
        System.out.println("Customer's first name: "+fName);
        System.out.println("Customer's last name: "+lName);
        System.out.println("Customer's state: "+state);
        System.out.println("Customer's e-mail: "+eMail);
        accList.display();
    }
    //selects a single customer from database when given a customer's id. and fills var with the values in the database.
    public void selectCust(String i){
            try{
		//load driver
            String file = "jdbc:ucanaccess://C:/Users/GhostBit/Desktop/git/schoolBankWebApp/Database/BlankBank.mdb";
            Connection con = DriverManager.getConnection(file);
		//statement
            Statement stmt = con.createStatement();
            String sql;
            sql = ("Select CustID, CustPassword, CustFirstName, CustLastName, CustAddress, CustEmail  From Customers Where CustID = '"+(i)+"'");
            System.out.println(sql);
            ResultSet rs;
		//excute
            rs = stmt.executeQuery(sql);
		//process
            while(rs.next()){
                //gets results and sets var with the given data
                id = rs.getString("CustID");
                pwd = rs.getString("CustPassword");
                fName = rs.getString("CustFirstName");
                lName = rs.getString("CustLastName");
                state = rs.getString("CustAddress");
                eMail = rs.getString("CustEmail");
		}
		//close
                con.close();
	}
	catch(SQLException e){
            System.out.println("Database: 'BUZZ, the beep ba boop didb't work, <select customer>");
            System.out.println("XoX^hep ne plz");
            System.out.println("PP: "+e);
        }
        getAccount();
    }
    //gets a list of the customer's accounts.
    public void getAccount(){
         try{
		//load driver
            String file = "jdbc:ucanaccess://C:/Users/GhostBit/Desktop/git/schoolBankWebApp/Database/BlankBank.mdb";
            Connection con = DriverManager.getConnection(file);
		//statement
            Statement stmt = con.createStatement();
            String sql;
            sql = ("Select AcctNo From Accounts Where Cid = '"+(id)+"'");
            System.out.println(sql);
            ResultSet rs;
		//excute
            rs = stmt.executeQuery(sql);
		//process
            String an;
            account a1;
            while(rs.next()){
                //takes the account number found in the database and calls the add method from accList and adds it to the array.
                an = rs.getString(1);
                a1 = new account();
                a1.selectAcc(an);
                accList.addAccount(a1);
		}
		//close
                con.close();
	}
		 catch(SQLException e){
			 System.out.println("PP: "+e);
		 }
    }
    //insert new customer to database
    public void insertCust(String CustID, String CustPwd, String CustFName, String CustLName, String CustState, String CustEMail){
        try{
                //load driver
            String file = "jdbc:ucanaccess://C:/Users/GhostBit/Desktop/git/schoolBankWebApp/Database/BlankBank.mdb";
            Connection con = DriverManager.getConnection(file);
		//statement
            Statement stmt = con.createStatement();
            String sql;
            sql = ("INSERT INTO Customers (CustID, CustPassword, CustFirstName, CustLastName, CustAddress, CustEmail)" +
                    "VALUES ('"+CustID+"',"
                    + " '"+CustPwd+"',"
                    + " '"+CustFName+"',"
                    + " '"+CustLName+"',"
                    + " '"+CustState+"',"
                    + " '"+CustEMail+"');");
            System.out.println(sql);
            	//excute
            stmt.executeUpdate(sql);
		//process
            System.out.println("Row has been inserted, I hope.");
            //sets the values of the var after its been added to the database
            id = CustID;
            pwd = CustPwd;
            fName = CustFName;
            lName = CustLName;
            state = CustState;
            eMail = CustEMail;
            //close con
            con.close();
        }
        catch(SQLException e){
            System.out.println("Database: 'BUZZ BUZZ, the beep ba boop didb't work, <insert customer>");
            System.out.println("XoX^hep ne plz");
            System.out.println("PP: "+e);
        }
    }
    //update customer in database
    public void updateCust(){
        try{
                //load driver
            String file = "jdbc:ucanaccess://C:/Users/GhostBit/Desktop/git/schoolBankWebApp/Database/BlankBank.mdb";
            Connection con = DriverManager.getConnection(file);
		//statement
            Statement stmt = con.createStatement();
            String sql;
            sql = ("Update Customers set CustPassword = '"+pwd+
                       "', CustFirstName = '"+fName+
                       "', CustLastName = '"+lName+
                       "', CustAddress = '"+state+
                       "', CustEmail = '"+eMail+
                       "' Where CustID = '"+id+"'");
            System.out.println(sql);
		//excute
            stmt.executeUpdate(sql);
            System.out.println("Row has been updated, I hope.");
		//close
            con.close();
        }
        catch(SQLException e){
            System.out.println("Database: 'BUZZ BUZZ BUZZ, the beep ba boop didb't work, <update customer>");
            System.out.println("XoX^hep ne plz");
            System.out.println("PP: "+e);
        }
    }
    //main used for testing without run whole project
    public static void main(String[] args) {
       customer v = new customer();
       v.selectCust("3001");
       v.display();
    }
}
