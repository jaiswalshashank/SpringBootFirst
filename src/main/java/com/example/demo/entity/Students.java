package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Getter
//@Setter
@EqualsAndHashCode
public class Students {
	
	@Id
	private int id;
	private String sName;
	private String year;
	@ManyToMany(mappedBy = "student")
	private  List<Library> lib;
	private String issueDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public List<Library> getLib() {
		return lib;
	}
	public void setLib(List<Library> lib) {
		this.lib = lib;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", sName=" + sName + ", year=" + year + ", lib=" + lib + ", issueDate="
				+ issueDate + "]";
	}
	
	
	
}
