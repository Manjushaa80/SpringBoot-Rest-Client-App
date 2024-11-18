package com.app.model;


public class Product {
	
	private Integer productId;
	private String productName;
	private Double productPrice;
	private String compannyName;
	private String productCategory;
	private String productColor;

        

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getCompannyName() {
		return compannyName;
	}
	public void setCompannyName(String compannyName) {
		this.compannyName = compannyName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public Product(Integer productId, String productName, Double productPrice, String compannyName,
			String productCategory, String productColor) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.compannyName = compannyName;
		this.productCategory = productCategory;
		this.productColor = productColor;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", compannyName=" + compannyName + ", productCategory=" + productCategory + ", productColor="
				+ productColor + "]";
	}
     
           
       public void m1(){

       System.out.println("m1 method add");
}
	

}
