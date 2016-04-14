package com.stefanini.hackathon2.managed.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Login;
import com.stefanini.hackathon2.servicos.LoginServico;
import com.stefanini.hackathon2.util.Mensageiro;

@ManagedBean
@ViewScoped
public class LoginManagedBeans {

	private Login login;
	private List<Login> listaDeLoginsCadastrados;
	private String[] selecionarPermissoes;
	private List<String> permissoes;
	

	@Inject
	private LoginServico servico;

	public LoginManagedBeans() {
	}

	public void salvar() {
		servico.salvar(getLogin());
		Mensageiro.notificaInformacao("Parabéns!", "Cadastro salvo com sucesso!");
		carregaListaDeLogins();
		limpar();
	}

	public void deletar(Login login) {
		servico.deletar(login);
		Mensageiro.notificaInformacao("Parabéns!", "Cadastro deletado com sucesso!");
		carregaListaDeLogins();
		limpar();
	}

	public void limpar() {
		setLogin(new Login());
	}

	private void carregaListaDeLogins() {
		setListaDeLoginsCadastrados(servico.carregaTodosLoginsDoBanco());
	}

	public List<Login> getListaDePessoasCadastradas() {
		if (listaDeLoginsCadastrados == null) {
			carregaListaDeLogins();
		}
		return listaDeLoginsCadastrados;
	}

	public void setListaDeLoginsCadastrados(List<Login> listaDeLoginsCadastrados) {
		this.listaDeLoginsCadastrados = listaDeLoginsCadastrados;
	}

	public Login getLogin() {
		if (login == null) {
			limpar();
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@PostConstruct
	public void init() {
		permissoes = new ArrayList<String>();
		permissoes.add("ADM");
		permissoes.add("Bibliotecario");
		permissoes.add("RegistroLivro");
		permissoes.add("RegistroPessoa");

	}

	public String[] getSelecionarPermissoes() {
		return selecionarPermissoes;
	}

	public void setSelecionarPermissoes(String[] selecionarPermissoes) {
		this.selecionarPermissoes = selecionarPermissoes;
	}

	public List<String> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<String> permissoes) {
		this.permissoes = permissoes;
	}

}
