import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInterface {

    public static String getDate(){
        SimpleDateFormat europeanFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date currentDate = new Date();
        String europeanDate = europeanFormat.format(currentDate);
        return europeanDate;
    }
}
