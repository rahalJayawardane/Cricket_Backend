package Server.LogHandler;

import Server.Util.UtilMethods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class LogWriter {

    public synchronized static void writeInfoFile(String reqId, String message) throws Exception{
        FileWriter fw = new FileWriter("logs/INFO_"+UtilMethods.todayDate()+".txt",true);
        fw.write("\n");
        fw.write(UtilMethods.timestamp()+" INFO "+reqId+" --- "+message);
        fw.close();

        System.out.println(UtilMethods.timestamp()+"  INFO "+reqId+" --- "+message);
    }


    public synchronized static void writeErrorFile(String reqId, String message) throws Exception{
        FileWriter fw = new FileWriter("logs/ERRORS_"+UtilMethods.todayDate()+".txt",true);
        fw.write("\n");
        fw.write(UtilMethods.timestamp()+" ERROR "+reqId);
        fw.write("\n"+message);
        fw.close();
    }

}
