package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.ReadCommand;

public class ReadCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n READ foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n R foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n R:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n R \"boo\",foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n R foo#10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n R foo 10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n R foo#10 11 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n R *foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n R *foo 10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n R @foo,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n R !!##??,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ReadCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

}

