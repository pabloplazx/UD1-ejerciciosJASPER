package com.dam2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Taller {
	
	private String idOrden;
	private String cliente;
	private String dispositivo;
	private String averiaReportada;
	private String fechaSalida;
	private double totalNeto;
	private List<Intervencion> intervenciones = new ArrayList<>();
	public Taller() {
		super();
	}
	public String getIdOrden() {
		return idOrden;
	}
	public void setIdOrden(String idOrden) {
		this.idOrden = idOrden;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getDispositivo() {
		return dispositivo;
	}
	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}
	public String getAveriaReportada() {
		return averiaReportada;
	}
	public void setAveriaReportada(String averiaReportada) {
		this.averiaReportada = averiaReportada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public double getTotalNeto() {
		return totalNeto;
	}
	public void setTotalNeto(double totalNeto) {
		this.totalNeto = totalNeto;
	}
	public List<Intervencion> getIntervenciones() {
		return intervenciones;
	}
	public void setIntervenciones(List<Intervencion> intervenciones) {
		this.intervenciones = intervenciones;
	}
	
	
	
	

}
