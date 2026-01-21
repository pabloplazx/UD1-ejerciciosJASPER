package com.dam2.principal;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.dam2.modelo.Boletin;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class Principal {

	public static void main(String[] args) {
		try {
			File archivo = new File("boletin.json");
			
			Boletin boletin = leerJson(archivo);
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(boletin.getAsignaturas());
			
			Map<String, Object> parametros = new HashMap<>();
			parametros.put("nombreParam", boletin.getNombreAlumno());
			parametros.put("cursoParam", boletin.getCurso());
			parametros.put("centroEducativo", boletin.getCentroEducativo());
			parametros.put("notaMedia", boletin.getNotaMedia());
			
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("informes/boletin.jasper");
			
			JasperPrint print = JasperFillManager.fillReport(report, parametros, dataSource);
			
			JasperExportManager.exportReportToPdfFile(print, "informes/MiFactura.pdf");
			
			System.out.println("Boletin generada con éxito!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Boletin leerJson(File file) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode nodo = mapper.readTree(file);
		
		Boletin boletin = mapper.treeToValue(nodo, Boletin.class);
		
		return boletin;
	}
}
