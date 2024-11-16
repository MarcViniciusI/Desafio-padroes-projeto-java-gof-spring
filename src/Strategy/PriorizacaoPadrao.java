package Strategy;
import models.OrdemServico;

/**
 * Implementação da estratégia de priorização padrão baseada no nível de prioridade
 */
public class PriorizacaoPadrao implements PriorizacaoStrategy {
    @Override
    public int calcularPrioridade(OrdemServico os) {
        switch(os.getPrioridade().toLowerCase()) {
            case "alta": return 3;
            case "media": return 2;
            case "baixa": return 1;
            default: return 0;
        }
    }
}
