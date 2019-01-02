package Server.GetRows;

import Server.Util.ResData;
import Server.Util.Response;
import Server.Util.SessionHandler;
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
    public ResData getCricketGames(SessionHandler s) throws Exception {
        Response response = new Response();
        response.setGameCode(s.getGameId());
        response.setTeamOne("Alexsandar Women Team");
        response.setTeamTwo("FallBall Women Team");
        response.setGameDate(s.getGameDate());
        return new ResData(response);
    }


}
