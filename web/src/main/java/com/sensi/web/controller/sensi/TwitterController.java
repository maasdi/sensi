package com.sensi.web.controller.sensi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sensi.twitter.connect.TwitterConnectionFactory;

import twitter4j.Query;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jun 20, 2012
 */
@Controller
public class TwitterController {
	
	static final Logger logger = LoggerFactory.getLogger(TwitterController.class);
	
	@Autowired
	private TwitterConnectionFactory twitterConnectionFactory;
	
	@RequestMapping(value="sensi/tweet", method = RequestMethod.GET)
	public String showTweet(@RequestParam(value="query", required=false) String query, Model model){
		try {
			if(query != null){
				model.addAttribute("tweets", twitterConnectionFactory.getTwitter().search(new Query(query)).getTweets());
			}else{
				model.addAttribute("tweets", twitterConnectionFactory.getTwitter().getHomeTimeline());
			}
			
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex.getCause());
		}
		return "sensi/tweet";
	}
	
	@RequestMapping(value="sensi/tweet", method = RequestMethod.POST)
	public String showResultTweet(@RequestParam(value="query", required=false) String query, Model model){
		try {
			if(query != null){
				model.addAttribute("tweets", twitterConnectionFactory.getTwitter().search(new Query(query)).getTweets());
			}else{
				model.addAttribute("tweets", twitterConnectionFactory.getTwitter().getHomeTimeline());
			}
			
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex.getCause());
		}
		return "sensi/tweet";
	}

}
