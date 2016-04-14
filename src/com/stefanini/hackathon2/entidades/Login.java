package com.stefanini.hackathon2.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLogin;
	@Column
	private String nameLogin;
	@Column
	private String senha;
	@JoinColumn(name = "idFuncionario")
	@OneToOne(cascade = CascadeType.REFRESH)
	private Funcionario funcionario;
	@Column
	private boolean ADM;
	@Column
	private boolean bibliotecario;
	@Column
	private boolean registroLivro;
	@Column
	private boolean registroPessoa;

	public Login() {

	}

	public Integer getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}

	public String getNameLogin() {
		return nameLogin;
	}

	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public boolean isADM() {
		return ADM;
	}

	public void setADM(boolean aDM) {
		ADM = aDM;
	}

	public boolean isBibliotecario() {
		return bibliotecario;
	}

	public void setBibliotecario(boolean bibliotecario) {
		this.bibliotecario = bibliotecario;
	}

	public boolean isRegistroLivro() {
		return registroLivro;
	}

	public void setRegistroLivro(boolean registroLivro) {
		this.registroLivro = registroLivro;
	}

	public boolean isRegistroPessoa() {
		return registroPessoa;
	}

	public void setRegistroPessoa(boolean registroPessoa) {
		this.registroPessoa = registroPessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ADM ? 1231 : 1237);
		result = prime * result + (bibliotecario ? 1231 : 1237);
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((idLogin == null) ? 0 : idLogin.hashCode());
		result = prime * result + ((nameLogin == null) ? 0 : nameLogin.hashCode());
		result = prime * result + (registroLivro ? 1231 : 1237);
		result = prime * result + (registroPessoa ? 1231 : 1237);
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Login other = (Login) obj;
		if (ADM != other.ADM)
			return false;
		if (bibliotecario != other.bibliotecario)
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (idLogin == null) {
			if (other.idLogin != null)
				return false;
		} else if (!idLogin.equals(other.idLogin))
			return false;
		if (nameLogin == null) {
			if (other.nameLogin != null)
				return false;
		} else if (!nameLogin.equals(other.nameLogin))
			return false;
		if (registroLivro != other.registroLivro)
			return false;
		if (registroPessoa != other.registroPessoa)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

}
