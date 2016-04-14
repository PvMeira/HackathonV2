package com.stefanini.hackathon2.servicos;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Emprestimo;
import com.stefanini.hackathon2.entidades.Livro;
import com.stefanini.hackathon2.repositorios.EmprestimoRepositorio;
import com.stefanini.hackathon2.transacao.Transacional;

public class EmprestimoServico {
	@Inject
	private EmprestimoRepositorio repositorio;

	@Transacional
	public void salvar(Emprestimo emprestimo) {
		if (emprestimo.getIdEmprestimo() == null) {
			if (emprestimo.getStatus() == "DISPONIVEL") {
				for (Livro confereEstoque : emprestimo.getLivros()) {
					if (confereEstoque.getEstoque() <= 1) {
						System.out.println("Desculpe mas o livro está sem exemplares");
					} else {
						for (Livro livroDiminui : emprestimo.getLivros()) {
							livroDiminui.setEstoque(livroDiminui.getEstoque() - 1);
						}
						emprestimo.setDataEntrada(LocalDateTime.now());
						emprestimo.setStatus("ALUGADO");
						repositorio.inserir(emprestimo);
					}

				}

			}

		}
	}



	@Transacional
	public List<Emprestimo> carregarTodosEmprestimosDoBanco() {
		return repositorio.todosEmprestimos();
	}

	@Transacional
	public void deletar(Emprestimo emprestimo) {
		repositorio.remover(emprestimo);
		;
	}

	@Transacional
	public int calcIntervaloDias(LocalDateTime begin, LocalDateTime end) {
		LocalDateTime weekDay = begin;
		Integer dayQuantity = 0;

		if (end == null) {
			end = LocalDateTime.now();
		}

		while (weekDay.isBefore(end)) {
			if (weekDay.getDayOfWeek() == DayOfWeek.FRIDAY) {
				weekDay = weekDay.plusDays(3);
			} else {
				weekDay = weekDay.plusDays(1);
			}
			dayQuantity++;
		}
		return dayQuantity <= 7 ? 0 : dayQuantity - 7;
	}

}
