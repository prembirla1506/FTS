package com.cts.fms.event.model;

import java.io.Serializable;

public class SubmitFeedbackResponse implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	public SubmitFeedbackResponse() {
		super();
	}

	private int summaryFeedbackCount;
	private int naFeedbackCount;
	private int unFeedbackCount;
	
	public int getSummaryFeedbackCount() {
		return summaryFeedbackCount;
	}
	public void setSummaryFeedbackCount(int summaryFeedbackCount) {
		this.summaryFeedbackCount = summaryFeedbackCount;
	}
	public int getNaFeedbackCount() {
		return naFeedbackCount;
	}
	public void setNaFeedbackCount(int naFeedbackCount) {
		this.naFeedbackCount = naFeedbackCount;
	}
	public int getUnFeedbackCount() {
		return unFeedbackCount;
	}
	public void setUnFeedbackCount(int unFeedbackCount) {
		this.unFeedbackCount = unFeedbackCount;
	}
	
	

}
