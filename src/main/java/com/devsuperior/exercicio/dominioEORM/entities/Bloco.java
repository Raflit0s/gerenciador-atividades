package com.devsuperior.exercicio.dominioEORM.entities;

import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_bloco")
@Getter @Setter @NoArgsConstructor
public class Bloco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant inicio;
	private Instant fim;

	@ManyToOne
	@JoinColumn(name = "atividade_id")
	private Atividade atividade;
	
	public Bloco(Integer id, Instant inicio, Instant fim) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fim = fim;
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
		Bloco other = (Bloco) obj;
		return Objects.equals(id, other.id);
	}
}
