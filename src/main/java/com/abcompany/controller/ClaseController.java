package com.abcompany.controller;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.abcompany.model.Clase;
import com.abcompany.model.Estudiante;
import com.abcompany.model.Grado;
import com.abcompany.model.Premio;
import com.abcompany.model.Profesor;
import com.abcompany.service.ClaseService;
import com.abcompany.service.EstudianteService;
import com.abcompany.service.GradoService;
import com.abcompany.service.ProfesorService;

@Controller
public class ClaseController {

	@Autowired
	private ClaseService claseService;

	@Autowired
	private ProfesorService profesorService;

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private GradoService gradoService;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	// CREACION DE ESTUDIANTES
	@GetMapping(value = "/clase/{id_clase}")
	public String classVo(@PathVariable Integer id_clase, Map<String, Object> map, Model model) {

		Clase clase = claseService.findById(id_clase);
		model.addAttribute("clase", clase);
		Profesor profesor = profesorService.findById(clase.getProfesor().getId_profesor());
		map.put("profesor", profesor);

		// modal Estudiante
		Estudiante estudiante = new Estudiante();
		model.addAttribute("estudianteVo", estudiante);
		
		
		int puntosClase = 0;
		for (Estudiante estudianteP : clase.getEstudianteList()) {
			puntosClase += estudianteP.getPuntosTotal();
		}

		List<Estudiante> listaEstudiante = clase.getEstudianteList().stream().collect(Collectors.toList());
		// ordenando la lista de estudiantes
		Collections.sort(listaEstudiante);
		map.put("alumnos", listaEstudiante);
		map.put("puntosClase", puntosClase);

		return "clase";
	}
	
	@PostMapping(value = "/dashboard")
	public String crearClase(@Valid Clase clase, Errors errors, Principal principal) {
		
		Optional<Profesor> profesorModel = profesorService.findByUsername(principal.getName());
		Profesor profesor = profesorService.findById(profesorModel.get().getId_profesor());
		clase.setProfesor(profesor);
		claseService.save(clase);

		return "redirect:/clase/"+clase.getId_clase();
	}
	
	@GetMapping(value = "/editar_clase/{id_clase}")
	public String editarClase_GET(@PathVariable Integer id_clase,Map<String, Object> map) {
		
		Clase clase = claseService.findById(id_clase);
		map.put("clase", clase);
		List<Estudiante> listaEstudiante = clase.getEstudianteList().stream().collect(Collectors.toList());

		//ordenando la lista de estudiantes
		Collections.sort(listaEstudiante);
		map.put("estudiantes",listaEstudiante);
		map.put("grados", gradoService.findAll());
		
		return "editar_clase";
	}
	
	@PostMapping(value = "/editar_clase/{id_clase}")
	public String editarClase_POST(@PathVariable Integer id_clase,Map<String, Object> map, Clase clase) {

		Clase clase1 = claseService.findById(id_clase);
//		Set<Estudiante> lista = new HashSet<>();
		clase.setProfesor(clase1.getProfesor());
		clase.setEstudianteList(clase1.getEstudianteList());
		clase.setGrado(clase.getGrado());
		claseService.save(clase);
		
		return "redirect:/clase/"+clase.getId_clase();
	}

	@GetMapping(value = "/reporteEstudiante/{id_estudiante}/{id_clase}")
	public String reportes(@PathVariable Integer id_estudiante, @PathVariable Integer id_clase,
			Map<String, Object> map) {

		Estudiante estudiante = estudianteService.findById(id_estudiante);
		Clase clase = claseService.findById(id_clase);
		map.put("estudiante", estudiante);
		map.put("clase", clase);
		map.put("premios", clase.getPremioList());
		map.put("estudianteRewards", estudiante.getPremioList());
		Premio premio = new Premio();
		map.put("premio", premio);

		return "reporteEstudiante";
	}



	// delete class
	@GetMapping(value = "/delete/{id_clase}")
	public String delete_class(@PathVariable Integer id_clase, Model model) {

		if (id_clase > 0) {
			// funciona con el orphanremoval = true -- OneToMany
			Clase clase = claseService.findById(id_clase);
//				Profesor profesor = profesorService.findById(clase.getProfesor().getId_profesor());
//				profesor.getClaseList().remove(clase);
//				profesorService.save(profesor);
			clase.setProfesor(null);
			claseService.delete(clase.getId_clase());
		}

		return "redirect:/dashboard";
	}
	

	@GetMapping("/grados/registrar")
	public String crearGrado(Model model) {
		Grado grado = new Grado();
		model.addAttribute("grado", grado);
		
		return "crear_grado";
	}
	
	@PostMapping("/grados/registrar")
	public String crearGrado_POST(Grado grado) {
		gradoService.insertar(grado);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/grados")
	public String listaGrados(Model model) {
		model.addAttribute("grados", gradoService.findAll());
		
		
		return "lista_grados";
	}
	
	@GetMapping("/grados/{id_grado}")
	public String editarGrado(@PathVariable Integer id_grado,Model model) {
		Grado gradoEncontrado = gradoService.findById(id_grado);
		model.addAttribute("grado", gradoEncontrado);
		
		return "editar_grado";
	}
	
	@PostMapping("/grados/{id_grado}")
	public String editarGrado_POST(@PathVariable Integer id_grado, Grado grado) {
		gradoService.insertar(grado);
		
		return "redirect:/grados";
	}
	
	@GetMapping("/grados/eliminar/{id_grado}")
	public String eliminar(@PathVariable Integer id_grado) {
		
		
		//SOLUCIONAR PARA QUE NO HAYA PROBLEMAS DE RELACIÓN CON CLASE
		Grado gradoEncontrado = gradoService.findById(id_grado);
		if(gradoEncontrado.getClaseList().size() > 0) {
			
			return "redirect:/grados";
		}
		
		
		gradoService.eliminar(id_grado);
		
		return "redirect:/grados";
	}
	
	
	
	
	

}
