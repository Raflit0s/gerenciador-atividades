package com.devsuperior.exercicio.dominioEORM.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_participante")
@Getter @Setter @NoArgsConstructor
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	
	@ManyToMany
	@JoinTable(name = "tb_participante_atividade",
	joinColumns = @JoinColumn(name = "participante_id"),
	inverseJoinColumns = @JoinColumn(name = "atividade_id"))
	private List<Atividade> atividades = new ArrayList<>();
	
	public Participante(Integer id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Participante(Integer id) {
		super();
		this.id = id;
	}
}
