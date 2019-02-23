package Server.Util;

import Server.Database.DatabaseConfig;
import Server.LogHandler.LogWriter;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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


    public static void getStackTrace(Throwable aThrowable,SessionHandler s) throws Exception {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        aThrowable.printStackTrace(printWriter);
        LogWriter.writeInfoFile(s.getRequestId(),"Error Occurred. Please check the ERROR file for more details");
        LogWriter.writeErrorFile(s.getRequestId(), result.toString());
    }

    public static void clearData(SessionHandler s) throws Exception {
        if(s.getDbCon() != null){
            LogWriter.writeInfoFile(s.getRequestId(), "Clearing Database Connection");
            s.getDbCon().close();
            DatabaseConfig.printDbStatus();
        }
        s = null;
    }


    public static String generateGameUniqueId() {

        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghighlmnopqurstwxyz@_&";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public static Map getTriggerBetData(String GameId) {

        // Value format = <betCode> & <Title>
        // Sample value = CRT01 & 2 & Match Winner

        Map data = new HashMap();
        data.put(1,GameId+"01&Match Winner");
        data.put(2,GameId+"02&Highest Opening Partnership");
        data.put(3,GameId+"03&Team Make to Highest 1st 6 Overs score");
        data.put(4,GameId+"04&Most Match Sixes");
        data.put(5,GameId+"05&Team of Top Match Run Scorer");
        data.put(39,GameId+"39&Most Match Fours");
        data.put(40,GameId+"40&Highest Score First Overs");
        data.put(6,GameId+"06&To Win the Toss");
        data.put(9,GameId+"09&50 Scored? - 1st Innings");
        data.put(10,GameId+"10&100 Scored? - 1 st Innings");
        data.put(11,GameId+"11&Most Run Outs");
        data.put(17,GameId+"17&Team One - Player 1 - Score 50 or more");
        data.put(18,GameId+"18&Team One - Player 2 - Score 50 or more");
        data.put(19,GameId+"19&Team Two - Player 1 - Score 50 or more");
        data.put(20,GameId+"20&Team Two - Player 2 - Score 50 or more");
        data.put(21,GameId+"21&1st Wicket Caught?");


        return data;

    }


    public static Map getTriggerBetValues(String GameId) {

        // Value format = <betCode> & <no of inputs> & <value 1> | <value 2> | <value 3>
        // Sample value = CRT01 & 2 & Yes | No

        Map data = new HashMap();
        data.put(1,GameId+"01&2&T1|T2");
        data.put(2,GameId+"02&2&T1|T2");
        data.put(3,GameId+"03&2&T1|T2");
        data.put(4,GameId+"04&3&T1|Tie|T2");
        data.put(5,GameId+"05&2&T1|T2");
        data.put(39,GameId+"39&3&T1|Tie|T2");
        data.put(40,GameId+"40&3&T1|Tie|T2");
        data.put(6,GameId+"06&2&T1|T2");
        data.put(9,GameId+"09&2&Yes|No");
        data.put(10,GameId+"10&2&Yes|No");
        data.put(11,GameId+"11&3&T1|Tie|T2");
        data.put(17,GameId+"17&2&Yes|No");
        data.put(18,GameId+"18&2&Yes|No");
        data.put(19,GameId+"19&2&Yes|No");
        data.put(20,GameId+"20&2&Yes|No");
        data.put(21,GameId+"21&2&Yes|No");


        return data;

    }
}
