package address.model;

import address.events.EventManager;
import address.events.NewDataEvent;
import com.google.common.eventbus.Subscribe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Created by dcsdcr on 4/5/2016.
 */
public class ModelManager {

    /**
     * The data as an observable list of Persons.
     */
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    /**
     * Constructor
     */
    public ModelManager() {
        // Add some sample data
        populateInitialData();
        EventManager.getInstance().registerHandler(this);
    }

    protected void populateInitialData() {
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public void addNewData(List<Person> newData){
        System.out.println("New data added "+ newData);
        personData.addAll(newData);
    }

    @Subscribe
    private void handleNewDataEvent(NewDataEvent nde){
        addNewData(nde.personData);
    }
}