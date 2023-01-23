package com.talissonmelo.configuracao;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguracao {

	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}
}
