package org.angelrabasco.HilosProyecto;

import org.angelrabasco.HilosProyecto.Model.Airplane;
import org.angelrabasco.HilosProyecto.Model.Port;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;

public class LoadUnloadController {
	private Port p1 = new Port(0);
	private Airplane a1 = new Airplane(1, 0, 5, 0, p1);
	private Airplane a2 = new Airplane(2, 0, 5, 0, p1);
	private Airplane a3 = new Airplane(3, 5, 5, 1, p1);

	@FXML
	private Text planeTitle1;
	@FXML
	private Slider sliderPlane1;
	@FXML
	private Text planeCounter1;

	@FXML
	private Text planeTitle2;
	@FXML
	private Slider sliderPlane2;
	@FXML
	private Text planeCounter2;

	@FXML
	private Text planeTitle3;
	@FXML
	private Slider sliderPlane3;
	@FXML
	private Text planeCounter3;
	
	@FXML
	private Button button;

	public void initialize() {
	}

	@FXML
	private void beginOperations() {
		/*
		 * Le asigna a los aviones 1 y 2 su carga máxima y al avión tres le asignamos la
		 * cantidad de cargo que va a traer
		 */
		a1.setMaxCargo(Double.valueOf(sliderPlane1.getValue()).intValue());
		a2.setMaxCargo(Double.valueOf(sliderPlane2.getValue()).intValue());
		a3.setCargo(Double.valueOf(sliderPlane3.getValue()).intValue());

		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a2);
		Thread t3 = new Thread(a3);

		t1.start();
		t2.start();
		t3.start();
	}
}