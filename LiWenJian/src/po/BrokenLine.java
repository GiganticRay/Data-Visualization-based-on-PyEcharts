package edu.cuit.gcsj.po;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class BrokenLine 
{
	private String[] xContent;
	private List<JsonData> data;
	public String[] getxContent() {
		return xContent;
	}
	public void setxContent(String[] xContent) {
		this.xContent = xContent;
	}
	public List<JsonData> getData() {
		return data;
	}
	public void setDatas(List<JsonData> datas) {
		this.data = datas;
	}
	@Override
	public String toString() {
		return "BrokenLine [xContent=" + Arrays.toString(xContent) + ", datas=" + data + "]";
	}

	
	
	
	
	
}
