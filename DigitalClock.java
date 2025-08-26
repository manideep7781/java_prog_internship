import java.text.SimpleDateFormat;
import java.util.Date;
public class DigitalClock{
    public static void main(String[] args) {
        SimpleDateFormat fmt=new SimpleDateFormat("HH:MM:SS");
        while(true){
            String now=fmt.format(new Date());
            System.out.println("\r Time:"+now);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
 