package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Line;
import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.IfCommand;

public class IfCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n IF foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, IfCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n I foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, IfCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n I 1,foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, IfCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n I \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, IfCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n I @foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, IfCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n I @foo,\"\",@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, IfCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	// are indented lines correctly bound?
	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n I @foo \r\n . S a=0\r\n . S b=2 Q\r\n E\r\n . S a=1\r\n Q\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, IfCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
		assertNull(cc.getPostCondition());
		
		// the if command should have one child line with one command
		assertNotNull(cc.getLineList());
		assertNotNull(cc.getLineList().getLineList());
		assertEquals(2, cc.getLineList().getLineList().size());
	}

	// Test lines indented under a for cmd under the if command
	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n I @foo \r\n . S a=0\r\n . F\r\n . . S a=1 Q\r\n . S b=2\r\n Q\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, IfCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
		assertNull(cc.getPostCondition());
		
		// the if command should have one child line with one command
		assertNotNull(cc.getLineList());
		assertNotNull(cc.getLineList().getLineList());
		assertEquals(3, cc.getLineList().getLineList().size());
	}
	
	// commands after a IF command on a line wrapped into a new sub line?
	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n I 0 S b=2 Q\r\n Q\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, IfCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
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

