package br.com.elo7.sonda.candidato.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.elo7.sonda.candidato.dto.ProbeDTO;

@Entity
@Table(name = "Probe")
public class Probe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private int x;
	
	@Column
	private int y;
	
	@Column
	private char direction;
	
	@ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "planet_id")    
	private Planet planet;

	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public char getDirection() {
		return direction;
	}
	public void setDirection(char direction) {
		this.direction = direction;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	
	public static Probe buildEntityFromDTO(ProbeDTO dto) {
		Probe probe = new Probe();
		
		if(dto.getPlanet()!=null)
			probe.setPlanet(Planet.buildEntityFromDTO(dto.getPlanet()));
		
		probe.setX(dto.getX());
		probe.setY(dto.getY());
		probe.setDirection(dto.getDirection());
		return probe;		
	}
}
