package edu.cuit.gcsj.po;

import java.util.Arrays;

public class JsonData {
	private String name;
	private Integer[] data;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer[] getData() {
		return data;
	}
	public void setData(Integer[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonData [name=" + name + ", data=" + Arrays.toString(data) + "]";
	}
	
}
