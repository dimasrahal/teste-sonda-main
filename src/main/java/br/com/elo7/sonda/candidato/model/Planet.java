package br.com.elo7.sonda.candidato.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.elo7.sonda.candidato.dto.PlanetDTO;

@Entity
@Table(name = "Planet")
public class Planet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private int width;
	
	@Column
	private int height;
	

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Planet) {
			return ((Planet) obj).id == this.id;
		}
		return false;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public static Planet buildEntityFromDTO(PlanetDTO dto) {
		Planet entity = new Planet();
		if(dto.getId()>0) {
			entity.setId(dto.getId());
		}
		entity.setHeight(dto.getHeight());
		entity.setWidth(dto.getWidth());
		
		return entity;		
	}
}
