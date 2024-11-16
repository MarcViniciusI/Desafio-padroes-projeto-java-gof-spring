package Strategy;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import models.OrdemServico;

/**
 * Implementação da estratégia de priorização baseada na data de criação
 */
public class PriorizacaoPorData implements PriorizacaoStrategy {
    @Override
    public int calcularPrioridade(OrdemServico os) {
        long diasEmAberto = ChronoUnit.DAYS.between(
                os.getDataCriacao(),
                LocalDateTime.now()
        );
        if (diasEmAberto > 7) return 3;
        if (diasEmAberto > 3) return 2;
        return 1;
    }
}
