package org.serratec.triagem.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.triagem.Dto.TriagemDto;
import org.serratec.triagem.service.TriagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/curriculos")
public class TriagemController {
	
	@Autowired
	private TriagemService servico; //"junta" com service
	
	@GetMapping
	public List<TriagemDto> obterTodos() {
	    return servico.obterTodos();
	}
	
	@GetMapping("/{id}")  //busca por id
	public ResponseEntity<TriagemDto> obterPorId(@PathVariable Long id) {
	    Optional<TriagemDto> dto = servico.obterPorId(id);
	    
	    // Verifica se o ID existe ou não
	    if (!dto.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    return ResponseEntity.ok(dto.get());
	}
	
	@PostMapping //cria
	@ResponseStatus(HttpStatus.CREATED) //muda o status para 201
	public TriagemDto cadstrarTriagem(@RequestBody TriagemDto dto) {
	    return servico.salvarCurriculo(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletaTriagem(@PathVariable Long id) {
	    if (!servico.apagarCurriculo(id)) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TriagemDto> alterarTriagem(@PathVariable Long id, @RequestBody TriagemDto dto) {
	    Optional<TriagemDto> triagemAlterada = servico.alterarCurriculo(id, dto);

	    if (!triagemAlterada.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.ok(triagemAlterada.get());
	}
	
	/*@GetMapping("/vagas/{vagas}")
	public List<TriagemDto> obterPorVagaDesejada(@PathVariable String vagaDesejada) {
	    return servico.obterPorVagaDesejada(vagaDesejada);
	}

	@GetMapping("/cliente/{cliente}")
	public List<TriagemDto> obterPorEscolaridade(@PathVariable String escolaridade) {
	    return servico.obterPorEscolaridade(escolaridade);
	}*/

}
