package edu.cuit.gcsj.mapper;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import edu.cuit.gcsj.po.Sale;
import edu.cuit.gcsj.po.SaleExample;


public interface SaleMapper {

	List<Sale> selectSY7(SaleExample example);
	
	List<Sale> selectCategoryName(SaleExample example);
	
	List<Sale> selectBrandName(SaleExample example);
	
	List<Sale> selectProductChineseName(SaleExample example);
	

}