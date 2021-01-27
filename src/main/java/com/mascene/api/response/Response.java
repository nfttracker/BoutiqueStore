package com.mascene.api.response;

/**
 * @author Raman.Ahuja
 *
 *         Class to get a generalised response
 *
 */
public class Response {

	private String apiResponseMessage;

	private boolean apiResponseStatus;

	public String getApiResponseMessage() {
		return apiResponseMessage;
	}

	public void setApiResponseMessage(String apiResponseMessage) {
		this.apiResponseMessage = apiResponseMessage;
	}

	public boolean isApiResponseStatus() {
		return apiResponseStatus;
	}

	public void setApiResponseStatus(boolean apiResponseStatus) {
		this.apiResponseStatus = apiResponseStatus;
	}

}
