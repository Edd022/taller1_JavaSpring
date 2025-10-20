package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class TestController {
	@Autowired
	@Qualifier("experimentoConBean")	
	private ExperimentBeanService pruebaManual;
	
	@Autowired 
	private ExperimentService pruebaAutomatica;
	
	@GetMapping("/prueba")
	public String test() {
		System.out.println("probandoo");
		pruebaManual.Experimento();
		return "prueba finalizada";
	}
	
	
	
}
