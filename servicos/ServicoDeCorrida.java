package servicos;
import entidades.Corrida;
import entidades.Passageiro;
import entidades.Motorista;
import java.lang.Exception;
import entidades.Categoria;
import entidades.MetodoPagamento;

public class ServicoDeCorrida {

	public Corrida solicitarCorrida(Passageiro p, String origem, String destino, Categoria cat) {
	
		System.out.println("O passageiro "+p.getNome()+" solicitou uma corrida de "+ origem +" até "+destino+ " pela categoria " + cat);
		return null;
	}
	public void aceitarCorrida(Corrida c, Motorista m) {
		
	}
	public void iniciarCorrida(Corrida c, double km) {
		
	}
	public void finalizarCorrida(Corrida c, double km) {
		
	}
	public void cancelarCorrida(Corrida c, double km) {
		
	}
	public void processarPagamento(Corrida c, MetodoPagamento mp) throws Exception{
		
	}
	}
	
	
	

