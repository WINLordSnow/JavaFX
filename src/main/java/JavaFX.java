import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFX extends Application {

    private Stage primaryStage;
    private ObservableList<Contract> contracts = FXCollections.observableArrayList();

    public JavaFX() {
        contracts.add(new Contract(5614896, "22.12.2020", "22.12.2020"));
        contracts.add(new Contract(6845795, "22.02.2020", "22.12.2020"));
        contracts.add(new Contract(6851387, "11.10.2019", "22.12.2019"));
    }

    /**
     * Getting list of contracts.
     *
     * @return list of contracts.
     */
    public ObservableList<Contract> getContracts() {
        return contracts;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("List of contracts");

        initRootLayout();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Loading root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFX.class.getResource("scene.fxml"));
            AnchorPane rootLayout = loader.load();

            // Display the scene containing the root layout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Accessing a methods in the controller
            FXMLController controller = loader.getController();
            controller.setDataForLoad();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}