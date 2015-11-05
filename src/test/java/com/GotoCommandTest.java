package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.GotoCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class GotoCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n GOTO foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), GotoCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n G foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), GotoCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n G:0 foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), GotoCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof GotoCommand);
		GotoCommand cc = (GotoCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
}

