package Server.Util;

public class Request {
    private static String   gameId;
    private static int      colNo;




    public static String getGameId() {
        return gameId;
    }

    public static void setGameId(String gameId) {
        Request.gameId = gameId;
    }

    public static int getColNo() {
        return colNo;
    }

    public static void setColNo(int colNo) {
        Request.colNo = colNo;
    }
}
