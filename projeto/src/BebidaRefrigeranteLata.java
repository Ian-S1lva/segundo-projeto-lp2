public class BebidaRefrigeranteLata extends BebidaRefrigerante{
    BebidaRefrigeranteLata(int i) {
        setSabor(i);        
        setNome();
        setPreco(5.00);        
    }

    @Override
    public void setNome() {
        this.nome = "Refrigerante lata "+ getSabor()+"\n";
    }

    
}
