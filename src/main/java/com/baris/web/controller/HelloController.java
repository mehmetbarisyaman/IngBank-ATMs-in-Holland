package com.baris.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		return "hello";

	}
	
	@RequestMapping(value = "/results", method = RequestMethod.GET)
	public @ResponseBody ModelAndView printResults(@RequestParam(value="city")String city) throws IOException, JSONException {
		Service serve = new Service();
		ArrayList<Bank>list = serve.showBankUsingCity(city);
		System.out.println(list.size());
		ModelAndView model = new ModelAndView();
		model.setViewName("results");
		model.addObject("banks", list);
		return model;

	}

	@RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("hello");
		model.addObject("msg", name);

		return model;

	}

}