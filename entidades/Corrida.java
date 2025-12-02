package entidades;

import java.time.LocalDateTime;

public class Corrida {

    private LocalDateTime data;
    private String origem;
    private String destino;
    private double distanciaKm;
    private double valorFinal;
    private StatusCorrida status;
    private MetodoPagamento metodoPagamento;
    private Passageiro passageiro;
    private Motorista motorista; 
    private Categoria categoria; 
    
    public double calcularDistancia(String origem, String destino) {
    	return Math.random() * 20;
    }

    public Corrida(Passageiro passageiro, String origem, String destino, Categoria categoria, double distanciaKm) {
        this.passageiro = passageiro;
        this.origem = origem;
        this.destino = destino;
        this.categoria = categoria;
        this.data = LocalDateTime.now();
        this.distanciaKm = calcularDistancia(origem, destino);
        this.valorFinal = 0.0;
        this.status = StatusCorrida.SOLICITADA;
    }

    public StatusCorrida getStatus() {
        return status;
    }

    public void setStatus(StatusCorrida s) {
        this.status = s;
    }

    public double getValor() {
        return valorFinal;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public double calcularValorEstimado(double distanciaKm) {
        return categoria.calcularPreco(distanciaKm);
        
    }

    public void setValorFinal(double valor) {
        this.valorFinal = valor;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public void setMetodoPagamento(MetodoPagamento metodo) {
        this.metodoPagamento = metodo;
    }

    public void iniciarViagem() {
        this.status = StatusCorrida.EM_ANDAMENTO;
        System.out.println("Corrida iniciada às " + data + "! Você partirá de " + origem + " e chegará a " + destino);
    }

    public void finalizarViagem() {
        this.valorFinal = categoria.calcularPreco(distanciaKm);
        this.status = StatusCorrida.FINALIZADA;

        System.out.println("Corrida finalizada! Você percorreu " + distanciaKm + ": Valor total de " + valorFinal + "reais.");
    }

    public void cancelar() {
    	this.status = StatusCorrida.CANCELADA;
        System.out.println("Corrida cancelada!");
    }
    
    public MetodoPagamento getMetodoPagamento() {
    	return metodoPagamento;
    }
}



