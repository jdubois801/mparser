package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.HangCommand;

public class HangCommandTest extends BaseTest {

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n HANG 10\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HangCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HangCommand);
		HangCommand cc = (HangCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n H 10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HangCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HangCommand);
		HangCommand cc = (HangCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n H:0 10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HangCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HangCommand);
		HangCommand cc = (HangCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
	
	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n H:0 10,20 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HangCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HangCommand);
		HangCommand cc = (HangCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n H:0 10,@bar,@foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HangCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HangCommand);
		HangCommand cc = (HangCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
	
}

