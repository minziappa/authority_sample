package io.sample.bean;

import java.io.Serializable;

public class SampleBean implements Serializable {

	private static final long serialVersionUID = -2758511412673492544L;

	private String userImage;

	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}


}