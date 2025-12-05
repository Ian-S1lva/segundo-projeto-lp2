public abstract class BebidaRefrigerante implements Produtos {
    protected double preco;
    protected RefriSabores sabor;
    protected String nome;  

    //abstrato
    public abstract void setNome();

    //comum
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setSabor(int i) {
        this.sabor = RefriSabores.values()[i-1];
    }

    public String getNome() {
        return this.nome;
    }

    public RefriSabores getSabor() {
        return this.sabor;
    }

    //interface
    @Override
    public void imprime() {
        exibirNome();
        System.out.print("Preço: " + getPreco() + "\n");
    }

    @Override
    public void exibirNome() {
        System.out.print(getNome());
    }

    @Override
    public double getPreco() {
        return preco;
    }
}