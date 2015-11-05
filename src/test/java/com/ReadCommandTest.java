package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.ReadCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class ReadCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n READ foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), ReadCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n R foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), ReadCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n R:0 foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), ReadCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof ReadCommand);
		ReadCommand cc = (ReadCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
}

