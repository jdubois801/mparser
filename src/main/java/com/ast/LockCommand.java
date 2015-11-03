package com.ast;

public class LockCommand extends Command {

	public LockCommand(PostCondition condition) {
		setPostCondition(condition);
	}

	public String toString() {
		return "LockCommand";
	}
}

