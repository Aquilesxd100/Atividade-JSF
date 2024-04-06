package br.com.cadUser;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named
@SessionScoped
public class Pessoa implements Serializable {
	private String nome = "";
	private String[] nomes = new String[0];
	
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void addNome() {
		String[] novosNomes = new String[this.nomes.length + 1];
		
		for (int idx = 0; idx < this.nomes.length; idx++) {
			novosNomes[idx] = this.nomes[idx];
		}
		novosNomes[this.nomes.length] = this.nome;
		
		this.setNomes(novosNomes);
		this.clearName();
	}
	
	public void setNomes(String[] _nomes) {
		this.nomes = _nomes;
	}	
	
	public void clearName() {
		this.nome = "";
	}
	
	public String renderizarNomesParaTabela() {
		String estruturaHtml = "";
		
		for(int idx = 0; idx < this.nomes.length; idx++) {
			estruturaHtml = 
				estruturaHtml + 
				"<tr>" + 
					"<th>" +
						(idx + 1) +
					"</th>" +
					"<th>" +
						this.nomes[idx] +
					"</th>" +
				"</tr>";
		}
		
		return estruturaHtml;
	}
}
