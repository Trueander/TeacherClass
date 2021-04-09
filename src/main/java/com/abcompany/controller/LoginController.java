package com.abcompany.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model, Principal principal, RedirectAttributes flash){
		
		if(principal != null) {
			flash.addFlashAttribute("info","Ya ha iniciado sesión");
			return "redirect:/dashboard";
		}
		
		if(error != null) {
			model.addAttribute("error","Error en el login datos incorrectos");
		}
		
		return "login";
	}
	
	//método para cerrar sesión por spring security
    @GetMapping(value="/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response) 
    {
        //identifica al usuario autenticado
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();

        //si existe, cerrar sesión
        if(auth!=null)    
            new SecurityContextLogoutHandler().logout(request,response,auth);

        //si no existe, redireccionar al login
        return "redirect:login?logout";
    }
	
}
