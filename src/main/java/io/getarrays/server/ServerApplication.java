package io.getarrays.server;

import io.getarrays.server.enumeration.Status;
import io.getarrays.server.model.Server;
import io.getarrays.server.repo.ServerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static io.getarrays.server.enumeration.Status.*;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	CommandLineRunner run(ServerRepository serverRepository){
		return args -> {
			serverRepository.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16 GB", "Personal PC", "http://localhost:8080/server/image/server1.png", SERVER_UP));
			serverRepository.save(new Server(null, "192.168.1.10", "Windows 11", "32 GB", "Workstation Pro", "http://localhost:8080/server/image/server2.png", Status.SERVER_UP));

			serverRepository.save(new Server(null, "172.16.0.50", "Debian GNU/Linux", "64 GB", "Mail Server", "http://localhost:8080/server/image/server3.png", Status.SERVER_DOWN));

			serverRepository.save(new Server(null, "10.0.0.15", "Red Hat Enterprise", "128 GB", "Database Cluster", "http://localhost:8080/server/image/server4.png", Status.SERVER_UP));

		};
	}
}
