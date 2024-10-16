package org.serratec.triagem.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;

@Entity
@Table (name = "curriculos")
public class Triagem {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty // não deixa espaço vazio (nem espaço)
	private String nomeCandidato;
	@Past
	private LocalDate dataDeNascimento; // 
	private long cpf;
	@Enumerated(EnumType.STRING) //salva a string e não o id
	private Escolaridade escolaridade; //(tipos: MEDIO, FUNDAMENTAL, GRADUACAO, POS_GRADUACAO, ESPECIALIZACAO)
	@Enumerated(EnumType.STRING)
	private VagaDesejada vagaDesejada; //(tipos: ANALISTA, QA, DEV, TECH_LEAD, SUPORTE, UX)
	@Enumerated(EnumType.STRING)
	private StatusCurriculo statusCurriculo; //(tpos: EM_ANALISE, REPROVADO, APROVADO)
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeCandidato() {
		return nomeCandidato;
	}
	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	
	}
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	public VagaDesejada getVagaDesejada() {
		return vagaDesejada;
	}
	public void setVagaDesejada(VagaDesejada vagaDesejada) {
		this.vagaDesejada = vagaDesejada;
	}
	public StatusCurriculo getStatusCurriculo() {
		return statusCurriculo;
	}
	public void setStatusCurriculo(StatusCurriculo statusCurriculo) {
		this.statusCurriculo = statusCurriculo;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	

}
