package br.com.elo7.sonda.candidato.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;

import br.com.elo7.sonda.candidato.controller.request.InputRequest;
import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.model.Command;
import br.com.elo7.sonda.candidato.model.Direction;
import br.com.elo7.sonda.candidato.model.Planet;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.port.outbound.PersistencePortOutbound;
import br.com.elo7.sonda.candidato.repository.PlanetsRepository;
import br.com.elo7.sonda.candidato.repository.ProbesRepository;

@Service
public class ProbeService {

	@Autowired
	private PlanetService planetService;

	@Autowired
	private PersistencePortOutbound persistenceOutb;

	public List<ProbeDTO> landProbes(PlanetDTO planet, List<ProbeDTO> probes) {

		PlanetDTO planetDTO = planetService.getPlanetByPlanetDTO(planet);

		if (planetDTO == null) {
			planetDTO = planetService.savePlanet(planet);
		}

		List<ProbeDTO> convertedProbes = saveProbeProcess(probes, planetDTO);
		return convertedProbes;
	}

	private List<ProbeDTO> saveProbeProcess(List<ProbeDTO> probes, PlanetDTO planet) {
		
		List<ProbeDTO> convertedProbes = convertAndMoveProbes(probes, planet);
		
		convertedProbes.forEach(probe -> persistenceOutb.saveProbe(probe));
		return convertedProbes;
	}

	@VisibleForTesting
	void applyCommandToProbe(ProbeDTO probe, char command) {
		switch (command) {
		case Command.R:
			turnProbeRight(probe);
			break;
		case Command.L:
			turnProbeLeft(probe);
			break;
		case Command.M:
			moveProbeForward(probe);
			break;
		}
	}

	private void moveProbeForward(ProbeDTO probe) {
		int newX = probe.getX();
		int newY = probe.getY();
		switch (probe.getDirection()) {
		case Direction.N:
			newY++;
			break;
		case Direction.W:
			newX--;
			break;
		case Direction.S:
			newY--;
			break;
		case Direction.E:
			newX++;
			break;
		}
		probe.setX(newX);
		probe.setY(newY);
	}

	private void turnProbeLeft(ProbeDTO probe) {
		char newDirection = Direction.N;
		switch (probe.getDirection()) {
		case Direction.N:
			newDirection = Direction.W;
			break;
		case Direction.W:
			newDirection = Direction.S;
			break;
		case Direction.S:
			newDirection = Direction.E;
			break;
		case Direction.E:
			newDirection = Direction.N;
			break;
		}
		probe.setDirection(newDirection);
	}

	private void turnProbeRight(ProbeDTO probe) {
		char newDirection = Direction.N;
		switch (probe.getDirection()) {
		case Direction.N:
			newDirection = Direction.E;
			break;
		case Direction.E:
			newDirection = Direction.S;
			break;
		case Direction.S:
			newDirection = Direction.W;
			break;
		case Direction.W:
			newDirection = Direction.N;
			break;
		}
		System.out.println(newDirection);
		probe.setDirection(newDirection);

	}

	private List<ProbeDTO> convertAndMoveProbes(List<ProbeDTO> probes, PlanetDTO planet) {
		return probes.stream().map(probeDto -> {
			probeDto.setPlanet(planet);			
			moveProbeWithAllCommands(probeDto);
			return probeDto;
		}).collect(Collectors.toList());
	}

	private void moveProbeWithAllCommands(ProbeDTO probeDTO) {
		for (char command : probeDTO.getCommands().toCharArray()) {
			applyCommandToProbe(probeDTO, command);
		}
	}

}
