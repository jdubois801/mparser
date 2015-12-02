package com.ast;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.MParser;
import com.ParseException;
import com.ast.command.Command;
import com.ast.command.CommandList;
import com.ast.command.ElseCommand;
import com.ast.command.ForCommand;
import com.ast.command.IfCommand;
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
		
		return findCommands(routine.getLineList());
	}
	
	private List<Command> findCommands(LineList linelist) {
		List<Command> result = new ArrayList<>();
		
		if (linelist != null) {
			for (Line line : linelist.getLineList()) {
				CommandList cl = line.getCommandList();
				
				if (!cl.getCommandList().isEmpty()) {
					for (Command cmd : cl.getCommandList()) {
						result.add(cmd);
						
						if (cmd instanceof IfCommand) {
							result.addAll(findCommands(((IfCommand)cmd).getLineList()));
						}
						else if (cmd instanceof ElseCommand) {
							result.addAll(findCommands(((ElseCommand)cmd).getLineList()));
						}
						else if (cmd instanceof ForCommand) {
							result.addAll(findCommands(((ForCommand)cmd).getLineList()));
						}
					}
				}
			}
		}
		
		return result;
	}

	protected Routine parseAndValidate(String src) throws ParseException {
		MParser parser = new MParser(new StringReader(src));
		parser.routine();
		Routine routine = parser.getParseResult();
		
		RoutineProcessor.visit(routine);
		
		RoutineValidator.visit(routine);
		
		return routine;
	}
}
