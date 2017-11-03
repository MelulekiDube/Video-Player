/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MediaPlayer;

import java.awt.Color;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Meluleki
 */
public class MediaPlayer extends Application {
    
    /**
     * Set the state and show the videos
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        Player player= new PLayer("file:///C:/<videoname>");
        Scene scene= new Scene(player, 720,450, Color.BLACK);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
