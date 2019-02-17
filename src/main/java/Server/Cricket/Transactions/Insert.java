package Server.Cricket.Transactions;

import Server.Database.DatabaseLayer;
import Server.LogHandler.LogWriter;
import Server.Util.Request;
import Server.Util.Response;
import Server.Util.SessionHandler;
import Server.Util.UtilMethods;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Rahal on 1/1/2019.
 */

@RestController


@RequestMapping("/cricket/insert")
public class Insert {

    String appId = "abc";
    String intId = "123";


    /**
     * Get get games columns details
     * @param request
     * @return
     * @throws Exception
     */
    @Async("threadPoolTaskExecutor")
    @RequestMapping("/getColDetails")
    @ResponseBody
    public CompletableFuture<Response> insertColumndetails(@RequestBody Request request) throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());
        s.setColNo(request.getColNo());
        s.setGameId(request.getGameId());
        s.setColNo(request.getColNo());
        s.setColDetails(request.getColDetails());


        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Insert Columns Details - Game ID: "+s.getGameId()+" | Column No: "+s.getColNo());
        LogWriter.writeInfoFile(s.getRequestId(), "Insert details from database");

//        DatabaseLayer.getColumnDetails(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);
    }




}
