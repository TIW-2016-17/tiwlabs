package es.uc3m.tiw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyFirstController {

	@RequestMapping("/greet/{name}")
	public String greet(Model model, @PathVariable String name){
		model.addAttribute("name", name);
		return "hello";
	}
  
  @RequestMapping("/params/{name}/{age}")
	public @ResponseBody String parameters(@PathVariable String name, @PathVariable int age){
		return "Parameters are: "+name+" and "+age;
	}
}
