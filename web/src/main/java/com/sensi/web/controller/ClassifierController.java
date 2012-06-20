package com.sensi.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sensi.classification.CorpusException;
import com.sensi.classification.SensiClassifier;
import com.sensi.domain.ClassifyResult;
import com.sensi.service.CorpusService;

/**
 * 
 * @author <a href="mailto:maas_dianto@xybase.com">Maas Dianto</a>
 * @version 1.0 - Jun 20, 2012
 */
@Controller
public class ClassifierController {

	static final Logger logger = LoggerFactory
			.getLogger(ClassifierController.class);

	SensiClassifier sensiClassifier = null;
	@Autowired
	private CorpusService corpusService;

	@PostConstruct
	private void initialize() {
		sensiClassifier = new SensiClassifier(corpusService.findCorpuses(),
				"weka.classifiers.trees.J48");
		sensiClassifier.train();
	}

	@RequestMapping(value = "classify", method = { RequestMethod.POST })
	public ModelAndView classify(
			@RequestParam(value = "text", required = true) String text) {
		ModelAndView view = new ModelAndView("redirect:/");
		if (text != null && text.length() > 0) {
			view.setViewName("home");
			ClassifyResult result = null;
			try {
				result = sensiClassifier.classify(text);
			} catch (CorpusException cex) {
				logger.error(cex.getMessage(), cex);
				view.addObject("corpus_error", cex.getMessage());
			}
			view.addObject("result", result);
		}
		return view;
	}

	@RequestMapping(value = "classify", method = { RequestMethod.GET })
	public String classify() {
		return "redirect:/";
	}
	
	// --------------------

	@RequestMapping(value = "savedata", method = { RequestMethod.POST })
	public String saveData(@RequestParam(value = "text", required = true) String text,
			HttpServletRequest request, HttpServletResponse response) {
		if (text != null && text.length() > 0) {
			List<String> list = request.getSession().getAttribute("listData") == null ? new ArrayList<String>(): (List<String>) request.getSession().getAttribute("listData");
			list.add(text);
			request.getSession().setAttribute("listData", list);
		}
		return "redirect:/listdata";
	}

	@RequestMapping(value = "listdata", method = { RequestMethod.GET })
	public ModelAndView formData(HttpServletRequest request, HttpServletResponse response) {
		List<String> list = (List<String>) request.getSession().getAttribute("listData");
		ModelAndView view = new ModelAndView("listdata");
		view.addObject("list", list);
		return view;
	}

	@RequestMapping(value = "cleardata", method = { RequestMethod.GET })
	public String clearData(HttpServletRequest request, HttpServletResponse response) {
		List<String> list = (List<String>) request.getSession().getAttribute("listData");
		if (list != null) {
			request.getSession().removeAttribute("listData");
		}
		return "redirect:/listdata";
	}
	
	@RequestMapping(value="doclassify", method = {RequestMethod.POST, RequestMethod.GET} )
	public ModelAndView doClassify(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView("redirect:/listdata");
		List<String> list = (List<String>) request.getSession().getAttribute("listData");
		if (list != null) {
			request.getSession().removeAttribute("listData");
			try {
				List<ClassifyResult> results = sensiClassifier.classify(list);
				view.addObject("list", results);
				view.setViewName("result");
			} catch (CorpusException cex) {
				logger.error(cex.getMessage(), cex);
				view.addObject("corpus_error", cex.getMessage());
			}
		}
		return view;
	}

}
