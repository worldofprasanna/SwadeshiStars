package org.swadeshi.entities;

import javax.persistence.Entity;

@Entity
public class Appreciation extends AbstractEntity{

	private String appreciationText;
	
	private String imageUrl;

	public String getAppreciationText() {
		return appreciationText;
	}

	public void setAppreciationText(String appreciationText) {
		this.appreciationText = appreciationText;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
