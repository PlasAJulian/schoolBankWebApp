/**
 * Julian A. P.
 * userAccs
 * */
package bis;
//creates an array accounts, four being the max number of accounts a user can have.
public class userAccs {
    public int count = 0;
    public account[] uAcc = new account[4];
    
    public void addAccount(account a){
        uAcc[count] = a;
        count++;
    }
    public void display(){
        for(int x = 0; x<count; x++)
        {
            account a = uAcc[x];
            a.display();
        }
    }
}