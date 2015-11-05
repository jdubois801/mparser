package com.ast;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class LineList {
	private List<Line> lineList = new ArrayList<>();


	public List<Line> getLineList() {
		return lineList;
	}

	public void add(Line cmd) {
		if (cmd != null) {
			lineList.add(cmd);
		}
	}

	public void addAll(Collection<Line> lineCollection) {
		if (lineCollection != null) {
			lineList.addAll(lineCollection);
		}
	}

}
