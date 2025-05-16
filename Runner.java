import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private BarChart chart;
    private Scanner userIn;
    private Scanner sc;
    private int numLines;
    private String countLine;

    public Runner(BarChart chart, Scanner userIn, Scanner sc){
        this.chart = chart;
        this.userIn = userIn;
        this.sc = sc;
    }

    public void runScript(){
        while(sc.hasNextLine()){
            ArrayList <Bar> bars = new ArrayList<>(); // initalizies the list of bar objects.

            //counts the lines and skips all the lines that don't have text
            countLine = sc.nextLine().trim();
            if(countLine.isEmpty()){
                continue;
            } 

            numLines = Integer.parseInt(countLine);
            createBar(bars);

            bars.sort((a, b) -> b.getValue() - a.getValue());

            for (int i = 0; i < Math.min(10, bars.size()); i++) {
               Bar b = bars.get(i);
               chart.add(b.getName(), b.getValue(), b.getCategory());
            }  
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(5); // brief pause to animate
            chart.reset(); 
         }
      }

    public String quirySearch(){ // the search for a specific charecter
        System.out.println("Would you like search a charecter?");
        String yesNo = userIn.nextLine();
        if(yesNo.toLowerCase().equals("yes")){
            System.out.println("Chose a Charecter");
            return userIn.nextLine();
        }
        return "";
    }

    public void createBar(ArrayList<Bar> bars){
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

            bars.add(new Bar(name, val, group)); // adds the information taken from the txt file to the list
        }
    }
}
