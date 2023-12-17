package files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.entities.Tour;


public class FileTour {
	 public static void outputList(List<Tour> list) throws IOException {
		 	File file = new File("Tour.bin");
			if(!file.exists())
				file.createNewFile();
			FileOutputStream outFile = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeInt(list.size());
			for (Tour tour : list) {
				out.writeObject(tour);
			}
			out.close();
	}
	 
	public static List<Tour> inputList() throws IOException, ClassNotFoundException {
		FileInputStream inputFile = new FileInputStream("Tour.bin");
		ObjectInputStream in = new ObjectInputStream(inputFile);

		int n = in.readInt();
		List<Tour> list = new ArrayList<>();
		for(int i = 0 ; i < n; i++) {
			list.add((Tour)in.readObject());
		}
		in.close();
		return list;
	}
	
	public static List<Tour> InOutFile(List<Tour> list) throws IOException, ClassNotFoundException {
		outputList(list);
		list = inputList();
		return list;
	}

}
