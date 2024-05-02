package guia.veterinaria.animales;

public class Animal {

    protected int id;
    protected String name;
    protected int edad;
    protected double peso;

    public Animal(int id, String name, int edad, double peso) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        this.peso = peso;
    }

    public void baniarse() {

        System.out.printf("Bañando a: %s%n",name);
        System.out.println(">> Enguague Listo!");
        System.out.println(">> Lavado Listo!");
        System.out.println(">> Secado Listo!");
    
    }

    public void saludar() {
        System.out.printf("- Hola! %s%n", name);
    }

    public void alimentarse() {
        System.out.printf("El animal %s se esta alimentando %n", name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

}
