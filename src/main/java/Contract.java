import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Contract {
    private final IntegerProperty           number;
    private final ObjectProperty<LocalDate> dateCreate;
    private       ObjectProperty<LocalDate> dateOfLastUpdate;

    public Contract(int number, String dateCreate, String dateOfLastUpdate) {
        this.number = new SimpleIntegerProperty(number);
        this.dateCreate = new SimpleObjectProperty<>(DateUtil.parse(dateCreate));
        this.dateOfLastUpdate = new SimpleObjectProperty<>(DateUtil.parse(dateOfLastUpdate));
    }

    /**
     * Returns true if less than 60 days
     * have passed since the last update
     * of the contract.
     *
     * @return true or false
     */
    public BooleanProperty isActual() {
        long daysNow = LocalDate.now().toEpochDay();
        long daysUpdate = dateOfLastUpdate.get().toEpochDay();
        boolean isActual = null != dateOfLastUpdate && daysNow - daysUpdate < 60;
        return new SimpleBooleanProperty(isActual);
    }

    /**
     * Contract for display.
     *
     * @return Contract for display.
     */
    public StringProperty toStringProperty() {
        return new SimpleStringProperty(
                "Contract No." +
                          number.get()+
                          " from " +
                          DateUtil.format(dateCreate.get()));
    }

    public int getNumber() {
        return number.get();
    }

    public IntegerProperty numberProperty() {
        return number;
    }

    public LocalDate getDateCreate() {
        return dateCreate.get();
    }

    public LocalDate getDateOfLastUpdate() {
        return dateOfLastUpdate.get();
    }

    public void setDateOfLastUpdate(String dateOfLastUpdate) {
         this.dateOfLastUpdate = new SimpleObjectProperty<>(DateUtil.parse(dateOfLastUpdate));
    }
}
