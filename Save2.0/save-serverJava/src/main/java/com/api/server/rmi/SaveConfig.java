package com.api.server.rmi;

import com.api.server.modules.movies.MoviesService;
import com.api.server.modules.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import java.rmi.Remote;

@Configuration
public class SaveConfig implements Remote {

    final
    UserService userService;

    final
    MoviesService moviesService;

    public SaveConfig(UserService userService, MoviesService moviesService) {
        this.userService = userService;
        this.moviesService = moviesService;
    }

    @Bean
    SaveService saveService() {
        return new SaveImpl(userService);
    }

    @Bean
    RmiServiceExporter exporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(SaveService.class);
        exporter.setService(new SaveImpl(userService));
        exporter.setServiceName("Save");
        exporter.setRegistryPort(18000);
        return exporter;
    }

}
