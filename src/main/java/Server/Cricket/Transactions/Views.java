package Server.Cricket.Transactions;

import Server.Configurations.SysConfig;
import Server.Database.DatabaseLayer;
import Server.LogHandler.LogWriter;
import Server.Util.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Rahal on 1/1/2019.
 */
@RestController
@RequestMapping("/cricket/view")
@CrossOrigin(origins = SysConfig.crossOrigin)
public class Views {

    String appId = "abc";
    String intId = "123";

    /**
     * Get All cricket games which are active
     * @param
     * @return
     * @throws Exception
     */
    //this is test commit
    @Async("threadPoolTaskExecutor")
    @GetMapping("/getCricketGames")
    public CompletableFuture <Response> getCricketGames() throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());

        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : All Cricket Games");
        LogWriter.writeInfoFile(s.getRequestId(), "Get details from database");

        DatabaseLayer.getCricketGames(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);

    }


    /**
     * Get get games active details
     * @param request
     * @return
     * @throws Exception
     */
    @Async("threadPoolTaskExecutor")
    @PostMapping("/getGameDetails")
    @ResponseBody
    public CompletableFuture <Response> getGameDetails(@RequestBody Request request) throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());
        s.setGameId(request.getGameId());

        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Game Details -  Game ID: "+s.getGameId());
        LogWriter.writeInfoFile(s.getRequestId(), "Get details from database");

        DatabaseLayer.getGameDetails(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);
    }

    /**
     * Get get games columns details
     * @param request
     * @return
     * @throws Exception
     */
    @Async("threadPoolTaskExecutor")
    @RequestMapping("/getColDetails")
    @ResponseBody
    public CompletableFuture <Response> getColumndetails(@RequestBody Request request) throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());
        s.setColNo(request.getColNo());
        s.setGameId(request.getGameId());


        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Columns Details - Game ID: "+s.getGameId()+" | Column No: "+s.getColNo());
        LogWriter.writeInfoFile(s.getRequestId(), "Get details from database");

        DatabaseLayer.getColumnDetails(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);
    }


    /**
     * check columns is taken
     * @param request
     * @return
     * @throws Exception
     */
    @Async("threadPoolTaskExecutor")
    @RequestMapping("/checkColDetails")
    @ResponseBody
    public CompletableFuture <Response> checkColDetails(@RequestBody Request request) throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());
        s.setColNo(request.getColNo());
        s.setGameId(request.getGameId());


        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Checking Columns Details - Game ID: "+s.getGameId()+" | Column No: "+s.getColNo());
        LogWriter.writeInfoFile(s.getRequestId(), "Get details from database");

        DatabaseLayer.checkColumnDetails(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);
    }

    /**
     * check value is taken
     * @param request
     * @return
     * @throws Exception
     */
    @Async("threadPoolTaskExecutor")
    @RequestMapping("/colValues")
    @ResponseBody
    public CompletableFuture <Response> colValues(@RequestBody Request request) throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());
        s.setColNo(request.getColNo());
        s.setGameId(request.getGameId());
        s.setColId(request.getColId());


        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Checking Columns Details - Game ID: "+s.getGameId()+" | Column No: "+s.getColNo());
        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Checking Columns Details - Value ID: "+s.getColId());
        LogWriter.writeInfoFile(s.getRequestId(), "Insert details from database");

        DatabaseLayer.checkColumnValues(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);
    }


}
