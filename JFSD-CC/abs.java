/*
Abstraction
 
Hiding the details and Exposing only the essential functionalities.
 
 
Abstract Classes and methods
 
Interfaces
 
 
*/
interface  ATM{
    //Abstract methods and default methods and Final constants
   public void Withdraw(int amount);
   public void deposit(int amount);
   public void accDetails();
   public void setBalance(int amount);
}
 
 
 
class IciciATM implements ATM{
    private int balance;
    
    public void Withdraw(int amount){
        if (balance>=amount){
            balance -= amount;
            System.out.println("MoneyMoneyMoney");
        }else{
            System.out.println("Balance is Low");
        }
    }
    public void setBalance(int amount){
        balance = amount;
    }
    
    public void deposit(int amount){
        balance+=amount;
        System.out.println("Thanks for the Money!!!!");
    }
    
    public void accDetails(){
        System.out.println("Bank: ICICI");
        System.out.println("Balance: "+ balance);
    }
}
 
 
 
class SbiATM implements ATM{
    
   public int balance;
    
     public void Withdraw(int amount){
        if (balance>=amount){
            balance -= amount;
            System.out.println("Please Collect the Money");
        }else{
            System.out.println("Insufficient Balance");
        }
    }
    public void setBalance(int amount){
        balance = amount;
    }
    
    
    public void deposit(int amount){
        balance+=amount;
        System.out.println("Money deposited sucessfully !!!!");
    }
    
    public void accDetails(){
        System.out.println("Bank: SBI");
        System.out.println("Balance: "+ balance);
    }
}
 
public class abs
{
public static void main(String[] args) 
{
       ATM  a = new SbiATM();
       a.accDetails();
       a.setBalance(230000);
       a.Withdraw(30000);
       a.accDetails();
       a.deposit(50000);
       a.accDetails();
       ATM b =new  IciciATM();
       b.accDetails();
       b.setBalance(230000);
      b.Withdraw(30000);
      b.accDetails();
    //   a.deposit(50000);
    //   a.accDetails();
       
       
}
}