/**
 * Interface que define o contrato para diferentes estratégias de priorização
 */
public interface PriorizacaoStrategy {
    int calcularPrioridade(OrdemServico os);
}

