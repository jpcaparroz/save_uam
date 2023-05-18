package com.api.server.rmi;

import org.springframework.remoting.rmi.RmiServiceExporter;

import java.rmi.Remote;


public class SaveConfig implements Remote {


    SaveService saveService() {
        return new SaveImpl(userService, moviesService);
    }


    RmiServiceExporter exporter(SaveService implementation) {
        Class<SaveService> serviceInterface = SaveService.class;
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceInterface(serviceInterface);
        exporter.setService(implementation);
        exporter.setServiceName(serviceInterface.getName());
        exporter.setRegistryPort(18000);
        return exporter;
    }

}
