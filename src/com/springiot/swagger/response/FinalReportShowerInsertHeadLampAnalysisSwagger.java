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
 * This class contains response on /final/report/shower/insert/head/lamp/analysis API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FinalReportShowerInsertHeadLampAnalysisSwagger {
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

	private List<FinalReportShowerInsertHeadLampAnalysis> object;

	/**
	 * @return the object
	 */
	public List<FinalReportShowerInsertHeadLampAnalysis> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FinalReportShowerInsertHeadLampAnalysis> object) {
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
class FinalReportShowerInsertHeadLampAnalysis {
	private int in_id; 
	private String analysis;
	/**
	 * @return the in_id
	 */
	public int getIn_id() {
		return in_id;
	}
	/**
	 * @param in_id the in_id to set
	 */
	public void setIn_id(int in_id) {
		this.in_id = in_id;
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