package mx.edu.j2se.resendiz.tasks;

public class Persona {
    //Atributos
    String nombre;
    int edad;
    String genero;
    float altura;
    String nacionalidad;

    //Constructor

    //Métodos

    /**
     * @return String
     */
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getGenero(){
        return this.genero;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getNacionalidad(){
        return this.nombre;
    }

    public void setNacionalidad(String nacionalidad){
        this.nacionalidad = nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String esMayorDeEdad(){
        if (this.edad >= 18){
            return "Bienvanido";
        }else{
            return "Sigue participando";
        }

    }
}
