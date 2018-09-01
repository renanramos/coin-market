package br.com.deviscoming.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class Coin {
	
	public Coin(){
		
	}
	
	private String id;
	private String name;
	private String price_usd;

}
