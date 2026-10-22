package br.com.protons.sprintapi.repository;

import br.com.protons.sprintapi.model.Categoria;
import br.com.protons.sprintapi.model.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

    /** Busca por texto (Query Method): enunciado contem o termo, sem diferenciar maiusculas. */
    List<Pergunta> findByEnunciadoContainingIgnoreCase(String texto);

    List<Pergunta> findByCategoria(Categoria categoria);
}
