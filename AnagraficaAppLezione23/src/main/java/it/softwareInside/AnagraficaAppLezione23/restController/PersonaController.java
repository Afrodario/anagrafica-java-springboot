package it.softwareInside.AnagraficaAppLezione23.restController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softwareInside.AnagraficaAppLezione23.models.Persona;
import it.softwareInside.AnagraficaAppLezione23.service.PersonaService;

@RestController
public class PersonaController {

	@Autowired
	PersonaService personaService;
	
	@PostMapping("/crea")
	public boolean aggiungiPersona(@RequestBody Persona persona) {
		return personaService.addPersonaToDB(persona);
	}
	
	@GetMapping("/stampa")
	public Iterable<Persona> stampaPersone() {
		return personaService.getAllPersona();
	}
	
	@PostMapping("/trova")
	public Persona trovaPersona(@RequestParam("code") String codiceFiscale) {
		return personaService.getPersonaByCode(codiceFiscale);
	}
	
	@DeleteMapping("/cancella-persona")
	public Persona cancellaPersona(@RequestParam("code") String codiceFiscale) {
		return personaService.deletePersonaByCode(codiceFiscale);
	}
	
	@GetMapping("/cancella-tutto")
	public void cancellaTutto() {
		personaService.deleteAllPersona();
	}
	
	@PostMapping("/aggiorna")
	public boolean aggiornaPersona(@RequestBody Persona persona) {
		return personaService.updatePersona(persona);
	}
	
	@GetMapping("/lista-25")
	public ArrayList<Persona> stampaPersone25() {
		return personaService.getPersona25Max();
	}
	
}
