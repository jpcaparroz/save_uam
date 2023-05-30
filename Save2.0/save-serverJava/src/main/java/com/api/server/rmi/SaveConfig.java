package com.api.server.rmi;

import com.api.server.modules.movies.MoviesService;
import com.api.server.modules.omdb.OmdbService;
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

    final
    OmdbService omdbService;

    public SaveConfig(UserService userService, MoviesService moviesService, OmdbService omdbService) {
        this.userService = userService;
        this.moviesService = moviesService;
        this.omdbService = omdbService;
    }

    @Bean
    SaveService saveService() {
        return new SaveImpl(userService, moviesService, omdbService);
    }

    @Bean
    RmiServiceExporter exporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(SaveService.class);
        exporter.setService(new SaveImpl(userService, moviesService, omdbService));
        exporter.setServiceName("Save");
        exporter.setRegistryPort(18000);
        return exporter;
    }

}
