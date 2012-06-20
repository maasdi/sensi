package com.sensi.web.controller;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jun 20, 2012
 */
@Controller
public class TwitterController {
	
	private Twitter twitter;
	
	public TwitterController(Twitter twitter) {
		this.twitter = twitter;
	}
	
	public String showResult(@RequestParam("query") String query, Model model){
		
		return "twitter/timeline";
	}

}
