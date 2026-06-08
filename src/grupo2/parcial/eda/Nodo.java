
package grupo2.parcial.eda;

public class Nodo {
    private Palabra dato;
    private Nodo izquierdo;
    private Nodo derecho;

    public Nodo(String palabra) {
        this.dato = new Palabra(palabra);
        this.izquierdo = null;
        this.derecho = null;
    }

    public Palabra getDato() {
        return dato;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
}
