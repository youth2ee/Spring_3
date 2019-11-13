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
	
	public QnaVO qnaSelect(int num) throws Exception {
		return qnaDAO.qnaSelect(num);
	}
	
	public int qnaWrite(QnaVO qnaVO) throws Exception {
		return qnaDAO.qnaWrite(qnaVO);
	}
	
	public int qnaDelete(int num) throws Exception {
		return qnaDAO.qnaDelete(num);
	}
	
	public int qnaUpdate(int num) throws Exception {
		return qnaDAO.qnaUpdate(num);
	}
	
	public int qnaReply(QnaVO qnaVO) throws Exception {
		//부모의 글번호를 통해 부모VO를 호출하고 ref와 step을 수정
		QnaVO parentVO = qnaDAO.qnaSelect(qnaVO.getNum());
		int result = qnaDAO.qnaReplyUpdate(parentVO);
		
		qnaVO.setRef(parentVO.getRef());
		qnaVO.setStep(parentVO.getStep() + 1);
		qnaVO.setDepth(parentVO.getDepth() + 1);
		
		result = qnaDAO.qnaReply(qnaVO);
		
		return result;
	}
}
