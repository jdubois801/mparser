package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.BreakCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class BreakStatementTest extends BaseTest {

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n B \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), BreakCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof BreakCommand);
		BreakCommand bc = (BreakCommand)cmd;
		assertNull(bc.getPostCondition());
		
		System.err.println("cmd = " + cmd);
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n B:0 \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), BreakCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof BreakCommand);
		BreakCommand bc = (BreakCommand)cmd;
		assertNotNull(bc.getPostCondition());
	}
}

