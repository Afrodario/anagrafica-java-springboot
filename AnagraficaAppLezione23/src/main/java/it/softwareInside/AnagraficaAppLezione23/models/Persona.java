package it.softwareInside.AnagraficaAppLezione23.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persona {
	@Id
    @Size(min = 5, max = 16, message = "Il codice fiscale dev'essere compreso tra 1 e 5 caratteri")
	private String codiceFiscale;
	
	@Min(value = 15, message = "L'età dev'essere minimo di 15")
	private int eta;
	
	@NotBlank(message="Il campo non deve essere vuoto")
	private String nome, cognome;
}
