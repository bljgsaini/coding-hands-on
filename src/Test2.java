import java.util.Calendar;

public class Test2 {

    public static void main(String[] args) {

        int offerTimestamp = 1652256055;
        long timeoutInMs = 60;
        //long currentTime = 1652256066;
        long currentTime = Calendar.getInstance().toInstant().getEpochSecond();

        boolean isTimeExpired = currentTime - offerTimestamp >= timeoutInMs ? Boolean.TRUE : Boolean.FALSE;
        System.out.println("isTimeExpired=>" + isTimeExpired);

    }



}
