package address;


import address.MainApp;

public class TestApp extends MainApp {
    public TestApp(){
        super();
    }

    @Override
    protected void setupComponents(){
        super.setupComponents();
        appTitle = "TestApp";
    }

    public static void main(String[] args) {
        launch(args);
    }
}