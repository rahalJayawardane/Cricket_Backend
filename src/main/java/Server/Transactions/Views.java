package Server.Transactions;

import Server.Database.DatabaseLayer;
import Server.Util.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Rahal on 1/1/2019.
 */

@RestController


@RequestMapping("/cricket/view")
public class Views {

    String appId = "abc";
    String intId = "123";

    /**
     * Get All cricket games which are active
     * @param s
     * @return
     * @throws Exception
     */

    @GetMapping("/getCricketGames")
    public Response getCricketGames(SessionHandler s) throws Exception {

        String reqId = UtilMethods.getReqId();

        LogHandler.writeInfoFile(reqId, "Method Calling : All Cricket Games");
        LogHandler.writeInfoFile(reqId, "Get details from database");

        DatabaseLayer.getCricketGames(s);

        LogHandler.writeInfoFile(reqId, "Send response to frontend");
        return new Response(reqId, s.getList());
    }


    /**
     * Get get games active details
     * @param s
     * @return
     * @throws Exception
     */
    @PostMapping("/getGameDetails")
    @ResponseBody
    public Response getGameDetails(SessionHandler s, HttpServletRequest request) throws Exception {
        String reqId = UtilMethods.getReqId();
        System.out.println(request.getParameter("gameId"));
        s.setGameId("");

        LogHandler.writeInfoFile(reqId, "Method Calling : Game Details -  Game ID: "+s.getGameId());
        LogHandler.writeInfoFile(reqId, "Get details from database");

        DatabaseLayer.getGameDetails(s);

        LogHandler.writeInfoFile(reqId, "Send response to frontend");

        return new Response(reqId, s.getList());
    }

    /**
     * Get get games columns details
     * @param s
     * @return
     * @throws Exception
     */
    @RequestMapping("/getColDetails")
    public Response getColumndetails(SessionHandler s, @RequestParam("GameID")String gameID, @RequestParam("ColNo")int colNo) throws Exception {
        String reqId = UtilMethods.getReqId();
        s.setColNo(colNo);
        s.setGameId(gameID);


        LogHandler.writeInfoFile(reqId, "Method Calling : Columns Details - Game ID: "+s.getGameId()+" | Column No: "+s.getColNo());
        LogHandler.writeInfoFile(reqId, "Get details from database");

        DatabaseLayer.getColumnDetails(s);

        LogHandler.writeInfoFile(reqId, "Send response to frontend");

        return new Response(reqId, s.getList());
    }


}
