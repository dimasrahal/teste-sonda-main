package br.com.elo7.sonda.candidato.port.outbound;

import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;

public interface PersistencePortOutbound {
	
	public ProbeDTO saveProbe(ProbeDTO probe);	
	public PlanetDTO savePlanet(PlanetDTO planet);
	public PlanetDTO getPlanetByPlanetDTO(PlanetDTO planet);

}
