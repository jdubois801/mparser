package com.ast;

import java.util.ArrayList;
import java.util.List;

public class OpenParamList extends AstNode {
	private List<OpenParam> openParamList = new ArrayList<>();

	public List<OpenParam> getOpenParamList() {
		return openParamList;
	}

	public void setOpenParamList(List<OpenParam> openParamList) {
		this.openParamList = openParamList;
	}
	
	public void add(OpenParam param) {
		this.openParamList.add(param);
	}
}
