package entidades;
import java.util.ArrayList;
import java.util.List;

import excecoes.FuncionarioComExcessoDeOcorrencias;
import excecoes.FuncionarioComOcorrenciaJaIncluida;


public class Funcionario {
	
	private int id;
	private String nome;
	private List<Ocorrencia> ocorrenciasAtendidas;
	private final int NUM_MAX_OCORRENCIAS = 10;

	public Funcionario(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.ocorrenciasAtendidas = new ArrayList<Ocorrencia>();
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
	public int getId(){
		return id;
	}
	
	public String getNome(){
		return nome;
	}
	
	@Override
	public boolean equals(Object objeto) {
		
		if(objeto instanceof Funcionario){
			Funcionario outroFuncionario = (Funcionario) objeto;
			return id == outroFuncionario.getId();
		}
		return false;
		
	}
	
	public boolean estaAtendendoOcorrencia(Ocorrencia oc){
		return ocorrenciasAtendidas.contains(oc);
	}
	
	public void adicionarOcorrencia(Ocorrencia oc) throws FuncionarioComExcessoDeOcorrencias{
		
		if(ocorrenciasAtendidas.size() >= NUM_MAX_OCORRENCIAS){
			String msg = "Funcionário excedeu número máximo de ocorrências atendidas: " + NUM_MAX_OCORRENCIAS;
			throw new FuncionarioComExcessoDeOcorrencias(msg);
			
		}
		else if(ocorrenciasAtendidas.contains(oc)){
			String msg = "Funcionário já possui a ocorrência " + oc + " cadastrada";
			throw new FuncionarioComOcorrenciaJaIncluida(msg);		
		}
		
		ocorrenciasAtendidas.add(oc);
		
		
	}
	
	public void removerOcorrencia(Ocorrencia oc){
		ocorrenciasAtendidas.remove(oc);
	}
	

}
