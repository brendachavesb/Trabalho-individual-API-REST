package org.serratec.triagem.Dto;
import java.time.LocalDate;

import org.serratec.triagem.model.Escolaridade;
import org.serratec.triagem.model.StatusCurriculo;
import org.serratec.triagem.model.Triagem;
import org.serratec.triagem.model.VagaDesejada;

public record TriagemDto (
	Long id,
	String nomeCandidato,
	LocalDate dataDeNascimento,
	long cpf,
	Escolaridade escolaridade,
	VagaDesejada vagaDesejada,
	StatusCurriculo statusCurriculo
	){
	
	public Triagem toEntity () {
		Triagem triagem = new Triagem ();
		triagem.setId(this.id);
		triagem.setNomeCandidato(this.nomeCandidato);
		triagem.setDataDeNascimento(this.dataDeNascimento);
		triagem.setCpf(this.cpf);
		triagem.setEscolaridade(this.escolaridade);
		triagem.setVagaDesejada(this.vagaDesejada);
		triagem.setStatusCurriculo(this.statusCurriculo);
		return triagem;	
		}
	public static TriagemDto toDto(Triagem triagem) 
	{ 
		return new TriagemDto(
				triagem.getId(),
				triagem.getNomeCandidato(),
				triagem.getDataDeNascimento(),
				triagem.getCpf(),
				triagem.getEscolaridade(),
				triagem.getVagaDesejada(),
				triagem.getStatusCurriculo());			
	}			

	}
	
	
	


