package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Command;
import com.ast.IfCommand;
import com.ast.Routine;

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
}

