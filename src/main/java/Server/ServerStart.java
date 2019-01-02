package Server;

import Server.Database.DatabaseConfig;
import Server.Util.SessionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ServerStart {

    public static void main(String[] args) {

        SessionHandler sessionHandler = new SessionHandler();
        sessionHandler.setGameId("asdasd");
        sessionHandler.setGameDate("213123123");

        System.setProperty("server.port", "2000");
        SpringApplication.run(ServerStart.class, args);

//        DatabaseConfig.makeJDBCConnection(sessionHandler);
    }
}

