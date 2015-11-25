package com.ast;

import com.ast.expression.Expression;

public class OpenParam {
	private DeviceParamList deviceParamList;
	private Expression timeout;
	private MnemonicSpaceList mnemonicSpaceList;
	
	public DeviceParamList getDeviceParamList() {
		return deviceParamList;
	}
	
	public void setDeviceParamList(DeviceParamList deviceParamList) {
		this.deviceParamList = deviceParamList;
	}
	
	public Expression getTimeout() {
		return timeout;
	}
	
	public void setTimeout(Expression timeout) {
		this.timeout = timeout;
	}
	
	public MnemonicSpaceList getMnemonicSpaceList() {
		return mnemonicSpaceList;
	}
	
	public void setMnemonicSpaceList(MnemonicSpaceList mnemonicSpaceList) {
		this.mnemonicSpaceList = mnemonicSpaceList;
	}
	
}
