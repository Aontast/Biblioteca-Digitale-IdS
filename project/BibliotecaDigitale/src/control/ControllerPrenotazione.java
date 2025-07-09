package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerPrenotazione {

    public static boolean futureDateCheck(Date check){
        Date today = new Date();
        return check.after(today);
    }
}
