package com.dam2.main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.dam2.model.Factura;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class Principal {

    public static void main(String[] args) {
        try {
            // 1. Leemos el JSON y lo convertimos a Objeto Java
            File archivo = new File("factura.json");
            Factura factura = leerJson(archivo);
            
            // --- AQUI EMPIEZA LA MAGIA DE JASPER ---
            
            // A. LOS DATOS DE LA LISTA (Para el Detail)
            // Pasamos SOLO la lista de líneas como fuente de datos principal
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(factura.getLineas());
            
            // B. LOS DATOS DE CABECERA (Para el Title/Page Header)
            // Los metemos en un Mapa de Parámetros
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("clienteParam", factura.getCliente());
            parametros.put("numFacturaParam", factura.getNumeroFactura()); // Ojo al nombre corregido
            parametros.put("fechaParam", factura.getFechaEmision());
            parametros.put("totalParam", factura.getTotalFactura());
            
            // 3. Cargamos el diseño (Asumiendo que crearás factura.jasper)
            JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("informes/factura.jasper");
            
            // 4. Llenamos el informe
            // Fíjate: pasamos 'report', 'parametros' (Map) y 'dataSource' (List)
            JasperPrint print = JasperFillManager.fillReport(report, parametros, dataSource);
            
            // 5. Exportamos
            JasperExportManager.exportReportToPdfFile(print, "informes/MiFactura.pdf");
            
            System.out.println("Factura generada con éxito!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // He simplificado tu método leerJson, esto es más directo:
    private static Factura leerJson(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(file, Factura.class);
    }
}