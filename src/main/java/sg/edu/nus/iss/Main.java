package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) throws Exception
    {
        String fileName = "";

        if (args.length > 0) {
            fileName = args[0];
        } 

        File newFile = new File(fileName);

        // read file line by line into a string

        FileReader fr = new FileReader(newFile);
        BufferedReader br = new BufferedReader(fr);
        br.readLine();



        String line;
        List<String> tempList = new ArrayList<>(10000);

        Map<String, List<AppData>> categoryMap = new HashMap<>(); 

        while ((line = br.readLine()) != null) {
            
            tempList = Arrays.asList(line.split(","));

            if ("NaN".equalsIgnoreCase(tempList.get(2))) {
                continue;
            }
            
            AppData newAppData = new AppData(tempList.get(0), tempList.get(1), tempList.get(2)); 

            List<AppData> list = new ArrayList<>();

            list.add(newAppData);
            
            if (!categoryMap.containsKey(tempList.get(1).trim())) {
                categoryMap.put(tempList.get(1).trim(), new LinkedList<AppData>());                    
            }

            categoryMap.put(tempList.get(1).trim(), list);
        }

        System.out.println(categoryMap);


        // Map<String, PlaystoreStats> stats = new HashMap<>();
        //
        // br.lines()
        //     .skip(1)        // ignore the first line
        //     .filter(line -> !line.contains("NaN"))       // lines that don't have NaN
        //     // String -> String[]
        //     .map(line -> line.split(","))
        //     // String[] -> PlaystoreEntry
        //     .map(cols -> new PlaystoreEntry(cols[0].trim(), cols[1].trim(), Float.parseFloat(cols[2].trim())))
        //     // PlaystoreEntry -> Map<String, List<PlaystoreEntry>
        //     .collect(Collectors.groupingBy(entry -> entry.category()))
        //     .forEach((String category, List<PlaystoreEntry> entries) -> {
        //         PlaystoreStats s = new PlaystoreStats(category);
        //         for (PlaystoreEntry e : entries)
        //             s.compute(e);
        //         stats.put(category, s);
        //     });

        // for (String c : stats.keySet()) {
        //     PlaystoreStats s = stats.get(c);
        //     System.out.printf("%s: avg: %f, ^%s:%f, V%s:%f\n", c, s.averageRating()
        //             , s.getHighestRatedApp(), s.getHighestRating(), s.getLowestRatedApp(), s.getLowestRating());
        // }

        
        

        
    }
}
