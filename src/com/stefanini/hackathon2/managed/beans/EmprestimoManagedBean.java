package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Emprestimo;
import com.stefanini.hackathon2.servicos.EmprestimoServico;
import com.stefanini.hackathon2.util.Mensageiro;

public class EmprestimoManagedBean {

	private Emprestimo emprestimo;
	private List<Emprestimo> listaDeEmprestimoCadastrados;

	@Inject
	private EmprestimoServico servico;

	public EmprestimoManagedBean() {
	}

	public void salvar() {
		servico.salvar(getEmprestimo());
		Mensageiro.notificaInformacao("Parab�ns!", "Cadastro salvo com sucesso!");
		carregaListaDeEmprestimos();
		limpar();
	}

	public void deletar(Emprestimo emprestimo) {
		servico.deletar(emprestimo);
		Mensageiro.notificaInformacao("Parab�ns!", "Cadastro deletado com sucesso!");
		carregaListaDeEmprestimos();
		limpar();
	}

	public void limpar() {
		setEmprestimo(new Emprestimo());
	}

	private void carregaListaDeEmprestimos() {
		setListaDeEmprestimosCadastrados(servico.carregarTodosEmprestimosDoBanco());
	}

	public List<Emprestimo> getListaDeEmprestimosCadastrados() {
		if (listaDeEmprestimoCadastrados == null) {
			carregaListaDeEmprestimos();
		}
		return listaDeEmprestimoCadastrados;
	}

	public void setListaDeEmprestimosCadastrados(List<Emprestimo> listaDeEmprestimosCadastrados) {
		this.listaDeEmprestimoCadastrados = listaDeEmprestimosCadastrados;
	}

	public Emprestimo getEmprestimo() {
		if (emprestimo == null) {
			limpar();
		}
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

}