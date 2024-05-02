package guia.veterinaria.animales;

public class Herbivoro extends Animal {

    public Herbivoro(int id, String name, int edad, double peso) {
        super(id, name, edad, peso);
    }
    

    @Override
    public void alimentarse() {
        super.alimentarse();
        System.out.println("Dando ensalada al animal.");
    }
}
