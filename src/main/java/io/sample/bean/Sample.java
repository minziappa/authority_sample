package io.sample.bean;

import java.util.List;

public class Sample {

	private SampleBean sample;
	private List<SampleBean> sampleList;
	private String navi;
    private String errorMessage;

	public SampleBean getSample() {
		return sample;
	}

	public void setSample(SampleBean sample) {
		this.sample = sample;
	}

	public List<SampleBean> getSampleList() {
		return sampleList;
	}

	public void setSampleList(List<SampleBean> sampleList) {
		this.sampleList = sampleList;
	}

	public String getNavi() {
		return navi;
	}

	public void setNavi(String navi) {
		this.navi = navi;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
