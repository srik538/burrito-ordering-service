package com.generali.burritoorderingservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "`ORDER`")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Order implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "tortilla")
	@Pattern(regexp = "corn|flour")
	private String tortilla;

	@Column(name = "protein")
	@Pattern(regexp = "bean|beef|chicken|pork|shrimp|steak")
	private String protein;

	@Column(name = "vegetables")
	private String vegetables;

	@Column(name = "salsa")
	@Pattern(regexp = "mild|medium|hot")
	private String salsa;

	@Column(name = "extras")
	private String extras;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTortilla() {
		return tortilla;
	}

	public void setTortilla(String tortilla) {
		this.tortilla = tortilla;
	}

	public String getProtein() {
		return protein;
	}

	public void setProtein(String protein) {
		this.protein = protein;
	}

	public String getVegetables() {
		return vegetables;
	}

	public void setVegetables(String vegetables) {
		this.vegetables = vegetables;
	}

	public String getSalsa() {
		return salsa;
	}

	public void setSalsa(String salsa) {
		this.salsa = salsa;
	}

	public String getExtras() {
		return extras;
	}

	public void setExtras(String extras) {
		this.extras = extras;
	}

}