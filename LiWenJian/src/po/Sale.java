package edu.cuit.gcsj.po;

public class Sale {
    private Integer id;

    private String yearmonth;

    private String productChineseName;

    private String categoryName;

    private String brandName;

    private Integer catnum;
    
    private Integer brandnum;
    
    private Integer chinesenum;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(String yearmonth) {
        this.yearmonth = yearmonth == null ? null : yearmonth.trim();
    }

	public String getProductChineseName() {
		return productChineseName;
	}

	public void setProductChineseName(String productChineseName) {
		this.productChineseName = productChineseName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getCatnum() {
		return catnum;
	}

	public void setCatnum(Integer catnum) {
		this.catnum = catnum;
	}

	public Integer getBrandnum() {
		return brandnum;
	}

	public void setBrandnum(Integer brandnum) {
		this.brandnum = brandnum;
	}

	public Integer getChinesenum() {
		return chinesenum;
	}

	public void setChinesenum(Integer chinesenum) {
		this.chinesenum = chinesenum;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", yearmonth=" + yearmonth + ", productChineseName=" + productChineseName
				+ ", categoryName=" + categoryName + ", brandName=" + brandName + ", catnum=" + catnum + ", brandnum="
				+ brandnum + ", chinesenum=" + chinesenum + "]";
	}

    
}