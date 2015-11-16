package com.ast.command;

public class HaltCommand extends Command {

	public HaltCommand(PostCondition condition) {
		setPostCondition(condition);
	}
}

