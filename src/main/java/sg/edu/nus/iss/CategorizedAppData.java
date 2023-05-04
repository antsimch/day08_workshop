package sg.edu.nus.iss;

import java.util.ArrayList;
import java.util.List;

public class CategorizedAppData {
    
    private List<AppData> appStats = new ArrayList<>();

    public CategorizedAppData() {
        
    }

    public String getHighestRankedApp() {
        double highestRating = 0;
        String highestRankedApp = "";

        for (int i = 0; i < appStats.size(); i++) {
            if (Integer.parseInt(appStats.get(i).getRating().trim()) > highestRating) {
                highestRating = Integer.parseInt(appStats.get(i).getRating().trim());
                highestRankedApp = appStats.get(i).getName();
            }
        }

        return highestRankedApp;
    }

    public String getLowestRankedApp() {
        double lowestRating = 5.0;
        String lowestRankedApp = "";

        for (int i = 0; i < appStats.size(); i++) {
            if (Integer.parseInt(appStats.get(i).getRating().trim()) < lowestRating) {
                lowestRating = Integer.parseInt(appStats.get(i).getRating().trim());
                lowestRankedApp = appStats.get(i).getName();
            }
        }

        return lowestRankedApp;
    }

    public double getAverageRating() {
        double totalRating = 0;
        int totalApps = 0;

        for (int i = 0; i < appStats.size(); i++) {
            totalRating += Integer.parseInt(appStats.get(i).getRating().trim());
            totalApps++;
        }

        return totalRating / totalApps;
    }

    
}
