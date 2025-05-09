package com.devsuperior.exercicio.dominioEORM.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_atividade")
@Getter @Setter @NoArgsConstructor
public class Atividade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Double preco;
	
	@ManyToMany(mappedBy = "atividades")
	private List<Participante> participantes = new ArrayList<>();
	
	@OneToMany(mappedBy = "atividade")
	private List<Bloco> blocos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	public Atividade(Integer id, String nome, String descricao, Double preco) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return Objects.equals(id, other.id);
	}
}
