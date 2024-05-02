package guia.veterinaria.animales;

public abstract class Carnivoro extends Animal {

    protected Carnivoro(int id, String name, int edad, double peso) {
        super(id, name, edad, peso);
    }
    
    @Override
    public void alimentarse() {
        System.out.printf("El animal %s se esta alimentando %n", name);
        System.out.println("Dando trozo de carne al animal.");
        System.out.printf("El animal comio mucho, peso inicial: %.2f Kg, actual: %.2f Kg%n", peso , peso + 1.0);
        super.peso = peso + 1.0;
    }


}
