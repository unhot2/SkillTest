package com.epps.dto;

import com.epps.controller.NoticeController;

public class PagingDTO {
	private int current_page;
	private int per_page_num;
	private int total_count;
	private int start_page;
	private int end_page;
	private int display_page_num;
	private int last_page;

	public PagingDTO() {
		this.current_page = 1;
		this.per_page_num = NoticeController.per_page_num;
		this.display_page_num = 5;
	}

	public int getLast_page() {
		return last_page;
	}

	public void setLast_page(int last_page) {
		this.last_page = last_page;
	}

	public int getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(int current_page) {
		if (current_page <= 0) {
			this.current_page = 1;
		} else {
			this.current_page = current_page;
		}
	}

	public int getPer_page_num() {
		return per_page_num;
	}

	public void setPer_page_num(int per_page_num) {
		this.per_page_num = per_page_num;
	}

	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
		dataCalc();
	}

	public int getStart_page() {
		return start_page;
	}

	public void setStart_page(int start_page) {
		this.start_page = start_page;
	}

	public int getEnd_page() {
		return end_page;
	}

	public void setEnd_page(int end_page) {
		this.end_page = end_page;
	}

	public int getDisplay_page_num() {
		return display_page_num;
	}

	public void setDisplay_page_num(int display_page_num) {
		this.display_page_num = display_page_num;
	}

	public void dataCalc() {
		end_page = (int) (Math.ceil(current_page / (double) display_page_num) * display_page_num);
		start_page = (end_page - display_page_num) + 1;
		if (start_page <= 0)
			start_page = 1;
		last_page = (int) (Math.ceil(total_count / (double) per_page_num));
		if (end_page > last_page) {
			end_page = last_page;
		}
	}
}
