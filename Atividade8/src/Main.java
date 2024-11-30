import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/atividade08";
        String user = "root";
        String password = "2597";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            ProdutoDB produtoDB = new ProdutoDB(connection);

            // Inserindo produtos
            produtoDB.inserirProduto(new Produto("Limpeza", "Sabão de quadro", 2.5, 10, "kg"));
            produtoDB.inserirProduto(new Produto("Limpeza", "Desinfetante", 1.0, 20, "litro"));
            produtoDB.inserirProduto(new Produto("Limpeza", "Sabão em Pó", 1.500, 5, "kg"));
            produtoDB.inserirProduto(new Produto("Limpeza", "Veja", 1.0, 5, "litro"));
            produtoDB.inserirProduto(new Produto("Limpeza", "Amaciante", 1.5, 5, "litro"));
            // Alterando produto
            Produto produtoAlterado = new Produto("Limpeza", "Detergente", 1.0, 15, "litro");
            produtoAlterado.setId(2); // Defina o ID do produto que você deseja alterar
            produtoDB.alterarProduto(produtoAlterado);

            //Excluindo produto
            produtoDB.excluirProduto(1);

            // Listando produtos
            produtoDB.listarProdutos().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
