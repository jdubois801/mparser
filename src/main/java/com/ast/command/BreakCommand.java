package com.ast.command;

public class BreakCommand extends Command {

	public BreakCommand(PostCondition condition) {
		setPostCondition(condition);
	}
}

