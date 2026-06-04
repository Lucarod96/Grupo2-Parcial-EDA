/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo2.parcial.eda;

/**
 *
 * @author Usuario
 */
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
