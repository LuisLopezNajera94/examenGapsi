package com.gapsy.back.datasource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.gapsy.back.entity.ProvedoresEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class DataSourceProvedores {

	public DataSourceProvedores() {
	}

	public 	List<ProvedoresEntity> ReadBD() {
		List<ProvedoresEntity> provedores = null;
		Gson gson = new Gson();
		String fichero = "";
		try (BufferedReader br = new BufferedReader(new FileReader("bd.json"))) {
			String linea;
			while ((linea = br.readLine()) != null) {
				fichero += linea;
			}
			ProvedoresEntity[] lista = gson.fromJson(fichero, ProvedoresEntity[].class);
			
			provedores = Arrays.asList(lista);
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		return provedores;
	}
	
	public void WriteBD(List<ProvedoresEntity> provedores) {
		
		try (PrintWriter printable = new PrintWriter(new FileWriter("bd.json"))){
			
		Gson  gson = new GsonBuilder().setPrettyPrinting().create();
		
		printable.println("[");
				
		for(int i =0; i < provedores.size() ; i++) {
			
			String jsonProvedor = gson.toJson(provedores.get(i));
			printable.println(jsonProvedor);
			
			if( i != provedores.size()-1){
				printable.println(",");
			}
			
		}
		
		printable.println("]");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
