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
import com.epps.dto.SearchDTO;
import com.epps.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	NoticeService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String noticeList(Model model, NoticeDTO dto) {
		model.addAttribute("list", service.noticeList(dto));
		int page_num = service.pageCnt() / dto.getRange_size() + (service.pageCnt() % dto.getRange_size() == 0 ? 0 : 1);
		model.addAttribute("page_num", page_num);
		model.addAttribute("current_page", dto.getCurrent_page());
		return "noticeList";
	}

	@RequestMapping("noticeWriteForm")
	public String noticeWriteForm() {
		return "noticeWriteForm";
	}

	@RequestMapping("noticeWrite")
	public String noticeWrite(NoticeDTO dto, MultipartHttpServletRequest mpRequest, HttpServletRequest request)
			throws Exception {
		final String title = dto.getTitle();
		final String content = dto.getContent();
		final String org_file_name = dto.getOrg_file_name();
		for (int i = 1; i < 15; i++) {
			dto.setTitle(title + i);
			service.noticeWrite(dto, mpRequest, request);
			Thread.sleep(150);
		}
		service.noticeWrite(dto, mpRequest, request);
		return "redirect:/";
	}

	@RequestMapping("search")
	public String search(Model model, SearchDTO dto) throws ParseException {
		List<NoticeDTO> list = service.search(dto);
		model.addAttribute("list", list);
		int page_num = list.size() / 10 + (list.size() % 10 == 0 ? 0 : 1);
		model.addAttribute("page_num", page_num);
		model.addAttribute("current_page", 1);
		return "noticeList";
	}

	@RequestMapping("noticeDelete")
	@ResponseBody
	public void noticeDelete(@RequestParam(value = "deleteArr[]") List<Integer> deleteArr) {
		service.noticeDelete(deleteArr);
	}

	@RequestMapping("hitUp")
	@ResponseBody
	public void hitUp(@RequestParam(value = "num") int num) {
		service.hitUp(num);
	}
}
