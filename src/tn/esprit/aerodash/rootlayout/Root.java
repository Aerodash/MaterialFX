package tn.esprit.aerodash.rootlayout;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.kairos.ActionBarDrawerToggle;
import org.kairos.core.Activity;
import org.kairos.layouts.DrawerLayout;
import org.kairos.layouts.RecyclerView;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import tn.esprit.aerodash.rootlayout.listadapter.Item;
import tn.esprit.aerodash.rootlayout.listadapter.MyAdapter;
import tn.esprit.aerodash.rootlayout.toolbar.ButtonBarToolbar;


public class Root extends Activity {

    @FXML
    private ButtonBarToolbar toolbar;
    @FXML
    private DrawerLayout drawer;
    @FXML
    private RecyclerView<Item> items;

    private HashMap<Item, String> listItemLayouts = new HashMap<>();
    private HashMap<Class<? extends Controller>, Controller> controllers = new HashMap<>();
    private BorderPane content;
    private Controller current;
    //private StackPane content;
    @Override
    public void onCreate() {
        super.onCreate();
        Main.root = this;
        setContentView(getClass().getResource("RootLayout.fxml"));
        
        toolbar.setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Default Title : Please set a title !");

        setActionBar(toolbar);


        drawer.setDrawerListener(new ActionBarDrawerToggle(this, drawer, toolbar));

        //content = (StackPane) drawer.getContent().lookup("#content");
        content = (BorderPane) drawer.getContent().lookup("#content");
        drawer.getNav().getStyleClass().add("drawer-nav");

        MyAdapter adapter = new MyAdapter();
        items.setAdapter(adapter);

        items.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            //content.getChildren().clear();
            try {
                //content.setAlignment(Pos.CENTER);
                Controller c = controllers.get(newValue.controller);
                //content.getChildren().add(c);
                current = c;
                content.setCenter(c);
            } catch (Exception e) {
                e.printStackTrace();
            }

            toolbar.setTitle(newValue.name);
            drawer.closeDrawer();

        });
    }

    public void addItem(Item listItem, String fxml) {
        listItemLayouts.put(listItem, fxml);

        try {
            Controller instance = listItem.controller.getConstructor(String.class).newInstance(listItemLayouts.get(listItem));
            instance.setItem(listItem);
            controllers.put(listItem.controller, instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        listItem.setParent(items);
        items.getItems().add(listItem);
    }

    public void setToolbarTitle(String title) {
        toolbar.setTitle(title);
    }

    public void addToolbarIconButton(String icon) {
        toolbar.addIconButton(icon);
    }

    public void addToolbarIconButtons(String... icons) {
        toolbar.addIconButtons(icons);
    }

    public void showScreen(Class<? extends Controller> c) {

        if (!controllers.containsKey(c)) throw new IllegalStateException("Le controller n'a pas été ajouté dans le root de la classe Main");
        Controller instance = controllers.get(c);
        content.getChildren().clear();

        //content.setAlignment(Pos.CENTER);
        content.getChildren().add(instance);

        toolbar.setTitle(instance.getItem().name);

        drawer.closeDrawer();

    }

    public Controller getCurrentScreen(){
        return current;
    }
}