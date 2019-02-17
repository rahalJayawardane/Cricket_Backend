package Server.Database;

import Server.Util.SessionHandler;

public class DatabaseLayer {

    //Get Data    ---------------------------------------------------------------

    public static void getCricketGames(SessionHandler s) throws Exception{
        DataBaseQuery.getCricketGames(s);
    }

    public static void getGameDetails(SessionHandler s) throws Exception{
        DataBaseQuery.getGameDetails(s);
    }


    public static void getColumnDetails(SessionHandler s) throws Exception{
        DataBaseQuery.getColumnDetails(s);
    }

    //Insert    ---------------------------------------------------------------
    public static void insertColumnDetails(SessionHandler s) throws Exception{
        DataBaseQuery.insertColumnDetails(s);
    }

    //Updates   ---------------------------------------------------------------


    //Delete    ---------------------------------------------------------------
    public static void deleteColumnDetails(SessionHandler s) throws Exception{
        DataBaseQuery.deleteColumnDetails(s);
    }

}
