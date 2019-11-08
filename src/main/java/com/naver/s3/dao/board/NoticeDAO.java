package com.naver.s3.dao.board;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.naver.s3.model.board.NoticeVO;

@Repository
public class NoticeDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper.";
	
	
	public int noticeInsert(NoticeVO noticeVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"noticeInsert", noticeVO);
	}
	
	
	public int noticeDelete(int num) throws Exception {
		return sqlSession.delete(NAMESPACE+"noticeDelete", num);
	}
	
	
	public NoticeVO noticeSelect(int num) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);

		return sqlSession.selectOne(NAMESPACE+"noticeSelect", map);
	}
	
	
	public List<NoticeVO> noticeList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"noticeList");
	}
	
	
	public int noticeUpdate(NoticeVO noticeVO) throws Exception {
		return sqlSession.update(NAMESPACE+"noticeUpdate", noticeVO);
	}
	
}
