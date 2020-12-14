package com.epps.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.epps.dao.NoticeDAO;
import com.epps.dto.NoticeDTO;
import com.epps.dto.SearchDTO;
import com.epps.util.FileUtils;

@Service
public class NoticeService {

	@Autowired
	NoticeDAO dao;

	@Autowired
	FileUtils fileUtils;

	public List<NoticeDTO> noticeList(NoticeDTO dto) {
		return dao.noticeList(dto);
	}
	
	public void noticeWrite(NoticeDTO dto, MultipartHttpServletRequest mpRequest, HttpServletRequest request) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// Announment 와 Popup의 날짜와 시간,분 문자열을 합쳐서 Date 형태로 변환
		dto.setAnnounment_start(format.parse(sumDate(dto.getAnnounment_start_date(),dto.getAnnounment_start_hour(),dto.getAnnounment_start_minute())));
		dto.setAnnounment_end(format.parse(sumDate(dto.getAnnounment_end_date(),dto.getAnnounment_end_hour(),dto.getAnnounment_end_minute())));
		dto.setPopup_start(format.parse(sumDate(dto.getPopup_start_date(),dto.getPopup_start_hour(),dto.getPopup_start_minute())));
		dto.setPopup_end(format.parse(sumDate(dto.getPopup_end_date(),dto.getPopup_end_hour(),dto.getPopup_end_minute())));
		dao.noticeWrite(fileUtils.parseInsertFileInfo(dto, mpRequest,request));
	}
	
	public String sumDate(String a, String b, String c) {
		String sumDate = a+" "+b+":"+c;
		return sumDate;
	}


	public int pageCnt() {
		return dao.pageCnt();
	}

	public List<NoticeDTO> search(SearchDTO dto) throws ParseException {
		return dao.search(dto);
	}

	public void noticeDelete(List<Integer> deleteArr) {
		 dao.noticeDelete(deleteArr);
		
	}

	public void hitUp(int num) {
		dao.hitUp(num);
	}
}
