import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
   public static void main(String[] args){

      //create the scanner
      try {
        File inputFile = new File("GameOfThrones.txt"); // input file
        Scanner sc = new Scanner(inputFile); //scanner for text file
        Scanner userIn = new Scanner(System.in); // scanner for user input

         // create the bar chart
         String title = sc.nextLine();
         String xAxis = sc.nextLine();
         String source = sc.nextLine();
         BarChart chart = new BarChart(title, xAxis, source);
         
         Runner runner = new Runner(chart, userIn, sc); // instantiates the runner class which handles the much of the logic

         // draw the bar chart
         StdDraw.setCanvasSize(1000, 700);
         StdDraw.enableDoubleBuffering();
         
         runner.quirySearch();
         while(sc.hasNextLine()){
            ArrayList <Bar> bars = new ArrayList<>(); // initalizies the list of bar objects.
            
            String countLine = sc.nextLine().trim();
            if(countLine.isEmpty()){
                continue;
            } 

            int numLines = Integer.parseInt(countLine);
            runner.createBar(bars, numLines); // runs the class that creates the bars;
            runner.sorting(bars);

            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(5); // brief pause to animate
            chart.reset(); 
         }
      }
      catch (FileNotFoundException e) { // the catch exception if the scanner cannot find the file
         System.out.println("File not found: " + e.getMessage());
      }
   }
}