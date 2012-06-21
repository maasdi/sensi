package com.sensi.twitter.connect;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jun 21, 2012
 */
public class TwitterConnectionFactory {
	
	private String consumerKey;
	private String consumerSecret;
	private String accessTokenKey;
	private String accessTokenSecret;
	
	public TwitterConnectionFactory(String consumerKey, String consumerSecret, String accessTokenKey, String accessTokenSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.accessTokenKey = accessTokenKey;
		this.accessTokenSecret = accessTokenSecret;
	}
	
	public Twitter getTwitter(){
		ConfigurationBuilder config = new ConfigurationBuilder();
		config.setDebugEnabled(true)
		.setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret)
		.setOAuthAccessToken(accessTokenKey)
		.setOAuthAccessTokenSecret(accessTokenSecret);
		
		return new TwitterFactory(config.build()).getInstance();
	}
	
}
