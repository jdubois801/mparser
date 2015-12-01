package com.ast;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ast.Routine;
import com.ast.command.Command;
import com.ast.command.UseCommand;
import com.ast.expression.IndirectExpression;
import com.ast.expression.LocalVariableExpression;
import com.ast.expression.NumericConstant;

public class UseCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n USE foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof UseArg);
		UseArg uarg = (UseArg)arg;
		assertNull(uarg.getDeviceParams());
		assertNull(uarg.getMnemonicSpace());
		assertNotNull(uarg.getExpression());
		assertTrue(uarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)uarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n U foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof UseArg);
		UseArg uarg = (UseArg)arg;
		assertNull(uarg.getDeviceParams());
		assertNull(uarg.getMnemonicSpace());
		assertNotNull(uarg.getExpression());
		assertTrue(uarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)uarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n U:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNotNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof UseArg);
		UseArg uarg = (UseArg)arg;
		assertNull(uarg.getDeviceParams());
		assertNull(uarg.getMnemonicSpace());
		assertNotNull(uarg.getExpression());
		assertTrue(uarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)uarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
	}
	
	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n U foo,@bar \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(2, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof UseArg);
		UseArg uarg = (UseArg)arg;
		assertNull(uarg.getDeviceParams());
		assertNull(uarg.getMnemonicSpace());
		assertNotNull(uarg.getExpression());
		assertTrue(uarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)uarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		Arg arg1 = cc.getArgList().getArgList().get(1);
		assertTrue(arg1 instanceof UseArg);
		UseArg uarg1 = (UseArg)arg1;
		assertNull(uarg1.getDeviceParams());
		assertNull(uarg1.getMnemonicSpace());
		assertNotNull(uarg1.getExpression());
		assertTrue(uarg1.getExpression() instanceof IndirectExpression);
		IndirectExpression ie = (IndirectExpression)uarg1.getExpression();
		assertNull(ie.getIndirectArgList());
		assertNotNull(ie.getValue());
		assertTrue(ie.getValue() instanceof LocalVariableExpression);
		LocalVariableExpression lve1 = (LocalVariableExpression)ie.getValue();
		assertNull(lve1.getArgList());
		assertEquals("bar", lve1.getName());

	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n U foo:1 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof UseArg);
		UseArg uarg = (UseArg)arg;
		assertNotNull(uarg.getDeviceParams());
		assertNull(uarg.getMnemonicSpace());
		assertNotNull(uarg.getExpression());
		assertTrue(uarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)uarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		assertNotNull(uarg.getDeviceParams().getDeviceParamList());
		assertEquals(1, uarg.getDeviceParams().getDeviceParamList().size());
		DeviceParam dp = uarg.getDeviceParams().getDeviceParamList().get(0);
		assertNull(dp.getName());
		assertNotNull(dp.getExpression());
		assertTrue(dp.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)dp.getExpression();
		assertEquals("1", nconst.getValue());
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n U foo:1:mnemonicspace \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof UseArg);
		UseArg uarg = (UseArg)arg;
		assertNotNull(uarg.getDeviceParams());
		assertNotNull(uarg.getMnemonicSpace());
		assertNotNull(uarg.getExpression());
		assertTrue(uarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)uarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		assertNotNull(uarg.getDeviceParams().getDeviceParamList());
		assertEquals(1, uarg.getDeviceParams().getDeviceParamList().size());
		DeviceParam dp = uarg.getDeviceParams().getDeviceParamList().get(0);
		assertNull(dp.getName());
		assertNotNull(dp.getExpression());
		assertTrue(dp.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)dp.getExpression();
		assertEquals("1", nconst.getValue());
		
		assertTrue(uarg.getMnemonicSpace() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)uarg.getMnemonicSpace();
		assertNull(lve2.getArgList());
		assertEquals("mnemonicspace", lve2.getName());
	}
	
	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n U foo:(1:2:3) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof UseArg);
		UseArg uarg = (UseArg)arg;
		assertNotNull(uarg.getDeviceParams());
		assertNull(uarg.getMnemonicSpace());
		assertNotNull(uarg.getExpression());
		assertTrue(uarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)uarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		assertNotNull(uarg.getDeviceParams().getDeviceParamList());
		assertEquals(3, uarg.getDeviceParams().getDeviceParamList().size());
		DeviceParam dp = uarg.getDeviceParams().getDeviceParamList().get(0);
		assertNull(dp.getName());
		assertNotNull(dp.getExpression());
		assertTrue(dp.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)dp.getExpression();
		assertEquals("1", nconst.getValue());
		
		DeviceParam dp1 = uarg.getDeviceParams().getDeviceParamList().get(1);
		assertNull(dp1.getName());
		assertNotNull(dp1.getExpression());
		assertTrue(dp1.getExpression() instanceof NumericConstant);
		NumericConstant nconst1 = (NumericConstant)dp1.getExpression();
		assertEquals("2", nconst1.getValue());

		DeviceParam dp2 = uarg.getDeviceParams().getDeviceParamList().get(2);
		assertNull(dp2.getName());
		assertNotNull(dp2.getExpression());
		assertTrue(dp2.getExpression() instanceof NumericConstant);
		NumericConstant nconst2 = (NumericConstant)dp2.getExpression();
		assertEquals("3", nconst2.getValue());
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n U foo:(1:2:3):mnemonicspace \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, UseCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof UseCommand);
		UseCommand cc = (UseCommand)cmd;
		assertNull(cc.getPostCondition());
		
		assertNotNull(cc.getArgList());
		assertNotNull(cc.getArgList().getArgList());
		assertEquals(1, cc.getArgList().getArgList().size());
		Arg arg = cc.getArgList().getArgList().get(0);
		assertTrue(arg instanceof UseArg);
		UseArg uarg = (UseArg)arg;
		assertNotNull(uarg.getDeviceParams());
		assertNotNull(uarg.getMnemonicSpace());
		assertNotNull(uarg.getExpression());
		assertTrue(uarg.getExpression() instanceof LocalVariableExpression);
		LocalVariableExpression lve = (LocalVariableExpression)uarg.getExpression();
		assertNull(lve.getArgList());
		assertEquals("foo", lve.getName());
		
		assertNotNull(uarg.getDeviceParams().getDeviceParamList());
		assertEquals(3, uarg.getDeviceParams().getDeviceParamList().size());
		DeviceParam dp = uarg.getDeviceParams().getDeviceParamList().get(0);
		assertNull(dp.getName());
		assertNotNull(dp.getExpression());
		assertTrue(dp.getExpression() instanceof NumericConstant);
		NumericConstant nconst = (NumericConstant)dp.getExpression();
		assertEquals("1", nconst.getValue());
		
		DeviceParam dp1 = uarg.getDeviceParams().getDeviceParamList().get(1);
		assertNull(dp1.getName());
		assertNotNull(dp1.getExpression());
		assertTrue(dp1.getExpression() instanceof NumericConstant);
		NumericConstant nconst1 = (NumericConstant)dp1.getExpression();
		assertEquals("2", nconst1.getValue());

		DeviceParam dp2 = uarg.getDeviceParams().getDeviceParamList().get(2);
		assertNull(dp2.getName());
		assertNotNull(dp2.getExpression());
		assertTrue(dp2.getExpression() instanceof NumericConstant);
		NumericConstant nconst2 = (NumericConstant)dp2.getExpression();
		assertEquals("3", nconst2.getValue());
		
		assertTrue(uarg.getMnemonicSpace() instanceof LocalVariableExpression);
		LocalVariableExpression lve2 = (LocalVariableExpression)uarg.getMnemonicSpace();
		assertNull(lve2.getArgList());
		assertEquals("mnemonicspace", lve2.getName());
	}
}

