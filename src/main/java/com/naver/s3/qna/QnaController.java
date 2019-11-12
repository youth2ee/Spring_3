package com.naver.s3.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naver.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private QnaService qnaService;
	
	@RequestMapping("qnaList")
	public void qnaList(Model model, Pager pager) throws Exception {
		List<QnaVO> ar = qnaService.qnaList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);

	}
	


	
}
