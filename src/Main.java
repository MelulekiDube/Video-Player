/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javax.swing.JFileChooser;

/**
 *
 * @author Meluleki
 */
public class Main extends Application {

    Player player;
    JFileChooser fc;

    /**
     * Set the state and show the videos
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
	MenuItem open = new MenuItem("Open");
	Menu file_menu = new Menu("File");
	MenuBar menu = new MenuBar();
	fc = new JFileChooser();
	int returnVal = fc.showOpenDialog(null);
	File f = null;
	if (returnVal == JFileChooser.APPROVE_OPTION) {
	    f = fc.getSelectedFile();
	}
	file_menu.getItems().add(open);
	menu.getMenus().add(file_menu);
	player = new Player(f.toURI().toString());
	player.setTop(menu);
	Scene scene = new Scene(player, 720, 535, Color.BLACK);
	File files = new File(player.media.getSource());
	primaryStage.setTitle(files.getName());
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	launch(args);
    }
}
