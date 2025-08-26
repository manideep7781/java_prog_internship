import java.util.*;
public class GuessTheNumber{
    public static void main(String[] args){
        Random rand=new Random();
        int target=rand.nextInt(100)+1;
        int attempt=0;
        int guess;
        Scanner sc=new Scanner(System.in);
        System.out.println("i have choosen a number between 1 to 100..guess the number");
        while(true){
            System.out.println("enetr your guess number:");
            guess=sc.nextInt();
            attempt++;
        
            if(guess<target){
                System.out.println("Too low to target");
            }
            else if(guess>target){
                System.out.println("Too high to target");
            }
            else{
                System.out.println("correct!you too"+attempt+"attempts");
            }
            break;
        }
    }
}