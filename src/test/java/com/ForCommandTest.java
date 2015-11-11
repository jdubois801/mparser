package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Command;
import com.ast.ForCommand;
import com.ast.Routine;

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
}

