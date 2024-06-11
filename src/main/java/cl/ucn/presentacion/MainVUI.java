package cl.ucn.presentacion;

import cl.ucn.modelo.Estudiante;
import cl.ucn.modelo.Profesor;
import cl.ucn.modelo.Tarea;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class MainVUI extends Application {
    Profesor profesor = new Profesor();
    Tarea tarea = new Tarea("Escribir una programa en Java");

    Estudiante estudiante1 = new Estudiante("Juan");
    Estudiante estudiante2 = new Estudiante("Pedro");
    Estudiante estudiante3 = new Estudiante("Maria");
    Estudiante estudiante4 = new Estudiante("Isabel");
    Estudiante estudiante5 = new Estudiante("Matias");


    private boolean isRunning = false;

    @Override
    public void start(Stage primaryStage) {
        Button botonComenzar = new Button("Iniciar");
        Button botonParar = new Button("Parar");

        botonComenzar.setOnAction(e -> {
            comenzarEjecucion();
            botonComenzar.setDisable(true);
            botonParar.setDisable(false);
        });

        botonParar.setOnAction(e -> {
            pararEjecucion();
            botonComenzar.setDisable(false);
            botonParar.setDisable(true);
        });

        VBox raiz = new VBox(10, botonComenzar, botonParar);
        raiz.setPrefSize(200, 100);

        Scene escena = new Scene(raiz);
        primaryStage.setScene(escena);
        primaryStage.setTitle("Asignar Ejecucion");
        primaryStage.show();
    }

    private void comenzarEjecucion() {
        if (!isRunning) {
            isRunning = true;
            profesor.asignarTarea(tarea.obtenerDescripcionTarea());

            for (String nombre : List.of("Juan", "Pedro", "Maria", "Isabel", "Matias")) {
                Estudiante estudiante = new Estudiante(nombre);
                estudiante.hacerTarea(tarea);
            }
        }
    }

    private void pararEjecucion() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}