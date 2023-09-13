package com.gapsy.back.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gapsy.back.Config;
import com.gapsy.back.datasource.DataSourceProvedores;
import com.gapsy.back.entity.ProvedoresEntity;

@Service
public class ServiceProvedores {
	
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
	
	
	
	public Page<ProvedoresEntity> getProvedores(Pageable pageable){
		
		DataSourceProvedores datasource = context.getBean(DataSourceProvedores.class);
		
		
		List<ProvedoresEntity> provedores = datasource.ReadBD();
		
		    int start = (int) pageable.getOffset();
		    int end = Math.min((start + pageable.getPageSize()), provedores.size());

		    List<ProvedoresEntity> pageContent = provedores.subList(start, end);
		    return new PageImpl<>(pageContent, pageable, provedores.size());
		
		
	}



	public void saveProvedor(ProvedoresEntity request) throws Exception {
		DataSourceProvedores datasource = context.getBean(DataSourceProvedores.class);
		List<ProvedoresEntity> provedores = datasource.ReadBD();
		List<ProvedoresEntity> provedoresNuevo = new ArrayList<>();
		
		for(ProvedoresEntity provedor : provedores) {
			if(provedor.getNombre().equals(request.getNombre())) {
				throw new Exception("El provedor ya existe");
			}
			provedoresNuevo.add(provedor);
		}
		
		provedoresNuevo.add(request);
		
		datasource.WriteBD(provedoresNuevo);
	}
	
	
	public void deleteProvedor(String nombre) {
		DataSourceProvedores datasource = context.getBean(DataSourceProvedores.class);
		List<ProvedoresEntity> provedores = datasource.ReadBD();
		List<ProvedoresEntity> provedoresNuevo = new ArrayList<>();
		
		for(ProvedoresEntity provedor : provedores) {
			if(!provedor.getNombre().equals(nombre)) {
				provedoresNuevo.add(provedor);
			}
		}
		
		datasource.WriteBD(provedoresNuevo);
	}
	
	
	

}
