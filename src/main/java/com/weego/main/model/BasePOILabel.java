package com.weego.main.model;

import org.mongojack.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BasePOILabel {
	@Id
	private String id;
	private String label;
	@JsonProperty("label_en")
	private String labelEn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
