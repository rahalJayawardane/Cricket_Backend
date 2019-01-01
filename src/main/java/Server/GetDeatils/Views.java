package Server.GetDeatils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Util.ResData;
import Util.Response;

/**
 * Created by Rahal on 1/1/2019.
 */

@RestController


@RequestMapping("/cricket")
public class Views {

    String appId = "abc";
    String intId = "123";


    @RequestMapping("/getGameDetails")
    public ResData getGameDetails() throws Exception {
        Response response = new Response();
        response.setGameCode("CAF");
        response.setTeamOne("Alexsandar Women Team");
        response.setTeamTwo("FallBall Women Team");
        response.setGameDate("2018-12-31");
        return new ResData(response);
    }


}
