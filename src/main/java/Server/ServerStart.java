package Server;

import Server.Configurations.SysConfig;
import Server.Database.DatabaseConfig;
import Server.LogHandler.LogInit;
import Server.LogHandler.LogWriter;
import Server.Util.SessionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@SpringBootApplication
public class ServerStart {


    @Bean("threadPoolTaskExecutor")
    public TaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(1000);
        executor.setWaitForTasksToCompleteOnShutdown(false);
        executor.setThreadNamePrefix("Async-");
        return executor;
    }

    public static void main(String[] args) throws Exception {

        System.setProperty(SysConfig.portProperty, SysConfig.port);
        SpringApplication.run(ServerStart.class, args);

        LogInit.createLogFile();
        System.out.println("\n \n");;
        LogWriter.writeInfoFile("00000000000000000000000000000000","////////////   Server Starting..  ////////////");
        LogWriter.writeInfoFile("00000000000000000000000000000000","=============================================");
        LogWriter.writeInfoFile("00000000000000000000000000000000","Application \t : Cricket_Backend");
        LogWriter.writeInfoFile("00000000000000000000000000000000","Version     \t : "+SysConfig.version);
        LogWriter.writeInfoFile("00000000000000000000000000000000","Released Date  : "+SysConfig.releaseDate);
        LogWriter.writeInfoFile("00000000000000000000000000000000","Developers  \t : Rahal | Shehan | Supun");
        LogWriter.writeInfoFile("00000000000000000000000000000000","=============================================");

        SysConfig.dataSource = DatabaseConfig.makeDBConnection();
        DatabaseConfig.printDbStatus();






    }
}

