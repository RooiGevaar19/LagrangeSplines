import java.util.List;
import java.util.Scanner;
import java.util.Locale;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

public class GeneratorSplines {

	static EntryManager db = new EntryManager("base");
	// search
	static void load (String inp) {
        FileReader fr = null;
        try {
        	int i = 0;
            fr = new FileReader(inp);
            Scanner plik = new Scanner(fr);
            plik.useLocale(Locale.US);
            while (plik.hasNext()) {
				double d = plik.nextDouble();
				double h = plik.nextDouble();
            	db.getEntries().add(new Entry(i, d, h));
            	i++;
            }
            plik.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
		load(args[0]);
		System.out.println(Interpolation.countSplines(Double.parseDouble(args[1]), db));
    }
}
