package Util;

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


}
