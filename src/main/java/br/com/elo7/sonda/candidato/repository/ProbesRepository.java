package br.com.elo7.sonda.candidato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.elo7.sonda.candidato.model.Probe;

public interface ProbesRepository extends JpaRepository<Probe, Long>{

}
