package com.uca.capas.parcial2.domain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(schema = "public",name = "cat_libro")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="c_libro")
	private Integer id_libro;
	
	@Size(message= "El campo sobrepasa la cantidad de 500 caracteres",max = 500)
	@NotEmpty(message = "El campo no puede estar vacío")
	@Column(name="s_titulo")
	private String titulo;
	
	@Size(message= "El campo sobrepasa la cantidad de 150 caracteres",max = 150)
	@NotEmpty(message = "El campo no puede estar vacío")
	@Column(name="s_autor")
	private String autor;
	
	
	@Size(message= "El campo sobrepasa la cantidad de 10 caracteres",max = 10)
	@NotEmpty(message = "El campo no puede estar vacío")
	@Column(name="s_isbn")
	private String isbn;
	

	//@NotNull(message = "el campo no puede estar vacio")
	@Column(name="f_ingreso")
	private Calendar fecha_ingreso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria")
	private Categoria categoria;
	//@NotNull(message = "el campo no puede estar vacio")
	@Column(name="b_estado")
	private Boolean estado;
	
	public Libro() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId_libro() {
		return id_libro;
	}
	public void setId_libro(Integer id_libro) {
		this.id_libro = id_libro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Calendar getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(Calendar fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getFechaDelegate() {
		if(this.fecha_ingreso==null) {
			return "";
		}
		else {
			Date date = fecha_ingreso.getTime();  
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(date);
			
		
			//return "SDADF";
		}
	}
	
	public String getEstadoDelegate() {
		if(this.estado==null) {
			return "";
		}
		else {
			return this.estado ? "Activo":"Inactivo";
		
			//return "SDADF";
		}
	}
	
	
	
	
	
	

}
