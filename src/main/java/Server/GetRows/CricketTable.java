package Server.GetRows;

import Util.ResData;
import Util.Response;
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
    public ResData getCricketGames() throws Exception {
        Response response = new Response();
        response.setGameCode("CAF");
        response.setTeamOne("Alexsandar Women Team");
        response.setTeamTwo("FallBall Women Team");
        response.setGameDate("2018-12-31");
        return new ResData(response);
    }


}
