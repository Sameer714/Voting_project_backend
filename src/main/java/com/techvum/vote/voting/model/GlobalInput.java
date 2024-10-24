package com.techvum.vote.voting.model;

public class GlobalInput {
	public static class signin{
		private String email;
		private String pass;
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		@Override
		public String toString() {
			return "signin [email=" + email + ", pass=" + pass + "]";
		}
		public signin(String email, String pass) {
			super();
			this.email = email;
			this.pass = pass;
		}
		public signin() {
			super();
		}
	}

	public static class JwtResponse {
		
		private String Jwtoken;
		private String username;
		private String role;
		private long id;
		
		public String getJwtoken() {
			return Jwtoken;
		}
		public void setJwtoken(String jwtoken) {
			Jwtoken = jwtoken;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		public JwtResponse(String jwtoken, String username, String role, long id) {
			super();
			Jwtoken = jwtoken;
			this.username = username;
			this.role = role;
			this.id = id;
		}
		
		public JwtResponse() {
			super();
		}
		@Override
		public String toString() {
			return "JwtResponse [Jwtoken=" + Jwtoken + ", usernm=" + username + ", role=" + role + ", id=" + id + "]";
		}
	}
	
	public static class JwtRequest {
		private String email;
		private String pass;
		
		public JwtRequest() {
		}
		
		public JwtRequest(String email, String pass) {
			super();
			this.email = email;
			this.pass = pass;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getPass() {
			return pass;
		}
		
		public void setPass(String pass) {
			this.pass = pass;
		}
		
		@Override
		public String toString() {
			return "JwtRequest [email=" + email + ", pass=" + pass+ "]";
		}
	}
	

	public static class VoteRequest {
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
}