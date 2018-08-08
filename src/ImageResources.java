
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Meluleki
 */
public final class ImageResources {

    private FileInputStream pauseFile, playFile, fsFile, ufsFile;
    private final Image pauseicon,playicon, fsicon, ufsicon;
    public ImageView play,pause,fs, ufs;
    public ImageResources() {
        //initialising the file input streams
        try {
            playFile = new FileInputStream(new File("./Assets/Play.png"));
            pauseFile=new FileInputStream(new File("./Assets/Pause.png"));
            fsFile= new FileInputStream(new File("./Assets/Fullscreen.png"));
            ufsFile= new FileInputStream(new File("./Assets/Compress.png"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MediaBar.class.getName()).log(Level.SEVERE, null, ex);
        }
        //initialising the image files
        playicon = new Image(playFile);
        pauseicon = new Image(pauseFile);
        fsicon=new Image(fsFile);
        ufsicon= new Image(ufsFile);
        //initialising the image viewers
        play=new ImageView(playicon);
        pause=new ImageView(pauseicon);
        fs=new ImageView(fsicon);
        ufs=new ImageView(ufsicon);
    }
}
