package com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.ast.Command;
import com.ast.LockCommand;
import com.ast.Routine;

public class LockCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n LOCK foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);
		
		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n L foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
	}

	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n L foo,bar \r\n";
		Routine routine = parseAndValidate(src); 
		
		List<Command> cmdList = findAllCommands(routine, LockCommand.class); 
		assertNotNull(cmdList);
		assertEquals(1, cmdList.size());
		
		for (Command cmd : cmdList) {
			
			assertTrue(cmd instanceof LockCommand);
			LockCommand lc = (LockCommand)cmd;
			assertNotNull(lc.getArgList());
			assertNull(lc.getPostCondition());
			
			assertNotNull(lc.getArgList());
			assertNotNull(lc.getArgList().getArgList());
			assertEquals(2, lc.getArgList().getArgList().size());
		}
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n L:0 foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
	}

	@Test
	public void testFour() throws Exception {

		String src = "TEST ;\r\n L +foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the +/- modifier?
	}

	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n L -foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the +/- modifier?
	}
	
	@Test
	public void testSix() throws Exception {

		String src = "TEST ;\r\n L (foo,bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(2, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the arg list?
	}

	@Test
	public void testSeven() throws Exception {

		String src = "TEST ;\r\n L foo 10 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the timeout?
	}

	@Test
	public void testEight() throws Exception {

		String src = "TEST ;\r\n L ^|env|foo(bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testNine() throws Exception {

		String src = "TEST ;\r\n L |env|foo(bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testTen() throws Exception {

		String src = "TEST ;\r\n L ^foo(bar) \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testEleven() throws Exception {

		String src = "TEST ;\r\n L |env|foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testTwelve() throws Exception {

		String src = "TEST ;\r\n L ^foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testThirteen() throws Exception {

		String src = "TEST ;\r\n L |env|foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
		assertEquals(1, lc.getArgList().getArgList().size());
		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the verbose nref?
	}

	@Test
	public void testFourteen() throws Exception {

		String src = "TEST ;\r\n L @foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, LockCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof LockCommand);
		LockCommand lc = (LockCommand)cmd;
		assertNotNull(lc.getArgList());
		assertNull(lc.getPostCondition());
		
		assertNotNull(lc.getArgList());
		assertNotNull(lc.getArgList().getArgList());
//		assertEquals(1, lc.getArgList().getArgList().size());
//		assertNotNull(lc.getArgList().getArgList().get(0));
		
		// TODO - how to test the reference?
	}
}


