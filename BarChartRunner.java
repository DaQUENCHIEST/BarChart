import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BarChartRunner {
   public static void main(String[] args){

      //create the scanner
      try {
        File inputFile = new File("GameOfThrones.txt"); // input file
        Scanner sc = new Scanner(inputFile);

      // create the bar chart
      String title = sc.nextLine();
      String xAxis = sc.nextLine();
      String source = sc.nextLine();
      BarChart chart = new BarChart(title, xAxis, source);


        // draw the bar chart
      StdDraw.setCanvasSize(1000, 700);
      StdDraw.enableDoubleBuffering();

      // add the bars to the bar chart
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
            StdDraw.pause(50);   // brief pause to animate
            chart.reset(); 
         }
      }
      catch (FileNotFoundException e) {
         System.out.println("File not found: " + e.getMessage());
    }
   }
}