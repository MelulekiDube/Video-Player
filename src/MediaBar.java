
import java.io.FileInputStream;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Meluleki
 */
public class MediaBar extends HBox {

    private static final ImageResources IR = new ImageResources();
    FileInputStream pause;
    Slider time = new Slider(), vol = new Slider();
    Label volume = new Label("Volume");
    MediaPlayer player;
    Button playButton = new Button("", IR.pause);
    Button fullscreen = new Button("", IR.fs);
    Stage currentStage;

    public MediaBar(MediaPlayer play, Stage cs) {
        this.currentStage = cs;
        player = play;
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5, 10, 5, 10));
        setStyle("-fx-background-color: #bfc2c7");

        //set prefecences for the components
        vol.setPrefWidth(70);
        vol.setMinWidth(30);
        vol.setValue(100);
        vol.setMax(250);
        HBox.setHgrow(time, Priority.ALWAYS);
        playButton.setPrefWidth(30);
        getChildren().add(playButton);
        getChildren().add(time);
        getChildren().add(volume);
        getChildren().add(vol);
        getChildren().add(fullscreen);

        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Status status = player.getStatus();

                if (status == Status.PLAYING) {
                    if (player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())) {
                        player.seek(player.getStartTime());
                        player.play();
                    } else {
                        player.pause();
                        playButton.setGraphic(IR.play);
                    }
                }
                if (status == Status.PAUSED || status == Status.HALTED || status == Status.STOPPED) {
                    player.play();
                    playButton.setGraphic(IR.pause);
                }
            }
        });
        player.currentTimeProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable ov) {
                updateValues();
            }
        });
        time.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (time.isPressed()) {
                    player.seek(player.getMedia().getDuration().multiply(time.getValue() / 100));
                }
            }
        });
        vol.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (vol.isPressed()) {
                    player.setVolume(vol.getValue() / 100);
                }
            }
        });

        fullscreen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!currentStage.isFullScreen()) {
                    fullscreen.setGraphic(IR.ufs);
                    currentStage.setFullScreen(true);
                    currentStage.setScene(new Scene(currentStage.getScene().getRoot(),  currentStage.getWidth(),currentStage.getHeight()));
                }else{
                    currentStage.setFullScreen(false);
                }
            }
        });
    }

    protected void updateValues() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                time.setValue(player.getCurrentTime().toMillis() / player.getTotalDuration().toMillis() * 100);
            }
        });
    }
}
