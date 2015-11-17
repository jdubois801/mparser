package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Line;
import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.ElseCommand;

public class ElseCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n ELSE \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ElseCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof ElseCommand);
		ElseCommand cc = (ElseCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n E \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ElseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ElseCommand);
		ElseCommand cc = (ElseCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	// are indented lines correctly bound?
	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n I 0 \r\n . S a=0\r\n E\r\n . S a=1\r\n . S b=2 Q\r\n Q\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ElseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ElseCommand);
		ElseCommand cc = (ElseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		// the else command should have one child line with one command
		assertNotNull(cc.getLineList());
		assertNotNull(cc.getLineList().getLineList());
		assertEquals(2, cc.getLineList().getLineList().size());
	}
	
	// Test lines indented under a for cmd under the if command
	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n I @foo \r\n . S a=0\r\n E\r\n . S b=1 F\r\n . . S a=1 Q\r\n . S b=2\r\n Q\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ElseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ElseCommand);
		ElseCommand cc = (ElseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		// the if command should have one child line with one command
		assertNotNull(cc.getLineList());
		assertNotNull(cc.getLineList().getLineList());
		assertEquals(2, cc.getLineList().getLineList().size());
	}
	
	// commands after a ELSE command on a line wrapped into a new sub line?
	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n E S b=2 Q\r\n Q\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ElseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ElseCommand);
		ElseCommand cc = (ElseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		// the for command should have one child line with one command
		assertNotNull(cc.getLineList());
		assertNotNull(cc.getLineList().getLineList());
		assertEquals(1, cc.getLineList().getLineList().size());
		Line line = cc.getLineList().getLineList().get(0);
		assertNotNull(line);
		assertNotNull(line.getCommandList());
		assertNotNull(line.getCommandList().getCommandList());
		assertEquals(2, line.getCommandList().getCommandList().size());
	}

}
