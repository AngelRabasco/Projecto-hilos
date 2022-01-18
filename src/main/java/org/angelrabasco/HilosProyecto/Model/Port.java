package org.angelrabasco.HilosProyecto.Model;

public class Port {
	private Integer cargo;

	public Port(Integer cargo) {
		this.cargo = cargo;
	}

	public Port() {
		this(Integer.MIN_VALUE);
	}

	public Integer getCargo() {
		return cargo;
	}
	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}

	public synchronized void cargarAvion(Airplane plane) {
		/*
		 * Si el cargo no es 0 actualiza el cargo del avión, los muestra por terminal y
		 * se espera 400ms, si el cargo es 0 lo muestra por terminal y se espera a que
		 * este vuelva a incrementar. Una vez alcanzada la carga máxima de un avión se
		 * sale del bucle y lo muestra por terminal.
		 */
		try {
			for (Integer i = 1; i <= plane.getMaxCargo(); i++) {
				if (cargo != 0) {
					plane.setCargo(i);
					System.out.println("El avión " + plane.getPlaneNum() + " carga, tiene una carga de " + plane.getCargo()
							+ "/" + plane.getMaxCargo());
					cargo--;
					wait(400);
				} else {
					System.out.println("El avión " + plane.getPlaneNum() + " espera a la llegada de más cargo");
					i--;
					wait();
				}
			}
			System.out.println("El avión " + plane.getPlaneNum() + " se marcha con una carga de " + plane.getCargo());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void descargarAvion(Airplane plane) {
		/*
		 * Añade el cargo del avión al cargo del puerto y notifica para que los aviones
		 * consumidores puedan continuar
		 */
		System.out.println("Desposita " + plane.getCargo());
		cargo += plane.getCargo();
		notifyAll();
	}

}
