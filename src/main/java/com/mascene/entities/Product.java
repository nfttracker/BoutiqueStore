package com.mascene.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.mascene.api.response.Response;

/**
 * @author Raman.Ahuja
 * 
 *         Product Entity
 *
 */
@Entity
public class Product extends Response {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	@Column(nullable = false, unique = true)
	private String productTitle;

	private String productColour;

	@Column(nullable = false)
	private String productDescription;

	@Column(nullable = false, unique = true)
	private long productBarcode;

	@Column(nullable = false)
	private long productQuantity;

	@Column(nullable = false)
	private float productPrice;

	private String reasonForUnavailability;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	private List<ProductSize> productSizes;

	@Column(nullable = false)
	private Date dateAdded;

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductColour() {
		return productColour;
	}

	public void setProductColour(String productColour) {
		this.productColour = productColour;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Long getProductBarcode() {
		return productBarcode;
	}

	public void setProductBarcode(Long productBarcode) {
		this.productBarcode = productBarcode;
	}

	public long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getReasonForUnavailability() {
		return reasonForUnavailability;
	}

	public void setReasonForUnavailability(String reasonForUnavailability) {
		this.reasonForUnavailability = reasonForUnavailability;
	}

	public List<ProductSize> getProductSizes() {
		return productSizes;
	}

	public void setProductSizes(List<ProductSize> productSizes) {
		this.productSizes = productSizes;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productTitle=" + productTitle + ", productColour=" + productColour
				+ ", productDescription=" + productDescription + ", productBarcode=" + productBarcode
				+ ", productQuantity=" + productQuantity + ", productPrice=" + productPrice
				+ ", reasonForUnavailability=" + reasonForUnavailability + ", productSizes=" + productSizes + "]";
	}

}
