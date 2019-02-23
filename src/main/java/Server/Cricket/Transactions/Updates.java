package Server.Cricket.Transactions;

import Server.Configurations.SysConfig;
import Server.Database.DatabaseLayer;
import Server.LogHandler.LogWriter;
import Server.Util.Request;
import Server.Util.Response;
import Server.Util.SessionHandler;
import Server.Util.UtilMethods;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/cricket/update")
@CrossOrigin(origins = SysConfig.crossOrigin)
public class Updates {

    /**
     * update the bet type
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateBet")
    @ResponseBody
    public CompletableFuture<Response> UpdateBet(@RequestBody Request request) throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());
        s.setColNo(request.getColNo());
        s.setGameId(request.getGameId());
        s.setColDetails(request.getColDetails());
        s.setColId(request.getColId());


        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Update Bet Details - Game ID: "+s.getGameId()+" | Bet Code: "+s.getColNo());
        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Update Bet Details - Description: "+s.getColDetails()+" | Visibility: "+s.getGameId());
        LogWriter.writeInfoFile(s.getRequestId(), "Updating details to the database");

        DatabaseLayer.updateBet(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);
    }

    /**
     * update game
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateGame")
    @ResponseBody
    public CompletableFuture<Response> UpdateGame(@RequestBody Request request) throws Exception {

        SessionHandler s = new SessionHandler();
        s.setRequestId(UtilMethods.getReqId());
        s.setGameId(request.getGameId());
        s.setTeamOne(request.getTeamOne());
        s.setTeamTwo(request.getTeamTwo());
        s.setGameDate(request.getGameDate());
        s.setColId(request.getColId()); // for disable the game


        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Update Game Details - Game ID: "+s.getGameId());
        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Update Game Details - Team One: "+s.getTeamOne()+" | Team Two: "+s.getTeamTwo()+" | Game Date: "+s.getGameDate());
        LogWriter.writeInfoFile(s.getRequestId(), "Method Calling : Update Game Details - Active status: "+s.getColId());
        LogWriter.writeInfoFile(s.getRequestId(), "Updating details to the database");

        DatabaseLayer.updateGame(s);

        LogWriter.writeInfoFile(s.getRequestId(), "Send response to frontend");

        Response response = new Response(s);
        return CompletableFuture.completedFuture(response);
    }
}
