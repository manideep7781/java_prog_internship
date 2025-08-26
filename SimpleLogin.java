import  java.util.*;

public class SimpleLogin {
    public static void main(String[] args) {
            Map<String,String>creds=new HashMap<>();
            creds.put("alice", "alice123");
            creds.put("mani", "123456");
            creds.put("admin","root");
            Scanner sc=new Scanner(System.in);
            System.out.println("username:");
            String user=sc.nextLine();
            System.out.println("password:");
            String pass=sc.nextLine();
            if (creds.containsKey(user) && creds.get(user).equals(pass))
            {
                System.out.println("login Successfu! welcome"+user);
            }
            else{
                System.out.println("login failed! Invalid username/password");
            }
    }
}
