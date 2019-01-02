package Server.Database;

import Server.Util.Response;
import Server.Util.SessionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseQuery {

    public static void getCricketGames(SessionHandler s, Response r) throws Exception{

        ResultSet rs = null;
        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM CRICKET_GAMES order by date desc");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Username: " + rs.getString("tech_username"));
            }

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }

    }


    public static void getGameDetails(SessionHandler s, Response r) throws Exception{
        ResultSet rs = null;
        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM CRICKET_GAMES where id =? and date=? ");
            ps.setString(1,s.getGameId());
            ps.setString(2,s.getGameDate());

            rs = ps.executeQuery();
            while (rs.next()) {
                r.setGameCode(rs.getString("gameCode"));
            }

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }
    }

}
