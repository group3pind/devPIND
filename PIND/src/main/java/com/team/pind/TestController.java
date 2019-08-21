package com.team.pind;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	
	@RequestMapping(value = "testpage", method = RequestMethod.GET)
	public String testpage() {
		return "test";
	}

	@RequestMapping(value = "mychannel", method = RequestMethod.GET)
	public String mcpage() {
		return "Member/myChannel";
	}
}
