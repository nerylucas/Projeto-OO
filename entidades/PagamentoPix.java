package entidades;

public class PagamentoPix implements MetodoPagamento {
	private String chavePix;
	private String tipoChave;
	
	public PagamentoPix(String chave, String tipo) {
		this.chavePix = chave;
		this.tipoChave = tipo;
	}
	
	public String getChavePix() {
		return chavePix;
	}
	
	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}
	
	public String getTipoChave() {
		return tipoChave;
	}
	
	public void setTipoChave(String tipoChave) {
		this.tipoChave = tipoChave;
	}
	
	public void processarPagamento(double valor) {
		System.out.println("Pagamento PIX de " + valor + " reais enviado pela chave: " + chavePix);
	}

}
