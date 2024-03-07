package Utilidades;

public class Constantes {
	
	public static final String NOMBRE_APLICACION = "Singletune";

	// "com.jtattoo.plaf.texture.TextureLookAndFeel"
	public static final String ESTILO_POR_DEFECTO = "Texture";
	public static final String[] ESTILOS = {"Texture", "HiFi", "Acryl", "Aero", "Mint", "Bernstein", "Fast", "Graphite", "Luna", "McWin", "Noire", "Smart", "Devil"};
	public static final String[] ESTILOS_OSCUROS = {"Hifi", "Noire", "Devil"};
	public static final String[] ESTILOS_CLAROS = {"Texture", "Acryl", "Aero", "Mint", "Bernstein", "Fast", "Graphite", "Luna", "McWin", "Smart"};

	public static final int OKAY = -1;
	public static final int ERROR_INICIO_SESION = 0;
	public static final int ERROR_REGISTRO_CAMPOS = 1;
	public static final int ERROR_REGISTRO_CORREO = 2;
	public static final int ERROR_REGISTRO_FECHA = 3;
	
	public static final String ERROR_INICIO_SESION_MENSAJE = "Los parámetros no son correctos";
	public static final String ERROR_REGISTRO_CAMPOS_MENSAJE = "Hay campos por rellenar";
	public static final String ERROR_REGISTRO_CORREO_MENSAJE = "El correo ya está asociado a un usuario";
	public static final String ERROR_REGISTRO_FECHA_MENSAJE = "La fecha de nacimiento es incorrecta";
	public static final String ERROR_BUSQUEDA_TITULO_MENSAJE = "Se debe añadir un título para crear una playlist";
	public static final String ERROR_TABLA_VACIA_MENSAJE = "Ha ocurrido algún problema rellenando la tabla";
	public static final String ERROR_LISTA_VACIA_MENSAJE = "Ha ocurrido algún problema rellenando la lista";
	
	// JOptionPane.showMessageDialog(...);
}
