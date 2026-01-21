package com.dam2.modelo;

import java.util.ArrayList;
import java.util.List;

public class Boletin {

	private String nombreAlumno;
	private String curso;
	private String centroEducativo;
	private double notaMedia;
	private List<Asignatura> asignaturas = new ArrayList<>();
	public Boletin() {
		super();
	}
	public String getNombreAlumno() {
		return nombreAlumno;
	}
	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getCentroEducativo() {
		return centroEducativo;
	}
	public void setCentroEducativo(String centroEducativo) {
		this.centroEducativo = centroEducativo;
	}
	public double getNotaMedia() {
		return notaMedia;
	}
	public void setNotaMedia(double notaMedia) {
		this.notaMedia = notaMedia;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
}
