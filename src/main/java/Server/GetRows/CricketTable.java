package Server.GetRows;

import Server.Database.DatabaseLayer;
import Server.Util.LogHandler;
import Server.Util.Response;
import Server.Util.SessionHandler;
import Server.Util.UtilMethods;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rahal on 1/1/2019.
 */

@RestController


@RequestMapping("/cricket")
public class CricketTable {

    String appId = "abc";
    String intId = "123";


    @RequestMapping("/getCricketGames")
    public Response getCricketGames(SessionHandler s) throws Exception {

        String reqId = UtilMethods.getReqId();

        LogHandler.writeInfoFile(reqId, "Method Calling : Games Details");
        LogHandler.writeInfoFile(reqId, "Get details from database");

        DatabaseLayer.getCricketGames(s);

        LogHandler.writeInfoFile(reqId, "Send response to frontend");
        return new Response(reqId, s.getList());
    }


}
