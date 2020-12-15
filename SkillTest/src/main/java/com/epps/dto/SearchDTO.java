package com.epps.dto;

public class SearchDTO {
	private String search_company; // 검색용 회사명
	private String search_regdate_start; // 검색일자(시작)
	private String search_regdate_end; // 검색일자(끝)
	private String search_title; // 검색용 제목
	private String search_writer; // 검색용 작성자

	public String getSearch_company() {
		return search_company;
	}

	public void setSearch_company(String search_company) {
		this.search_company = search_company;
	}

	public String getSearch_regdate_start() {
		return search_regdate_start;
	}

	public void setSearch_regdate_start(String search_regdate_start) {
		this.search_regdate_start = search_regdate_start;
	}

	public String getSearch_regdate_end() {
		return search_regdate_end;
	}

	public void setSearch_regdate_end(String search_regdate_end) {
		this.search_regdate_end = search_regdate_end;
	}

	public String getSearch_title() {
		return search_title;
	}

	public void setSearch_title(String search_title) {
		this.search_title = search_title;
	}

	public String getSearch_writer() {
		return search_writer;
	}

	public void setSearch_writer(String search_writer) {
		this.search_writer = search_writer;
	}

}
