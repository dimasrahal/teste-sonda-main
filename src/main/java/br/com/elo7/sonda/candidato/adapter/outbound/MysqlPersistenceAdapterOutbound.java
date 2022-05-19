package br.com.elo7.sonda.candidato.adapter.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.port.outbound.PersistencePortOutbound;
import br.com.elo7.sonda.candidato.repository.PlanetsRepository;
import br.com.elo7.sonda.candidato.repository.ProbesRepository;


@Component
public class MysqlPersistenceAdapterOutbound implements PersistencePortOutbound {
	
	@Autowired
	private PlanetsRepository planetRepository;
	
	@Autowired
	private ProbesRepository probeRepository;

	@Override
	public ProbeDTO saveProbe(ProbeDTO probe) {
		
		Probe probeEntity = Probe.buildEntityFromDTO(probe);
		probeEntity = probeRepository.save(probeEntity);
				
		probe.setId(probeEntity.getId());
		
		return probe;
	}

	@Override
	public PlanetDTO savePlanet(PlanetDTO planet) {
		
		Planet planetEntity = Planet.buildEntityFromDTO(planet);
		planetEntity = planetRepository.save(planetEntity);
		planet.setId(planetEntity.getId());
		return planet;
	}

	@Override
	public PlanetDTO getPlanetByPlanetDTO(PlanetDTO planet) {
		
		Planet planetEntity = planetRepository.findOneByWidthAndHeight(planet.getWidth(), planet.getHeight());
		
		if(planetEntity!=null)
			return planetEntity.buildDTOFromEntity();				
		
		return null;
	}

}
