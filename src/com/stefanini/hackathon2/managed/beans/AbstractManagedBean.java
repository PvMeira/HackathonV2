package com.stefanini.hackathon2.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Pessoa;
import com.stefanini.hackathon2.util.Mensageiro;


@ManagedBean
@ViewScoped
public abstract class AbstractManagedBean<T> {

	private List<T> listaCadastrados;
	private T tipo;
	
	
	
	@Inject
	private T servico;

	public AbstractManagedBean() {

	}
	public void salvar(){
//		servico.salvar(getTipo());
		Mensageiro.notificaInformacao("Parabéns!", "Salvo com sucesso!");
	}
	private void carregaLista(){
//		setListaCadastradas(servico.carregaTipoDoBanco());
	}
	private void carregaTipoDoBanco(){
		
	}
//	public T getTipo() {
//		if(tipo==null){
//			limpar();
//		}
//		return tipo;
//	}
//	
	public void setTipo(T tipo) {
		this.tipo = tipo;
	}
	


public void setListaCadastrados(List<T>listaCadastro ){
	this.listaCadastrados=listaCadastro;
}

public List<T> getListaCadastrados() {
	if(listaCadastrados==null){
		carregaLista();
	}
	return listaCadastrados;
}

}
