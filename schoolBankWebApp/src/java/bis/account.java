/**
 * Julian A. P.
 * account
 * */
package bis;
import java.sql.*;
import java.text.DecimalFormat;
public class account {
    //var
    private String accNo;
    private String custId;
    private String accType;
    private double bal;
    private DecimalFormat df = new DecimalFormat("#.00");
    //default var
    public account(){
        accNo = "";
        custId = "";
        accType = "";
        bal = 0.0;
    }
    //getters and setter for all var
    public String getAccNo(){
        return accNo;
    }
    public void setAccNo(String aNo){
        accNo = aNo;
    }
    
    public String getCustId(){
        return custId;
    }
    public void setCustId(String cId){
        custId = cId;
    }
    
    public String getType(){
        return accType;
    }
    public void setType(String type){
        accType = type;
    }
    
    public double getBal(){
        return bal;
    }
    public void setBal(double mon){
        bal = mon;
    }
    //adds an amount of money to bal
     public double deposit(double amount){
	bal += amount;
	return bal;
    }
     //subtracts an amount of money to bal
    public double withdraw(double amount){
        if (amount <= bal){
		 bal -= amount;
	}
	else{
            System.out.println("Do don't have that much money!!");
	}
	 return bal;
    }
    //gets the next account number for a new account that will be added to the database. limit 100000
     public void getUnusedAccNo(){
        try{
		//load driver
            String file = "jdbc:ucanaccess://C:/Users/GhostBit/Desktop/git/schoolBankWebApp/Database/BlankBank.mdb";
            Connection con = DriverManager.getConnection(file);
		//statement
            Statement stmt = con.createStatement();
            String sql;
            sql = ("SELECT AcctNo FROM Accounts Where AcctNo = (SELECT MAX(AcctNo) FROM Accounts)");
            System.out.println(sql);
            ResultSet rs;
		//excute
            rs = stmt.executeQuery(sql);
		//process
            while(rs.next()){
                accNo = rs.getString("AcctNo");
		}
		//close
                con.close();
	}
	catch(SQLException e){
            System.out.println("PP: "+e);
        }
        //converts result from string to int. adds 1 and converts back into a string.
        int i = 0;
        i = Integer.parseInt(accNo) + 1;
        accNo = Integer.toString(i);
        System.out.println(i);
    }
    //display var to make user everything is right, when testing
    public void display(){
        System.out.println("~~~~~~~~~~~~Accounts~~~~~~~~~~~~~~ ");
        System.out.println("Account No: "+accNo);
        System.out.println("Customer's No: "+custId);
        System.out.println("Account type: "+accType);
        System.out.println("Account balance: $"+df.format(bal));
    }
    //selects a single account from database when given a account num. and fills var with the values in the database.
    public void selectAcc(String i){
        try{
		//load driver
            String file = "jdbc:ucanaccess://C:/Users/GhostBit/Desktop/git/schoolBankWebApp/Database/BlankBank.mdb";
            Connection con = DriverManager.getConnection(file);
		//statement
            Statement stmt = con.createStatement();
            String sql;
            sql = ("Select AcctNo, Cid, Type, Balance From Accounts Where AcctNo = '"+(i)+"'");
            System.out.println(sql);
            ResultSet rs;
		//excute
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                //gets results and sets var with the given data
                accNo = rs.getString("AcctNo");
                custId = rs.getString("Cid");
                accType = rs.getString("Type");
                bal = rs.getDouble("Balance");
            }
        }
        catch(SQLException e){
            System.out.println("Database: 'BUZZ, the beep ba boop didb't work, <select account>");
            System.out.println("XoX^hep ne plz");
            System.out.println("PP: "+e);
        }
    }
    //adds a new account to the database when given the valuse.
    public void insertAcc(String acc, String id, String t, double mon){
        try{
                //load driver
            String file = "jdbc:ucanaccess://C:/Users/GhostBit/Desktop/git/schoolBankWebApp/Database/BlankBank.mdb";
            Connection con = DriverManager.getConnection(file);
		//statement
            Statement stmt = con.createStatement();
            String sql;
            sql = ("INSERT INTO Accounts (AcctNo, Cid, Type, Balance)" +
                    "VALUES ('"+acc+"',"
                    + " '"+id+"',"
                    + " '"+t+"',"
                    + " '"+mon+"');");
            System.out.println(sql);
            	//excute
            stmt.executeUpdate(sql);
		//process
            System.out.println("Row has been inserted, I hope.");
            //sets the values of the var after its been added to the database
            accNo = acc;
            custId = id;
            accType = t;
            bal = mon;
            //close con
            con.close();
        }
        catch(SQLException e){
            System.out.println("Database: 'BUZZ BUZZ, the beep ba boop didb't work, <insert account>");
            System.out.println("XoX^hep ne plz");
            System.out.println("PP: "+e);
        }
    }
    //update an account in database
    public void updateAcc(){
        try{
                //load driver
            String file = "jdbc:ucanaccess://C:/Users/GhostBit/Desktop/git/schoolBankWebApp/Database/BlankBank.mdb";
            Connection con = DriverManager.getConnection(file);
		//statement
            Statement stmt = con.createStatement();
            String sql;
            sql = (sql = "Update Accounts set Cid = '"+custId+
                       "', Type = '"+accType+
                       "', Balance = '"+bal+
                       "' Where AcctNo = '"+accNo+"'");
            System.out.println(sql);
		//excute
            stmt.executeUpdate(sql);
            System.out.println("Row has been updated, I hope.");
		//close
            con.close();
        }
        catch(SQLException e){
            System.out.println("Database: 'BUZZ BUZZ BUZZ, the beep ba boop didb't work, <update account>");
            System.out.println("XoX^hep ne plz");
            System.out.println("PP: "+e);
        }
    }
    //main used for testing without run whole project
    public static void main(String[] args) {
        account a = new account();
        a.getUnusedAccNo();
        a.display();
    }
}
