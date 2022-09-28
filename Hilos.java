public class Hilos
{
	public static void main(String[] args){		
			
		Musica music = new Musica();
		Operaciones op = new Operaciones();
		music.start();
		op.start();
		
	}
}