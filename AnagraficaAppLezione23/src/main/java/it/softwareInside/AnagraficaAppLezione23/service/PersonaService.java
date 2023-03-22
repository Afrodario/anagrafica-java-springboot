package it.softwareInside.AnagraficaAppLezione23.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import it.softwareInside.AnagraficaAppLezione23.models.Persona;
import it.softwareInside.AnagraficaAppLezione23.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	PersonaRepository personaRepository;
	
	/**
	 * Metodo che prende in ingresso un oggetto di tipo Persona e ritorna
	 * true se riesce ad aggiungerlo al database
	 * @param note
	 * @return
	 */
	public boolean addPersonaToDB(@Validated Persona persona) {
		try {
			personaRepository.save(persona);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/**
	 * Metodo che stampa tutti gli oggetti di tipo Persona tramite un Iterable
	 * @return
	 */
	public Iterable<Persona> getAllPersona() {
		try {
			return personaRepository.findAll();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Metodo che prende in ingresso un codice fiscale e restituisce un oggetto di tipo Persona
	 * oppure null se non riesce a trovarlo
	 * @param codiceFiscale
	 * @return
	 */
	public Persona getPersonaByCode(String codiceFiscale) {
		try {
			return personaRepository.findById(codiceFiscale).get();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Metodo che prende in ingresso un codice fiscale, salva in una variabile d'appoggio l'oggetto
	 * di tipo Persona trovato, lo cancella dal database e ritorna l'oggetto salvato
	 * @param codiceFiscale
	 * @return
	 */
	public Persona deletePersonaByCode(String codiceFiscale) {
		try {
			Persona persona = personaRepository.findById(codiceFiscale).get();
			personaRepository.deleteById(codiceFiscale);
			return persona;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**
	 * Metodo di tipo void che cancella tutti i record dal database
	 */
	public void deleteAllPersona() {
		try {
			personaRepository.deleteAll();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Metodo che fa l'aggiornamento di un record del database, recuperandolo tramite
	 * il codice fiscale di un oggetto di tipo Persona in ingresso e salvandolo nuovamente a database
	 * @param persona
	 * @return
	 */
	public boolean updatePersona(@Validated Persona persona) {
		try {
			personaRepository.findById(persona.getCodiceFiscale()).get();
			personaRepository.save(persona);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/**
	 * Metodo che crea un nuovo ArrayList, cicla l'Iterable contenente tutti i record del 
	 * database e aggiunge nel nuovo ArrayList tutti gli oggetti di tipo Persona il cui
	 * attributo età è maggiore o uguale a 25. Ritorna il nuovo ArrayList
	 * @return
	 */
	public ArrayList<Persona> getPersona25Max() {
		try {
			ArrayList<Persona> nuovaLista = new ArrayList<>();
			Iterable<Persona> listaCompleta = personaRepository.findAll();
			for(Persona persona : listaCompleta) {
				if(persona.getEta() >= 25)
					nuovaLista.add(persona);
			}
			return nuovaLista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	
	
	
}
