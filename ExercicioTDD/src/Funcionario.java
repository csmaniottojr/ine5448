import java.util.ArrayList;
import java.util.List;


public class Funcionario {
	
	private String nome;
	private List<Ocorrencia> ocorrencias;
	private final int NUM_MAX_OCORRENCIAS = 10;

	public Funcionario(String nome) {
		this.nome = nome;
		this.ocorrencias = new ArrayList<Ocorrencia>();
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}
	
	public void adicionarOcorrencia(Ocorrencia oc) throws FuncionarioComExcessoDeOcorrencias{
		
		if(ocorrencias.size() < NUM_MAX_OCORRENCIAS){
			ocorrencias.add(oc);
		}
		else{
			throw new FuncionarioComExcessoDeOcorrencias("Funcionário excedeu número máximo de ocorrências atendidas: " + NUM_MAX_OCORRENCIAS);
		}
		
	}

}
