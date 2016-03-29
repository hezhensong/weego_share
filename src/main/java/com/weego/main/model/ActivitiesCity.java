package com.weego.main.model;

import org.bson.types.ObjectId;
import org.mongojack.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivitiesCity {

	@Id
	private ObjectId id;

	@JsonProperty("cityname")
	private String cityName;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
