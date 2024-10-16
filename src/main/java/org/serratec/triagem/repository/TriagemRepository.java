package org.serratec.triagem.repository;

import org.serratec.triagem.model.Triagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriagemRepository extends JpaRepository <Triagem, Long>
{
	/*List<Triagem>findByvagaDesejadaIgnoreCase(String vagaDesejada);
	List<Triagem> findByEscolaridadeIgnoreCase(Escolaridade escolaridade);*/
}
