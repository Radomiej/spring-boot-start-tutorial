package pl.rest.repozytoria;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.rest.model.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    List<Team> findByNazwa(String nazwa);
}
