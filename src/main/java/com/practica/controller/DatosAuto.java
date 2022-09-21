package com.practica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.model.RequestDataAuto;
import com.practica.model.ResponseAuto;
import com.practica.model.ResponseDatosAuto;
import com.practica.service.DatosAutoService;

@RestController

@RequestMapping("/autos")
public class DatosAuto {
	@Autowired
	private	DatosAutoService datosAutoService;
	
	@PostMapping("/mostrar")
	
	public ResponseDatosAuto datosAuto(@RequestBody RequestDataAuto request){
		ResponseDatosAuto datoFinal= new ResponseDatosAuto();
		ResponseAuto datoAuto=new ResponseAuto();
		
		datoAuto = datosAutoService.obtenerDatos(request.getIdauto());
		
		if(datoAuto != null) {
			datoFinal.setCodigo(200);
			datoFinal.setData(datoAuto);
			datoFinal.setStatus("ok");
		}else {
			datoFinal.setCodigo(500);
			datoFinal.setData(null);
			datoFinal.setStatus("error");
				}
		
		return datoFinal;
	}

	}	

