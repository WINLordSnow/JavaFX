import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

public class FXMLController implements Initializable{
    @FXML
    private TableView<Contract> table;
    @FXML
    private TableColumn<Contract, String> contractsColumn;
    @FXML
    private TableColumn<Contract, Boolean> actualColumn;

    public FXMLController() {}

    public void initialize(URL url, ResourceBundle rb) {
        contractsColumn.setCellValueFactory(cellData -> cellData.getValue().toStringProperty());
        contractsColumn.getStyleClass().add("custom-align");

        actualColumn.setCellValueFactory(cellData -> cellData.getValue().isActual());
        actualColumn.setCellFactory(CheckBoxTableCell.forTableColumn(actualColumn));
        actualColumn.getStyleClass().add("custom-align");
    }

    /**
     * Setting data for load.
     */
    public void setDataForLoad() {
       table.setItems(new JavaFX().getContracts());
    }
}