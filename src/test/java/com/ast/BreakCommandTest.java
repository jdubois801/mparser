package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.BreakCommand;
import com.ast.command.Command;
import com.ast.expression.NumericConstant;

public class BreakCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n BREAK \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, BreakCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof BreakCommand);
		BreakCommand bc = (BreakCommand)cmd;
		assertNull(bc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n B \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, BreakCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof BreakCommand);
		BreakCommand bc = (BreakCommand)cmd;
		assertNull(bc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n B:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, BreakCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof BreakCommand);
		BreakCommand bc = (BreakCommand)cmd;
		assertNotNull(bc.getPostCondition());
		assertNotNull(bc.getPostCondition().getExpr());
		assertTrue(bc.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst0 = (NumericConstant)bc.getPostCondition().getExpr();
		assertEquals("0", nconst0.getValue());
	}
}

