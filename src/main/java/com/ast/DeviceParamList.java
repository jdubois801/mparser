package com.ast;

import java.util.ArrayList;
import java.util.List;

public class DeviceParamList extends AstNode {
	private List<DeviceParam> deviceParamList = new ArrayList<>();

	public List<DeviceParam> getDeviceParamList() {
		return deviceParamList;
	}

	public void setDeviceParamList(List<DeviceParam> deviceParamList) {
		this.deviceParamList = deviceParamList;
	}
	
	public void add(DeviceParam param) {
		this.deviceParamList.add(param);
	}
}
