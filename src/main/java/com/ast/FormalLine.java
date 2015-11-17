package com.ast;

public class FormalLine extends LabelLine {
	private LineList lineList;
	private ParamList paramList;
	
	public FormalLine(String label) {
		super(label);
	}

	public LineList getLineList() {
		return lineList;
	}

	public void setLineList(LineList lineList) {
		this.lineList = lineList;
	}

	public ParamList getParamList() {
		return paramList;
	}

	public void setParamList(ParamList paramList) {
		this.paramList = paramList;
	}
}
