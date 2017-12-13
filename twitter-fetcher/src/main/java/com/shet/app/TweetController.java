package com.shet.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@RestController
@RequestMapping("/tweetList")
public class TweetController {
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
		ConfigurationBuilder cf = new ConfigurationBuilder();
		cf.setDebugEnabled(true).setOAuthConsumerKey("sGjaEdW6P0BBLnicLEFhMqIGv")
				.setOAuthConsumerSecret("s8t5JRd3XUrx7PtfDNK42ZVT2fRh90YNlDeroGxjS6otCZPNzO")
				.setOAuthAccessToken("")
				.setOAuthAccessTokenSecret("");

		TwitterFactory tf = new TwitterFactory(cf.build());
		Twitter twitter = tf.getInstance();
		List<Status> status = new ArrayList<Status>();
		StringBuffer sb = new StringBuffer();
		try {
			status = twitter.getHomeTimeline();
			for (Status st : status) {
				sb.append(st.getUser().getName() + "-------" + st.getText());
				sb.append("/n");
			}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sb.toString();
	}
}