import java.util.Scanner;
class Atm{
    private double balance;
    Atm(double initialBalance){
        this.balance=initialBalance;
    }
    double getBalance(){
        return balance;
    }
    void deposit(double amount){
        if(amount<=0){
            System.out.println("amount must be positive");
            return;
        }
        amount+=balance;
        System.out.println("Deposited"+amount);
    }
    void withDraw(double amount){
        if(amount<=0){
            System.out.println("amount must be positive");
            return;
        }
        else if(amount>balance){
            System.out.println("insufficient balance");
            return;
        }
        else{
            System.out.println("withdraw:"+amount);
        }
        balance-=amount;
    }
}
public class SimpleAtm{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Atm a=new Atm(1000);
        while(true){
            System.out.println("\n-------------Menu-----------");
            System.out.println("\n1.Check Balance");
            System.out.println("\n2.Deposit");
            System.out.println("\n3.WithDraw");
            System.out.println("\4.Exit");
            System.out.println("Choose an option");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("balance:"+a.getBalance());
                    break;
                case 2:
                    System.out.println("enter amount to deposit");
                    double dep=sc.nextInt();
                    a.deposit(dep);
                    break;
                case 3:
                    System.out.println("enter amount to withdraw");
                    double w=sc.nextInt();
                    a.withDraw(w);
                    break;
                case 4:
                    System.out.println("GoodBye");
                    return;
                default:
                    System.out.println("Invalid option,Try Again");


            }
            
        }
    }
    
}
