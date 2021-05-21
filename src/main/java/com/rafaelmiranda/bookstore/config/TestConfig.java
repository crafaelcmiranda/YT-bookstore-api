package com.rafaelmiranda.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rafaelmiranda.bookstore.service.DBService;

@Configuration
@Profile("test")//configurado no arquvio application.properties
public class TestConfig {
	
	@Autowired
	DBService dbService;
	
	@Bean
	public void instanciaBaseDeDados() {
		this.dbService.instanciaDeDados();
	}

}
