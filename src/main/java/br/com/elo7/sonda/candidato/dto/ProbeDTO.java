package br.com.elo7.sonda.candidato.dto;

public class ProbeDTO {
	
	private long id;
	private int x; 
	private int y;
	private char direction;
	private String commands;
	private PlanetDTO planet;
	

	public PlanetDTO getPlanet() {
		return planet;
	}
	public void setPlanet(PlanetDTO planet) {
		this.planet = planet;
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
	public String getCommands() {
		return commands;
	}
	public void setCommands(String commands) {
		this.commands = commands;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
