package com.api.server;

import com.api.server.rmi.SaveImpl;
import com.api.server.rmi.SaveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

@SpringBootApplication
@EnableFeignClients
public class ServerApplication {

	public static void main(String[] args) throws RemoteException {
		SpringApplication.run(ServerApplication.class, args);

		SaveService saveService = new SaveImpl(userService, moviesService);
		Registry registry = LocateRegistry.createRegistry(18000);
		registry.rebind("SaveService", saveService);

	}
}
