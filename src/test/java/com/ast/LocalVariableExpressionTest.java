package com.ast;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Arg;
import com.ast.ArgList;
import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.QuitCommand;
import com.ast.expression.*;


public class LocalVariableExpressionTest extends BaseTest {

	@Test
	public void testFourteen() throws Exception {

		String src = "TEST ;\r\n Q:bar foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", lvn.getName());
		assertNull(lvn.getArgList());
	}
	
	@Test
	public void testFifteen() throws Exception {

		String src = "TEST ;\r\n Q:'bar foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());

		assertTrue(cc.getPostCondition().getExpr() instanceof UnaryExpression);
		UnaryExpression uexpr = (UnaryExpression)cc.getPostCondition().getExpr();
		assertEquals("'", uexpr.getOperator());
		
		assertTrue(uexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)uexpr.getValue();
		assertEquals("bar", lvn.getName());
		assertNull(lvn.getArgList());
	}

	@Test
	public void testSixteen() throws Exception {

		String src = "TEST ;\r\n Q:-bar foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());

		assertTrue(cc.getPostCondition().getExpr() instanceof UnaryExpression);
		UnaryExpression uexpr = (UnaryExpression)cc.getPostCondition().getExpr();
		assertEquals("-", uexpr.getOperator());
		
		assertTrue(uexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)uexpr.getValue();
		assertEquals("bar", lvn.getName());
		assertNull(lvn.getArgList());
	}

	@Test
	public void testSeventeen() throws Exception {

		String src = "TEST ;\r\n Q:+bar foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());

		assertTrue(cc.getPostCondition().getExpr() instanceof UnaryExpression);
		UnaryExpression uexpr = (UnaryExpression)cc.getPostCondition().getExpr();
		assertEquals("+", uexpr.getOperator());
		
		assertTrue(uexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)uexpr.getValue();
		assertEquals("bar", lvn.getName());
		assertNull(lvn.getArgList());
	}

	@Test
	public void testEighteen() throws Exception {

		String src = "TEST ;\r\n Q:(bar) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", lvn.getName());
		assertNull(lvn.getArgList());
	}

	@Test
	public void testNineteen() throws Exception {

		String src = "TEST ;\r\n Q:bar() foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", lvn.getName());
		assertNotNull(lvn.getArgList());
		assertNotNull(lvn.getArgList().getArgList());
		assertEquals(0, lvn.getArgList().getArgList().size());
	}

	@Test
	public void testTwenty() throws Exception {

		String src = "TEST ;\r\n Q:bar(0) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof LocalVariableExpression);
		LocalVariableExpression lvn = (LocalVariableExpression)cc.getPostCondition().getExpr();
		assertEquals("bar", lvn.getName());
		assertNotNull(lvn.getArgList());
		ArgList argList = lvn.getArgList();
		assertNotNull(argList.getArgList());
		assertEquals(1, argList.getArgList().size());
		Arg arg0 = argList.getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());	
	}

	@Test
	public void testThirty() throws Exception {

		String src = "TEST ;\r\n Q B \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("B", lve.getName());  // B is not a reserved word and can be used as a variable name
	}

	@Test
	public void testThirtyOne() throws Exception {

		String src = "TEST ;\r\n QUIT BREAK \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("BREAK", lve.getName());
	}
	

	@Test
	public void testThirtyTwo() throws Exception {

		String src = "TEST ;\r\n Q C \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("C", lve.getName()); 
	}

	@Test
	public void testThirtyThree() throws Exception {

		String src = "TEST ;\r\n QUIT CLOSE \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("CLOSE", lve.getName());
	}
	
	@Test
	public void testThirtyFour() throws Exception {

		String src = "TEST ;\r\n Q D \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("D", lve.getName()); 
	}

	@Test
	public void testThirtyFive() throws Exception {

		String src = "TEST ;\r\n QUIT DO \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("DO", lve.getName());
	}
	
	@Test
	public void testThirtySix() throws Exception {

		String src = "TEST ;\r\n Q E \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("E", lve.getName()); 
	}

	@Test
	public void testThirtySeven() throws Exception {

		String src = "TEST ;\r\n QUIT ELSE \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("ELSE", lve.getName());
	}
	
	@Test
	public void testThirtyEight() throws Exception {

		String src = "TEST ;\r\n Q F \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("F", lve.getName()); 
	}

	@Test
	public void testThirtyNine() throws Exception {

		String src = "TEST ;\r\n QUIT FOR \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("FOR", lve.getName());
	}
	
	@Test
	public void testForty() throws Exception {

		String src = "TEST ;\r\n Q G \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("G", lve.getName()); 
	}

	@Test
	public void testFortyOne() throws Exception {

		String src = "TEST ;\r\n QUIT GOTO \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("GOTO", lve.getName());
	}
	
	@Test
	public void testFortyTwo() throws Exception {

		String src = "TEST ;\r\n Q H \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("H", lve.getName()); 
	}

	@Test
	public void testFortyThree() throws Exception {

		String src = "TEST ;\r\n QUIT HA \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("HA", lve.getName());
	}
	
	@Test
	public void testFortyFour() throws Exception {

		String src = "TEST ;\r\n QUIT HALT \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("HALT", lve.getName());
	}
	
	@Test
	public void testFortyFive() throws Exception {

		String src = "TEST ;\r\n QUIT HANG \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("HANG", lve.getName());
	}
	
	@Test
	public void testFortySix() throws Exception {

		String src = "TEST ;\r\n QUIT I \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("I", lve.getName());
	}
	
	@Test
	public void testFortySeven() throws Exception {

		String src = "TEST ;\r\n QUIT IF \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("IF", lve.getName());
	}
	
	@Test
	public void testFortyEight() throws Exception {

		String src = "TEST ;\r\n QUIT J \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("J", lve.getName());
	}
	
	@Test
	public void testFortyNine() throws Exception {

		String src = "TEST ;\r\n QUIT JOB \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("JOB", lve.getName());
	}
	
	@Test
	public void testFifty() throws Exception {

		String src = "TEST ;\r\n QUIT K \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("K", lve.getName());
	}
	
	@Test
	public void testFiftyOne() throws Exception {

		String src = "TEST ;\r\n QUIT KILL \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("KILL", lve.getName());
	}
	
	@Test
	public void testFiftyTwo() throws Exception {

		String src = "TEST ;\r\n QUIT L \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("L", lve.getName());
	}
	
	@Test
	public void testFiftyThree() throws Exception {

		String src = "TEST ;\r\n QUIT LOCK \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("LOCK", lve.getName());
	}
	
	@Test
	public void testFiftyFour() throws Exception {

		String src = "TEST ;\r\n QUIT M \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("M", lve.getName());
	}
	
	@Test
	public void testFiftyFive() throws Exception {

		String src = "TEST ;\r\n QUIT MERGE \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("MERGE", lve.getName());
	}
	
	@Test
	public void testFiftySix() throws Exception {

		String src = "TEST ;\r\n QUIT N \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("N", lve.getName());
	}
	
	@Test
	public void testFiftySeven() throws Exception {

		String src = "TEST ;\r\n QUIT NEW \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("NEW", lve.getName());
	}
	
	@Test
	public void testFiftyEight() throws Exception {

		String src = "TEST ;\r\n QUIT O \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("O", lve.getName());
	}
	
	@Test
	public void testFiftyNine() throws Exception {

		String src = "TEST ;\r\n QUIT OPEN \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("OPEN", lve.getName());
	}
	
	@Test
	public void testSixty() throws Exception {

		String src = "TEST ;\r\n QUIT Q \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("Q", lve.getName());
	}
	
	@Test
	public void testSixtyOne() throws Exception {

		String src = "TEST ;\r\n QUIT QUIT \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("QUIT", lve.getName());
	}
	
	@Test
	public void testSixtyTwo() throws Exception {

		String src = "TEST ;\r\n QUIT R \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("R", lve.getName());
	}
	
	@Test
	public void testSixtyThree() throws Exception {

		String src = "TEST ;\r\n QUIT READ \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("READ", lve.getName());
	}
	
	@Test
	public void testSixtyFour() throws Exception {

		String src = "TEST ;\r\n QUIT S \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("S", lve.getName());
	}
	
	@Test
	public void testSixtyFive() throws Exception {

		String src = "TEST ;\r\n QUIT SET \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("SET", lve.getName());
	}
	
	@Test
	public void testSixtySix() throws Exception {

		String src = "TEST ;\r\n QUIT U \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("U", lve.getName());
	}
	
	@Test
	public void testSixtySeven() throws Exception {

		String src = "TEST ;\r\n QUIT USE \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("USE", lve.getName());
	}
	
	@Test
	public void testSixtyEight() throws Exception {

		String src = "TEST ;\r\n QUIT V \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("V", lve.getName());
	}
	
	@Test
	public void testSixtyNine() throws Exception {

		String src = "TEST ;\r\n QUIT VIEW \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("VIEW", lve.getName());
	}
	
	@Test
	public void testSeventy() throws Exception {

		String src = "TEST ;\r\n QUIT W \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("W", lve.getName());
	}
	
	@Test
	public void testSeventyOne() throws Exception {

		String src = "TEST ;\r\n QUIT WRITE \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("WRITE", lve.getName());
	}
	
	@Test
	public void testSeventyTwo() throws Exception {

		String src = "TEST ;\r\n QUIT X \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("X", lve.getName());
	}
	
	@Test
	public void testSeventyThree() throws Exception {

		String src = "TEST ;\r\n QUIT XECUTE \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getReturnExpression());
		assertTrue(cc.getReturnExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)cc.getReturnExpression();
		assertNull(lve.getArgList());
		assertEquals("XECUTE", lve.getName());
	}
}
