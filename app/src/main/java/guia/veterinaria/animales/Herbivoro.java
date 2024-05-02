package guia.veterinaria.animales;

public abstract class Herbivoro extends Animal {

    protected Herbivoro(int id, String name, int edad, double peso) {
        super(id, name, edad, peso);
    }
    

    @Override
    public void alimentarse() {
        System.out.printf("El animal %s se esta alimentando %n", name);
        System.out.println("Dando ensalada al animal.");
    }
}
