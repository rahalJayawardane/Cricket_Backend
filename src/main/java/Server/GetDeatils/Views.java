package Server.GetDeatils;

import Server.Util.LogHandler;
import Server.Util.SessionHandler;
import Server.Util.UtilMethods;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Server.Util.Response;

/**
 * Created by Rahal on 1/1/2019.
 */

@RestController


@RequestMapping("/cricket")
public class Views {

    String appId = "abc";
    String intId = "123";


    @RequestMapping("/getGameDetails")
    public Response getGameDetails(SessionHandler s) throws Exception {
        String reqId = UtilMethods.getReqId();
        LogHandler.writeInfoFile(reqId, "Method Calling : Games Details");
        return new Response(reqId, s.getList());
    }


}
