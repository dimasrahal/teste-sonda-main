package br.com.elo7.sonda.candidato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.port.outbound.PersistencePortOutbound;

@Service
public class PlanetService {
	
	@Autowired
	private PersistencePortOutbound persistenceOutb;
	
	public PlanetDTO savePlanet(PlanetDTO inputDTO) {
		
		PlanetDTO planetDB = persistenceOutb.savePlanet(inputDTO);
		return planetDB;
		
	}
	
	public PlanetDTO getPlanetByPlanetDTO(PlanetDTO planet) {
				
		PlanetDTO planetDB = persistenceOutb.getPlanetByPlanetDTO(planet);
		
		if(planetDB!=null) {
			return planetDB;
		}
		
		return null;
	}

}
