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

        JSONArray jsonArray = new JSONArray();

        try {
            ps = conn.prepareStatement("SELECT * FROM game_deatils where id =?");
            ps.setString(1,s.getGameId());

            rs = ps.executeQuery();
            while (rs.next()) {

                JSONObject jsonObject = new JSONObject();

                jsonObject.put("GameCode",rs.getString("GameCode"));
                jsonObject.put("Value",rs.getString("Value"));
                jsonObject.put("Visibility",rs.getString("Vissiblity"));

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
            ps = conn.prepareStatement("SELECT * FROM games_col_details where ID = ? and colCode=?");
            ps.setString(1,s.getGameId());
            ps.setString(2,s.getColNo());
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




//    /////////////////// ---------------------------- Insert -----------------------/////////////////////

    /**
     * insert values to column
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void insertColumnDetails(SessionHandler s) throws Exception{

        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONObject jsonObject = new JSONObject();

        try {
            ps = conn.prepareStatement("INSERT INTO games_col_details(ID, colCode, value, no) VALUES (?,?,?,?)");
            ps.setString(1,s.getGameId());
            ps.setString(2,s.getColNo());
            ps.setString(3,s.getColDetails());
            ps.setInt(4,s.getColId());

            if(ps.executeUpdate() == 1){
                jsonObject.put("response","success");
            }else{
                jsonObject.put("response","failed");
            }


            s.setMessage(jsonObject);

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if(ps != null) ps.close();
        }

    }







    //    /////////////////// ---------------------------- Delete -----------------------/////////////////////

    /**
     * insert values to column
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void deleteColumnDetails(SessionHandler s) throws Exception{

        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONObject jsonObject = new JSONObject();

        try {
            ps = conn.prepareStatement("DELETE FROM games_col_details WHERE ID = ? and colCode = ? and no = ?");
            ps.setString(1,s.getGameId());
            ps.setString(2,s.getColNo());
            ps.setInt(3,s.getColId());

            if(ps.executeUpdate() == 1){
                jsonObject.put("response","success");
            }else{
                jsonObject.put("response","failed");
            }


            s.setMessage(jsonObject);

        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if(ps != null) ps.close();
        }

    }
}
