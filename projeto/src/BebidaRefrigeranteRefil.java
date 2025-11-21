public class BebidaRefrigeranteRefil extends BebidaRefrigerante {
    private static double preco;
    private RefriSabores sabor;
    private String nome;

    BebidaRefrigeranteRefil(int i) {
        setSabor(i);        
        setNome();
        setPreco(7.00);        
    }

    @Override
    public void setNome() {
        this.nome = "Refrigerante refil "+getSabor()+"\n";
    }

}
