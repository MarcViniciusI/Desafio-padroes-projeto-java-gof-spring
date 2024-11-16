package Strategy;
import models.OrdemServico;

/**
 * Implementação da estratégia de priorização baseada no valor do serviço
 */
public class PriorizacaoPorValor implements PriorizacaoStrategy {
    @Override
    public int calcularPrioridade(OrdemServico os) {
        if (os.getValor() > 1000) return 3;
        if (os.getValor() > 500) return 2;
        return 1;
    }
}
