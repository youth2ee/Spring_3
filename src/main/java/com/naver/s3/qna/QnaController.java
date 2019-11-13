package com.naver.s3.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value = "qnaList", method = RequestMethod.GET)
	public ModelAndView qnaList(Pager pager) throws Exception {
		List<QnaVO> ar = qnaService.qnaList(pager);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		
		mv.setViewName("qna/qnaList");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaSelect")
	public Model qnaSelect(int num, Model model) throws Exception {
		QnaVO qnaVO = qnaService.qnaSelect(num);
		
		model.addAttribute("dto", qnaVO);
		
		return model;
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.GET)
	public void qnaWrite() throws Exception {		
	}
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaWrite(QnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaWrite(qnaVO);
	
		String msg = "작성 실패";
		
		if(result > 0) {
			msg = "작성 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaDelete")
	public ModelAndView qnaDelete(int num) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaDelete(num);
		
		String msg = "삭제 실패";
		
		if(result > 0) {
			msg = "삭제 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping(value = "qnaUpdate", method = RequestMethod.GET)
	public void qnaUpdate(int num, Model model) throws Exception {
	}
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.GET)
	public Model qnaReply(int num, Model model) throws Exception {
		model.addAttribute("num", num);
		return model;
	}
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public ModelAndView qnaReply(QnaVO qnaVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.qnaReply(qnaVO);
		
		String msg = "답글작성 실패";
		
		if(result > 0) {
			msg = "답글작성 성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	

	
}




