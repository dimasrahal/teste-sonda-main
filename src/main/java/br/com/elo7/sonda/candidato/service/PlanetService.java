package br.com.elo7.sonda.candidato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elo7.sonda.candidato.controller.request.InputRequest;
import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.repository.PlanetsRepository;

@Service
public class PlanetService {
	
	@Autowired
	private PlanetsRepository planets;
	
	public PlanetDTO savePlanetProcess(InputRequest input) {
		Planet planet = concertPlanet(input);
		planets.save(planet);
		
		PlanetDTO planetRet = PlanetDTO.buildDTOFromEntity(planet);
		
		return planetRet;
	}
	
	private Planet concertPlanet(InputRequest input) {
		Planet planet = new Planet();
		planet.setHeight(input.getHeight());
		planet.setWidth(input.getWidth());
		return planet;
	}

}
