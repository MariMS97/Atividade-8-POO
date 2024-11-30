import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDB {
    private final Connection connection;

    public ProdutoDB(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir produto
    public void inserirProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (tipo, descricao, peso, quantidade, unidade_medida) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPeso());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setString(5, produto.getUnidadeMedida());
            stmt.executeUpdate();
        }
    }
    /*Método para alterar produto*/
    public void alterarProduto(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET tipo = ?, descricao = ?, peso = ?, quantidade = ?, unidade_medida = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getTipo());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPeso());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setString(5, produto.getUnidadeMedida());
            stmt.setInt(6, produto.getId()); // O ID é usado para localizar o produto no banco
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto alterado com sucesso!");
            } else {
                System.out.println("Nenhum produto foi encontrado para alterar.");
            }
        }
    }
    //Método para excluir produto
    public void excluirProduto(int id) throws SQLException {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id); // O ID do produto a ser excluído
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("Nenhum produto foi encontrado para excluir.");
            }
        }
    }



    // Método para listar todos os produtos
    public List<Produto> listarProdutos() throws SQLException {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getDouble("peso"),
                        rs.getInt("quantidade"),
                        rs.getString("unidade_medida")
                );
                produto.setId(rs.getInt("id"));
                produtos.add(produto);
            }
        }
        return produtos;
    }
}
