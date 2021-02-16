package mx.edu.j2se.resendiz.tasks;

public class Main {
	
	public static void main(String[] args) {
	    Persona persona1 = new Persona();
	    persona1.setNombre("Raúl");
	    persona1.setEdad(24);
        String respuesta = persona1.esMayorDeEdad();
        System.out.println(persona1.getNombre() + " :" + respuesta);

        Persona persona2 = new Persona();
        persona2.setNombre("Eduardo");
        persona2.setEdad(12);
	}
}
