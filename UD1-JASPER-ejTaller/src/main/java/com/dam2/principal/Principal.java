package com.dam2.principal;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.dam2.modelo.Taller;
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
			File archivo = new File("taller.json");
			
			Taller taller = leerJson(archivo);
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(taller.getIntervenciones());
			
			Map<String, Object> parametros = new HashMap<>();
			parametros.put("idParam", taller.getIdOrden());
			parametros.put("clienteParam", taller.getCliente());
			parametros.put("dispositivoParam", taller.getDispositivo());
			parametros.put("averiaParam", taller.getAveriaReportada());
			parametros.put("fechaParam", taller.getFechaSalida());
			parametros.put("totalNetoParam", taller.getTotalNeto());
			
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("informes/taller.jasper");
			
			JasperPrint print = JasperFillManager.fillReport(report, parametros, dataSource);
			
			JasperExportManager.exportReportToPdfFile(print, "informes/intervencions.pdf");
			
			System.out.println("Boletin generada con éxito!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static Taller leerJson(File file) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode nodo = mapper.readTree(file);
		
		Taller taller = mapper.treeToValue(nodo, Taller.class);
		
		return taller;
	}
}
