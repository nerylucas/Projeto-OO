package entidades;

import excecoes.*;

public interface MetodoPagamento {
	void processarPagamento(double valor) throws SaldoInsuficienteException;

}

