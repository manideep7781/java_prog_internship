import java.util.Scanner;
public class SimpleCalculator{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("enter 1st number");
        double n1=s.nextInt();
        System.out.println("enter 2nd number");
        double n2=s.nextInt();
        System.out.println("select operation(+,-*,%,/):");
        char op=s.next().charAt(0);
        double result;
        switch(op){
            case '+':
                result=n1+n2;
                System.out.println("result="+result);
                break;
            case '-':
                result=n1-n2;
                System.out.println("result="+result);
                break;
            case '*':
                result=n1*n2;
                System.out.println("result="+result);
                break;
            case '/':
                if(n2!=0){
                    result=n1+n2;
                    System.out.println("result="+result);
                }
                else{
                    System.out.println("cannot be divided by zero");
                }
                break;
        default:
            System.out.println("invalid opearation");
        }
    }
}