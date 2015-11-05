package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.ForCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class ForCommandTest extends BaseTest {

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n F foo=0 \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), ForCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof ForCommand);
		ForCommand cc = (ForCommand)cmd;
		assertNull(cc.getPostCondition());
		
		System.err.println("cmd = " + cmd);
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n F foo=0:1 \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), ForCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof ForCommand);
		ForCommand cc = (ForCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n F foo=0:1:2 \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), ForCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof ForCommand);
		ForCommand cc = (ForCommand)cmd;
		assertNull(cc.getPostCondition());
	}
}

