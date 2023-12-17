package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.entities.Mobile;

public class FileMobile {
	private static String FILE_PATH ="Mobile.bin";
	public static void writeMobile(ArrayList<Mobile> mobiles) throws IOException {
		File file = new File(FILE_PATH);
		if(!file.exists())
			file.createNewFile();
		FileOutputStream fos = new FileOutputStream(FILE_PATH);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(mobiles);
		oos.close();
	} 
	@SuppressWarnings("unchecked")
	public static ArrayList<Mobile> readMobiles(){
		ArrayList<Mobile> list = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(FILE_PATH);
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (ArrayList<Mobile>) ois.readObject();
			ois.close();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
