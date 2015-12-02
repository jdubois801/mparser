package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.QuitCommand;
import com.ast.expression.LocalVariableExpression;

public class QuitCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n QUIT foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n Q foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n Q:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
	
	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n Q \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n Q:0\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n Q @foo\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n Q\r\n";  // the trailing space is optional
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n Q  S S=1\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		assertNull(cc.getReturnExpression());
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n Q:1  S S=1\r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNull(cc.getReturnExpression());
	}
}

