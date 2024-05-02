package guia.veterinaria.animales;

public class Vaca extends Herbivoro {

    public Vaca(int id, String name, int edad, double peso) {
        super(id, name, edad, peso);
    }
    
    @Override
    public void saludar() {
        super.saludar();
        System.out.println("+ MUUUU!");
    }
}
