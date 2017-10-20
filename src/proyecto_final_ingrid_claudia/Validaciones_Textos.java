package proyecto_final_ingrid_claudia;

public class Validaciones_Textos {
    //Declaracion de valores del objeto.

    String nombre;
    String Contra;
    String Tipo;
    String Usuario;
    String Contra_Maestra;

    public Validaciones_Textos() {
        nombre = "Claudia";
        Usuario = "Claudia97";
        Contra = "123456";
        Tipo = "Visitante";
        Contra_Maestra = "Ingrid";
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getContra() {
        return Contra;
    }

    public String getContraMaestra() {
        return Contra_Maestra;
    }

    public void SetTipo(String usuario) {
        Tipo = usuario;
    }

    public void SetMaes(String usuario) {
        Contra_Maestra = usuario;
        //System.out.println("CAMBIO CLAVE MAESTRA");
    }

    public void SetNombre(String usuario) {
        nombre = usuario;
    }

    public static boolean Anular() {
        Boolean Bandera = false;

        return Bandera;
    }

}
