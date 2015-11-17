package com.ast;

public class LabelLine extends Line {
	private String label;

	public LabelLine(String label) {
		this.label = label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}

