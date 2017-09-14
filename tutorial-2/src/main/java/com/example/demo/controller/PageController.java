package com.example.demo.controller;

import java.util.Optional;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController
{
		@RequestMapping("/hello")
		public String index ()
		{
		return "hello";
		}
		
		@RequestMapping("/greeting")
		public String greeting (@RequestParam(value = "name", required = false, defaultValue = "dunia") String name, Model model) 
		{
			model.addAttribute("name", name);
			return "greeting";
		}
		
		@RequestMapping(value = {"/greeting", "greeting/{name}"})
		public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
		model.addAttribute("name", name.get());
		} else {
		model.addAttribute("name", "dengklek");
		}
		return "greeting";
		}

		
		/*
		@RequestMapping("/greeting/{name}")
		public String greetingPath (@PathVariable Optional<String> name, Model model)
		{
			if (name.isPresent()) {
				model.addAttribute("name", name.get());
			} else {
				model.addAttribute("name", "dengklek");
			}
			return "greeting";
		} */
		
	
		@RequestMapping("/perkalian")
		public String perkalian(@RequestParam(value = "a", required = false, defaultValue = "0") String nilaiA, Model model, @RequestParam(value = "b", required = false, defaultValue = "0") String nilaiB, Model model2, @RequestParam(value = "nilaiC", required = false, defaultValue = "0") String nilaiC, Model model3) {
		    // use the request parameters
			model.addAttribute("nilaiA", nilaiA);
			model2.addAttribute("nilaiB", nilaiB);
			if (nilaiA.equals("0") || nilaiB.equals("0")) {
				model3.addAttribute("nilaiC", nilaiC);
			} else {
				int a = Integer.parseInt(nilaiA);
				int b = Integer.parseInt(nilaiB);
				int c = a * b;
				nilaiC = Integer.toString(c);
				model3.addAttribute("nilaiC", nilaiC);
			}
			
			return "perkalian";
		} 
		
	
		
		
}