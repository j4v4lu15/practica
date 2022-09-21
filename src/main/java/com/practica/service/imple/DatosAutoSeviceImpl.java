package com.practica.service.imple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.practica.model.ArchivoTxt;
import com.practica.model.ResponseAuto;
import com.practica.service.DatosAutoService;

@Service
public class DatosAutoSeviceImpl implements DatosAutoService {

	@Override
	public ResponseAuto obtenerDatos(int idauto){ 
		ResponseAuto datosAutos = new ResponseAuto();
		String arregloa[] = {"rojo","verde","azul"};
		
		if(idauto == 1) {
			datosAutos.setMarca("nissan");
			datosAutos.setColor(arregloa);
			crearArchivo(datosAutos);
			}
		else {
			return null;
		}
			
			
		return datosAutos;
	
		}
	
	public void crearArchivo(ResponseAuto auto) {
		String ruta = "C:\\Users\\DELL\\Documents\\practicags\\";
		String nombretxt = "prueba.txt";
		String rutaCompleta = ruta + nombretxt;
	    String encoding = "UTF-8";
	    try{
	    PrintWriter writer = new PrintWriter(rutaCompleta, encoding);
	    writer.println(auto.toString());
	    writer.close();
	    
	    leertxt();
	    }
	    catch (IOException e){
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	}
	
	public void leertxt() {
		try {
			String ruta = "C:\\Users\\DELL\\Documents\\practicags\\";
			String nombretxt = "prueba.txt";
			String rutaCompleta = ruta + nombretxt;
			 File doc = new File(rutaCompleta);

			  BufferedReader obj = new BufferedReader(new FileReader(doc));
	
			  String lectura = "";
			  String datosLeidos = "";
			  while ((lectura = obj.readLine()) != null) {
				  System.out.println(lectura);
				  datosLeidos = lectura;
			  }
			  crearPdf(datosLeidos);
			    
		}catch(Exception e) {
			
		}
	}
	
	private void crearPdf(String datosLeidos) {
		 com.itextpdf.text.Document document = new com.itextpdf.text.Document();
		 System.out.print("Creando pdf.");
	        try {
	        	String path = "C:\\Users\\DELL\\Documents\\practicags\\";
	        	String FILE_NAME = path + "prueba.pdf";
	        	
	            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
	 
	            document.open();
	 
	            Paragraph paragraphHello = new Paragraph();
	            paragraphHello.add("datos del txt:" + datosLeidos);
	            paragraphHello.setAlignment(Element.ALIGN_JUSTIFIED);
	 
	            document.add(paragraphHello);
	 
	            document.close();
	            System.out.print("Terminando pdf.");
	        } catch (FileNotFoundException | DocumentException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
				e.printStackTrace();
			}
	 
	    }
}