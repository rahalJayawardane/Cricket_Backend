package Server.Database;

import Server.Configurations.SysConfig;
import Server.Util.SessionHandler;
import Server.Util.UtilMethods;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseQuery {

    /**
     * Get all cricket games which are active in descending order
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void getCricketGames(SessionHandler s) throws Exception{

        ResultSet rs = null;
        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONArray jsonArray = new JSONArray();

        try {
            ps = conn.prepareStatement("SELECT * FROM cricket_games where status = ? order by Date desc");
            ps.setInt(1,SysConfig.Active);
            rs = ps.executeQuery();
            while (rs.next()) {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("GameCode",rs.getString("GameCode"));
                jsonObject.put("TeamOne",rs.getString("TeamOne"));
                jsonObject.put("TeamTwo",rs.getString("TeamTwo"));
                jsonObject.put("Date",rs.getString("Date"));
                jsonObject.put("Id",rs.getString("ID"));

                jsonArray.add(jsonObject);

            }

            s.setList(jsonArray);

        } catch(Exception e) {
            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }

    }

    /**
     * get game details and column status
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void getGameDetails(SessionHandler s) throws Exception{
        ResultSet rs = null;
        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONObject jsonObject = new JSONObject();

        try {
            ps = conn.prepareStatement("SELECT * FROM game_deatils where id =?");
            ps.setString(1,s.getGameId());

            rs = ps.executeQuery();
            while (rs.next()) {


                jsonObject.put("col01",rs.getString("col01"));
                jsonObject.put("col02",rs.getString("col02"));
                jsonObject.put("col03",rs.getString("col03"));
                jsonObject.put("col04",rs.getString("col04"));
                jsonObject.put("col05",rs.getString("col05"));
                jsonObject.put("col06",rs.getString("col06"));
                jsonObject.put("col07",rs.getString("col07"));
                jsonObject.put("col08",rs.getString("col08"));
                jsonObject.put("col09",rs.getString("col09"));
                jsonObject.put("col10",rs.getString("col10"));
                jsonObject.put("col11",rs.getString("col11"));
                jsonObject.put("col12",rs.getString("col12"));
                jsonObject.put("col13",rs.getString("col13"));
                jsonObject.put("col14",rs.getString("col14"));
                jsonObject.put("col15",rs.getString("col15"));
                jsonObject.put("col16",rs.getString("col16"));
                jsonObject.put("col17",rs.getString("col17"));
                jsonObject.put("col18",rs.getString("col18"));
                jsonObject.put("col19",rs.getString("col19"));
                jsonObject.put("col20",rs.getString("col20"));
                jsonObject.put("col21",rs.getString("col21"));
                jsonObject.put("col22",rs.getString("col22"));
                jsonObject.put("col23",rs.getString("col23"));
                jsonObject.put("col24",rs.getString("col24"));
                jsonObject.put("col25",rs.getString("col25"));
                jsonObject.put("col26",rs.getString("col26"));
                jsonObject.put("col27",rs.getString("col27"));
                jsonObject.put("col28",rs.getString("col28"));
                jsonObject.put("col29",rs.getString("col29"));
                jsonObject.put("col30",rs.getString("col30"));


            }

            s.setMessage(jsonObject);

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
        }
    }

    /**
     * Get column details
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void getColumnDetails(SessionHandler s) throws Exception{

        ResultSet rs = null;
        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONArray jsonArray = new JSONArray();

        try {
            ps = conn.prepareStatement("SELECT * FROM games_col_details where ID = ? and colNo=?");
            ps.setString(1,s.getGameId());
            ps.setInt(2,s.getColNo());
            rs = ps.executeQuery();
            while (rs.next()) {

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("value",rs.getString("value"));
                jsonObject.put("no",rs.getString("no"));

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

}
