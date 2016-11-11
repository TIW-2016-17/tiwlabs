package es.uc3m.tiw.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyFirstController {

	@RequestMapping("/greet")
	public @ResponseBody String greet(){
		return "Hi";
	}
  
  @RequestMapping("/params/{name}/{age}")
	public @ResponseBody String parameters(@PathVariable String name, @PathVariable int age){
		return "Parameters are: "+name+" and "+age;
	}
}
