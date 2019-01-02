package Server.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class LogHandler {

    public static void createLogFile() throws Exception{

        String fileSeparator = System.getProperty("file.separator");
        String fileName      = "INFO_"+UtilMethods.todayDate();

        //absolute file name with path
        String path = "logs"+fileSeparator+fileName+".txt";
        File file   = new File(path);
        file.getParentFile().mkdirs();

        if ( !file.exists()) {
            FileWriter writer = new FileWriter(file);
        }

    }

    public synchronized static void writeInfoFile(String reqId, String message) throws Exception{
        FileWriter fw = new FileWriter("logs/INFO_"+UtilMethods.todayDate()+".txt",true);
        fw.write("\n");
        fw.write(UtilMethods.timestamp()+" INFO "+reqId+" --- "+message);
        fw.close();

        System.out.println(UtilMethods.timestamp()+"  INFO "+reqId+" --- "+message);
    }

}
