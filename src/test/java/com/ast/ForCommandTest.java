package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Line;
import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.ForCommand;

public class ForCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n FOR foo=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ForCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ForCommand);
		ForCommand cc = (ForCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n F \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ForCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ForCommand);
		ForCommand cc = (ForCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n F foo=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ForCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ForCommand);
		ForCommand cc = (ForCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n F foo=0:1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ForCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ForCommand);
		ForCommand cc = (ForCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n F foo=0:1:2 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ForCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ForCommand);
		ForCommand cc = (ForCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	// are indented lines correctly bound?
	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n F \r\n . S a=0\r\n . S a=1\r\n . S b=2 Q\r\n Q\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ForCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ForCommand);
		ForCommand cc = (ForCommand)cmd;
		assertNull(cc.getPostCondition());
		
		// the for command should have one child line with one command
		assertNotNull(cc.getLineList());
		assertNotNull(cc.getLineList().getLineList());
		assertEquals(3, cc.getLineList().getLineList().size());
	}
	
	// commands after a FOR command on a line wrapped into a new sub line?
	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n F S b=2 Q\r\n Q\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ForCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ForCommand);
		ForCommand cc = (ForCommand)cmd;
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

