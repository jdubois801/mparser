package com;

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

public class RelationExpressionTest extends BaseTest {

	
	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n Q:(0=1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("=", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}
	
	// in chained expressions of the same level, we bind left to right
	// so in this example, "0&1" binds first, then "x&2"
	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n Q:(0=1<2) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("<", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof RelationExpression);
		RelationExpression bexpr0 = (RelationExpression)bexpr.getLeftExpression();

		assertEquals("=", bexpr0.getOperator());
		assertNotNull(bexpr0.getLeftExpression());
		assertTrue(bexpr0.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr0.getLeftExpression();
		assertEquals("0", nconst.getValue());

		assertNotNull(bexpr0.getRightExpression());
		assertTrue(bexpr0.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr0.getRightExpression();
		assertEquals("1", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("2", nconst.getValue());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n Q:(0<1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("<", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n Q:(0>1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals(">", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n Q:(0]1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("]", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n Q:(0[1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("[", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n Q:(0]]1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("]]", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n Q:(0'=1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("'=", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n Q:(0'<1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("'<", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n Q:(0'>1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("'>", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testEleven() throws Exception {

		String src = "TEST ;\r\n Q:(0']1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("']", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testTwelve() throws Exception {

		String src = "TEST ;\r\n Q:(0'[1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("'[", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testThirteen() throws Exception {

		String src = "TEST ;\r\n Q:(0']]1) foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, QuitCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof QuitCommand);
		QuitCommand cc = (QuitCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof RelationExpression);
		RelationExpression bexpr = (RelationExpression)cc.getPostCondition().getExpr();
		assertEquals("']]", bexpr.getOperator());
		
		assertNotNull(bexpr.getLeftExpression());
		assertTrue(bexpr.getLeftExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)bexpr.getLeftExpression();
		assertEquals("0", nconst.getValue());
		
		assertNotNull(bexpr.getRightExpression());
		assertTrue(bexpr.getRightExpression() instanceof NumericConstant);
		nconst = (NumericConstant)bexpr.getRightExpression();
		assertEquals("1", nconst.getValue());
	}
	
}