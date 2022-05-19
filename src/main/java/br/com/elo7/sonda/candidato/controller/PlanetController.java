package br.com.elo7.sonda.candidato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.elo7.sonda.candidato.controller.request.InputRequest;
import br.com.elo7.sonda.candidato.dto.PlanetDTO;
import br.com.elo7.sonda.candidato.service.PlanetService;

@Controller
@RequestMapping("/planet")
public class PlanetController {
	@Autowired
	private PlanetService planetService;

	@PostMapping
    public ResponseEntity<PlanetDTO> register(@RequestBody InputRequest inputDto) {
		PlanetDTO planet = new PlanetDTO(inputDto.getWidth(),inputDto.getHeight());		
		return ResponseEntity.ok(planetService.savePlanet(planet));        
    }
}
