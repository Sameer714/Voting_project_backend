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
		private String usernm;
		private String role;
		private long id;
		
		public String getJwtoken() {
			return Jwtoken;
		}
		public void setJwtoken(String jwtoken) {
			Jwtoken = jwtoken;
		}
		public String getUsernm() {
			return usernm;
		}
		public void setUsernm(String usernm) {
			this.usernm = usernm;
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
		
		public JwtResponse(String jwtoken, String usernm, String role, long id) {
			super();
			Jwtoken = jwtoken;
			this.usernm = usernm;
			this.role = role;
			this.id = id;
		}
		
		public JwtResponse() {
			super();
		}
		@Override
		public String toString() {
			return "JwtResponse [Jwtoken=" + Jwtoken + ", usernm=" + usernm + ", role=" + role + ", id=" + id + "]";
		}
	}
	
	public static class JwtRequest {
		private String gmail;
		private String pass;
		
		public JwtRequest() {
		}
		
		public JwtRequest(String gmail, String passw) {
			super();
			this.gmail = gmail;
			this.pass = pass;
		}
		
		public String getGmail() {
			return gmail;
		}
		
		public void setGmail(String gmail) {
			this.gmail = gmail;
		}
		
		public String getPass() {
			return pass;
		}
		
		public void setPass(String passw) {
			this.pass = passw;
		}
		
		@Override
		public String toString() {
			return "JwtRequest [gmail=" + gmail + ", passw=" + pass+ "]";
		}
	}
}