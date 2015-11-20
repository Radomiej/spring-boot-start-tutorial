package pl.rest.repozytoria;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.rest.model.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {

    List<Player> findByNazwa(String nazwa);
}
