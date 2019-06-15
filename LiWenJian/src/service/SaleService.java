package edu.cuit.gcsj.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import edu.cuit.gcsj.mapper.SaleMapper;
import edu.cuit.gcsj.po.BrokenLine;
import edu.cuit.gcsj.po.JsonData;
import edu.cuit.gcsj.po.Sale;
import edu.cuit.gcsj.po.SaleExample;

public class SaleService implements ISaleService{
	@Autowired
	private SaleMapper saleMapper;
	
	@Override
	public BrokenLine selectSY7() {
		SaleExample example = new SaleExample();
		List<Sale> sales =  saleMapper.selectSY7(example);
		List<String> dates = new ArrayList<>();
		BrokenLine line = new BrokenLine();
		List<JsonData> jsdt = new ArrayList<>();

		Map<String,List<Integer>> map = new HashMap<>();
		for(Sale s : sales) {
			if(dates.contains(s.getYearmonth())) {
			}else
			{
				dates.add(s.getYearmonth());
			}
			
			if(map.containsKey(s.getCategoryName())) {
				List<Integer> list = map.get(s.getCategoryName());
				list.add(s.getId());
				map.put(s.getCategoryName(), list);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(s.getId());
				map.put(s.getCategoryName(), list);			
			}
		}
		int i = 0;
		String[] xcontent=new String[12];
		for(String date : dates) {
			xcontent[i] = date;
			i++;
		}
		for(String cat : map.keySet()) {
			JsonData jd = new JsonData();
			jd.setName(cat);
			Integer[] datas = new Integer[12];
			int j = 0;
			for(Integer value : map.get(cat)) {
				datas[j] = value;
				j++;
			}
			jd.setData(datas);
			jsdt.add(jd);
		}		
		
		
		line.setxContent(xcontent);
		line.setDatas(jsdt);
		//String jsonOutput = JSON.toJSONString();
		return line;
	}

	
}
