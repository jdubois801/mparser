package com.ast;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class CommandList {
	private List<Command> commandList = new ArrayList<>();


	public List<Command> getCommandList() {
		return commandList;
	}

	public void add(Command cmd) {
		if (cmd != null) {
			commandList.add(cmd);
		}
	}

	public void addAll(Collection<Command> commandCollection) {
		if (commandCollection != null) {
			commandList.addAll(commandCollection);
		}
	}

}
