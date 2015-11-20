package pl.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.rest.model.Team;
import pl.rest.repozytoria.TeamRepository;

@RestController("football")
public class FootballService {
	
	@Autowired
	TeamRepository teamRepository;
	
	@RequestMapping
	public Iterable<Team> hello(@RequestParam(value="name", defaultValue="World") String name){
		return teamRepository.findAll();
		
	}
}
