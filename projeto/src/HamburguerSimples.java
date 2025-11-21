import java.util.ArrayList;
import java.util.Collections;

public class HamburguerSimples extends Hamburguer{

    HamburguerSimples(int i){
        ingredientes = new ArrayList<>();
        setIngredientes(i);
        setPreco(21.50);
        setNome("Hamburguer Simples\n");
    }

    //classe abstrata
    @Override    
    public void setIngredientes(int i){
        for(int j = 0; j < 6; j++){
            ingredientes.add(Ingredientes.values()[j]);
        }
        if(i == 1){
            ingredientes.add(Ingredientes.FRANGO);
        } else if (i == 2){
            ingredientes.add(Ingredientes.CARNE);
        } else {
            System.out.print("erro no set de ingredientes do hamburguer");
            return;
        }

        return;
    }    
    
    

}
