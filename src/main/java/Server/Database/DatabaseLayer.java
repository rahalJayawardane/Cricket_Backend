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

    public static void checkColumnDetails(SessionHandler s) throws Exception{
        DataBaseQuery.checkColumnDetails(s);
    }

    public static void checkColumnValues(SessionHandler s) throws Exception{
        DataBaseQuery.checkColumnValues(s);
    }

    //Insert    ---------------------------------------------------------------
    public static void insertColumnDetails(SessionHandler s) throws Exception{
        DataBaseQuery.insertColumnDetails(s);
    }

    public static void insertNewBet(SessionHandler s) throws Exception{
        DataBaseQuery.insertNewBet(s);
    }

    public static void insertGame(SessionHandler s) throws Exception{
        DataBaseQuery.insertGame(s);
    }

    //Updates   ---------------------------------------------------------------
    public static void updateBet(SessionHandler s) throws Exception{
        DataBaseQuery.updateBet(s);
    }

    public static void updateGame(SessionHandler s) throws Exception{
        DataBaseQuery.updateGame(s);
    }


    //Delete    ---------------------------------------------------------------
    public static void deleteColumnDetails(SessionHandler s) throws Exception{
        DataBaseQuery.deleteColumnDetails(s);
    }

    public static void deleteBets(SessionHandler s) throws Exception{
        DataBaseQuery.deleteBets(s);
    }

}
