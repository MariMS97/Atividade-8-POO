public class Produto {
    private int id;
    private String tipo;
    private String descricao;
    private double peso;
    private int quantidade;
    private String unidadeMedida;


    // Construtor completo
    public Produto(String tipo, String descricao, double peso, int quantidade, String unidadeMedida) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.peso = peso;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }



        @Override
        public String toString () {
            return String.format("Produto{id=%d, tipo='%s', descricao='%s', peso=%.2f, quantidade=%d, unidadeMedida='%s'}",
                    id, tipo, descricao, peso, quantidade, unidadeMedida);
        }


}
