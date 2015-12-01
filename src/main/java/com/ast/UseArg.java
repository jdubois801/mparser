package com.ast;

import com.ast.expression.Expression;

public class UseArg extends Arg {
	private DeviceParamList deviceParams;
	private Expression mnemonicSpace;
	
	public DeviceParamList getDeviceParams() {
		return deviceParams;
	}
	
	public void setDeviceParams(DeviceParamList deviceParams) {
		this.deviceParams = deviceParams;
	}
	
	public Expression getMnemonicSpace() {
		return mnemonicSpace;
	}

	public void setMnemonicSpace(Expression mnemonicSpace) {
		this.mnemonicSpace = mnemonicSpace;
	}
}
