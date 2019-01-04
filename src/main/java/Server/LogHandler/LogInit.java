package Server.LogHandler;

import Server.Util.UtilMethods;

import java.io.File;
import java.io.FileWriter;

public class LogInit {

    public static void createLogFile() throws Exception{

        String fileSeparator    = null;
        String fileName         = null;
        String path             = null;
        File file               = null;

        //create INFO file
        fileSeparator = System.getProperty("file.separator");
        fileName      = "INFO_"+UtilMethods.todayDate();

        path = "logs"+fileSeparator+fileName+".txt";
        file   = new File(path);
        file.getParentFile().mkdirs();

        if ( !file.exists()) {
            FileWriter writer = new FileWriter(file);
        }


        //create ERROR file
        fileSeparator = System.getProperty("file.separator");
        fileName      = "ERRORS_"+UtilMethods.todayDate();

        path = "logs"+fileSeparator+fileName+".txt";
        file   = new File(path);
        file.getParentFile().mkdirs();

        if ( !file.exists()) {
            FileWriter writer = new FileWriter(file);
        }


    }


}
