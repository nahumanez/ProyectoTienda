package utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;

public class ArchivadorGeneric<T> {
	
	private File archivo;
	
	public ArchivadorGeneric(String ruta) {
		super();
		this.archivo = new File(ruta);
	}
	public boolean existe() {
		return archivo.exists();
		
		
	}


	
	public T leer() {
		
		T objetoLeido = null;
		
		try {
		FileInputStream fis = new FileInputStream(archivo);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		objetoLeido = (T) ois.readObject();

		ois.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return objetoLeido;
	}
	
	public void guardar(T o) {
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
