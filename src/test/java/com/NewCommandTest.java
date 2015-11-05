package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.NewCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class NewCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n NEW foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), NewCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n N foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), NewCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n N:0 foo \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), NewCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof NewCommand);
		NewCommand cc = (NewCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
}

