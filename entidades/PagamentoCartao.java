package entidades;

public class PagamentoCartao implements MetodoPagamento {
	private String numeroCartao;
	private String nomeTitular;
	private String cvv;
	private String validade;
	
	public PagamentoCartao(String numero, String nome, String cvv, String val) {
		this.numeroCartao = numero;
		this.nomeTitular = nome;
		this.cvv = cvv;
		this.validade = val;
	}
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	
	public String getCvv() {
		return cvv;
	}
	
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	public String getValidade() {
		return validade;
	}
	
	public void setValidade(String validade) {
		this.validade = validade;
	}
	
	public void processarPagamento(double valor) {
		System.out.println("Pagamento de " + valor + " reais processado no cartão");
	}

}
