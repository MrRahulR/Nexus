package com.nexusv1.execution;

import com.beust.jcommander.Parameter;


public class Arguments {

	@Parameter(names = { "-init" })
	private boolean init = false;

	public final boolean a() {
		return this.init;
	}
}