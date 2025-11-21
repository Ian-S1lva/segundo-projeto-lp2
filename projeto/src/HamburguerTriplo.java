import java.util.ArrayList;
import java.util.Collections;

public class HamburguerTriplo extends Hamburguer{
    HamburguerTriplo(){
        super();
        setPreco(25.00);
        setIngredientes(1); //qualquer valor
        setNome("Hamburguer Triplo\n");
    }

    @Override
    public void setIngredientes(int i){ //descarta i      
        Collections.addAll(ingredientes, Ingredientes.values());
    }

}