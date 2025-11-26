package entidades;

public class PagamentoDinheiro implements MetodoPagamento {
	
	public PagamentoDinheiro() {}
	
	public void processarPagamento(double valor) {
		System.out.println("Pagamento em dinheiro de " + " reais realizado");
	}

}
