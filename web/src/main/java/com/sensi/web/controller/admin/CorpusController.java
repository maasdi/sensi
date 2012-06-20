package com.sensi.web.controller.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sensi.domain.Corpus;
import com.sensi.service.CorpusService;

/**
 *
 * @author <a href="mailto:maas_dianto@xybase.com">Maas Dianto</a>
 * @version 1.0 - Jun 20, 2012
 */
@Controller
public class CorpusController {
	
	Logger logger = LoggerFactory.getLogger(CorpusController.class);
	
	@Autowired
	private CorpusService corpusService;

	@RequestMapping(value="/admin/listcorpus", method=RequestMethod.GET)
	public ModelAndView listCorpuses(@RequestParam(value="start", required=false, defaultValue="0") Integer start, @RequestParam(value="end", required=false, defaultValue="8") Integer end){
		ModelAndView view = new ModelAndView("admin/listcorpus");
		List<Corpus> listCorpuses = null;
		view.addObject("listCorpuses", corpusService.findCorpuses(start, end));
		view.addObject("no", start);
		view.addObject("count", corpusService.countCorpuses());
		return view;
	}
	
	@RequestMapping(value="/admin/submitcorpus", method = RequestMethod.POST)
	public String saveCorpus(Corpus corpus){
		if(corpus != null){
			logger.debug("save corpus");
			corpusService.save(corpus);
		}
		return "redirect:/admin/listcorpus";
	}
	
	@RequestMapping(value="/admin/formcorpus", method = RequestMethod.GET)
	public ModelAndView corpusForm(@RequestParam(value="id", required=false) Long id){
		ModelAndView view = new ModelAndView("admin/formcorpus");
		if(id != null && id != 0){
			view.addObject(corpusService.findCorpus(id));
		}else{
			view.addObject(new Corpus());
		}
		return view;
	}
	
	@RequestMapping(value="admin/corpusdelete", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteCorpus(@RequestParam(value="id", required=true, defaultValue="0") Long id){
		if(id != null && id != 0){
			Corpus corpus = corpusService.findCorpus(id);
			corpusService.delete(corpus);
		}
		return "redirect:/admin/listcorpus";
	}
	
}
