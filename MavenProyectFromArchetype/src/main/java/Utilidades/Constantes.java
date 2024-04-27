package Utilidades;

public class Constantes {
	
	public static final String NOMBRE_APLICACION = "Singletune";

	// "com.jtattoo.plaf.texture.TextureLookAndFeel"
	public static final String ESTILO_POR_DEFECTO = "Texture";
	public static final String[] ESTILOS = {"Texture", "HiFi", "Acryl", "Aero", "Mint", "Bernstein", "Fast", "Graphite", "Luna", "McWin", "Noire", "Smart", "Devil"};
	public static final String[] ESTILOS_OSCUROS = {"Hifi", "Noire", "Devil"};
	public static final String[] ESTILOS_CLAROS = {"Texture", "Acryl", "Aero", "Mint", "Bernstein", "Fast", "Graphite", "Luna", "McWin", "Smart"};

	public static final int OKAY = 0;
	public static final int ERROR_REGISTRO_CAMPOS = 1;
	public static final int ERROR_REGISTRO_CORREO = 2;
	public static final int ERROR_REGISTRO_FECHA = 3;
	
	public static final String ERROR_INICIO_SESION_MENSAJE = "Los parámetros no son correctos";
	public static final String ERROR_REGISTRO_CAMPOS_MENSAJE = "Hay campos por rellenar o alguno contiene valores invalidos";
	public static final String ERROR_REGISTRO_CORREO_MENSAJE = "El correo ya está asociado a un usuario";
	public static final String ERROR_REGISTRO_FECHA_MENSAJE = "La fecha de nacimiento es incorrecta";
	public static final String ERROR_BUSQUEDA_TITULO_MENSAJE = "Se debe añadir un título para crear una playlist";
	public static final String ERROR_TABLA_VACIA_MENSAJE = "Ha ocurrido algún problema rellenando la tabla";
	public static final String ERROR_LISTA_VACIA_MENSAJE = "Ha ocurrido algún problema rellenando la lista";
	public static final String ERROR_CREAR_PDF_MENSAJE = "Ha ocurrido algún problema al crear el PDF";
	public static final String ERROR_TITULO_VACIO_MENSAJE = "El campo \"titulo\" está vacio";
	public static final String ERROR_ELIMINAR_PLAYLIST_MENSAJE = "Ha ocurrido algún problema al eliminar la playlist";
	public static final String ERROR_CREAR_PLAYLIST_MENSAJE = "Ha ocurrido algún problema al crear la playlist";
	public static final String ERROR_ACTUALIZAR_PLAYLIST_MENSAJE = "Ha ocurrido algún problema actualizando la playlist";
	public static final String ERROR_PLAY_URL_MENSAJE = "No se ha reconocido la url";
	public static final String ERROR_STOP_URL_MENSAJE = "Ha ocurrido algún problema mientras se detenia la canción";
	
	public static final String EXITO_CREAR_PDF_MENSAJE = "El PDF ha sido creado exitosamente";
	public static final String EXITO_ELIMINAR_PLAYLIST_MENSAJE = "La playlist ha sido eliminada exitosamente";
	public static final String EXITO_CREAR_PLAYLIST_MENSAJE = "La playlist ha sido creada exitosamente";
	public static final String EXITO_ACTUALIZAR_PLAYLIST_MENSAJE = "La playlist ha sido actualizada exitosamente";
}
