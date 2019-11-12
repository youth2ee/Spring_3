package com.naver.s3.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.naver.s3.TestAbstractCase;
import com.naver.s3.util.Pager;


public class QnaDAOTest extends TestAbstractCase {

	@Inject
	private QnaDAO qnaDAO;
	

	@Test

	public void qnaList() throws Exception {
		Pager pager = new Pager();
		List<QnaVO> ar = qnaDAO.qnaList(pager);
		
		assertNotEquals(0, ar.size());

	}
	
	@Test
	public void qnaInsert() throws Exception {
		for(int i=0 ; i<100 ; i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setTitle("t"+i);
			qnaVO.setWriter("w"+i);
			qnaVO.setContents("c"+i);
			qnaDAO.qnaInsert(qnaVO);
		}
	
	

		
	}

}
