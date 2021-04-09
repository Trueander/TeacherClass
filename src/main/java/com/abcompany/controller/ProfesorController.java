package com.abcompany.controller;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.abcompany.model.Clase;
import com.abcompany.model.Profesor;
import com.abcompany.service.GradoService;
import com.abcompany.service.ProfesorService;

@Controller
public class ProfesorController {

	@Autowired
	private ProfesorService profesorService;

	@Autowired
	private GradoService gradoService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping(value = "/dashboard")
	public String main_p(Principal principal, Map<String, Object> map, Model model) {

		// creando la clase
		Clase clase = new Clase();
		model.addAttribute("clase", clase);

		String username = principal.getName();

		Optional<Profesor> profesorModel = profesorService.findByUsername(username);
		Profesor profesor = profesorService.findById(profesorModel.get().getId_profesor());
		model.addAttribute("profesor", profesor);
		map.put("bClases", profesor.getClaseList());
		map.put("grados", gradoService.findAll());

		return "main_p";
	}

	@GetMapping(value = "/registrar")
	public String crearProfesor(Model model) {

		Profesor profesor = new Profesor();
		model.addAttribute("profesor", profesor);

		return "save_p";
	}

	@GetMapping(value = "/editar_profesor/{id_profesor}")
	public String update_teacher_GET(@PathVariable Integer id_profesor, Map<String, Object> map) {

		Profesor profesor = profesorService.findById(id_profesor);
		map.put("profesor", profesor);

		return "editar_profesor";
	}

	@PostMapping(value = "/editar_profesor/{id_profesor}")
	public String update_teacher_POST(@Valid Profesor profesor, Errors errors, @PathVariable Integer id_profesor,
			Map<String, Object> map) {

		if (errors.hasErrors()) {
			return "editar_profesor";
		}

		profesorService.save(profesor);

		return "redirect:/dashboard";
	}

	@PostMapping(value = "/registrar")
	public String crearProfesor_POST(@Valid Profesor profesor, Errors errors, Map<String, Object> map, RedirectAttributes flash) {

		if (errors.hasErrors()) {
			return "save_p";
		}

		for (Profesor profesorModel : profesorService.findAll()) {
			if (profesor.getUsername().contains(profesorModel.getUsername())) {
				map.put("errorEmail", "El usuario ya existe!");
				return "save_p";
			}
		}

		int full = profesorService.findAll().size();
		if (full > 10) {
			map.put("full", "Límite de cuentas superada, contactese a: anderson.bengolea@gmail.com");
			return "save_p";
		} else {
			String bCrypt = passwordEncoder.encode(profesor.getPassword());
			profesor.setPassword(bCrypt);
			profesorService.save(profesor);

		}

		return "redirect:/dashboard";
	}

}
