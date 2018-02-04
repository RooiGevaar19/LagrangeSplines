import java.util.List;

public class Interpolation {

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
    public static double countSplines(double x, EntryManager db) {
    	int n = db.getCount();

        List<Entry> data = db.getEntries();
        // znajdź przedział, w którym znajduje się argument x - chyba że x jest węzłem, to zwróć argument y
        for (int j = 0; j < n-1; j++) {
        	if (data.get(j).getDistance() == x) {
        		return data.get(j).getHeight();
        	} else if ((data.get(j).getDistance() < x)&&(data.get(j+1).getDistance() > x)) {
        		double xj = data.get(j).getDistance();
                double xj1 = data.get(j+1).getDistance();
                double yj = data.get(j).getHeight();
                double yj1 = data.get(j+1).getHeight();


                double h = xj1 - xj;
                double Mj = 0.0;
                double Mj1 = 0.0;


                // wspolczynniki Mj, Mj+1 wyliczyć metodą CSI

                double[][] M = new double[n][n+1];
                // zeruj macierz
                for (int row = 0; row < n; row++) {
                	for (int col = 0; col < n+1; col++) {
                		M[row][col] = 0.0;
                	}
                }

                // wypełnij współczynnikami
                M[0][0] = 2.0;
                M[0][1] = 0.0;
                M[0][n] = 0.0;
                for (int row = 1; row < n-1; row++) {
                	double h_j = data.get(row).getDistance() - data.get(row-1).getDistance();
                	double h_j1 = data.get(row+1).getDistance() - data.get(row).getDistance();
                	double y_j = data.get(row).getHeight();
                	double y_j1 = data.get(row+1).getHeight();
                	double y_j_ = data.get(row-1).getHeight();

                	M[row][row-1] = h_j / (h_j + h_j1);
                    M[row][row] = 2.0;
                    M[row][row+1] = h_j1 / (h_j + h_j1);
                    M[row][n] = 6/(h_j + h_j1) *
                    		(((y_j1 - y_j)/(h_j1)) - ((y_j - y_j_)/(h_j)));

                }
                M[n-1][n-2] = 0.0;
                M[n-1][n-1] = 2.0;
                M[n-1][n] = 0.0;

                GaussSeidel g = new GaussSeidel(M);
                g.solve();

                M = g.getMatrix();
                Mj = M[j][n];
                Mj1 = M[j+1][n];


                // druga pochodna
                //double S2 = Mj * ((xj1 - x)/h) + Mj1 * ((x - xj)/h);


                // wartość funkcji
                double S = Mj * ((Math.pow((xj1 - x), 3))/(6*h))
                		+ Mj1 * ((Math.pow((x - xj), 3))/(6*h))
                		+ (((yj1-yj)/h) - ((h*(Mj1 - Mj))/6)) * (x - xj)
                		+ yj - Mj * ((h*h)/6);
            	return S;
        	}
        }
        return 0.0;
    }
}
