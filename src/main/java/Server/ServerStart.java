package Server;

import Server.Database.DatabaseConfig;
import Server.Util.LogHandler;
import Server.Util.SessionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class ServerStart {

    public static void main(String[] args) throws Exception {

        SessionHandler sessionHandler = new SessionHandler();
        sessionHandler.setGameId("asdasd");
        sessionHandler.setGameDate("213123123");

        System.setProperty("server.port", "2000");
        SpringApplication.run(ServerStart.class, args);

        LogHandler.createLogFile();
        System.out.println("\n \n");;
        LogHandler.writeInfoFile("00000000000000000000000000000000","////////////   Server Starting..  ////////////");
        LogHandler.writeInfoFile("00000000000000000000000000000000","=============================================");
        LogHandler.writeInfoFile("00000000000000000000000000000000","Application \t : Cricket_Backend");
        LogHandler.writeInfoFile("00000000000000000000000000000000","Version     \t : v_1.01");
        LogHandler.writeInfoFile("00000000000000000000000000000000","Released Date  : 2019-01-01 ");
        LogHandler.writeInfoFile("00000000000000000000000000000000","Developers  \t : Rahal | Shehan | Supun");
        LogHandler.writeInfoFile("00000000000000000000000000000000","=============================================");

        DatabaseConfig.makeJDBCConnection(sessionHandler);
    }
}

