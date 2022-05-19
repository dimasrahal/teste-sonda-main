package br.com.elo7.sonda.candidato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.elo7.sonda.candidato.model.Planet;

public interface PlanetsRepository extends JpaRepository<Planet, Long>{
	
	@Query("SELECT u FROM Planet u WHERE u.width = :width and u.height = :height")
	public Planet findOneByWidthAndHeight(int width, int height);
	
}
