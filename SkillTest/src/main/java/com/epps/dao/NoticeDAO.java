package com.epps.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.epps.dto.NoticeDTO;
import com.epps.dto.PagingDTO;
import com.epps.dto.SearchDTO;

@Repository
public class NoticeDAO {

	@Autowired
	SqlSession session;

	public void noticeWrite(NoticeDTO dto) {
		session.insert("sql.noticewirte", dto);
	}

	public List<NoticeDTO> noticeList(PagingDTO dto) {
		return session.selectList("sql.noticeList", dto);
	}

	public int pageCnt() {
		return session.selectOne("sql.pageCnt");
	}

	public List<NoticeDTO> search(SearchDTO dto) {
		return session.selectList("sql.search", dto);
	}

	public void noticeDelete(List<Integer> deleteArr) {
		for (int i = 0; i < deleteArr.size(); i++) {
			session.delete("sql.delete", deleteArr.get(i));
		}
	}

	public void hitUp(int num) {
		session.update("sql.hitUp", num);
	}

}
