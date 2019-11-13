package com.naver.s3.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.naver.s3.util.Pager;

@Repository
public class QnaDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "qnaMapper.";
	
	
	public List<QnaVO> qnaList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"qnaList", pager);
	}

	public QnaVO qnaSelect(int num) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"qnaSelect" , num);
	}
	
	public int qnaCount(Pager pager) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"qnaCount", pager);
	}
	
	public int qnaWrite(QnaVO qnaVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"qnaWrite", qnaVO);	
	}
	
	public int qnaDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE+"qnaDelete", num);
	}

	public int qnaUpdate(int num) throws Exception {
		return sqlSession.update(NAMESPACE+"qnaUpdate", num);
	}
	
	public int qnaReply(QnaVO qnaVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"qnaReply", qnaVO);
	}
	
	public int qnaReplyUpdate(QnaVO qnaVO) throws Exception {
		return sqlSession.update(NAMESPACE+"qnaReplyUpdate", qnaVO);
	}
	


}
