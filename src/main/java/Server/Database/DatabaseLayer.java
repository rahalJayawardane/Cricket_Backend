package Server.Database;

import Server.Util.Response;
import Server.Util.SessionHandler;

public class DatabaseLayer {

    //Get Data    ---------------------------------------------------------------

    public static void getCricketGames(SessionHandler s, Response r) throws Exception{
        DataBaseQuery.getCricketGames(s,r);
    }

    public static void getGameDetails(SessionHandler s, Response r) throws Exception{
        DataBaseQuery.getGameDetails(s,r);
    }

    //Insert    ---------------------------------------------------------------


    //Updates   ---------------------------------------------------------------


    //Delete    ---------------------------------------------------------------


}
