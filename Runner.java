import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    //these varibles are used. I have no idea what VS is doing
    private BarChart chart;
    private Scanner userIn;
    private Scanner sc;
    private String countLine;

    public Runner(BarChart chart, Scanner userIn, Scanner sc){
        this.chart = chart;
        this.userIn = userIn;
        this.sc = sc;
    }

    public String quirySearch(){ // the search for a specific character
        System.out.println("Would you like search a character?");
        String yesNo = userIn.nextLine();
        System.out.println(":)");
        if(yesNo.trim().toLowerCase().equals("yes")){
            System.out.println("Chose a character");
            return userIn.nextLine();
        }
        return "";
    }

    public void createBar(ArrayList<Bar> bars, int numLines, String quiry){ // the class responsible for creating individual bar objects
        for (int i = 0; i < numLines && sc.hasNextLine(); i++) {
            String characterLine = sc.nextLine();
            String[] parts = characterLine.split(",");

            if (parts.length < 5) { // checks to make sure that the line the scanner is on has important information
                System.out.println("Skipping malformed line: " + characterLine);
                continue;
            }  

            chart.setCaption(parts[0]); // needs to be changed to dynamic, or I need to find both the start and the end. 
            String name = parts[1];
            int val = Integer.parseInt(parts[3]);
            String group = parts[2];

            if (quiry.isEmpty() || name.toLowerCase().contains(quiry.toLowerCase())) {
                bars.add(new Bar(name, val, group));
            }
        }
    }

    public void sorting(ArrayList<Bar> bars){
        bars.sort((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < Math.min(10, bars.size()); i++) {
            Bar b = bars.get(i);
            chart.add(b.getName(), b.getValue(), b.getCategory());
        }  
    }
}
