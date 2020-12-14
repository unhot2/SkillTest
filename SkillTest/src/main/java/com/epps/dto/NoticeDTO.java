package com.epps.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoticeDTO {
	private int notice_num; // 게시판 글번호 (PK)
	private String company; // 회사명
	private Date regdate; // 등록일자 (기본값 'sysdate')
	private String title; // 제목
	private String password; // 비밀번호
	private String writer; // 작성자 (기본값 '관리자')
	private String content; // 내용
	private String announment_start_date;
	private String announment_start_hour;
	private String announment_start_minute;
	private Date announment_start; // 공지기간(시작)
	private String announment_end_date;
	private String announment_end_hour;
	private String announment_end_minute;
	private Date announment_end; // 공지기간(끝)
	private String popup_start_date;
	private String popup_start_hour;
	private String popup_start_minute;
	private Date popup_start; // 팝업기간(시작)
	private String popup_end_date;
	private String popup_end_hour;
	private String popup_end_minute;
	private Date popup_end; // 팝업기간(끝)
	private int popup_use; // 팝업여부
	private String org_file_name; // 파일원본이름
	private String stored_file_name; // 저장용파일이름
	private long file_size; // 파일사이즈
	int current_page; // 현재페이지
	int range_size; // 보여줄 페이지 수
	int hit; // 조회수
	
	/* 초기화용 생성자 */
	public NoticeDTO(){
		this.current_page = 1; // 현재페이지
		this.range_size = 10; // 보여줄 페이지 수
	}
}
