package com.ast;

public class HaltCommand extends Command {

	public HaltCommand(PostCondition condition) {
		setPostCondition(condition);
	}
}

