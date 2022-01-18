package org.angelrabasco.HilosProyecto.Model;

public class Airplane implements Runnable {

	private Integer planeNum;
	private Integer cargo;
	private Integer maxCargo;
	private Integer type; // 0 = Consumidor 1 = Productor 2 = LoadPlanes
	private Port port;

	public Airplane(Integer planeNum, Integer cargo, Integer maxCargo, Integer type, Port port) {
		this.planeNum = planeNum;
		this.cargo = cargo;
		this.maxCargo = maxCargo;
		this.type = type;
		this.port = port;
	}

	public Airplane() {
		this(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, new Port(Integer.MIN_VALUE));
	}

	public Integer getPlaneNum() {
		return planeNum;
	}
	public void setPlaneNum(Integer planeNum) {
		this.planeNum = planeNum;
	}

	public Integer getCargo() {
		return cargo;
	}
	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}

	public Integer getMaxCargo() {
		return maxCargo;
	}
	public void setMaxCargo(Integer maxCargo) {
		this.maxCargo = maxCargo;
	}

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

	public Port getPort() {
		return port;
	}
	public void setPort(Port port) {
		this.port = port;
	}

	@Override
	public void run() {
		/*
		 * Primero comprueba el tipo, si es 0 ejecutará el código que ejecutan los
		 * aviones tipo consumidor, si es 1 este será un productor y en caso de 2
		 * ejecutará el código que ejecuta en la ventana de carga
		 */
		switch (type) {
		case 0:
			/*
			 * El avión es un consumidor, por lo que se esperará a que el avión productor
			 * llegue con nuevo cargo y entonce empezará a consumir hasta que se acabe el
			 * cargo. Esta sucesión se repetirá hasta que la carga máxima del avión sea
			 * igual al cargo que este porta, y entonces partirá hasta volver 5000ms mas
			 * tarde para empezar a carga otra vez
			 */
			do {
				try {
					port.cargarAvion(this);
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} while (true);
		case 1:
			/*
			 * El avión es un productor por lo que viene cada 2250ms con nuevo cargo para
			 * que los aviones consumidores puedan cargarse
			 */
			while (true) {
				try {
					Thread.sleep(2250);
					port.descargarAvion(this);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		case 2:
			/*
			 * El avión disminuye el cargo del puerto, aumenta su carga y lo muestra hasta
			 * repetidamente hasta que el cargo alcance la carga máxima del avión
			 */

			for (int i = 0; i < this.maxCargo; i++) {
				try {
					this.port.setCargo(port.getCargo() - 1);
					cargo++;
					System.out.println(planeNum + ": " + cargo + "(" + this.port.getCargo() + ")");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			break;
		}

	}

}
