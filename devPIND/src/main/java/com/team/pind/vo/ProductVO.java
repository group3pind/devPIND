package com.team.pind.vo;

public class ProductVO {
	
	String productTitle;
	String productURL;
	String productImage;
	int productLPrice;
	
	public ProductVO(String productTitle, String productURL, String productImage, int productLPrice) {
		super();
		this.productTitle = productTitle;
		this.productURL = productURL;
		this.productImage = productImage;
		this.productLPrice = productLPrice;
	}

	public ProductVO() {
		super();
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductURL() {
		return productURL;
	}

	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public int getProductLPrice() {
		return productLPrice;
	}

	public void setProductLPrice(int productLPrice) {
		this.productLPrice = productLPrice;
	}

	@Override
	public String toString() {
		return "ProductVO [productTitle=" + productTitle + ", productURL=" + productURL + ", productImage="
				+ productImage + ", productLPrice=" + productLPrice + "]";
	}


}
