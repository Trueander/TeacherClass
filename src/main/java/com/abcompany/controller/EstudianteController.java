package com.abcompany.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.abcompany.model.Clase;
import com.abcompany.model.Estudiante;
import com.abcompany.service.ClaseService;
import com.abcompany.service.EstudianteService;

@Controller
public class EstudianteController {

	@Autowired
	private ClaseService claseService;

	@Autowired
	private EstudianteService estudianteService;

	// CREACION DE ESTUDIANTES
	@PostMapping(value = "/clase/{id_clase}")
	public String class_student_POST(Estudiante estudiante, @PathVariable Integer id_clase) {
		
		Clase clase;
		if(id_clase > 0) {
			clase = claseService.findById(id_clase);

			String[] listaFotos = { "monstruo.png", "monster1.svg", "monster2.svg", "monster3.svg", "monster4.svg",
					"monster5.svg", "monster6.svg", "monster7.svg", "monster8.svg", "monster9.svg", "monster10.svg",
					"monster11.svg", "monster12.svg", "monster13.svg", "monster14.svg", "monster15.svg", "monster16.svg",
					"monster17.svg", "monster18.svg", "monster19.svg" };
			String randomFoto = listaFotos[new Random().nextInt(listaFotos.length)];
			estudiante.setFoto(estudiante.getFoto() + randomFoto);
			estudianteService.save(estudiante);

			clase.getEstudianteList().add(estudiante);
			claseService.save(clase);
		}else {
			return "redirect:/clase/{id_clase}";
		}
		

		return "redirect:/clase/{id_clase}";
	}

	// delete student
	@GetMapping(value = "/delete_E/{id_estudiante}/{id_clase}")
	public String delete_student(@PathVariable Integer id_estudiante, @PathVariable Integer id_clase, Model model) {
		Clase clase;
		if (id_estudiante > 0) {
			Estudiante estudiante = estudianteService.findById(id_estudiante);
			clase = claseService.findById(id_clase);
			estudiante.getClaseList().remove(clase);
			estudianteService.save(estudiante);
			estudianteService.delete(estudiante.getId_estudiante());
		}

		return "redirect:/editar_clase/{id_clase}";
	}

	// add points
	@GetMapping(value = "/addPoints/{id_estudiante}/{id_clase}")
	public String addPointsStudent(@PathVariable Integer id_estudiante, Model model) {
		Estudiante estudiante = estudianteService.findById(id_estudiante);
		int puntos = estudiante.getPuntosFavor() + 1;
		int puntosTotal = estudiante.getPuntosTotal() + 1;
		estudiante.setPuntosTotal(puntosTotal);
		estudiante.setPuntosFavor(puntos);
		estudianteService.save(estudiante);
		return "redirect:/clase/{id_clase}";
	}

	// remove points
	@GetMapping(value = "/removePoints/{id_estudiante}/{id_clase}")
	public String removePointsStudent(@PathVariable Integer id_estudiante, Model model) {
		Estudiante estudiante = estudianteService.findById(id_estudiante);
		int points = estudiante.getPuntosContra() + 1;
		int puntosTotal = estudiante.getPuntosTotal() - 1;
		estudiante.setPuntosTotal(puntosTotal);
		estudiante.setPuntosContra(points);
		estudianteService.save(estudiante);

		return "redirect:/clase/{id_clase}";
	}

}
