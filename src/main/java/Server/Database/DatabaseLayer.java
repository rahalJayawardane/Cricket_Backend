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

    //Insert    ---------------------------------------------------------------


    //Updates   ---------------------------------------------------------------


    //Delete    ---------------------------------------------------------------


}
