package com;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ast.Command;
import com.ast.JobCommand;
import com.ast.Routine;

public class JobCommandTest extends BaseTest {

	@Test
	public void testZero() throws Exception {

		String src = "TEST ;\r\n JOB ^foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
	}

	@Test
	public void testOne() throws Exception {

		String src = "TEST ;\r\n J ^foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
	}
	
	@Test
	public void testTwo() throws Exception {

		String src = "TEST ;\r\n J:0 ^foo \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNotNull(cc.getPostCondition());
	}

	@Test
	public void testThree() throws Exception {

		String src = "TEST ;\r\n J ^foo,^bar,^grok \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
	}

//	@Test
//	public void testFour() throws Exception {
//
//		String src = "TEST ;\r\n J ^routine:10 \r\n";
//		Routine routine = parseAndValidate(src); 
//		Command cmd = findFirstCommand(routine, JobCommand.class);
//
//		assertNotNull(cmd);
//		assertTrue(cmd instanceof JobCommand);
//		JobCommand cc = (JobCommand)cmd;
//		assertNull(cc.getPostCondition());
//	}
	
	@Test
	public void testFive() throws Exception {

		String src = "TEST ;\r\n J ^routine:10 20 \r\n";
		Routine routine = parseAndValidate(src); 
		Command cmd = findFirstCommand(routine, JobCommand.class);

		assertNotNull(cmd);
		assertTrue(cmd instanceof JobCommand);
		JobCommand cc = (JobCommand)cmd;
		assertNull(cc.getPostCondition());
	}

}

