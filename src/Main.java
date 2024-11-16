/**
 * Classe principal que demonstra o uso do sistema
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Criando instância do sistema
            SistemaOSFacade sistema = new SistemaOSFacade();

            // Cadastrando alguns clientes
            sistema.cadastrarCliente("1", "João Silva", "1234-5678",
                    "joao@email.com", "Rua A, 123");
            sistema.cadastrarCliente("2", "Maria Santos", "8765-4321",
                    "maria@email.com", "Rua B, 456");

            // Criando algumas ordens de serviço
            sistema.criarOrdemServico("OS001", "1", "Manutenção de Computador",
                    800.0, "alta");
            sistema.criarOrdemServico("OS002", "2", "Formatação de Notebook",
                    300.0, "media");
            sistema.criarOrdemServico("OS003", "1", "Instalação de Software",
                    150.0, "baixa");

            // Listando ordens com priorização padrão
            System.out.println("\nOrdens de serviço por prioridade padrão:");
            sistema.listarOrdensServicoPriorizadas().forEach(System.out::println);

            // Mudando estratégia de priorização para valor
            sistema.setEstrategiaPriorizacao(new PriorizacaoPorValor());
            System.out.println("\nOrdens de serviço por valor:");
            sistema.listarOrdensServicoPriorizadas().forEach(System.out::println);

            // Atualizando status de uma ordem
            sistema.atualizarStatusOS("OS001", "Em andamento");

            // Finalizando o sistema
            sistema.finalizar();

        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}