import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    private String title; 
    private String xAxis;
    private String source;
    private BarChart chart;
    private Scanner userIn;
    private Scanner sc;

    public Runner(String title, String xAxis, String source, BarChart chart, Scanner userIn, Scanner sc){
        this.title = title;
        this.xAxis = xAxis;
        this.source = source;
        this.chart = chart;
        this.userIn = userIn;
        this.sc = sc;
    }

    public void createChart(){
    }

    public void runScript(){
        while(sc.hasNextLine()){
            //count
            String countLine = sc.nextLine().trim();
            if(countLine.isEmpty()) continue;
            int numLines = Integer.parseInt(countLine);

            ArrayList<Bar> bars = new ArrayList<>(); // initalizies the list of bar objects.
            for (int i = 0; i < numLines && sc.hasNextLine(); i++) {
               String characterLine = sc.nextLine();
               String[] parts = characterLine.split(",");

               if (parts.length < 5) { // checks to make sure that the line the scanner is on has important information
                  System.out.println("Skipping malformed line: " + characterLine);
                  continue;
               }          
               chart.setCaption(parts[0]); // needs to be changed to dynamic, or I need to find both the start and the end. 
               String name = parts[1];
               String value = parts[3];
               int val = Integer.parseInt(parts[3]);
               String group = parts[2];

               bars.add(new Bar(name, val, group)); // adds the information taken from the txt file to the list
            }

            bars.sort((a, b) -> b.getValue() - a.getValue());


            for (int i = 0; i < Math.min(10, bars.size()); i++) {
               Bar b = bars.get(i);
               chart.add(b.getName(), b.getValue(), b.getCategory());
            }  
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(5);   // brief pause to animate
            chart.reset(); 
         }
      }
}
