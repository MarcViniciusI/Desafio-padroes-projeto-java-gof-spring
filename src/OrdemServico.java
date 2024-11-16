import java.time.LocalDateTime;

/**
 * Classe que representa uma ordem de serviço no sistema
 */
public class OrdemServico {
    private String numero;
    private Cliente cliente;
    private String descricao;
    private double valor;
    private String status;
    private String prioridade;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public OrdemServico(String numero, Cliente cliente, String descricao,
                        double valor, String prioridade) {
        this.numero = numero;
        this.cliente = cliente;
        this.descricao = descricao;
        this.valor = valor;
        this.status = "Aberta";
        this.prioridade = prioridade;
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    // Getters e Setters
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        this.status = status;
        this.dataAtualizacao = LocalDateTime.now();
    }

    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }

    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }

    @Override
    public String toString() {
        return "OrdemServico{" +
                "numero='" + numero + '\'' +
                ", cliente=" + cliente.getNome() +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", status='" + status + '\'' +
                ", prioridade='" + prioridade + '\'' +
                '}';
    }
}