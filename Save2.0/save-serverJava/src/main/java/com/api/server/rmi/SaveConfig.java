package com.api.server.rmi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

import java.rmi.Remote;

@Configuration
public class SaveConfig implements Remote {

    @Bean
    SaveService saveService() {
        return new SaveImpl();
    }

    @Bean
    RemoteExporter exporter() {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(SaveService.class);
        exporter.setService(new SaveImpl());
        exporter.setServiceName("saveService");
        exporter.setRegistryPort(18000);
        return exporter;
    }

}
