package org.angelrabasco.HilosProyecto;

import org.angelrabasco.HilosProyecto.Model.Airplane;
import org.angelrabasco.HilosProyecto.Model.Port;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.text.Text;

public class LoadPlanesController {

	@FXML
	private Text cargoText;
	@FXML
	private Slider cargoSlider;

	@FXML
	private Text planeText;
	@FXML
	private Spinner<Integer> planeSpinner;

	@FXML
	private Button button;

	public void initialize() {
		// Establece los valores del spinner
		this.planeSpinner.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<Integer>(FXCollections.observableArrayList(1, 2, 3)));
	}

	@FXML
	private void begin() {
		/*
		 * Crea un puerto y le asigna de cargo el valor del slider y crea aviones y sus
		 * respectivos hilos dependiendo de la cantidad seleccionada en el spinner. La
		 * carga máxima de cada avión será la cantidad de cargo / la cantidad de aviones
		 * seleccionada.
		 */
		Port p1 = new Port(Double.valueOf(cargoSlider.getValue()).intValue());
		for (int i = 0; i < this.planeSpinner.getValue(); i++) {
			Airplane plane = new Airplane(i + 1, 0, Double.valueOf(cargoSlider.getValue()).intValue()/this.planeSpinner.getValue(), 2, p1);
			Thread thread = new Thread(plane);
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
