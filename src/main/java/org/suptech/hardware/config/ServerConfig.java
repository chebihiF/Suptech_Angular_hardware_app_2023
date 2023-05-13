package config;

import enumeration.Status;
import lombok.RequiredArgsConstructor;
import model.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repo.ServerRepository;

@Configuration
@RequiredArgsConstructor
public class ServerConfig {

    private final ServerRepository serverRepository;

    @Bean
    CommandLineRunner init_servers(){
        return args -> {
          serverRepository.save(new Server(null,"192.168.1.156","Ubuntu linux","16 GB","Personal PC", "", Status.SERVER_UP));
          serverRepository.save(new Server(null,"192.168.1.15","Fedora linux","12 GB","Personal PC", "", Status.SERVER_UP));
          serverRepository.save(new Server(null,"192.168.1.160","Macos","64 GB","Gaming PC", "", Status.SERVER_DOWN));
          serverRepository.save(new Server(null,"192.168.1.12","Ms 2008","6 GB","App Server", "", Status.SERVER_UP));
          serverRepository.save(new Server(null,"192.168.1.16","CentOs","8 GB","Web Server", "", Status.SERVER_DOWN));
          serverRepository.save(new Server(null,"192.168.1.22","Red Hat Entreprise Linux","mail server","Personal PC", "", Status.SERVER_DOWN));
        };
    }
}
