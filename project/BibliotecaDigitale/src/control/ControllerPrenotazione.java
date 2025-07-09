package control;

import java.util.Date;

public class ControllerPrenotazione {

    public static boolean futureDateCheck(Date check){
        Date today = new Date();
        return check.after(today);
    }

    
}
