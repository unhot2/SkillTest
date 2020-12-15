package com.epps.dto;

import java.util.Date;

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

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnnounment_start_date() {
		return announment_start_date;
	}

	public void setAnnounment_start_date(String announment_start_date) {
		this.announment_start_date = announment_start_date;
	}

	public String getAnnounment_start_hour() {
		return announment_start_hour;
	}

	public void setAnnounment_start_hour(String announment_start_hour) {
		this.announment_start_hour = announment_start_hour;
	}

	public String getAnnounment_start_minute() {
		return announment_start_minute;
	}

	public void setAnnounment_start_minute(String announment_start_minute) {
		this.announment_start_minute = announment_start_minute;
	}

	public Date getAnnounment_start() {
		return announment_start;
	}

	public void setAnnounment_start(Date announment_start) {
		this.announment_start = announment_start;
	}

	public String getAnnounment_end_date() {
		return announment_end_date;
	}

	public void setAnnounment_end_date(String announment_end_date) {
		this.announment_end_date = announment_end_date;
	}

	public String getAnnounment_end_hour() {
		return announment_end_hour;
	}

	public void setAnnounment_end_hour(String announment_end_hour) {
		this.announment_end_hour = announment_end_hour;
	}

	public String getAnnounment_end_minute() {
		return announment_end_minute;
	}

	public void setAnnounment_end_minute(String announment_end_minute) {
		this.announment_end_minute = announment_end_minute;
	}

	public Date getAnnounment_end() {
		return announment_end;
	}

	public void setAnnounment_end(Date announment_end) {
		this.announment_end = announment_end;
	}

	public String getPopup_start_date() {
		return popup_start_date;
	}

	public void setPopup_start_date(String popup_start_date) {
		this.popup_start_date = popup_start_date;
	}

	public String getPopup_start_hour() {
		return popup_start_hour;
	}

	public void setPopup_start_hour(String popup_start_hour) {
		this.popup_start_hour = popup_start_hour;
	}

	public String getPopup_start_minute() {
		return popup_start_minute;
	}

	public void setPopup_start_minute(String popup_start_minute) {
		this.popup_start_minute = popup_start_minute;
	}

	public Date getPopup_start() {
		return popup_start;
	}

	public void setPopup_start(Date popup_start) {
		this.popup_start = popup_start;
	}

	public String getPopup_end_date() {
		return popup_end_date;
	}

	public void setPopup_end_date(String popup_end_date) {
		this.popup_end_date = popup_end_date;
	}

	public String getPopup_end_hour() {
		return popup_end_hour;
	}

	public void setPopup_end_hour(String popup_end_hour) {
		this.popup_end_hour = popup_end_hour;
	}

	public String getPopup_end_minute() {
		return popup_end_minute;
	}

	public void setPopup_end_minute(String popup_end_minute) {
		this.popup_end_minute = popup_end_minute;
	}

	public Date getPopup_end() {
		return popup_end;
	}

	public void setPopup_end(Date popup_end) {
		this.popup_end = popup_end;
	}

	public int getPopup_use() {
		return popup_use;
	}

	public void setPopup_use(int popup_use) {
		this.popup_use = popup_use;
	}

	public String getOrg_file_name() {
		return org_file_name;
	}

	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}

	public String getStored_file_name() {
		return stored_file_name;
	}

	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	public int getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}

	public int getRange_size() {
		return range_size;
	}

	public void setRange_size(int range_size) {
		this.range_size = range_size;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
