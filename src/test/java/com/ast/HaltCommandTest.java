package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.HaltCommand;
import com.ast.expression.NumericConstant;

public class HaltCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n HALT \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HaltCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HaltCommand);
		HaltCommand cc = (HaltCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n H \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HaltCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HaltCommand);
		HaltCommand cc = (HaltCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n H:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, HaltCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof HaltCommand);
		HaltCommand cc = (HaltCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)cc.getPostCondition().getExpr();
		assertEquals("0", nconst.getValue());
	}
}

