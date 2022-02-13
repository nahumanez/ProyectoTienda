package utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;

public class Archivador {
	
	public boolean existe(String fuente) {
		File archivo = new File(fuente);
		return archivo.exists();
	}
	
	public Object leer(String fuente) {
		
		Object objetoLeido = null;
		
		try {
		File archivo = new File(fuente);
		FileInputStream fis = new FileInputStream(archivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		objetoLeido = ois.readObject();

		ois.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return objetoLeido;
	}
	
	public void guardar(String destino, Object o) {
		File archivo = new File(destino);
		try {
			FileOutputStream fos = new FileOutputStream(archivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(o);	
			
			oos.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
