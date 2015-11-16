package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.WriteCommand;

public class WriteCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n WRITE foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n W foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n W:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n W foo,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n W !!##??,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n W *foo,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, WriteCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof WriteCommand);
		WriteCommand cc = (WriteCommand)cmd;
		assertNull(cc.getPostCondition());
	}
}

