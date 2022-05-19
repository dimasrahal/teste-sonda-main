package br.com.elo7.sonda.candidato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.elo7.sonda.candidato.controller.request.InputRequest;
import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.dto.ProbeDTO;
import br.com.elo7.sonda.candidato.model.Probe;
import br.com.elo7.sonda.candidato.service.ProbeService;

@Controller
@RequestMapping("/planet-with-probes")
public class PlanetAndProbeController {
	@Autowired
	private ProbeService probeService;

	@PostMapping
    public ResponseEntity<List<ProbeDTO>> register(@RequestBody InputRequest inputDto) {
		
		PlanetDTO planet = new PlanetDTO(inputDto.getWidth(),inputDto.getHeight());
		
		return ResponseEntity.ok(probeService.landProbes(planet,inputDto.getProbes()));        
    }
}
