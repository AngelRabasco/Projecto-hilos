module org.angelrabasco.HilosProyecto {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;

	opens org.angelrabasco.HilosProyecto to javafx.fxml;

	exports org.angelrabasco.HilosProyecto;
}
