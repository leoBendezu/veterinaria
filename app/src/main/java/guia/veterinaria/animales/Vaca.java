package guia.veterinaria.animales;

public class Vaca extends Herbivoro {

    public Vaca(int id, String name, int edad, double peso) {
        super(id, name, edad, peso);
    }
    
    @Override
    public void saludar() {
        System.out.printf("- Hola! %s%n", name);
        System.out.println("+ MUUUU!");
    }
}
