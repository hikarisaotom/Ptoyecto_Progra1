
package proyecto_final_ingrid_claudia;

public class Transaaciones {

    double Total;
    String Pelicula;
    String Sala;
    String Horario;
    String Boleto;
    int Personas;
    double Descuento;
    double Porcentaje = 0;

    public Transaaciones() {
        Personas = 1;
    }

    public double getTotal() {
        return Total;
    }

    public String getPelicula() {
        return Pelicula;
    }

    public String getSala() {
        return Sala;
    }

    public String getHorario() {
        return Horario;
    }

    public String getBoleto() {
        return Boleto;
    }

    public int getPersonas() {
        return Personas;
    }

    public double getDescuento() {
        return Descuento;
    }

    public double getPorcentaje() {
        return Porcentaje;
    }

    public int Precio(String Tipo) {
        Pelicula = Tipo;
        int Precio = 0;
        switch (Tipo) {
            case "IT":
                Precio = 50;
                break;
            case "Anabelle":
                Precio = 90;
                break;
            case "Luz de Luna":
                Precio = 30;
                break;
        }

        return Precio;
    }

    public double Sala(String Tipo) {
        Sala = Tipo;
        double Precio = 0;
        switch (Tipo) {
            case "Normal":
                Precio = 10.50;
                break;
            case "3D":
                Precio = 50.50;
                break;
            case "XD":
                Precio = 60.75;
                break;
            case "2D":
                Precio = 15.35;
                break;
        }
        return Precio;
    }

    public int Boleto(String Tipo) {
        Boleto = Tipo;
        int Precio = 0;
        switch (Tipo) {
            case "Normal":
                Precio = 20;
                break;
            case "VIP":
                Precio = 30;
                break;
        }
        return Precio;
    }

    public double Horario(String Tipo) {
        Horario = Tipo;
        double Precio = 0;

        switch (Tipo) {
            case "8:00 AM":
                Precio = 10;
                break;
            case "1:00PM":
                Precio = 15;
                break;
            case "9:00PM":
                Precio = 20;
                break;
        }
        return Precio;
    }

    public double Total(double[] Valores, int Num, int usuario) {
        double Tot = 0;
        for (int i = 0; i < Valores.length; i++) {
            Tot += Valores[i];
        }
        Total = Tot * Num;
        Personas = Num;
        Total = Total - descuento(Total, usuario);
        return Total;
    }

    //Primer Metodo SobreCragado.
    public double descuento(double Descuento, int usuario) {
        this.Descuento = (Descuento * descuento(usuario));
        return this.Descuento;
    }

    //Segundo Metodo Sobrecargado
    public double descuento(int usuario) { //DETERMINA EL PORCENTAJE DE DESCUENTO
        if (usuario == 1) {
            Porcentaje = 0.15;
        } else if (usuario == 2) {
            Porcentaje = 0.30;
        } else if (usuario == 3) {
            Porcentaje = 0.45;
        }
        return Porcentaje;
    }
}//Fin de la clase.
