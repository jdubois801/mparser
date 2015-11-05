package com;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Command;
import com.ast.HaltCommand;
import com.ast.Routine;
import com.validation.RoutineValidator;

public class HaltCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n HALT \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), HaltCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof HaltCommand);
		HaltCommand cc = (HaltCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n H \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), HaltCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof HaltCommand);
		HaltCommand cc = (HaltCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n H:0 \r\n";
		FooParser parser = new FooParser(new StringReader(src));
		parser.routine();
		
		RoutineValidator.visit(parser.getParseResult());
		
		Command cmd = findFirstCommand(parser.getParseResult(), HaltCommand.class); 
		assertNotNull(cmd);
		assertTrue(cmd instanceof HaltCommand);
		HaltCommand cc = (HaltCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}
}

