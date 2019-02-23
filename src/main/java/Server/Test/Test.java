package Server.Test;

import Server.Database.DataBaseQuery;
import Server.LogHandler.LogWriter;
import Server.Util.UtilMethods;

import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Test {

    public static String givenUsingApache_whenGeneratingRandomStringBounded_thenCorrect() {

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

    public static void main(String[] args) {
//        System.out.println(givenUsingApache_whenGeneratingRandomStringBounded_thenCorrect());


        try{
            String mainQuery = "INSERT INTO `games_col_details` (`ID`, `colCode`, `value`, `no`) VALUES (?,?,?,?) ";
            Map Cols = UtilMethods.getTriggerBetData("SSS");
            Map data = UtilMethods.getTriggerBetValues("SSS");
            Set keys = data.keySet();
            for(Object key: keys) {

                String colDetails = (String) data.get(key);
                String[] colDetailArray = colDetails.split("&");
                String[] valueArray = colDetailArray[2].split("\\|");

                for (int i = 0; i < Integer.parseInt(colDetailArray[1]); i++) {

                    String value = valueArray[i];
                    if (value.equalsIgnoreCase("T1")) {
                        value = "TEAM01";
                    } else if (value.equalsIgnoreCase("T2")) {
                        value = "TEAM02";
                    }


                    System.out.println("Query: " + mainQuery);
                    System.out.println("Values: GameId - SSS | BetCode - " + colDetailArray[0] + " | Value - " + value + " | valueCode - " + (i + 1));



                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
