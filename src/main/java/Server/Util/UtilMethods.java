package Server.Util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by rahal_j on 8/13/2018.
 */
public class UtilMethods {

    public  static String getReqId() throws Exception{
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();

    }




    public static void generateRandomAmount() throws Exception{

        Random r = new Random();
        double randomValue = Integer.parseInt("100") - (Integer.parseInt("100")) * r.nextDouble();
    }

    //YYYY-MM-DD
    public static String todayDate() throws Exception{

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
        Date date = new Date();
        return dateFormat.format(date);
    }


    //YYYY-MM-DD HH:mm:ss.sss
    public static String timestamp() throws Exception{

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        String tString = timestamp.toString();
        if(tString.length()<23){
            for (int i= tString.length(); i<23;i++){
                tString = tString+"0";
            }
        }
        return tString;
    }

}
