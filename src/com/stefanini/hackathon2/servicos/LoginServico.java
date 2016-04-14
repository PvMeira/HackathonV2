package com.stefanini.hackathon2.servicos;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Login;
import com.stefanini.hackathon2.repositorios.LoginRepositorio;
import com.stefanini.hackathon2.transacao.Transacional;

public class LoginServico {
	@Inject
	private LoginRepositorio repositorio;

	@Transacional
	public void salvar(Login livro) {
		if (livro.getIdLogin() == null) {
			repositorio.inserir(livro);
		} else {
			repositorio.atualizar(livro);
		}
	}

	@Transacional
	public List<Login> carregaTodosLoginsDoBanco() {
		return repositorio.todosLogins();
	}

	@Transacional
	public void deletar(Login livro) {
		repositorio.remover(livro);
		;
	}
}