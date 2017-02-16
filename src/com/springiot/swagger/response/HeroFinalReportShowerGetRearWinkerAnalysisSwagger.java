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
 * This class contains response on /hero/final/report/shower/get/rear/winker/analysis API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroFinalReportShowerGetRearWinkerAnalysisSwagger {
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

	private List<HeroFinalReportShowerGetRearWinkerAnalysis> object;

	/**
	 * @return the object
	 */
	public List<HeroFinalReportShowerGetRearWinkerAnalysis> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroFinalReportShowerGetRearWinkerAnalysis> object) {
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
class HeroFinalReportShowerGetRearWinkerAnalysis {
	private int id; 
	private String analysis;
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
	 * @return the analysis
	 */
	public String getAnalysis() {
		return analysis;
	}
	/**
	 * @param analysis the analysis to set
	 */
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	} 

}