package br.com.treinaweb.twprojetos.entidades;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/* mappedSuperclass informa que a classe é abstrata portanto não será
 * criado no banco uma entidade pessoa
 */

@MappedSuperclass
public abstract class Pessoa extends Entidade {

   

    /* a anotação column define que o atributo da classe é um campo da tabela */
    @Column(nullable = false, length = 80)  
    private String nome;
    
    /*cpf varchar(14) not null unique */
    @Column(nullable = false, length = 14, unique = true)  
    private String cpf;
    
    @Column(nullable = false, length = 15)  
    private String telefone;
    
    @Column(nullable = false, length = 80, unique = true)  
    private String email;
    
    @Column(name="data_nascimento", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id_fk", nullable = false)
    private Endereco endereco;

    /* GERAR GET E SET */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }



    
    
}
