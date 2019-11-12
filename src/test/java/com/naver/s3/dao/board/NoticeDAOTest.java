package com.naver.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.naver.s3.TestAbstractCase;
import com.naver.s3.model.board.NoticeVO;
import com.naver.s3.util.Pager;

public class NoticeDAOTest extends TestAbstractCase {
	
	@Inject
	private NoticeDAO noticeDAO;
	
	
	//@Test
	public void checkDAO() throws Exception {
		assertNotNull(noticeDAO);
	}
	
	//@Test
	public void noticeInsertTest() throws Exception {
		for(int i=0;i<120;i++) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("title"+i);
		noticeVO.setWriter("writer"+i);
		noticeVO.setContents("con"+i);
		
		int result = noticeDAO.noticeInsert(noticeVO);
		}
		//assertEquals(1, result);
	}
	
	//@Test
	public void noticeDeleteTest() throws Exception {
		int num = 6;
		int result = noticeDAO.noticeDelete(num);
		
		assertEquals(1, result);
	}
	
	//@Test
	public void noticeSelect() throws Exception {
		NoticeVO noticeVO =  noticeDAO.noticeSelect(1);
		
		assertNotNull(noticeVO);
	}
	
	//@Test
	public void noticeList() throws Exception {
		List<NoticeVO> list = noticeDAO.noticeList(null);
	
		assertNotEquals(0, list.size());
	}
	
	@Test
	public void noticeCount(Pager pager) throws Exception {
		int count = noticeDAO.noticeCount(pager);
		
		assertEquals(110, count);
	}

	//@Test
	public void noticeUpdate() throws Exception {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNum(1);
		noticeVO.setTitle("update");
		noticeVO.setContents("update");
		
		int result = noticeDAO.noticeUpdate(noticeVO);
		
		assertEquals(1, result);
	}


}

