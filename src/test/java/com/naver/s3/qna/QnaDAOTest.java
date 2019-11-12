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
	
	
}
