package files;

import java.io.*;
import java.util.*;

import model.entities.CarX;

public class FileCarX {
	public static void outputList(List<CarX> list) throws IOException {
		File file = new File("CarX.bin");
		if(!file.exists())
			file.createNewFile();
			FileOutputStream outFile = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeInt(list.size());
			for (CarX car : list) {
				out.writeObject(car);
			}

			out.close();
	}
	
	public static List<CarX> inputList() throws IOException, ClassNotFoundException {
		FileInputStream inputFile = new FileInputStream("CarX.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);

		int n = in.readInt();
		List<CarX> list = new ArrayList<>();
		for(int i = 0 ; i < n; i++) {
			list.add((CarX)in.readObject());
		}
		in.close();
		return list;
	}
	
	
	public static List<CarX> InOutFile(List<CarX> list) throws IOException, ClassNotFoundException {
		outputList(list);
		list = inputList();
		return list;
	}
}
