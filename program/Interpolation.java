import java.util.List;

public class Interpolation {

    static int sectionLength = 4;

    // interpolacja Lagrange'a
    public static double countLagrange(double x, EntryManager db) {
        List<Entry> args = db.getEntries();
        double w = 0.0;
        for (int i = 0; i < args.size(); i++) {
            double y = args.get(i).getHeight();
            for (int j = 0; j < args.size(); j++) {
                if (j == i) continue;
                y *= ((x - args.get(j).getDistance())
                    /(args.get(i).getDistance() - args.get(j).getDistance()));
            }
            w += y;
        }
        return w;
    }

    // interpolacja splajnami 3-ciego stopnia
    // TODO
    public static double countSplines(double x, EntryManager db) {
        int count = db.getCount();
        int sectionMin = sectionLength * (int)(Math.floor(x/sectionLength));
        int sectionMax = sectionLength * (int)(Math.floor(x/sectionLength) + 1);
        EntryManager section = db.getEntriesSubset(sectionMin, sectionMax);
        return countLagrange(x, section);
    }
}
