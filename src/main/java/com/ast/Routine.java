package com.ast;

public class Routine {
	private String name;
	private LineList lineList;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLineList(LineList lineList) {
		this.lineList = lineList;
	}

	public LineList getLineList() {
		return lineList;
	}
}

