package br.com.treinaweb.twprojetos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.treinaweb.twprojetos.entidades.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {
    
    /*Performar o carregamento das queries */
    @EntityGraph(attributePaths = {"endereco", "cargo"})
    List<Funcionario> findAll();
    

    /*Anotação para buscar no banco apenas funcionarios de um determinado cargo*/
   /*  @Query("select f from Funcionario f where f.cargo.nome = :cargoNome")
    List<Funcionario> buscarPorCargo(String cargoNome);

    @Query("select f from Funcionario f where f.cargo.nome <> :cargoNome")
    List<Funcionario> buscarPorCargoExceto(String cargoNome);*/

List<Funcionario> findByCargoNome(String cargoNome);

List<Funcionario> findByCargoNomeNot(String cargoNome);

}
