package com.naver.s3.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.naver.s3.TestAbstractCase;
import com.naver.s3.util.Pager;


public class QnaServiceTest extends TestAbstractCase {

	@Inject
	private QnaService qnaService;
	

	@Test
	public void qnaList() throws Exception {
		Pager pager = new Pager();
		pager.makePager(50);
		List<QnaVO> ar = qnaService.qnaList(pager);

		assertNotEquals(0, ar.size());
		assertEquals(1, (int)pager.getStartRow());
		assertEquals(10, (int)pager.getLastRow());
		
		assertEquals(1, (int)pager.getStartNum());
		assertEquals(5, (int)pager.getLastNum());	
	}
	
	
}
