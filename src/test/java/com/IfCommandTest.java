package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.IfCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class IfCommandTest extends BaseTest {

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n I foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), IfCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
		assertNull(cc.getPostCondition());
		
		System.err.println("cmd = " + cmd);
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n I 1,foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), IfCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof IfCommand);
		IfCommand cc = (IfCommand)cmd;
		assertNull(cc.getPostCondition());
	}
}

