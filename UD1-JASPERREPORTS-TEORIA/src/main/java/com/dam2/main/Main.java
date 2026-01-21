package com.dam2.main;

import java.util.ArrayList;
import java.util.List;
import com.dam2.logic.Informe;
import com.dam2.model.Item;
import com.dam2.model.Pedido;
import net.sf.jasperreports.engine.JRException;

public class Main {

    public static void main(String[] args) {
        
        // 1. Crear datos de prueba (Mock Data)
        List<Pedido> listaPedidos = new ArrayList<>();
        
        // Pedido 1
        Pedido p1 = new Pedido();
        p1.setId("PED-001");
        List<Item> items1 = new ArrayList<>();
        
        Item i1 = new Item(); i1.setNombre("Ratón"); i1.setPrecio(15.50);
        Item i2 = new Item(); i2.setNombre("Teclado"); i2.setPrecio(20.00);
        
        items1.add(i1);
        items1.add(i2);
        p1.setItems(items1);
        
        // Pedido 2
        Pedido p2 = new Pedido();
        p2.setId("PED-002");
        List<Item> items2 = new ArrayList<>();
        
        Item i3 = new Item(); i3.setNombre("Monitor"); i3.setPrecio(150.00);
        
        items2.add(i3);
        p2.setItems(items2);
        
        listaPedidos.add(p1);
        listaPedidos.add(p2);
        
        // 2. Llamar a la lógica de generación
        try {
            // Asegúrate de crear la carpeta "informes" en tu proyecto antes de ejecutar
            Informe.generarInforme(listaPedidos, "MisPedidos.pdf");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}