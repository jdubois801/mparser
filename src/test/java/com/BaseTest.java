package com;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.ast.*;
import com.post.RoutineProcessor;
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
	// TODO - this implementation is crazy inefficient for large lists
	public Command findFirstCommand(Routine routine, Class<?> clz) {
		Command result = null;
		
		List<Command> resultList = findAllCommands(routine, clz);
		
		if (resultList != null && !resultList.isEmpty()) {
			result = resultList.get(0);
		}
		
		return result;
	}

	private List<Command> findLines(Routine routine) {
		List<Command> result = new ArrayList<>();
		LineList ll = routine.getLineList();
		
		// TODO - add descent into embedded line lists under IF, ELSE, and FOR commands
		if (ll != null) {
			for (Line line : ll.getLineList()) {
				CommandList cl = line.getCommandList();
				
				if (!cl.getCommandList().isEmpty()) {
					result.addAll(cl.getCommandList());
				}
			}
		}
		
		return result;
		
	}
	
	protected Routine parseAndValidate(String src) throws ParseException {
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		Routine routine = parser.getParseResult();
		
		RoutineProcessor.visit(routine);
		
		RoutineValidator.visit(routine);
		
		return routine;
	}
}
