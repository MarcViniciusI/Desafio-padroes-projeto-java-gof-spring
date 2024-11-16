package Singleton;
/**
 * Classe de conexão com o banco de dados utilizando padrão Singleton
 * Garante que existe apenas uma instância de conexão em toda a aplicação
 */
public class DatabaseConnection {
    // Instância única da classe
    private static DatabaseConnection instance;

    // Construtor privado para evitar instanciação direta
    private DatabaseConnection() {}

    //Método para obter a instância única da conexão @return Instância única de DatabaseConnection

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }


     //Realiza a conexão com o banco de dados

    public void connect() {
        // Implementar lógica real de conexão com o banco de dados
        System.out.println("Conexão com o banco de dados estabelecida");
    }


        //Fecha a conexão com o banco de dados

    public void disconnect() {
        // Implementar lógica real de desconexão
        System.out.println("Conexão com o banco de dados encerrada");
    }
}
