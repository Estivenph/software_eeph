import java.io.File;
import javax.swing.JOptionPane;
import javax.sound.sampled.*;

public class Musica extends Thread{
	
    public void run(){
		
		try
		{
			
			File archivo = new File("Musica\\Feliz_Cumpleaños_Ferxxo.wav");
			AudioInputStream cancion = AudioSystem.getAudioInputStream(archivo); 
			Clip clip = AudioSystem.getClip();
			clip.open(cancion);
		
			clip.start();
		}
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error en ejecucion");
        }
    }
}