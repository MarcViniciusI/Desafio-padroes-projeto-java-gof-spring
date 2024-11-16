package facade;
import Singleton.DatabaseConnection;
import Strategy.PriorizacaoPadrao;
import Strategy.PriorizacaoStrategy;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import models.OrdemServico;

/**
 * Facade que simplifica a interface do sistema para o cliente
 * Integra todos os componentes e fornece uma interface única
 */
public class SistemaOSFacade {
    private DatabaseConnection db;
    private List<Cliente> clientes;
    private List<OrdemServico> ordensServico;
    private PriorizacaoStrategy estrategiaPriorizacao;

    /**
     * Construtor que inicializa o sistema
     */
    public SistemaOSFacade() {
        this.db = DatabaseConnection.getInstance();
        this.clientes = new ArrayList<>();
        this.ordensServico = new ArrayList<>();
        this.estrategiaPriorizacao = new PriorizacaoPadrao();
        this.db.connect();
    }

    /**
     * Cadastra um novo cliente no sistema
     */
    public void cadastrarCliente(String id, String nome, String telefone,
                                 String email, String endereco) {
        // Validação básica
        if (id == null || nome == null || telefone == null) {
            throw new IllegalArgumentException("Dados obrigatórios não informados");
        }

        // Verifica se já existe cliente com o mesmo ID
        if (buscarCliente(id) != null) {
            throw new IllegalArgumentException("Cliente já cadastrado com este ID");
        }

        Cliente cliente = new Cliente(id, nome, telefone, email, endereco);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + nome);
    }

    /**
     * Cria uma nova ordem de serviço
     */
    public void criarOrdemServico(String numero, String clienteId,
                                  String descricao, double valor, String prioridade) {
        // Validação básica
        if (numero == null || clienteId == null || descricao == null) {
            throw new IllegalArgumentException("Dados obrigatórios não informados");
        }

        Cliente cliente = buscarCliente(clienteId);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        OrdemServico os = new OrdemServico(numero, cliente, descricao, valor, prioridade);
        ordensServico.add(os);
        System.out.println("Ordem de serviço criada com sucesso: " + numero);
    }

    /**
     * Define a estratégia de priorização a ser utilizada
     */
    public void setEstrategiaPriorizacao(PriorizacaoStrategy estrategia) {
        this.estrategiaPriorizacao = estrategia;
    }

    /**
     * Lista todas as ordens de serviço ordenadas pela prioridade atual
     */
    public List<OrdemServico> listarOrdensServicoPriorizadas() {
        List<OrdemServico> ordenadas = new ArrayList<>(ordensServico);
        ordenadas.sort((os1, os2) ->
                estrategiaPriorizacao.calcularPrioridade(os2) -
                        estrategiaPriorizacao.calcularPrioridade(os1));
        return ordenadas;
    }

    /**
     * Busca um cliente pelo ID
     */
    private Cliente buscarCliente(String id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Atualiza o status de uma ordem de serviço
     */
    public void atualizarStatusOS(String numero, String novoStatus) {
        OrdemServico os = ordensServico.stream()
                .filter(o -> o.getNumero().equals(numero))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ordem de serviço não encontrada"));

        os.setStatus(novoStatus);
        System.out.println("Status atualizado com sucesso: " + numero + " -> " + novoStatus);
    }

    /**
     * Fecha a conexão com o banco de dados
     */
    public void finalizar() {
        db.disconnect();
    }
}