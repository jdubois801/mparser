package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.command.Command;
import com.ast.command.QuitCommand;
import com.ast.expression.NumericConstant;
import com.ast.expression.StringConstant;

public class ExpressionTest extends BaseTest {

	// we'll use the QUIT command postcondition as a place to put expressions
	
	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n Q:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)cc.getPostCondition().getExpr();
		assertEquals("0", nconst.getValue());
	}
	
	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n Q:\"0\" foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StringConstant);
		StringConstant sconst = (StringConstant)cc.getPostCondition().getExpr();
		assertEquals("0", sconst.getValue());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n Q:\"\" foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof StringConstant);
		StringConstant sconst = (StringConstant)cc.getPostCondition().getExpr();
		assertEquals("", sconst.getValue());
	}
	
}