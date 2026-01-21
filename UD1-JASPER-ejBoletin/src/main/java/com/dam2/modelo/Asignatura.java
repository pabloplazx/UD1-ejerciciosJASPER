package com.dam2.modelo;

public class Asignatura {

	private String materia;
	private double calificacion;
	private String observacion;
	public Asignatura() {
		super();
	}
	public Asignatura(String materia, double calificacion, String observacion) {
		super();
		this.materia = materia;
		this.calificacion = calificacion;
		this.observacion = observacion;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
}
