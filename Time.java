package Network.Exam5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time extends Thread{
    Date date;
    Calendar cal;
    SimpleDateFormat date0 = null;

    public String getTime() {
        while(true) {
            cal = Calendar.getInstance();
            date = cal.getTime();

            date0 = new SimpleDateFormat("hh:mm");

            return date0.format(date);

        }

    }

    
}
