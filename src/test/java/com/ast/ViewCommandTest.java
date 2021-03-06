package com.ast;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.StringReader;
import java.util.List;

import com.ast.Routine;
import com.ast.command.CloseCommand;
import com.ast.command.Command;
import com.ast.command.ViewCommand;
import com.ast.expression.NumericConstant;
import com.validation.RoutineValidator;

public class ViewCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n VIEW \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ViewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ViewCommand);
		ViewCommand cc = (ViewCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n V \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ViewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ViewCommand);
		ViewCommand cc = (ViewCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n V:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, ViewCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof ViewCommand);
		ViewCommand cc = (ViewCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)cc.getPostCondition().getExpr();
		assertEquals("0", nconst.getValue());
	}
}

