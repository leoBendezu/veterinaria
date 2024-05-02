## Herencia

La herencia es un concepto fundamental en la programación orientada a objetos que nos permite crear nuevas clases basadas en clases existentes, aprovechando y extendiendo su funcionalidad. 

Es importante entender que la herencia es trae sus ventajas en reutilización de código, extendiendo las métodos de una clase y permitiéndonos sobrescribir esos métodos para que las clases hijas puedan completar el comportamiento pero es un mecanismo que trae también varios problemas acarreados, entre ellos:

- **Pensar mal una herencia**: hay que tener bien en claro que la herencia se piensa “Desde los comportamientos” y no desde los atributos, si tu viéramos dos clases que comparten muchos atributos en común pero hacen cosas totalmente diferentes la herencia no debería ser ni por asomo una. **(Liskov substitution principle)**
- **Viola el principio de encapsulamiento**: una clase que hereda de otra, normalmente suele tener acceso y conocimiento de sus métodos internos y campos privados,  java resuelve esto correctamente con el modificador de acceso private de todas formas es un tema a tener en el ojo siempre.
- Herencias múltiples: existe la posibilidad de que una clase herede de dos o mas clases? bueno, teóricamente si pero trae un problema. Si la clase A hereda de la clase B y C que ambas contienen el método calculoDeTotal() , que implementación de dicho método debería tener A? el de la clase B o el de la clase C?. Java no permite realizar herencias múltiples.

## **Herencia en Java: Modelando Animales en una Veterinaria**

Imaginemos que estamos desarrollando una aplicación para una veterinaria, donde necesitamos modelar las clases de perro, gato y vaca.

La veterinaria nos solicita que la aplicación permita a estos animales realizar acciones como saludar, ser bañados y alimentarse.

Vamos a analizar estos comportamientos:

- **Saludar**: Todos los animales deberían tener la capacidad de saludar de manera distinta, ya que emiten sonidos diferentes.
- **Bañarse**: El proceso de baño para los animales sigue un patrón estándar, que incluye enjuague, lavado y secado.
- **Alimentarse**: Nuestros animales se dividen en dos tipos: carnívoros y herbívoros, cada uno con una dieta diferente.

Con el análisis del negocio llegamos a la conclusión de que lo mejor seria plantear una estructura jerárquica la cual se ve modelada en el siguiente diagrama de clases:

![Untitled](https://prod-files-secure.s3.us-west-2.amazonaws.com/99e88e59-d351-463f-842d-f4980476f694/1df56a82-8ff7-4154-ad45-6705e332c6a6/Untitled.png)

Bien ahora vamos a implementar esta estructura en java:

```java
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
 
 
 // Getters y Setters   
}    

```

ya tenemos nuestra clase base con sus implementaciones base de los métodos que queremos reutilizar y sobrescribir en los.

Ahora veamos la implementación de la clase Carnívoro y Herbívoro

```java
public class Carnivoro extends Animal { // 1 

    public Carnivoro(int id, String name, int edad, double peso) { // 2
        super(id, name, edad, peso);
    }
    
    @Override // 3
    public void alimentarse() { // 4
        super.alimentarse(); // 5
        System.out.println("Dando trozo de carne al animal.");
        System.out.printf("El animal comio mucho, peso inicial: %.2f Kg, actual: %.2f Kg%n", peso , peso + 1.0);
        super.peso = peso + 1.0;
    }

}
```

```java
public class Herbivoro extends Animal {

    public Herbivoro(int id, String name, int edad, double peso) {
        super(id, name, edad, peso);
    }
    

    @Override
    public void alimentarse() {
        super.alimentarse(); 
        System.out.println("+ Gau gau!");
    }
}

```

Bien, en java para poder indicar que una clase extiende otra clase hacemos uso de la palabra reservada **extends** lo que puede verse en (1). 

Otros puntos a destacar:

1. Podemos ver que hay un constructor definido que utiliza la palabra reservada super y pasa todos los argumentos que recibe, esto se debe a que como la clase **Animal** define un constructor, las clases que la extiendan deben tener un constructor que si o si llame su constructor.
2. La anotación @Override la utilizamos para decir que estamos redefiniendo un método de la clase padre.
3. El método alimentarse, se esta sobrescribiendo de manera diferente en cada uno de los tipos, permitiéndonos realizar polimorfismo, pero vemos que las clases no redefinen ninguno de los otros dos métodos de **Animal.**
4. Podemos ver además que hacemos uso del método original al llamar a super.alimentarse() (Extendiendo su comportamiento) pero podríamos obviar esta parte y pisar por completo la implementación del padre.

Ahora veamos las implementaciones de las clases **Perro**, **Gato**, **Vaca**

```java
public class Perro extends Carnivoro {

    public Perro(int id, String name, int edad, double peso) {
        super(id, name, edad, peso);
    }

    @Override
    public void saludar() {
        super.saludar();
        System.out.println("+ Gau gau!");
    }
    
}
```

```java
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

```

```java
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

```

idem a lo que vimos anteriormente, solo que esta vez elegimos solo sobrescribir el método saludar. Algo que puede ser obvio pero aun así interesante de nombrar es el hecho de que ahora las clases finales son también animales por transitividad.

### Polimorfismo

El polimorfismo es la capacidad que tienen los objetos de responder de forma diferente al mismo mensaje, esto lo hemos estado viendo en los métodos de arriba, ahora hagamos la prueba en un main sobre como se ve esto y saquemos algunas conclusiones.

```java

public class Main {

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

```

Este código crea instancias de diferentes tipos de animales (**`Perro`**, **`Gato`** y **`Vaca`**) y las almacena en variables de tipo **`Animal`**. Aunque los objetos son instancias de clases específicas, como **`Perro`**, **`Gato`** y **`Vaca`**, se guardan en variables de tipo **`Animal`**. Esto se debe a que en Java, una variable de tipo más general, como lo es **`Animal`**, puede contener referencias a objetos de tipos más específicos, como **`Perro`**, **`Gato`** o **`Vaca`**. Este concepto se conoce como **polimorfismo**, que permite tratar objetos de diferentes clases de manera uniforme a través de su clase base padre.

El polimorfismo permite que cada objeto responda a los mensajes de acuerdo a su tipo específico. Aunque las variables son del tipo **`Animal`**, los objetos se comportan de acuerdo a su tipo real (por ejemplo, **`Perro`**, **`Gato`** o **`Vaca`**). Esto significa que cuando llamamos a métodos como **`alimentarse()`**, **`saludar()`** y **`baniarse()`**, cada objeto responderá utilizando su propia implementación específica de esos métodos, según la clase de la que son instancias.

Sin embargo, es importante tener en cuenta que si una clase específica tiene métodos propios que no están en la clase base, la variable del tipo base (**`Animal`**) no nos proporcionará acceso a esos métodos específicos. Si necesitamos acceder a esos métodos específicos en una variable de tipo base, necesitaríamos realizar una conversión de tipo, también conocida como casting. Por ejemplo:

```java
((Perro) pedro).rodar();
```

En resumen, aunque las variables son del tipo **`Animal`**, cada objeto se comporta de acuerdo a su tipo específico, gracias al polimorfismo, permitiendo un código más flexible y reutilizable. Si necesitamos acceder a métodos específicos de una clase concreta, podemos hacerlo mediante casting.

> **Nota final sobre herencia.** En Java, todas las clases, de manera directa o indirecta, extienden de la clase Object. Esto significa que, técnicamente, podríamos crear variables del tipo Object y almacenar cualquier objeto en ellas. Sin embargo, al hacerlo, perderíamos el acceso a los métodos y atributos específicos de las clases concretas, ya que la variable estaría tratando al objeto de manera genérica como un Object. En Object se definen algunos métodos clave que usan todos, por ejemplo el que borrar un objeto de memoria, o el toString que si no es redefinido muestra la ubicación en memoria del objeto.
> 

## Clases Abstractas

Las clases abstractas representan un tipo de clase que encapsula comportamiento pero no puede ser instanciada directamente. Este enfoque es útil en situaciones como la modelación de animales, donde no tendría sentido crear instancias de una clase genérica como "Animal", sino más bien de clases específicas como "Perro" o "Gato". Por ello, declaramos la clase "Animal" como abstracta, lo que automáticamente impide su instanciación.

Además, las clases abstractas tienen ciertas características distintivas. Por ejemplo, pueden definir métodos con solo su firma, pero sin implementación. Esto significa que las clases concretas que hereden de una clase abstracta están obligadas a proporcionar una implementación para dichos métodos.

Es importante destacar que, en caso de que una clase abstracta tenga constructores, estos deben ser necesariamente declarados como protected, asegurando así que solo las clases hijas puedan acceder a ellos.

## Clases Abstractas En java

Ahora veamos como convertir tanto las clases Animal como Herbívoro y Carnívoro en abstractas

```java
public abstract class Animal { // 1 

    protected int id;
    protected String name;
    protected int edad;
    protected double peso;

    protected Animal(int id, String name, int edad, double peso) {
        this.id = id;
        this.name = name;
        this.edad = edad;
        this.peso = peso;
    }

    public void baniarse() { // 2
        System.out.printf("Bañando a: %s%n",name);
        System.out.println(">> Enguague Listo!");
        System.out.println(">> Lavado Listo!");
        System.out.println(">> Secado Listo!");
    
    }

    public abstract void saludar(); // 3

    public abstract void alimentarse(); 
    
    // Getters Setters
    }
```

1. Para declarar una clase como abstracta, utilizamos la palabra reservada **abstract** seguida de la palabra **class**.
2. Es importante destacar que las clases abstractas pueden contener implementaciones de algunos métodos además de los métodos abstractos.
3. Para definir un método abstracto en una clase abstracta, también utilizamos la palabra **abstract** en la firma del método y lo dejamos sin un cuerpo.

El resto del código quedaría tal que: