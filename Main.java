import Classes.Client.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try{
            MainMenu.Start();
        }catch (UnsupportedAudioFileException e){
            System.out.println(e.toString());
        }catch (LineUnavailableException e){
            System.out.println(e.toString());
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
