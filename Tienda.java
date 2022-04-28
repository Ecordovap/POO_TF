package PC1;
import java.util.ArrayList;

public class Tienda {
    ArrayList<Bicicletas> bicicletas;

    public Tienda() {
        bicicletas = new ArrayList<Bicicletas>();
    }
    public void agregarBicicleta(Bicicletas bicicleta) {
        bicicletas.add(bicicleta);
    }

}
