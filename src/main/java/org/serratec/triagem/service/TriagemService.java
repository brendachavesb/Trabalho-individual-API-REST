package org.serratec.triagem.service;

import java.util.List;
import java.util.Optional;


import org.serratec.triagem.Dto.TriagemDto;
import org.serratec.triagem.model.Triagem;
import org.serratec.triagem.repository.TriagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriagemService {
	@Autowired
	private TriagemRepository repositorio;
	
	public List<TriagemDto> obterTodos(){
		return repositorio.findAll().stream().map(p -> TriagemDto.toDto(p)).toList();
	}
	
	public Optional<TriagemDto> obterPorId(Long id){
		if(!repositorio.existsById(id)) {
			return Optional.empty();			
		}
		return Optional.of(TriagemDto.toDto(repositorio.findById(id).get()));
		
		}
	
	public TriagemDto salvarCurriculo(TriagemDto dto) {		
		Triagem triagemEntity = repositorio.save(dto.toEntity());
		return TriagemDto.toDto(triagemEntity);
	}
	public boolean apagarCurriculo(Long id) {
		if (!repositorio.existsById(id)) {
			return false;
		}
		repositorio.deleteById(id);
		return true;
		}
	public Optional<TriagemDto> alterarCurriculo(Long id, TriagemDto dto){
		if(!repositorio.existsById(id)) {
			return Optional.empty();
		}
		Triagem triagemEntity = dto.toEntity();
		triagemEntity.setId(id);
		repositorio.save(triagemEntity);
		return Optional.of(TriagemDto.toDto(triagemEntity));
	}
	
	/*
	public List<TriagemDto> obterPorVagaDesejada(String vagaDesejada) {
		List<Triagem> triagem = repositorio.findByvagaDesejadaIgnoreCase(vagaDesejada);
		return triagem.stream().map(p -> TriagemDto.toDto(p)).toList();
	}

	public List<TriagemDto> obterPorEscolaridade(String escolaridade) {
	List<Triagem> triagem = repositorio.findByEscolaridadeIgnoreCase(escolaridade);
	return triagem.stream().map(p -> TriagemDto.toDto(p)).toList();
}*/
}
