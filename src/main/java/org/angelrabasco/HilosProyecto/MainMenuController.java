package org.angelrabasco.HilosProyecto;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {

	@FXML
	private void switchToLoad() { // Abre la ventana de carga
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("loadPlanes.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(loader.load()));
			stage.setTitle("Cargar");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void switchToLoadUnload() { // Abre la ventana de carga
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("loadUnload.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(loader.load()));
			stage.setTitle("Cargar y Descargar");
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
