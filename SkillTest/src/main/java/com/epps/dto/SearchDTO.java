package com.epps.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {
	private String search_company; // 검색용 회사명
	private String search_regdate_start; // 검색일자(시작)
	private String search_regdate_end; // 검색일자(끝)
	private String search_title; // 검색용 제목
	private String search_writer; // 검색용 작성자
}
