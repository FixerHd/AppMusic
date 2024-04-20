package dominio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Reproductor {

	private static Reproductor instancia;
	private MediaPlayer mediaPlayer;
	private String tempPath;

	private Reproductor() {
		tempPath = System.getProperty("user.dir");
	}

	public static Reproductor getUnicaInstancia() {
		if (instancia == null) {
			instancia = new Reproductor();
		}
		return instancia;
	}

	public boolean playCancion(String url) {
		URL uri = null;
		try {
			com.sun.javafx.application.PlatformImpl.startup(() -> {
			});

			uri = new URL(url);

			System.setProperty("java.io.tmpdir", tempPath);
			Path mp3 = Files.createTempFile("now-playing", ".mp3");

			System.out.println(mp3.getFileName());
			try (InputStream stream = uri.openStream()) {
				Files.copy(stream, mp3, StandardCopyOption.REPLACE_EXISTING);
			}
			System.out.println("finished-copy: " + mp3.getFileName());

			Media media = new Media(mp3.toFile().toURI().toString());
			mediaPlayer = new MediaPlayer(media);

			mediaPlayer.play();
			return true;
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public boolean stopCancion() {
		try {
			if (mediaPlayer != null)
				mediaPlayer.stop();
			File directorio = new File(tempPath);
			String[] files = directorio.list();
			for (String archivo : files) {
				File fichero = new File(tempPath + File.separator + archivo);
				fichero.delete();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
