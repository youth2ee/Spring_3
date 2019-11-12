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

	
	@Test
	public void sqlTest() {
		assertNotNull(sqlSession);
	}

}


