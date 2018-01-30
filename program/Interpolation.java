import java.util.List;

public class Interpolation {

    // interpolacja Lagrange'a
    public static double countLagrange(double x, List<Entry> args) {
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
}
