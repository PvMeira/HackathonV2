package com.stefanini.hackathon2.servicos;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Livro;
import com.stefanini.hackathon2.repositorios.LivroRepositorio;
import com.stefanini.hackathon2.transacao.Transacional;
import com.stefanini.hackathon2.util.Mensageiro;

public class LivroServico {

	@Inject
	private LivroRepositorio repositorio;
	
	@Transacional
	public void salvar(Livro livro) {
		if (livro.getId() == null) {
			repositorio.inserir(livro);
			Mensageiro.notificaInformacao("Parabéns!", "Livro salvo com sucesso!");
		} else {
			repositorio.atualizar(livro);
			Mensageiro.notificaInformacao("Parabéns!", "Livro salvo com sucesso!");
		}
	}

	@Transacional
	public List<Livro> carregaTodosLivrosDoBanco() {
		return repositorio.todosLivros();
	}

	@Transacional
	public void deletar(Livro livro) {
		repositorio.remover(livro);;
		Mensageiro.notificaInformacao("Parabéns!", "Livro deletado com sucesso!");
	}
	
}
