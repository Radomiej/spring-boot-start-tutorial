package pl.rest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nazwa;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Player> players;

	public Team() {
		players = new ArrayList<Player>();
	}

	public Team(String string) {
		this();
		nazwa = string;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
}
