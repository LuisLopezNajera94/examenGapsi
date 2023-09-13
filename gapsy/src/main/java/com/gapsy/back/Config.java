package com.gapsy.back;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.gapsy.back.datasource.DataSourceProvedores;
import com.gapsy.back.entity.ProvedoresEntity;

@Configuration
public class Config {

	
	@Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public DataSourceProvedores Datasource() {
		return new DataSourceProvedores();
	}
	
	@Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ProvedoresEntity provedor(){
		return new ProvedoresEntity();
	}
	
	
	
}
