package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.command.Command;
import com.ast.command.QuitCommand;
import com.ast.expression.FunctionExpression;
import com.ast.expression.NumericConstant;


public class BuiltinFunctionExpressionTest extends BaseTest {

	/* built-in functions */
	
	@Test
	public void testFortyTwo() throws Exception {

		String src = "TEST ;\r\n Q:($A(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$ASCII", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortyThree() throws Exception {

		String src = "TEST ;\r\n Q:($ASCII(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$ASCII", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortyFour() throws Exception {

		String src = "TEST ;\r\n Q:($C(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$CHAR", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortyFive() throws Exception {

		String src = "TEST ;\r\n Q:($CHAR(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$CHAR", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortySix() throws Exception {

		String src = "TEST ;\r\n Q:($D(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$DATA", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortySeven() throws Exception {

		String src = "TEST ;\r\n Q:($DATA(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$DATA", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortyEight() throws Exception {

		String src = "TEST ;\r\n Q:($E(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$EXTRACT", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFortyNine() throws Exception {

		String src = "TEST ;\r\n Q:($EXTRACT(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$EXTRACT", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFifty() throws Exception {

		String src = "TEST ;\r\n Q:($F(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$FIND", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFiftyOne() throws Exception {

		String src = "TEST ;\r\n Q:($FIND(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$FIND", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFiftyTwo() throws Exception {

		String src = "TEST ;\r\n Q:($FN(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$FNUMBER", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFiftyThree() throws Exception {

		String src = "TEST ;\r\n Q:($FNUMBER(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$FNUMBER", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFiftyFour() throws Exception {

		String src = "TEST ;\r\n Q:($G(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$GET", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFiftyFive() throws Exception {

		String src = "TEST ;\r\n Q:($GET(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$GET", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFiftySix() throws Exception {

		String src = "TEST ;\r\n Q:($J(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$JUSTIFY", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFiftySeven() throws Exception {

		String src = "TEST ;\r\n Q:($JUSTIFY(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$JUSTIFY", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFiftyEight() throws Exception {

		String src = "TEST ;\r\n Q:($L(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$LENGTH", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFiftyNine() throws Exception {

		String src = "TEST ;\r\n Q:($LENGTH(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$LENGTH", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSixty() throws Exception {

		String src = "TEST ;\r\n Q:($NA(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$NAME", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSixtyOne() throws Exception {

		String src = "TEST ;\r\n Q:($NAME(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$NAME", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSixtyTwo() throws Exception {

		String src = "TEST ;\r\n Q:($O(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$ORDER", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSixtyThree() throws Exception {

		String src = "TEST ;\r\n Q:($ORDER(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$ORDER", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSixtyFour() throws Exception {

		String src = "TEST ;\r\n Q:($P(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$PIECE", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSixtyFive() throws Exception {

		String src = "TEST ;\r\n Q:($PIECE(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$PIECE", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}
	
	@Test
	public void testSixtySix() throws Exception {

		String src = "TEST ;\r\n Q:($QL(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$QLENGTH", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSixtySeven() throws Exception {

		String src = "TEST ;\r\n Q:($QLENGTH(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$QLENGTH", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSixtyEight() throws Exception {

		String src = "TEST ;\r\n Q:($QS(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$QSUBSCRIPT", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSixtyNine() throws Exception {

		String src = "TEST ;\r\n Q:($QSUBSCRIPT(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$QSUBSCRIPT", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeventy() throws Exception {

		String src = "TEST ;\r\n Q:($Q(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$QUERY", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeventyOne() throws Exception {

		String src = "TEST ;\r\n Q:($QUERY(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$QUERY", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeventyTwo() throws Exception {

		String src = "TEST ;\r\n Q:($R(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$RANDOM", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeventyThree() throws Exception {

		String src = "TEST ;\r\n Q:($RANDOM(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$RANDOM", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeventyFour() throws Exception {

		String src = "TEST ;\r\n Q:($RE(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$REVERSE", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeventyFive() throws Exception {

		String src = "TEST ;\r\n Q:($REVERSE(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$REVERSE", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeventySix() throws Exception {

		String src = "TEST ;\r\n Q:($S(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$SELECT", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeventySeven() throws Exception {

		String src = "TEST ;\r\n Q:($SELECT(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$SELECT", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeventyEight() throws Exception {

		String src = "TEST ;\r\n Q:($ST(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$STACK", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeventyNine() throws Exception {

		String src = "TEST ;\r\n Q:($STACK(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$STACK", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testEighty() throws Exception {

		String src = "TEST ;\r\n Q:($T(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$TEXT", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testEightyOne() throws Exception {

		String src = "TEST ;\r\n Q:($TEXT(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$TEXT", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testEightyTwo() throws Exception {

		String src = "TEST ;\r\n Q:($TR(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$TRANSLATE", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testEightyThree() throws Exception {

		String src = "TEST ;\r\n Q:($TRANSLATE(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$TRANSLATE", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testEightyFour() throws Exception {

		String src = "TEST ;\r\n Q:($V(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$VIEW", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testEightyFive() throws Exception {

		String src = "TEST ;\r\n Q:($VIEW(0)) foo \r\n"; 
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof FunctionExpression);
		FunctionExpression func = (FunctionExpression)cc.getPostCondition().getExpr();
		assertEquals("$VIEW", func.getName());
		assertNotNull(func.getArgList());
		assertNotNull(func.getArgList().getArgList());
		assertEquals(1, func.getArgList().getArgList().size());

		Arg arg0 = func.getArgList().getArgList().get(0);
		assertNotNull(arg0);
		assertNotNull(arg0.getExpression());

		assertTrue(arg0.getExpression() instanceof NumericConstant);
		
		NumericConstant nconst = (NumericConstant)arg0.getExpression();
		assertEquals("0", nconst.getValue());
	}

}
