package pl.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import pl.rest.model.Player;
import pl.rest.model.Team;
import pl.rest.repozytoria.PlayerRepository;
import pl.rest.repozytoria.TeamRepository;

@SpringBootApplication
public class SpringRestApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringRestApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }
    
    @Bean
	public CommandLineRunner demo(PlayerRepository repozytoriumGraczy, TeamRepository repozytoriumDruzyn) {
		return (args) -> {
			
			Team testTeam = new Team("Legia");
			
			//dodajemy  testowe drużyny do bazy danych
			repozytoriumDruzyn.save(new Team("Wisła"));
			repozytoriumDruzyn.save(testTeam);
			
			// dodajemy testowych graczy do bazy danych
			repozytoriumGraczy.save(new Player("Lewandowski", testTeam));
			repozytoriumGraczy.save(new Player("Lee", testTeam));
			repozytoriumGraczy.save(new Player("Murarczyk", testTeam));
			repozytoriumGraczy.save(new Player("Joga", testTeam));
			repozytoriumGraczy.save(new Player("Kaczmarek", testTeam));

			repozytoriumDruzyn.save(testTeam);
			
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Player customer : repozytoriumGraczy.findAll()) {
				log.info(customer.toString());
			}
            log.info("");

			// fetch an individual customer by ID
            Player customer = repozytoriumGraczy.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
            log.info("");

			// fetch customers by last name
			log.info("Customer found with findByNazwa('Joga'):");
			log.info("--------------------------------------------");
			for (Player bauer : repozytoriumGraczy.findByNazwa("Joga")) {
				log.info(bauer.toString());
			}
            log.info("");
		};
	}

}
