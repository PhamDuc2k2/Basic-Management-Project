package files;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;

import model.entities.Car;

public class FileCar {
	public static void outputList(List<Car> list) throws IOException {
			File file = new File("Car.bin");
			if(!file.exists())	file.createNewFile();
			FileOutputStream outFile = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeInt(list.size());
			for (Car car : list) {
				out.writeObject(car);
			}

			out.close();
	}
	
	public static List<Car> inputList() throws IOException, ClassNotFoundException {
		FileInputStream inputFile = new FileInputStream("Car.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);

		int n = in.readInt();
		List<Car> list = new ArrayList<>();
		for(int i = 0 ; i < n; i++) {
			list.add((Car)in.readObject());
		}
		in.close();
		return list;
	}
	
	
	public static List<Car> InOutFile(List<Car> list) throws IOException, ClassNotFoundException {
		outputList(list);
		list = inputList();
		return list;
	}
}
