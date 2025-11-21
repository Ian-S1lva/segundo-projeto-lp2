import java.util.ArrayList;
import java.util.Collections;

public abstract class Hamburguer implements Produtos{

    protected ArrayList <Ingredientes> ingredientes;
    protected double preco; //nao é static
    protected String nome;

    public Hamburguer(){
        ingredientes = new ArrayList<>();
    }

    //abstrato
    public abstract void setIngredientes(int i);

    //metodos comuns
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public String getNome() {
        return this.nome;
    }

    public void remove(Ingredientes ingrediente){
        this.ingredientes.remove(ingrediente);
    }
    public void addIngrediente(Ingredientes ingredientes){
        this.ingredientes.add(ingredientes);
    }

    //interface
    @Override
    public void imprime() {
        exibirNome();
        for(Ingredientes ingredientes1 : ingredientes){
            System.out.print(ingredientes1+"\n");
        }
        System.out.print("Preço: "+getPreco()+"\n");
    }

    @Override
    public void exibirNome() {
        System.out.print(getNome());
    }

    @Override
    public double getPreco() {
        return this.preco;
    }


}