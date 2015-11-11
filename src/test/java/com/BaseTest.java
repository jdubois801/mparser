package com;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.ast.*;
import com.validation.RoutineValidator;

public abstract class BaseTest {

	// find all commands
	public List<Command> findAllCommands(Routine routine) {
		return findLines(routine);
	}

	// find all commands of a matching type
	public List<Command> findAllCommands(Routine routine, Class<?> clz) {
		List<Command> result = new ArrayList<>();
		
		for (Command cmd : findLines(routine)) {
			if (cmd.getClass().isAssignableFrom(clz)) {
				result.add(cmd);
			}
		}
		
		return result;
	}

	// find the first command of a matching class
	public Command findFirstCommand(Routine routine, Class<?> clz) {
		return findAllCommands(routine, clz).get(0);
	}

	private List<Command> findLines(Routine routine) {
		List<Command> result = new ArrayList<>();
		LineList ll = routine.getLineList();
		
		if (ll != null) {
			for (Line line : ll.getLineList()) {
				CommandList cl = line.getCommandList();
				
				result.addAll(cl.getCommandList());
			}
		}
		
		return result;
		
	}
	
	protected Routine parseAndValidate(String src) throws ParseException {
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		RoutineValidator.visit(parser.getParseResult());
		
		return parser.getParseResult();
	}
}
