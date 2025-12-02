package servicos;
import entidades.*;
import excecoes.*;
public class ServicoDeCorrida {

	public Corrida solicitarCorrida(Corrida c, Passageiro p, String origem, String destino, Categoria cat) throws PassageiroPendenteException {
		if(p.isEmDebito()) {
			throw new PassageiroPendenteException("O passageiro não pode solicitar uma nova viagem enquanto possui pendências.");
		}
		else {
		c.setStatus(StatusCorrida.SOLICITADA);
		System.out.println("Corrida do passageiro " +p+" solicitada! A viagem saíra de " +origem+" e irá até " +destino+"! A viagem será realizada na categoria "+cat+"!");
		}
		return null;
		}
		
	
	public void aceitarCorrida(Corrida c, Motorista m) throws NenhumMotoristaDisponivelException {
		if(m.getStatus() != StatusMotorista.ONLINE) {
			throw new NenhumMotoristaDisponivelException("Nenhum motorista disponivel");
		}
		else {
			c.setStatus(StatusCorrida.ACEITA);
			m.setStatus(StatusMotorista.EM_CORRIDA);
		}
	}
	public void iniciarCorrida(Corrida c) throws EstadoInvalidoDaCorridaException {
		if (c.getStatus() != StatusCorrida.ACEITA) {
        throw new EstadoInvalidoDaCorridaException("Corrida não está no estado ACEITA.");
    }
		else {
		    c.iniciarViagem();
		    c.setStatus(StatusCorrida.EM_ANDAMENTO);
		}
		}
	   
	public void finalizarCorrida(Corrida c, double km) throws EstadoInvalidoDaCorridaException, PagamentoRecusadoException, SaldoInsuficienteException {

        if (c.getStatus() != StatusCorrida.EM_ANDAMENTO) {
            throw new EstadoInvalidoDaCorridaException("Corrida não está EM_ANDAMENTO.");
        }
        
        double valorFinal = c.getCategoria().calcularPreco(km);
        c.setDistanciaKm(km);
        c.setValorFinal(valorFinal);
		    
         try {
        	    c.getMetodoPagamento().processarPagamento(valorFinal);
        	 } catch (SaldoInsuficienteException e) {
        	     throw new PagamentoRecusadoException("Pagamento recusado: " + e.getMessage());
        	 } 
	}
	public void cancelarCorrida(Corrida c, double km, Motorista m) throws EstadoInvalidoDaCorridaException {
		if(c.getStatus() == StatusCorrida.FINALIZADA) {
		throw new EstadoInvalidoDaCorridaException("Não existe nenhuma corrida solicitada ou em andamento.");
	}
	else {
			c.setStatus(StatusCorrida.FINALIZADA);
			m.setStatus(StatusMotorista.ONLINE);
	}
		}
	
	
	}
	
	
	


