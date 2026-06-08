
package grupo2.parcial.eda;

public class ArbolPalabras {
private Nodo raiz;

    private String[] negativas = {"realmente", "literalmente", "siempre", "cosa", "fui", "super", "súper"};
    private String[] articulos = {"el", "la", "los", "las", "un", "una", "unos", "unas"};
    private String[] monosilabos = {"a", "y", "o", "de", "en", "mi", "tu", "su", "no", "si", "se", "me"};

    public ArbolPalabras() {
        this.raiz = null;
    }
    
    public void limpiar() {
    raiz = null;
    }
    
    public boolean estaVacio() {
    return raiz == null;
    }

    public void ingresarTexto(String texto) {
        texto = texto.toLowerCase();
        texto = texto.replace(",", "");
        texto = texto.replace(".", "");
        texto = texto.replace(";", "");
        texto = texto.replace(":", "");
        texto = texto.replace("¿", "");
        texto = texto.replace("?", "");
        texto = texto.replace("¡", "");
        texto = texto.replace("!", "");

        String[] palabras = texto.split(" ");

        for (int i = 0; i < palabras.length; i++) {
            if (!palabras[i].equals("")) {
                raiz = insertar(raiz, palabras[i]);
            }
        }
    }

    private Nodo insertar(Nodo actual, String palabra) {
        if (actual == null) {
            actual = new Nodo(palabra);
        } else {
            int comparacion = palabra.compareTo(actual.getDato().getTexto());

            if (comparacion == 0) {
                actual.getDato().incrementarCantidad();
            } else if (comparacion < 0) {
                actual.setIzquierdo(insertar(actual.getIzquierdo(), palabra));
            } else {
                actual.setDerecho(insertar(actual.getDerecho(), palabra));
            }
        }

        return actual;
    }

    public int cantidadPalabrasUsadas() {
        return contarPalabras(raiz);
    }

    private int contarPalabras(Nodo actual) {
        if (actual == null) {
            return 0;
        }

        return actual.getDato().getCantidad()
                + contarPalabras(actual.getIzquierdo())
                + contarPalabras(actual.getDerecho());
    }

    public Palabra palabraMasRepetida() {
        return buscarMasRepetida(raiz, null);
    }

    private Palabra buscarMasRepetida(Nodo actual, Palabra mayor) {
        if (actual == null) {
            return mayor;
        }

        mayor = buscarMasRepetida(actual.getIzquierdo(), mayor);

        String texto = actual.getDato().getTexto();

        if (!esArticulo(texto) && !esMonosilabo(texto)) {
            if (mayor == null || actual.getDato().getCantidad() > mayor.getCantidad()) {
                mayor = actual.getDato();
            }
        }

        mayor = buscarMasRepetida(actual.getDerecho(), mayor);

        return mayor;
    }

    public int contarNegativas() {
        return contarNegativas(raiz);
    }

    private int contarNegativas(Nodo actual) {
        if (actual == null) {
            return 0;
        }

        int total = 0;

        if (esNegativa(actual.getDato().getTexto())) {
            total = actual.getDato().getCantidad();
        }

        return total + contarNegativas(actual.getIzquierdo()) + contarNegativas(actual.getDerecho());
    }

    private boolean esNegativa(String palabra) {
        for (int i = 0; i < negativas.length; i++) {
            if (palabra.equals(negativas[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean esArticulo(String palabra) {
        for (int i = 0; i < articulos.length; i++) {
            if (palabra.equals(articulos[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean esMonosilabo(String palabra) {
        for (int i = 0; i < monosilabos.length; i++) {
            if (palabra.equals(monosilabos[i])) {
                return true;
            }
        }
        return palabra.length() <= 2;
    }

    public void mostrarPalabras() {
        mostrarInOrden(raiz);
    }

    private void mostrarInOrden(Nodo actual) {
        if (actual != null) {
            mostrarInOrden(actual.getIzquierdo());
            System.out.println(actual.getDato());
            mostrarInOrden(actual.getDerecho());
        }
    }
}
