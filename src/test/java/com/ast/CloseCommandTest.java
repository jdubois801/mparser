package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.CloseCommand;
import com.ast.command.Command;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;

public class CloseCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n CLOSE foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof CloseArg);

		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n C foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());

		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof CloseArg);

		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n C:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNotNull(cc.getPostCondition());
		assertNotNull(cc.getPostCondition().getExpr());
		assertTrue(cc.getPostCondition().getExpr() instanceof NumericConstant);
		NumericConstant nconst0 = (NumericConstant)cc.getPostCondition().getExpr();
		assertEquals("0", nconst0.getValue());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof CloseArg);

		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n C foo:0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof CloseArg);
		
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
		
		CloseArg carg = (CloseArg)arg0;
		assertNotNull(carg.getDeviceParamList());
		assertNotNull(carg.getDeviceParamList().getDeviceParamList());
		assertEquals(1, carg.getDeviceParamList().getDeviceParamList().size());
		DeviceParam dp = carg.getDeviceParamList().getDeviceParamList().get(0);
		assertNull(dp.getName());
		assertNotNull(dp.getExpression());
		assertTrue(dp.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)dp.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n C foo:bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof CloseArg);
		
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
		
		CloseArg carg = (CloseArg)arg0;
		assertNotNull(carg.getDeviceParamList());
		assertNotNull(carg.getDeviceParamList().getDeviceParamList());
		assertEquals(1, carg.getDeviceParamList().getDeviceParamList().size());
		DeviceParam dp = carg.getDeviceParamList().getDeviceParamList().get(0);
		assertEquals("bar", dp.getName());
		assertNull(dp.getExpression());
	}
	
	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n C foo:bar=0 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof CloseArg);

		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
		
		CloseArg carg = (CloseArg)arg0;
		assertNotNull(carg.getDeviceParamList());
		assertNotNull(carg.getDeviceParamList().getDeviceParamList());
		assertEquals(1, carg.getDeviceParamList().getDeviceParamList().size());
		DeviceParam dp = carg.getDeviceParamList().getDeviceParamList().get(0);
		assertEquals("bar", dp.getName());
		assertNotNull(dp.getExpression());
		assertTrue(dp.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)dp.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n C foo:(0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof CloseArg);
		
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
		
		CloseArg carg = (CloseArg)arg0;
		assertNotNull(carg.getDeviceParamList());
		assertNotNull(carg.getDeviceParamList().getDeviceParamList());
		assertEquals(1, carg.getDeviceParamList().getDeviceParamList().size());
		DeviceParam dp = carg.getDeviceParamList().getDeviceParamList().get(0);
		assertNull(dp.getName());
		assertNotNull(dp.getExpression());
		assertTrue(dp.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)dp.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n C foo:(bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof CloseArg);
		
		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
		
		CloseArg carg = (CloseArg)arg0;
		assertNotNull(carg.getDeviceParamList());
		assertNotNull(carg.getDeviceParamList().getDeviceParamList());
		assertEquals(1, carg.getDeviceParamList().getDeviceParamList().size());
		DeviceParam dp = carg.getDeviceParamList().getDeviceParamList().get(0);
		assertEquals("bar", dp.getName());
		assertNull(dp.getExpression());
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n C foo:(bar=0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof CloseArg);

		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
		
		CloseArg carg = (CloseArg)arg0;
		assertNotNull(carg.getDeviceParamList());
		assertNotNull(carg.getDeviceParamList().getDeviceParamList());
		assertEquals(1, carg.getDeviceParamList().getDeviceParamList().size());
		DeviceParam dp = carg.getDeviceParamList().getDeviceParamList().get(0);
		assertEquals("bar", dp.getName());
		assertNotNull(dp.getExpression());
		assertTrue(dp.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)dp.getExpression();
		assertEquals("0", nconst.getValue());
	}

	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n C foo:(devicekeyword:12:bar=0) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg0 = cc.getArgList().getArgList().get(0);
		assertTrue(arg0 instanceof CloseArg);

		assertNotNull(arg0.getExpression());
		assertTrue(arg0.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lvexpr = (LocalVariableExpression)arg0.getExpression();
		assertEquals("foo", lvexpr.getName());
		
		CloseArg carg = (CloseArg)arg0;
		assertNotNull(carg.getDeviceParamList());
		assertNotNull(carg.getDeviceParamList().getDeviceParamList());
		assertEquals(3, carg.getDeviceParamList().getDeviceParamList().size());
		DeviceParam dp = carg.getDeviceParamList().getDeviceParamList().get(0);
		assertEquals("devicekeyword", dp.getName());
		assertNull(dp.getExpression());
		
		dp = carg.getDeviceParamList().getDeviceParamList().get(1);
		assertNull(dp.getName());
		assertNotNull(dp.getExpression());
		assertTrue(dp.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)dp.getExpression();
		assertEquals("12", nconst.getValue());
		
		dp = carg.getDeviceParamList().getDeviceParamList().get(2);
		assertEquals("bar", dp.getName());
		assertNotNull(dp.getExpression());
		assertTrue(dp.getExpression() instanceof NumericConstant);
		nconst = (NumericConstant)dp.getExpression();
		assertEquals("0", nconst.getValue());
	}
	
	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n C @foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, CloseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof CloseCommand);
		CloseCommand cc = (CloseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof CloseArg);

		assertNotNull(arg.getExpression());
		assertTrue(arg.getExpression() instanceof IndirectExpression);
		
		IndirectExpression indExpr = (IndirectExpression)arg.getExpression();
		assertNotNull(indExpr.getValue());

		assertTrue(indExpr.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lvExpr = (LocalVariableExpression)indExpr.getValue();
		assertEquals("foo", lvExpr.getName());
	}
}

