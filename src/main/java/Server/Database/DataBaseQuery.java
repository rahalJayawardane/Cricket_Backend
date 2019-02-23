package Server.Database;

import Server.Configurations.SysConfig;
import Server.LogHandler.LogWriter;
import Server.Util.SessionHandler;
import Server.Util.UtilMethods;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

        } catch(Exception e) {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Error","Backend Service Error Found");
            jsonArray.add(jsonObject);

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();

            s.setList(jsonArray);
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

        } catch(Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Error","Backend Service Error Found");
            jsonArray.add(jsonObject);

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();

            s.setList(jsonArray);
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

        } catch(Exception e) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Error","Backend Service Error Found");
            jsonArray.add(jsonObject);

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();

            s.setList(jsonArray);
        }

    }


    /**
     * Checking column details
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void checkColumnDetails(SessionHandler s) throws Exception{

        ResultSet rs = null;
        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONObject jsonObject = new JSONObject();

        try {
            ps = conn.prepareStatement("SELECT count(GameCode) as countCols FROM game_deatils where ID = ? and GameCode=?");
            ps.setString(1,s.getGameId());
            ps.setString(2,s.getColNo());
            rs = ps.executeQuery();
            while (rs.next()) {
                jsonObject.put("result",rs.getString("countCols"));
            }

        } catch(Exception e) {
            jsonObject.put("Error","Backend Service Error Found");

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();

            s.setMessage(jsonObject);
        }

    }


    /**
     * Checking column values
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void checkColumnValues(SessionHandler s) throws Exception{

        ResultSet rs = null;
        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONObject jsonObject = new JSONObject();

        try {
            ps = conn.prepareStatement("SELECT count(*) as countValues FROM games_col_details WHERE ID = ? and colCode = ? and no = ?");
            ps.setString(1,s.getGameId());
            ps.setString(2,s.getColNo());
            ps.setInt(3,s.getColId());
            rs = ps.executeQuery();
            while (rs.next()) {
                jsonObject.put("result",rs.getString("countValues"));
            }

        } catch(Exception e) {
            jsonObject.put("Error","Backend Service Error Found");

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();

            s.setMessage(jsonObject);
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

            jsonObject.put("Error","Backend Service Error Found");

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(ps != null) ps.close();
            s.setMessage(jsonObject);
        }

    }

    /**
     * insert new bet to a game
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void insertNewBet(SessionHandler s) throws Exception{

        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONObject jsonObject = new JSONObject();

        try {
            ps = conn.prepareStatement("INSERT INTO game_deatils(ID, GameCode, Value, Vissiblity) VALUES (?,?,?,?)");
            ps.setString(1,s.getGameId());
            ps.setString(2,s.getColNo());
            ps.setString(3,s.getColDetails());
            ps.setInt(4,SysConfig.visibility);

            if(ps.executeUpdate() == 1){
                jsonObject.put("response","success");
            }else{
                jsonObject.put("response","failed");
            }



        } catch(Exception e) {
            jsonObject.put("Error","Backend Service Error Found");

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(ps != null) ps.close();

            s.setMessage(jsonObject);
        }

    }



    /**
     * insert new game
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void insertGame(SessionHandler s) throws Exception{

        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONObject jsonObject = new JSONObject();

        try {
            ps = conn.prepareStatement("INSERT INTO cricket_games(ID, GameCode, TeamOne, TeamTwo, Date, status) VALUES (?,?,?,?,?,?)");
            ps.setString(1,s.getGameUniqueId());
            ps.setString(2,s.getGameId());
            ps.setString(3,s.getTeamOne());
            ps.setString(4,s.getTeamTwo());
            ps.setString(5,s.getGameDate());
            ps.setInt(6,SysConfig.visibility);

            if(ps.executeUpdate() == 1){

                if( triggerBetCodes(s) && triggerBetValues(s)){
                    jsonObject.put("response","success");
                }else{
                    jsonObject.put("response","Failed when adding betcodes and values");
                }
            }else{
                jsonObject.put("response","failed");
            }



        } catch(Exception e) {
            jsonObject.put("Error","Backend Service Error Found");
            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(ps != null) ps.close();
            s.setMessage(jsonObject);
        }

    }
    //    /////////////////// ---------------------------- Update -----------------------/////////////////////


    /**
     * update bet in a game
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void updateBet(SessionHandler s) throws Exception{

        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONObject jsonObject = new JSONObject();

        try {

            if(s.getColId() > 1){
                ps = conn.prepareStatement("UPDATE game_deatils SET Value =? WHERE ID=? AND GameCode=?");
                ps.setString(1,s.getColDetails());
                ps.setString(2,s.getGameId());
                ps.setString(3,s.getColNo());
            }else{
                ps = conn.prepareStatement("UPDATE game_deatils SET Vissiblity=? WHERE ID=? AND GameCode=?");
                ps.setInt(1,s.getColId());
                ps.setString(2,s.getGameId());
                ps.setString(3,s.getColNo());
            }

            if(ps.executeUpdate() == 1){
                jsonObject.put("response","success");
            }else{
                jsonObject.put("response","failed");
            }



        } catch(Exception e) {
            jsonObject.put("Error","Backend Service Error Found");

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(ps != null) ps.close();

            s.setMessage(jsonObject);
        }

    }


    /**
     * update the game
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void updateGame(SessionHandler s) throws Exception{

        Connection conn = s.getDbCon();
        PreparedStatement ps = null;
        ResultSet rs = null;

        JSONObject jsonObject = new JSONObject();
        String oldTeamOne = null;
        String oldTeamTwo = null;


        try {

            ps = conn.prepareStatement("SELECT * FROM cricket_games WHERE ID=?");
            ps.setString(1,s.getGameId());

            rs = ps.executeQuery();
            while (rs.next()) {
                oldTeamOne = rs.getString("TeamOne");
                oldTeamTwo = rs.getString("TeamTwo");
            }


            ps = conn.prepareStatement("UPDATE cricket_games SET TeamOne=?,TeamTwo=?,Date=?,status=? WHERE ID=?");
            ps.setString(1,s.getTeamOne());
            ps.setString(2,s.getTeamTwo());
            ps.setString(3,s.getGameDate());
            ps.setInt(4,s.getColId());
            ps.setString(5,s.getGameId());

            if(ps.executeUpdate() == 1){

                ps = conn.prepareStatement("UPDATE games_col_details SET value=? WHERE value = ? and ID = ? ");
                ps.setString(1,s.getTeamOne());
                ps.setString(2,oldTeamOne);
                ps.setString(3,s.getGameId());

                ps.executeUpdate();

                ps = conn.prepareStatement("UPDATE games_col_details SET value=? WHERE value = ? and ID = ? ");
                ps.setString(1,s.getTeamTwo());
                ps.setString(2,oldTeamTwo);
                ps.setString(3,s.getGameId());

                ps.executeUpdate();

                jsonObject.put("response","success");
            }else{
                jsonObject.put("response","failed");
            }



        } catch(Exception e) {
            jsonObject.put("Error","Backend Service Error Found");

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(rs != null) rs.close();
            if(ps != null) ps.close();
            s.setMessage(jsonObject);
        }

    }


    //    /////////////////// ---------------------------- Delete -----------------------/////////////////////

    /**
     * Delete values from column
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

            jsonObject.put("Error","Backend Service Error Found");

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(ps != null) ps.close();

            s.setMessage(jsonObject);
        }

    }


    /**
     * Delete bets from games
     * @param s - sessionHandler
     * @throws Exception
     */
    public static void deleteBets(SessionHandler s) throws Exception{

        Connection conn = s.getDbCon();
        PreparedStatement ps = null;

        JSONObject jsonObject = new JSONObject();

        try {

            ps = conn.prepareStatement("DELETE FROM games_col_details WHERE ID = ? and colCode = ?");
            ps.setString(1,s.getGameId());
            ps.setString(2,s.getColNo());

            ps.executeUpdate();

            ps = conn.prepareStatement("DELETE FROM game_deatils WHERE ID = ? and GameCode = ?");
            ps.setString(1,s.getGameId());
            ps.setString(2,s.getColNo());


            if(ps.executeUpdate() == 1){

                jsonObject.put("response","success");

            }else{
                jsonObject.put("response","failed to delete");
            }


            s.setMessage(jsonObject);

        } catch(Exception e) {

            jsonObject.put("Error","Backend Service Error Found");

            UtilMethods.getStackTrace((Throwable) e,s);
            throw e;

        } finally {
            if(ps != null) ps.close();

            s.setMessage(jsonObject);
        }

    }



    //    /////////////////// ---------------------------- Triggers -----------------------/////////////////////

    /**
     * Add default columns to games
     * @param s - sessionHandler
     * @throws Exception
     * return boolean
     */
    public static boolean triggerBetCodes(SessionHandler s) throws Exception{

        LogWriter.writeInfoFile(s.getRequestId(), "Start writing the Bet Codes ");

        Connection conn = SysConfig.dataSource.getConnection();
        PreparedStatement ps = null;

        String mainQuery = "INSERT INTO `game_deatils` (`ID`, `GameCode`, `Value`, `Vissiblity`) VALUES (?,?,?,?) ";
        Map data = UtilMethods.getTriggerBetData(s.getGameId());
        Set keys = data.keySet();
        for(Object key: keys){

            String colDetails= (String) data.get(key);
            String[] colDetailArray = colDetails.split("&");

            try {

                LogWriter.writeInfoFile(s.getRequestId(), "Query: "+mainQuery);
                LogWriter.writeInfoFile(s.getRequestId(), "Values: GameId - "+s.getGameUniqueId()+" | BetCode - "+colDetailArray[0]+" | Value - "+colDetailArray[1]);


                ps = conn.prepareStatement(mainQuery);
                ps.setString(1,s.getGameUniqueId());
                ps.setString(2,colDetailArray[0]);
                ps.setString(3,colDetailArray[1]);
                ps.setInt(4,SysConfig.visibility);

                ps.executeUpdate();


            } catch(Exception e) {

                UtilMethods.getStackTrace((Throwable) e,s);
                throw e;

            }
        }

        if(ps != null) ps.close();
        if(conn != null) conn.close();
        return true;

    }


    /**
     * Add default values to bets
     * @param s - sessionHandler
     * @throws Exception
     * return boolean
     */
    public static boolean triggerBetValues(SessionHandler s) throws Exception{

        LogWriter.writeInfoFile(s.getRequestId(), "Start writing the Bet Values ");

        Connection conn = SysConfig.dataSource.getConnection();
        PreparedStatement ps = null;

        String mainQuery = "INSERT INTO `games_col_details` (`ID`, `colCode`, `value`, `no`) VALUES (?,?,?,?) ";
        Map Cols = UtilMethods.getTriggerBetData(s.getGameId());
        Map data = UtilMethods.getTriggerBetValues(s.getGameId());
        Set keys = data.keySet();
        for(Object key: keys){

            String colDetails= (String) data.get(key);
            String[] colDetailArray = colDetails.split("&");
            String[] valueArray = colDetailArray[2].split("\\|");

            for (int i = 0; i < Integer.parseInt(colDetailArray[1]); i++) {

                String value = valueArray[i];
                if(value.equalsIgnoreCase("T1")){
                    value = s.getTeamOne();
                }else if(value.equalsIgnoreCase("T2")){
                    value = s.getTeamTwo();
                }

                try {

                    LogWriter.writeInfoFile(s.getRequestId(), "Query: "+mainQuery);
                    LogWriter.writeInfoFile(s.getRequestId(), "Values: GameId - "+s.getGameId()+" | BetCode - "+colDetailArray[0]+" | Value - "+value+" | valueCode - "+(i+1));

                    ps = conn.prepareStatement(mainQuery);
                    ps.setString(1,s.getGameUniqueId());
                    ps.setString(2,colDetailArray[0]);
                    ps.setString(3,value);
                    ps.setInt(4,(i+1));
                    ps.executeUpdate();


                } catch(Exception e) {

                    UtilMethods.getStackTrace((Throwable) e,s);

                    throw e;

                }
            }

        }

        if(ps != null) ps.close();
        if(conn != null) conn.close();
        return true;

    }


}
