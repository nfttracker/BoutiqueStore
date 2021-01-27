package com.mascene.api.request;

import java.util.List;

import com.mascene.entities.ProductSize;

/**
 * @author Raman.Ahuja
 *
 *         Class to make a request to the api for product CRUD operations
 *
 */
public class ProductRequest {

	private String productTitle;

	private String productColour;

	private String productDescription;

	private long productBarcode;

	private long productQuantity;

	private float productPrice;

	private String reasonForUnavailability;

	// private Map<String, Long> productSizeWithQuantity;

	private List<ProductSize> productSizes;

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

	public long getProductBarcode() {
		return productBarcode;
	}

	public void setProductBarcode(long productBarcode) {
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

//	public Map<String, Long> getProductSizeWithQuantity() {
//		return productSizeWithQuantity;
//	}
//
//	public void setProductSizeWithQuantity(Map<String, Long> productSizeWithQuantity) {
//		this.productSizeWithQuantity = productSizeWithQuantity;
//	}
//
//	@Override
//	public String toString() {
//		return "ProductRequest [productTitle=" + productTitle + ", productColour=" + productColour
//				+ ", productDescription=" + productDescription + ", productBarcode=" + productBarcode
//				+ ", productQuantity=" + productQuantity + ", productPrice=" + productPrice
//				+ ", reasonForUnavailability=" + reasonForUnavailability + ", productSizeWithQuantity="
//				+ productSizeWithQuantity + "]";
//	}

	public List<ProductSize> getProductSizes() {
		return productSizes;
	}

	public void setProductSizes(List<ProductSize> productSizes) {
		this.productSizes = productSizes;
	}

	@Override
	public String toString() {
		return "ProductDto [productTitle=" + productTitle + ", productColour=" + productColour + ", productDescription="
				+ productDescription + ", productBarcode=" + productBarcode + ", productQuantity=" + productQuantity
				+ ", productPrice=" + productPrice + ", reasonForUnavailability=" + reasonForUnavailability
				+ ", productSizes=" + productSizes + "]";
	}

}
