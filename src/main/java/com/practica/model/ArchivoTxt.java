package com.practica.model;

import java.io.IOException;
import java.io.PrintWriter;

import com.practica.controller.DatosAuto;

public class ArchivoTxt {
	
	public void crearArchivo(DatosAuto auto) {
		String ruta = "C:\\Users\\DELL\\Documents\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\practica";
		String nombretxt = "prueba.txt";
		String rutaCompleta = ruta +nombretxt;
		String encoding = "UTF-8";	
		
		try {
			
			PrintWriter writer = new PrintWriter(rutaCompleta, encoding);
			writer.println(auto.toString());
			writer.close();
			
			
		}
		catch(IOException e) {
			System.out.println("UN error ocurrio");
			e.printStackTrace();
			
		}
		
	}
	
	
	

}
