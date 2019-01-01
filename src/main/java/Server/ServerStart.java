package Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ServerStart {

    public static void main(String[] args) {
        System.setProperty("server.port", "2000");
        SpringApplication.run(ServerStart.class, args);
    }
}

