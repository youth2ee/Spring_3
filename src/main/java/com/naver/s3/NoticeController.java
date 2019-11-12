package com.naver.s3;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.jws.WebParam.Mode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s3.model.board.NoticeVO;
import com.naver.s3.service.board.NoticeService;
import com.naver.s3.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;

	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public ModelAndView noticeList(Pager pager) throws Exception {
		List<NoticeVO> ar = noticeService.noticeList(pager);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);

		mv.setViewName("notice/noticeList");
		
		return mv;
	}
	
	
	@RequestMapping(value = "noticeSelect")
	public Model noticeSelect(int num, Model model) throws Exception {
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		model.addAttribute("dto", noticeVO);
		return model;
	}
	
	
	@RequestMapping(value = "noticeInsert", method = RequestMethod.GET)
	public void noticeInsert() throws Exception {
	}
	
	
	@RequestMapping(value = "noticeInsert", method = RequestMethod.POST)
	public ModelAndView noticeInsert(NoticeVO noticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeInsert(noticeVO);
		String msg = "작성 실패";
		
		if(result > 0) {
			msg = "작성 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}

	@RequestMapping(value = "noticeDelete")
	public ModelAndView noticeDelete(int num) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeDelete(num);
		String msg ="삭제 실패";
		if(result > 0) {
			msg = "삭제 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.GET)
	public Model noticeUpdate (int num, Model model) throws Exception {
		NoticeVO noticeVO = noticeService.noticeSelect(num);
		model.addAttribute("dto", noticeVO);
		return model;
	}
	
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeVO noticeVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.noticeUpdate(noticeVO);
	
		String msg = "수정 실패";
		if(result > 0) {
			msg = "수정 성공";
		}
	
		mv.addObject("msg", msg);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/common_result");
	
		return mv;
	}
	
	
}
