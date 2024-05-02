package guia.veterinaria.animales;

public class Perro extends Carnivoro {

    public Perro(int id, String name, int edad, double peso) {
        super(id, name, edad, peso);
    }


    @Override
    public void saludar() {
        System.out.printf("- Hola! %s%n", name);
        System.out.println("+ Gau gau!");
    }
    
}
