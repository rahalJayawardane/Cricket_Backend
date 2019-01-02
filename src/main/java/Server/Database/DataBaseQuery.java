package Server.Database;

import Server.Util.SessionHandler;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseQuery {

    public static void getCricketGames(SessionHandler s) throws Exception{

        ResultSet rs = null;
        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONArray jsonArray = new JSONArray();

        try {
            ps = conn.prepareStatement("SELECT * FROM cricket_games order by Date desc");
            rs = ps.executeQuery();
            while (rs.next()) {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("GameCode",rs.getString("GameCode"));
                jsonObject.put("TeamOne",rs.getString("TeamOne"));
                jsonObject.put("TeamTwo",rs.getString("TeamTwo"));
                jsonObject.put("Date",rs.getString("Date"));

                jsonArray.add(jsonObject);

            }

            s.setList(jsonArray);

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }

    }


    public static void getGameDetails(SessionHandler s) throws Exception{
        ResultSet rs = null;
        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM CRICKET_GAMES where id =? and date=? ");
            ps.setString(1,s.getGameId());
            ps.setString(2,s.getGameDate());

            rs = ps.executeQuery();
            while (rs.next()) {
//                r.setGameCode(rs.getString("GameCode"));
//                r.setTeamOne(rs.getString("TeamOne"));
//                r.setTeamTwo(rs.getString("TeamTwo"));
//                r.setGameDate(rs.getString("Date"));
            }

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }
    }

}
