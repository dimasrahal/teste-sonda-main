package br.com.elo7.sonda.candidato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elo7.sonda.candidato.model.Planet;

public interface PlanetsRepository extends JpaRepository<Planet, Long>{
	
}
