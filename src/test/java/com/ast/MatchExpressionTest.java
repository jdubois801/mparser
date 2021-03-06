package com.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.command.Command;
import com.ast.command.QuitCommand;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.MatchExpression;
import com.ast.expression.NumericConstant;
import com.ast.expression.StringConstant;

public class MatchExpressionTest extends BaseTest {

	
	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n Q:(0?.E) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof MatchExpression);
		MatchExpression mexpr = (MatchExpression)cc.getPostCondition().getExpr();
		assertEquals("?", mexpr.getOperator());
		
		assertNotNull(mexpr.getLeftExpression());
		assertTrue(mexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)mexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(mexpr.getPattern());
		assertTrue(mexpr.getPattern() instanceof StringConstant);
		StringConstant sconst = (StringConstant)mexpr.getPattern();
		assertEquals(".E", sconst.getValue());
	}
	
	// in chained expressions of the same level, we bind left to right
	// so in this example, "0?." binds first, then "x?."
	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n Q:(0?.E?.E) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof MatchExpression);
		MatchExpression mexpr = (MatchExpression)cc.getPostCondition().getExpr();
		assertEquals("?", mexpr.getOperator());
		
		assertNotNull(mexpr.getLeftExpression());
		assertTrue(mexpr.getLeftExpression() instanceof MatchExpression);
		MatchExpression mexpr0 = (MatchExpression)mexpr.getLeftExpression();

		assertNotNull(mexpr0.getLeftExpression());
		assertTrue(mexpr0.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)mexpr0.getLeftExpression();
		assertEquals("0", nconst.getValue());

		assertNotNull(mexpr0.getPattern());
		assertTrue(mexpr0.getPattern() instanceof StringConstant);
		StringConstant sconst = (StringConstant)mexpr0.getPattern();
		assertEquals(".E", sconst.getValue());
		
		assertNotNull(mexpr.getPattern());
		assertTrue(mexpr.getPattern() instanceof StringConstant);
		sconst = (StringConstant)mexpr.getPattern();
		assertEquals(".E", sconst.getValue());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n Q:(0?@bar) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof MatchExpression);
		MatchExpression mexpr = (MatchExpression)cc.getPostCondition().getExpr();
		assertEquals("?", mexpr.getOperator());
		
		assertNotNull(mexpr.getLeftExpression());
		assertTrue(mexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)mexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(mexpr.getPattern());
		assertTrue(mexpr.getPattern() instanceof IndirectExpression);
		IndirectExpression indexpr = (IndirectExpression)mexpr.getPattern();
		assertNotNull(indexpr.getValue());
		assertTrue(indexpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)indexpr.getValue();
		assertEquals("bar", lvexpr.getName());
	}
	
	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n Q:(0?1.E) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof MatchExpression);
		MatchExpression mexpr = (MatchExpression)cc.getPostCondition().getExpr();
		assertEquals("?", mexpr.getOperator());
		
		assertNotNull(mexpr.getLeftExpression());
		assertTrue(mexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)mexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(mexpr.getPattern());
		assertTrue(mexpr.getPattern() instanceof StringConstant);
		StringConstant sconst = (StringConstant)mexpr.getPattern();
		assertEquals("1.E", sconst.getValue());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n Q:(0?.2E) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof MatchExpression);
		MatchExpression mexpr = (MatchExpression)cc.getPostCondition().getExpr();
		assertEquals("?", mexpr.getOperator());
		
		assertNotNull(mexpr.getLeftExpression());
		assertTrue(mexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)mexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(mexpr.getPattern());
		assertTrue(mexpr.getPattern() instanceof StringConstant);
		StringConstant sconst = (StringConstant)mexpr.getPattern();
		assertEquals(".2E", sconst.getValue());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n Q:(0?1.2E) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof MatchExpression);
		MatchExpression mexpr = (MatchExpression)cc.getPostCondition().getExpr();
		assertEquals("?", mexpr.getOperator());
		
		assertNotNull(mexpr.getLeftExpression());
		assertTrue(mexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)mexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(mexpr.getPattern());
		assertTrue(mexpr.getPattern() instanceof StringConstant);
		StringConstant sconst = (StringConstant)mexpr.getPattern();
		assertEquals("1.2E", sconst.getValue());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n Q:(0?1.2\"a\") foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof MatchExpression);
		MatchExpression mexpr = (MatchExpression)cc.getPostCondition().getExpr();
		assertEquals("?", mexpr.getOperator());
		
		assertNotNull(mexpr.getLeftExpression());
		assertTrue(mexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)mexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(mexpr.getPattern());
		assertTrue(mexpr.getPattern() instanceof StringConstant);
		StringConstant sconst = (StringConstant)mexpr.getPattern();
		assertEquals("1.2\"a\"", sconst.getValue());
	}
	
	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n Q:(0?1.2YaY) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof MatchExpression);
		MatchExpression mexpr = (MatchExpression)cc.getPostCondition().getExpr();
		assertEquals("?", mexpr.getOperator());
		
		assertNotNull(mexpr.getLeftExpression());
		assertTrue(mexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)mexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(mexpr.getPattern());
		assertTrue(mexpr.getPattern() instanceof StringConstant);
		StringConstant sconst = (StringConstant)mexpr.getPattern();
		assertEquals("1.2YaY", sconst.getValue());
	}

	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n Q:(0?1.2ZaZ) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof MatchExpression);
		MatchExpression mexpr = (MatchExpression)cc.getPostCondition().getExpr();
		assertEquals("?", mexpr.getOperator());
		
		assertNotNull(mexpr.getLeftExpression());
		assertTrue(mexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)mexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(mexpr.getPattern());
		assertTrue(mexpr.getPattern() instanceof StringConstant);
		StringConstant sconst = (StringConstant)mexpr.getPattern();
		assertEquals("1.2ZaZ", sconst.getValue());
	}
	
	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n Q:(0?1.2ZaZ1.2YbY) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof MatchExpression);
		MatchExpression mexpr = (MatchExpression)cc.getPostCondition().getExpr();
		assertEquals("?", mexpr.getOperator());
		
		assertNotNull(mexpr.getLeftExpression());
		assertTrue(mexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)mexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(mexpr.getPattern());
		assertTrue(mexpr.getPattern() instanceof StringConstant);
		StringConstant sconst = (StringConstant)mexpr.getPattern();
		assertEquals("1.2ZaZ1.2YbY", sconst.getValue());
	}
}
