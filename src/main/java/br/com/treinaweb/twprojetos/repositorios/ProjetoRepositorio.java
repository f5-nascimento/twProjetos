package br.com.treinaweb.twprojetos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.twprojetos.entidades.Projeto;

public interface ProjetoRepositorio extends JpaRepository<Projeto, Long> {
    
     /*Performar o carregamento das queries */
    @EntityGraph(attributePaths = {"lider", "cliente"})
    List<Projeto> findAll();

}
