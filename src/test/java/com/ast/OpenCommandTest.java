package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.OpenCommand;

public class OpenCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n OPEN foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n O foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n O:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n O foo,1+2 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n O foo:1+2 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n O @one,foo,@two \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n O foo:1(2) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, OpenCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof OpenCommand);
		OpenCommand cc = (OpenCommand)cmd;
		assertNull(cc.getPostCondition());
	}

//	@Test
//	public void testSeven() throws Exception {
//
//		String src = "TEST ;\r\n O foo:1:(2)3 \r\n";
//		Routine routine = parseAndValidate(src); 
//		Command cmd = findFirstCommand(routine, OpenCommand.class);
//
//		assertNotNull(cmd);
//		assertTrue(cmd instanceof OpenCommand);
//		OpenCommand cc = (OpenCommand)cmd;
//		assertNull(cc.getPostCondition());
//	}
//
//	@Test
//	public void testEight() throws Exception {
//
//		String src = "TEST ;\r\n O foo:1(2)3:4 \r\n";
//		Routine routine = parseAndValidate(src); 
//		Command cmd = findFirstCommand(routine, OpenCommand.class);
//
//		assertNotNull(cmd);
//		assertTrue(cmd instanceof OpenCommand);
//		OpenCommand cc = (OpenCommand)cmd;
//		assertNull(cc.getPostCondition());
//	}
}

