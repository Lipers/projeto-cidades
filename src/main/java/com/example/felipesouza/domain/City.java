package com.example.felipesouza.domain;

public class City {

	private int ibge_id;
	private String uf;
	private String name;
	private boolean capital;
	private double lon;
	private double lat;
	private String no_accents;
	private String alternative_names;
	private String microregion;
	private String mesoregion;

	public City() {

	}

	public City(City city) {
		this.ibge_id = city.getIbge_id();
		this.uf = city.getUf();
		this.name = city.getName();
		this.capital = city.getCapital();
		this.lon = city.getLon();
		this.lat = city.getLat();
		this.no_accents = city.getNo_accents();
		this.alternative_names = city.getAlternative_names();
		this.microregion = city.getMicroregion();
		this.mesoregion = city.getMesoregion(); 
	}

	public City(int ibge_id, String uf, String name, boolean capital, double lon, double lat, String no_accents,
			String alternative_names, String microregion, String mesoregion) {
		super();
		this.ibge_id = ibge_id;
		this.uf = uf;
		this.name = name;
		this.capital = capital;
		this.lon = lon;
		this.lat = lat;
		this.no_accents = no_accents;
		this.alternative_names = alternative_names;
		this.microregion = microregion;
		this.mesoregion = mesoregion;
	}

	public int getIbge_id() {
		return ibge_id;
	}

	public void setIbge_id(int ibge_id) {
		this.ibge_id = ibge_id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getCapital() {
		return capital;
	}

	public void setCapital(boolean capital) {
		this.capital = capital;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public String getNo_accents() {
		return no_accents;
	}

	public void setNo_accents(String no_accents) {
		this.no_accents = no_accents;
	}

	public String getAlternative_names() {
		return alternative_names;
	}

	public void setAlternative_names(String alternative_names) {
		this.alternative_names = alternative_names;
	}

	public String getMicroregion() {
		return microregion;
	}

	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}

	public String getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ibge_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (ibge_id != other.ibge_id)
			return false;
		return true;
	}


}
