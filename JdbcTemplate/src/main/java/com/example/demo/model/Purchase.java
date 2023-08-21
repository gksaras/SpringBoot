package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Purchase {
	
	  private int id;
	  private String product;
	  private BigDecimal price;

	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getProduct() {
	    return product;
	  }

	  public void setProduct(String product) {
	    this.product = product;
	  }

	  public BigDecimal getPrice() {
	    return price;
	  }

	  public void setPrice(BigDecimal price) {
	    this.price = price;
	  }
	  
	  @Override
	  public boolean equals(Object obj) {
		  
		  if (this==obj) return true;
			
		  if(obj==null||getClass()!=obj.getClass()) return false;
		  
		  Purchase purchase = (Purchase)obj;
		  return id==purchase.id && Objects.equals(product, purchase.product) && Objects.equals(price, purchase.price);
		  
	  }
	  
	  @Override
	public int hashCode() {
		return Objects.hash(id,product,price);
	}

}
