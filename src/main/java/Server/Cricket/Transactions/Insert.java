package Server.Cricket.Transactions;

import Server.Configurations.SysConfig;
import Server.Database.DatabaseLayer;
import Server.LogHandler.LogWriter;
import Server.Util.Request;
import Server.Util.Response;
import Server.Util.SessionHandler;
import Server.Util.UtilMethods;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Rahal on 1/1/2019.
 */

@RestController
@RequestMapping("/cricket/insert")
@CrossOrigin(origins = SysConfig.crossOrigin)
public class Insert {

    String appId = "abc";
    String intId = "123";


    /**
     * insert new value to columns details
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertColDetails")
    @ResponseBody
    public CompletableFuture<Response> insertColumndetails(@RequestBody Request request) throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());
        s.setColNo(request.getColNo());
        s.setGameId(request.getGameId());
        s.setColId(request.getColId());
        s.setColDetails(request.getColDetails());


        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Insert Columns Details - Game ID: "+s.getGameId()+" | Column No: "+s.getColNo());
        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Insert Columns Details - Value ID: "+s.getColId()+" | Value: "+s.getColDetails());
        LogWriter.writeInfoFile(s.getRequestId(), "Insert details from database");

        DatabaseLayer.insertColumnDetails(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);
    }

    /**
     * insert ne bet type
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertNewBet")
    @ResponseBody
    public CompletableFuture<Response> insertNewBet(@RequestBody Request request) throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());
        s.setColNo(request.getColNo());
        s.setGameId(request.getGameId());
        s.setColDetails(request.getColDetails());


        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Insert Bet Details - Game ID: "+s.getGameId()+" | Bet Code: "+s.getColNo());
        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Insert Bet Details - Description: "+s.getColDetails());
        LogWriter.writeInfoFile(s.getRequestId(), "Insert details from database");

        DatabaseLayer.insertNewBet(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);
    }

    /**
     * insert a new cricketGame
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/insertNewGame")
    @ResponseBody
    public CompletableFuture<Response> insertNewGame(@RequestBody Request request) throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());
        s.setGameId(request.getGameId().toUpperCase());
        s.setTeamOne(request.getTeamOne());
        s.setTeamTwo(request.getTeamTwo());
        s.setGameDate(request.getGameDate());
        s.setGameUniqueId(UtilMethods.generateGameUniqueId());


        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Insert New Game - Game ID: "+s.getGameId());
        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Insert New Game - Team One: "+s.getTeamOne()+" | Team One: "+s.getTeamOne()+" | Game Date: "+s.getGameDate());
        LogWriter.writeInfoFile(s.getRequestId(), "Insert details to database");

        DatabaseLayer.insertGame(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);
    }

}
