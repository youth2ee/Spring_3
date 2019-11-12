package com.naver.s3.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.naver.s3.util.RowMaker;

@Repository
public class QnaDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "qnaMapper.";
	
	
	public List<QnaVO> qnaList(RowMaker rowMaker) throws Exception {
		return sqlSession.selectList(NAMESPACE+"qnaList", rowMaker);
	}
	
	public int qnaCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE+"qnaCount");
	}
	


}
