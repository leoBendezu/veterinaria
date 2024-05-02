package guia.veterinaria.animales;

public class Gato extends Carnivoro {

    public Gato(int id, String name, int edad, double peso) {
        super(id, name, edad, peso);
    }
    

    @Override
    public void saludar() {
        super.saludar();
        System.out.println("+ Miau miaa!");
    }
}
