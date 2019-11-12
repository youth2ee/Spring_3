package com.naver.s3.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.naver.s3.dao.board.NoticeDAO;
import com.naver.s3.util.Pager;

@Service
public class QnaService {

	@Inject
	private QnaDAO qnaDAO; 
	
	
	public List<QnaVO> qnaList(Pager pager) throws Exception {
		pager.makeRow();
		pager.makePager(qnaDAO.qnaCount(pager));
		return qnaDAO.qnaList(pager);
	}
	
}
