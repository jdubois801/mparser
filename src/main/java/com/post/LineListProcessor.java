package com.post;

import java.util.List;

import com.ast.Command;
import com.ast.CommandList;
import com.ast.ElseCommand;
import com.ast.ForCommand;
import com.ast.IfCommand;
import com.ast.Line;
import com.ast.LineList;

public class LineListProcessor {

	public static void visit(LineList lineList) {

		if (lineList.getLineList() != null) {
			
			List<Line> lines = lineList.getLineList();

			for (int i = 0; i < lines.size(); i++) {
				Line line = lines.get(i);
				
				// TODO - bah. this algorithm might not be correct.  What about:
				// I 0 S a=1
				// . S b=2
				// Q
				// Are the line remainder after the IF command and the next indented line moved under the IF command in the AST?
				
				// get last command on line
				Command cmd = CommandListProcessor.last(line.getCommandList());
				if (cmd != null) {
					int indentation = line.getIndentation();
							
					if (cmd instanceof IfCommand) {
						IfCommand ifCmd = (IfCommand)cmd;
						
						// last command is an if
						// so grab all subsequent lines that >= indentation level i+1 and pull them under the if command
						processIfCommand(ifCmd, lines, i, indentation);
						
						// process lines under the IF command
						visit(ifCmd.getLineList());
					}
					else if (cmd instanceof ElseCommand) {
						ElseCommand elseCmd = (ElseCommand)cmd;
						
						// last command is an else
						// so grab all subsequent lines that >= indentation level i+1 and pull them under the if command
						processElseCommand(elseCmd, lines, i, indentation);
						
						// process lines under the ELSE command
						visit(elseCmd.getLineList());
					}
					else if (cmd instanceof ForCommand) {
						ForCommand forCmd = (ForCommand)cmd;
						
						// last command is a for
						// so grab all subsequent lines that >= indentation level i+1 and pull them under the if command
						processForCommand(forCmd, lines, i, indentation);
						
						// process lines under the FOR command
						visit(forCmd.getLineList());
					}
				}
				
				// Look for FOR commands that are not the last command in the list
				// and bring subsequent commands on that line into a new line under the FOR command
				Command firstCmd = CommandListProcessor.first(line.getCommandList(), ForCommand.class);
				if (firstCmd != null && firstCmd != cmd) {
					processForCommandLine(line.getCommandList().getCommandList(), (ForCommand)firstCmd);
				}

				// Look for ELSE commands that are not the last command in the list
				// and bring subsequent commands on that line into a new line under the ELSE command
				firstCmd = CommandListProcessor.first(line.getCommandList(), ElseCommand.class);
				if (firstCmd != null && firstCmd != cmd) {
					processElseCommandLine(line.getCommandList().getCommandList(), (ElseCommand)firstCmd);
				}

				// Look for IF commands that are not the last command in the list
				// and bring subsequent commands on that line into a new line under the IF command
				firstCmd = CommandListProcessor.first(line.getCommandList(), IfCommand.class);
				if (firstCmd != null && firstCmd != cmd) {
					processIfCommandLine(line.getCommandList().getCommandList(), (IfCommand)firstCmd);
				}
			}
		}
	}
	
	// TODO - would you rather put the next processing steps on commands into a single parametric type class
	// that only contains 2 methods?
	
	private static void processIfCommand(IfCommand cmd, List<Line> lines, int idx, int indentation) {
		cmd.setLineList(new LineList());
		
		for (int j = idx + 1; j < lines.size();) {
			Line nextLine = lines.get(j);
			if (nextLine.getIndentation() <= indentation) {
				break;
			}
			
			cmd.getLineList().getLineList().add(nextLine);
			lines.remove(j);
		}
	}
	
	private static void processElseCommand(ElseCommand cmd, List<Line> lines, int idx, int indentation) {
		cmd.setLineList(new LineList());
		
		for (int j = idx + 1; j < lines.size();) {
			Line nextLine = lines.get(j);
			
			if (nextLine.getIndentation() <= indentation) {
				break;
			}
			
			cmd.getLineList().getLineList().add(nextLine);
			lines.remove(j);
		}
	}

	private static void processForCommand(ForCommand cmd, List<Line> lines, int idx, int indentation) {
		cmd.setLineList(new LineList());
		
		for (int j = idx + 1; j < lines.size();) {
			Line nextLine = lines.get(j);
			
			if (nextLine.getIndentation() <= indentation) {
				break;
			}
			
			cmd.getLineList().getLineList().add(nextLine);
			lines.remove(j);
		}
	}
	
	private static void processForCommandLine(List<Command> cmdList, ForCommand cmd) {
		if (cmd.getLineList() == null) {
			cmd.setLineList(new LineList());
		}
		Line newLine = new Line();
		cmd.getLineList().add(newLine);
		newLine.setCommandList(new CommandList());
		
		int idx = cmdList.indexOf(cmd);
		List<Command> subCommands = cmdList.subList(idx+1, cmdList.size());
		newLine.getCommandList().getCommandList().addAll(subCommands);
		cmdList.removeAll(subCommands);
	}

	private static void processIfCommandLine(List<Command> cmdList, IfCommand cmd) {
		if (cmd.getLineList() == null) {
			cmd.setLineList(new LineList());
		}
		Line newLine = new Line();
		cmd.getLineList().add(newLine);
		newLine.setCommandList(new CommandList());
		
		int idx = cmdList.indexOf(cmd);
		List<Command> subCommands = cmdList.subList(idx+1, cmdList.size());
		newLine.getCommandList().getCommandList().addAll(subCommands);
		cmdList.removeAll(subCommands);
	}
	
	private static void processElseCommandLine(List<Command> cmdList, ElseCommand cmd) {
		if (cmd.getLineList() == null) {
			cmd.setLineList(new LineList());
		}
		Line newLine = new Line();
		cmd.getLineList().add(newLine);
		newLine.setCommandList(new CommandList());
		
		int idx = cmdList.indexOf(cmd);
		List<Command> subCommands = cmdList.subList(idx+1, cmdList.size());
		newLine.getCommandList().getCommandList().addAll(subCommands);
		cmdList.removeAll(subCommands);
	}

}
