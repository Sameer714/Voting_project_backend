package com.techvum.vote.voting.model;


public class VoteRequest {
	private long queryId;
	private long userId;
	private String selectedOption;
	public long getQueryId() {
		return queryId;
	}
	public void setQueryId(long queryId) {
		this.queryId = queryId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getSelectedOption() {
		return selectedOption;
	}
	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}
	@Override
	public String toString() {
		return "VoteRequest [queryId=" + queryId + ", userId=" + userId + ", selectedOption=" + selectedOption
				+ "]";
	}
	public VoteRequest(long queryId, long userId, String selectedOption) {
		super();
		this.queryId = queryId;
		this.userId = userId;
		this.selectedOption = selectedOption;
	}
	public VoteRequest() {
		super();
	}
}