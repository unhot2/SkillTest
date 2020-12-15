package com.epps.controller;

import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.epps.dto.NoticeDTO;
import com.epps.dto.PagingDTO;
import com.epps.dto.SearchDTO;
import com.epps.service.NoticeService;

@Controller
public class NoticeController {
	
	/* 게시판 보여줄 페이지 개수 설정 */
	public static int per_page_num = 10;

	@Autowired
	NoticeService service;

	/* 게시판 조회 */
	@RequestMapping(value = {"/","list"}, method = RequestMethod.GET)
	public String noticeList(Model model, PagingDTO dto) {
		dto.setTotal_count(service.pageCnt());
		model.addAttribute("list", service.noticeList(dto));
		model.addAttribute("paging", dto);
		return "noticeList";
	}

	/* 게시글 등록 폼 이동 */
	@RequestMapping("noticeWriteForm")
	public String noticeWriteForm() {
		return "noticeWriteForm";
	}

	/* 게시글 등록 */
	@RequestMapping("noticeWrite")
	public String noticeWrite(NoticeDTO dto, MultipartHttpServletRequest mpRequest, HttpServletRequest request)
			throws Exception {
		service.noticeWrite(dto, mpRequest, request);
		return "redirect:list";
	}

	/* 게시글 조회 */
	@RequestMapping("search")
	public String search(Model model, SearchDTO dto, PagingDTO p_dto) throws ParseException {
		List<NoticeDTO> list = service.search(dto);
		p_dto.setTotal_count(list.size());
		model.addAttribute("list", list);
		model.addAttribute("paging", p_dto);
		return "noticeList";
	}

	/* 게시글 삭제 */
	@RequestMapping("noticeDelete")
	@ResponseBody
	public void noticeDelete(@RequestParam(value = "deleteArr[]") List<Integer> deleteArr) {
		service.noticeDelete(deleteArr);
	}

	/* 게시글 조회수 */
	@RequestMapping("hitUp")
	@ResponseBody
	public void hitUp(@RequestParam(value = "num") int num) {
		service.hitUp(num);
	}

	/* 게시판 한번에 보여줄 페이지 값 설정 */
	@RequestMapping("setPerPageNum")
	public String setPerPageNum(@RequestParam("pageNum") int pageNum) {
		NoticeController.per_page_num = pageNum;
		return "redirect:list";
	}
}
