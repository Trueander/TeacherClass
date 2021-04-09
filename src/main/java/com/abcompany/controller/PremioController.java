package com.abcompany.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.abcompany.model.Clase;
import com.abcompany.model.Estudiante;
import com.abcompany.model.Premio;
import com.abcompany.service.ClaseService;
import com.abcompany.service.EstudianteService;
import com.abcompany.service.PremioService;

@Controller
public class PremioController {

	@Autowired
	private PremioService premioService;
	
	@Autowired
	private ClaseService claseService;
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping(value = "/rewardAll/{id_clase}")
	public String findAll(@PathVariable Integer id_clase, Map<String,Object> map) {
		
		Clase clase = claseService.findById(id_clase);
		map.put("clase", clase);
		map.put("rewards", clase.getPremioList());
		
		Premio premio = new Premio();
		map.put("premio", premio);
		
		return "rewardAll";
	}
	
	@PostMapping(value = "/rewardAll/{id_clase}")
	public String add_reward_POST(@PathVariable Integer id_clase ,Premio premio) {
		
		Clase clase = claseService.findById(id_clase);
		
		premio.setClase(clase);
		premioService.save(premio);
		return "redirect:/rewardAll/{id_clase}";
	}
	
	@PostMapping(value = "/reporteEstudiante/{id_estudiante}/{id_clase}")
	public String rewards(@PathVariable Integer id_estudiante,@PathVariable Integer id_clase, Premio premio) {
		Clase clase = claseService.findById(id_clase);
		Estudiante estudiante = estudianteService.findById(id_estudiante);
		premio.setEstudiante(estudiante);
		premio.setClase(clase);
		premioService.save(premio);
		
		return "redirect:/reporteEstudiante/{id_estudiante}/{id_clase}";
	}
	
	@GetMapping(value = "/delete_reward/{id_reward}/{id_estudiante}/{id_clase}")
	public String delete_reward(@PathVariable Integer id_reward, Model model) {

		if (id_reward > 0) {
			Premio premio = premioService.findById(id_reward);
			premioService.delete(premio.getId_premio());
		}
		
		return "redirect:/reporteEstudiante/{id_estudiante}/{id_clase}";
	}
	
}
