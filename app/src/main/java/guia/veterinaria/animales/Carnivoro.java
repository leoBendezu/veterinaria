package guia.veterinaria.animales;

public class Carnivoro extends Animal {

    public Carnivoro(int id, String name, int edad, double peso) {
        super(id, name, edad, peso);
    }
    
    @Override
    public void alimentarse() {
        super.alimentarse();
        System.out.println("Dando trozo de carne al animal.");
        System.out.printf("El animal comio mucho, peso inicial: %.2f Kg, actual: %.2f Kg%n", peso , peso + 1.0);
        super.peso = peso + 1.0;
    }

}
