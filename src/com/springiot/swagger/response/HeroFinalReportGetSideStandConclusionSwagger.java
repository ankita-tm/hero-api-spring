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
 * This class contains response on /hero/final/report/get/side/stand/conclusion API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroFinalReportGetSideStandConclusionSwagger {
	private String description;
/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<HeroFinalReportGetSideStandConclusion> object;

	/**
	 * @return the object
	 */
	public List<HeroFinalReportGetSideStandConclusion> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroFinalReportGetSideStandConclusion> object) {
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
*TO get response parameter getter setter
*/
class HeroFinalReportGetSideStandConclusion {
	private int id;
	private String conclusion;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the conclusion
	 */
	public String getConclusion() {
		return conclusion;
	}
	/**
	 * @param conclusion the conclusion to set
	 */
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

}
