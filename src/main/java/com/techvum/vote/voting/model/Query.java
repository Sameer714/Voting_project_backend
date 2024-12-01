package com.techvum.vote.voting.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "query")
public class Query{
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)	
	@Column(name="Id")
	private long id;
	
	@Column(name="query")
	private String query;
	
	@Column(name="status")
	private String status;
	
	@Column(name="op1")
	private String option1;
	
	@Column(name="op2")
	private String option2;
	
	@Column(name="op3")
	private String option3;
	
	@Column(name="op4")
	private String option4;
	
    public Query(String query, String status, String option1, String option2) {
        this(query, status, option1, option2, null, null);
    }

    public Query(String query, String status, String option1, String option2, String option3) {
        this(query, status, option1, option2, option3, null);
    }

    public Query(String query, String status, String option1, String option2, String option3, String option4) {
        this.query = query;
        this.status = status;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
        
	@Override
	public String toString() {
		return "Query [id=" + id + ", query=" + query + ", status=" + status + ", option1=" + option1 + ", option2="
				+ option2 + ", option3=" + option3 + ", option4=" + option4 + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOption1() {
		return option1;
	}
	public Query() {
		super();
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
}

