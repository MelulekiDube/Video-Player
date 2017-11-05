/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.*;
import javafx.stage.Stage;

/**
 *
 * @author Meluleki
 */
public class Player extends BorderPane {

    Media media;
    MediaPlayer mplayer;
    MediaView view;
    Pane mpane;
    MediaBar bar;
    Stage currentStage;

    public Player(String fileLocation, Stage cs) {
        this.currentStage=cs;
        media = new Media(fileLocation);
        mplayer = new MediaPlayer(media);
        view = new MediaView(mplayer);
        mpane = new Pane();
        mpane.getChildren().add(view);
        setCenter(mpane);
        bar = new MediaBar(mplayer,this.currentStage);
        setBottom(bar);
        mplayer.play();
    }
}
