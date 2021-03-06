/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

/**
 * To Import Classes to access their functionality
 */
import java.util.List;

/**
 * 
 * This class contains response on
 * /hero/final/report/shower/starter/insert/relay/signature API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroFinalReportShowerStarterInsertRelaySignatureSwagger {
	private String description;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<HeroFinalReportShowerStarterInsertRelaySignature> object;

	/**
	 * @return the object
	 */
	public List<HeroFinalReportShowerStarterInsertRelaySignature> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroFinalReportShowerStarterInsertRelaySignature> object) {
		this.object = object;
	}

	private boolean valid;

	/**
	 * To get if object is Valid
	 * 
	 * @return
	 */
	public boolean isValid() {
		return valid;
	}

	/**
	 * To set Object Valid
	 * 
	 * @param valid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

/*
 * TO get response parameter getter setter
 */
class HeroFinalReportShowerStarterInsertRelaySignature {
	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
