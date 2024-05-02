
package guia.veterinaria;

import guia.veterinaria.animales.Animal;
import guia.veterinaria.animales.Gato;
import guia.veterinaria.animales.Perro;

public class App {

    public static void main(String[] args) {
       Animal pedro = new Perro(1, "Pedro", 3, 14.0);
       pedro.alimentarse();
       pedro.saludar();
       pedro.baniarse();
       System.out.println("=".repeat(50));
       Animal naranjoso = new Gato(2, "Naranjoso", 1, 4.0);
       naranjoso.alimentarse();
       naranjoso.saludar();
       naranjoso.baniarse();
       System.out.println("=".repeat(50));
       Animal lola = new Perro(3, "Lola", 3, 120.0);
       lola.alimentarse();
       lola.saludar();
       lola.baniarse();

    }
}
