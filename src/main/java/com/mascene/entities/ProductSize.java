package com.mascene.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Raman.Ahuja
 * 
 *         ProductSize Entity
 *
 */
@Entity
public class ProductSize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sizeId;

	private String size;

	private long sizeQuantity;

	@Column(nullable = false)
	private Date dateAdded;

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Long getSizeId() {
		return sizeId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public long getSizeQuantity() {
		return sizeQuantity;
	}

	public void setSizeQuantity(long sizeQuantity) {
		this.sizeQuantity = sizeQuantity;
	}

	@Override
	public String toString() {
		return "ProductSize [sizeId=" + sizeId + ", size=" + size + ", sizeQuantity=" + sizeQuantity + "]";
	}

}
