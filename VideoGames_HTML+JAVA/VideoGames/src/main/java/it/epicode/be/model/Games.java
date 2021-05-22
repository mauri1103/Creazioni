package it.epicode.be.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Component
public class Games {
	
	private int id; 
	private String genere;
	private String nome;
	private String casaProdutrice;
	private int etaMinima;

}
