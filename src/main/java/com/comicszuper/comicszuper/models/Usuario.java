package com.comicszuper.comicszuper.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.br.CPF;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_USUARIO" )
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Email
	@Column(nullable = false, unique = true)
	private String Email;
    
	@CPF
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "Brazil/East")
	private LocalDate dataDeNascimento;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private Set<Comics> listagemComics = new HashSet<>();
	
	public Usuario toEntity() {
		return new Usuario(this.id, this.nome, this.cpf, this.Email, this.dataDeNascimento);
		
		
	}
public Usuario() {
	
}
	
	public Usuario(long id, String nome, @javax.validation.constraints.Email String Email,
			@org.hibernate.validator.constraints.br.CPF String cpf, LocalDate dataDeNascimento ) {
		super();
		this.id = id;
		this.nome = nome;
		this.Email = Email;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public Set<Comics> getListagemComics() {
		return listagemComics;
	}
	public void setListagemComics(Set<Comics> listagemComics) {
		this.listagemComics = listagemComics;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((dataDeNascimento == null) ? 0 : dataDeNascimento.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((listagemComics == null) ? 0 : listagemComics.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (dataDeNascimento == null) {
			if (other.dataDeNascimento != null)
				return false;
		} else if (!dataDeNascimento.equals(other.dataDeNascimento))
			return false;
		if (id != other.id)
			return false;
		if (listagemComics == null) {
			if (other.listagemComics != null)
				return false;
		} else if (!listagemComics.equals(other.listagemComics))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}

