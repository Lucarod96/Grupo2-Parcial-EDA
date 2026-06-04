
package grupo2.parcial.eda;


public class Palabra {

    private String texto;
    private int cantidad;

    public Palabra(String texto) {
        this.texto = texto.toLowerCase();
        this.cantidad = 1;
    }

    public String getTexto() {
        return texto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void incrementarCantidad() {
        cantidad++;
    }

    @Override
    public String toString() {
        return texto + " (" + cantidad + ")";
    }
}