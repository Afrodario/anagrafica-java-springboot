package it.softwareInside.AnagraficaAppLezione23.repository;

import org.springframework.data.repository.CrudRepository;

import it.softwareInside.AnagraficaAppLezione23.models.Persona;

public interface PersonaRepository extends CrudRepository<Persona, String> {

}
