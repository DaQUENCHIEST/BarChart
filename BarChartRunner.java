import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BarChartRunner {
   public static void main(String[] args){

      //create the scanner
      try {
        File inputFile = new File("GameOfThrones.txt");
        Scanner sc = new Scanner(inputFile);

      // create the bar chart
      String title = sc.nextLine();
      String xAxis = sc.nextLine();
      String source = sc.nextLine();
      BarChart chart = new BarChart(title, xAxis, source);
      chart.setCaption("2018");

      // add the bars to the bar chart
         while(sc.hasNextLine()){
            //count
            String countLine = sc.nextLine().trim();
            if(countLine.isEmpty()) continue;
            int numLines = Integer.parseInt(countLine);


            for (int i = 0; i < numLines && sc.hasNextLine(); i++) {
               String characterLine = sc.nextLine();
               String[] parts = characterLine.split(",");

               if (parts.length < 5) {
                  System.out.println("Skipping malformed line: " + characterLine);
                  continue;
               }          

               String name = parts[1];
               int value = Integer.parseInt(parts[3]);
               String group = parts[2];

               chart.add(name, value, group);
            }
         }
         // draw the bar chart
         StdDraw.setCanvasSize(1000, 700);
         StdDraw.enableDoubleBuffering();
         chart.draw();
         StdDraw.show();
      }
      catch (FileNotFoundException e) {
         System.out.println("File not found: " + e.getMessage());
    }
   }
}