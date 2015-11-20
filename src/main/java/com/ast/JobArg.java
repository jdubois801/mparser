package com.ast;

import com.ast.expression.Expression;

public class JobArg extends Arg {

	private JobParam jobParams;

	public JobParam getJobParams() {
		return jobParams;
	}

	public void setJobParams(JobParam jobParams) {
		this.jobParams = jobParams;
	}
}
