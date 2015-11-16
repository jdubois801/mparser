package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.XecuteCommand;

public class XecuteCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n XECUTE foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, XecuteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof XecuteCommand);
		XecuteCommand cc = (XecuteCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n X foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, XecuteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof XecuteCommand);
		XecuteCommand cc = (XecuteCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n X:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, XecuteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof XecuteCommand);
		XecuteCommand cc = (XecuteCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n X foo,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, XecuteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof XecuteCommand);
		XecuteCommand cc = (XecuteCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n X foo:0,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, XecuteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof XecuteCommand);
		XecuteCommand cc = (XecuteCommand)cmd;
		assertNull(cc.getPostCondition());
	}
}

