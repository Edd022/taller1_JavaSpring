package com.example.demo;



import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ExperimentService {
	
	public ExperimentService() {
		System.out.println("Hola, utilizando @Component  en ExperimentService");
	}

}
