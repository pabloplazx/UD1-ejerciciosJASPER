package com.dam2.logic;

import java.util.ArrayList;
import java.util.List;

import com.dam2.model.Pedido;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class Informe {

    public static void generarInforme(List<Pedido> pedidos, String nomFichero) throws JRException {
        
        // 1. Preparamos la lista de datos (DTOs)
        List<DatosInforme> datos = new ArrayList<>();
        
        for (Pedido p : pedidos) {
            DatosInforme d = new DatosInforme();
            d.setId(p.getId());
            
            // CORREGIDO: "setPrecioTotal" (antes tenías "sePrecioTotal")
            // Asegúrate de que en DatosInforme.java el método se llame setPrecioTotal
            d.setPrecioTotal(p.getItems().stream().mapToDouble(x -> x.getPrecio()).sum());
            
            datos.add(d);
        } 
        
        // 2. Generar el informe
        
        // Envolvemos la lista en un JRBeanCollectionDataSource
        JRBeanCollectionDataSource camposInforme = new JRBeanCollectionDataSource(datos);
        
        // Carga el diseño compilado (.jasper) desde la carpeta "informes"
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile("informes/listaPedidos.jasper");
        
        // Llena el informe con los datos
        // El segundo parámetro es null porque no estamos pasando parámetros (como fechas o títulos dinámicos), solo la lista
        JasperPrint informe = JasperFillManager.fillReport(jasperReport, null, camposInforme);
        
        // Exporta a PDF en la carpeta informes
        JasperExportManager.exportReportToPdfFile(informe, "informes\\" + nomFichero);
        
        System.out.println("Informe generado correctamente en informes\\" + nomFichero);
    }
}