package Server.Cricket.Transactions;

import Server.Database.DatabaseLayer;
import Server.LogHandler.LogWriter;
import Server.Util.*;
import org.springframework.web.bind.annotation.*;

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
    public Response getCricketGames() throws Exception {

        SessionHandler s = new SessionHandler();
        String reqId = UtilMethods.getReqId();

        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : All Cricket Games");
        LogWriter.writeInfoFile(s.getRequestId(), "Get details from database");

        DatabaseLayer.getCricketGames(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");
        return new Response(s.getRequestId(), s.getList());
    }


    /**
     * Get get games active details
     * @param s
     * @return
     * @throws Exception
     */
    @PostMapping("/getGameDetails")
    @ResponseBody
    public Response getGameDetails(SessionHandler s, @RequestBody Request request) throws Exception {
        s.setRequestId(UtilMethods.getReqId());
        s.setGameId(request.getGameId());

        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Game Details -  Game ID: "+s.getGameId());
        LogWriter.writeInfoFile(s.getRequestId(), "Get details from database");

        DatabaseLayer.getGameDetails(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        return new Response(s.getRequestId(), s.getMessage());
    }

    /**
     * Get get games columns details
     * @param s
     * @return
     * @throws Exception
     */
    @RequestMapping("/getColDetails")
    @ResponseBody
    public Response getColumndetails(SessionHandler s, @RequestBody Request request) throws Exception {
        s.setRequestId(UtilMethods.getReqId());
        s.setColNo(request.getColNo());
        s.setGameId(request.getGameId());


        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Columns Details - Game ID: "+s.getGameId()+" | Column No: "+s.getColNo());
        LogWriter.writeInfoFile(s.getRequestId(), "Get details from database");

        DatabaseLayer.getColumnDetails(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        return new Response(s.getRequestId(), s.getList());
    }




}
