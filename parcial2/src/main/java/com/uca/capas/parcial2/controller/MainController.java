package com.uca.capas.parcial2.controller;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.uca.capas.parcial2.domain.Categoria;
import com.uca.capas.parcial2.domain.Libro;
import com.uca.capas.parcial2.service.CategoriaService;
import com.uca.capas.parcial2.service.LibroService;

@Controller
public class MainController {
	@Autowired
	LibroService libroService;
	@Autowired
	CategoriaService categoriaService;
	
	
	@RequestMapping("/index")
	public ModelAndView Main() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("message","");
		mav.setViewName("index");
		return mav;
	}
	
	
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView iLirbos() {
		ModelAndView mav = new ModelAndView();
		Libro libro= new Libro();
		
		List<Categoria> categorias= null;
		try {
			
			categorias = categoriaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("categorias",categorias);
		mav.addObject("libro",libro);
		mav.setViewName("agregarLibro");
		return mav;
	}
	
	@PostMapping("/saveL")
	public ModelAndView saveL(@Valid @ModelAttribute Libro libro,BindingResult result,@RequestParam Integer iC) {
		
		ModelAndView mav = new ModelAndView();
		
		Calendar newdate = Calendar.getInstance();
		libro.setFecha_ingreso(newdate);
		List<Categoria> categorias= null;
		try {
			
			categorias = categoriaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("categorias",categorias);
		
		
		if (result.hasErrors()) {
			
			mav.setViewName("agregarLibro");
			
		} else {
			

			try {
				Categoria c =  categoriaService.findOne(iC);
				
				libro.setCategoria(c);
				
				libroService.save(libro);
				mav.addObject("message","Libro guardado con éxito");
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.setViewName("agregarLibro");
			

		}
		
		return mav;
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView iCat() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria= new Categoria();
		/*
		List<Categoria> categorias= null;
		try {
			
			categorias = categoriaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	//	mav.addObject("categorias",categorias);
		mav.addObject("categoria",categoria);
		mav.setViewName("agregarCategoria");
		return mav;
	}	
	
	
	
	
	@PostMapping("/saveC")
	public ModelAndView saveC(@Valid @ModelAttribute Categoria categoria,BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
	/*
		List<Categoria> categorias= null;
		try {
			
			categorias = categoriaService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		//mav.addObject("categorias",categorias);
		
		
		if (result.hasErrors()) {
			
			mav.setViewName("agregarCategoria");
			
		} else {
			

			try {
			//	Categoria c =  categoriaService.findOne(iC);
			//	libro.setCategoria(c);
				
				categoriaService.save(categoria);
				mav.addObject("message","Categoría guardada con éxito");
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			mav.setViewName("index");
			

		}
		
		return mav;
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/listado")
	public ModelAndView  list(){

				
				
					
		ModelAndView mav = new ModelAndView();
		
		
		List<Libro> libros= null;
		try {
			
			libros= libroService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("libros",libros);
		
		mav.setViewName("mostrarLibros");
		

		return mav;
	}
	
}
