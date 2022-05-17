package br.com.elo7.sonda.candidato.dto;

import br.com.elo7.sonda.candidato.model.Planet;

public class PlanetDTO {
	
	private long id;
	private int width;
	private int height;
	
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
	
	public static PlanetDTO buildDTOFromEntity(Planet entity) {
		
		PlanetDTO dto = new PlanetDTO();
		dto.setId(entity.getId());
		dto.setHeight(entity.getHeight());
		dto.setWidth(entity.getWidth());
		return dto;		
		
	}
	
	

}
