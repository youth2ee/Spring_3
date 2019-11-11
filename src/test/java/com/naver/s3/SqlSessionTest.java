package com.naver.s3;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.naver.s3.qna.QnaDAO;
import com.naver.s3.qna.QnaVO;

public class SqlSessionTest extends TestAbstractCase {

	@Inject
	private SqlSession sqlSession;

	private QnaDAO qnaDAO;
	
	//@Test
	public void sqlTest() {
		assertNotNull(sqlSession);
	}
	
	
	  @Test 
	  public void qnaInsert() throws Exception { 
		  for(int i=0;i<100;i++) {
	  QnaVO qnaVO = new QnaVO(); 
	  qnaVO.setTitle("t1"+i); 
	  qnaVO.setWriter("w1"+i);
	  qnaVO.setContents("c1"+i);
	  
	  int result = qnaDAO.qnaInsert(qnaVO); 
	  }
	  
	 
	  }
	
	
	
		
}


