package com.naver.s3.qna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.naver.s3.TestAbstractCase;
import com.naver.s3.util.RowMaker;

public class QnaDAOTest extends TestAbstractCase {

	@Inject
	private QnaDAO qnaDAO;
	

	@Test
	public void qnaList() throws Exception {
		RowMaker rowMaker = new RowMaker();
		rowMaker.setStartRow(1);
		rowMaker.setLastRow(10);
		List<QnaVO> ar = qnaDAO.qnaList(rowMaker);
		
		assertNotEquals(0, ar.size());
		
	}
	
	
}
