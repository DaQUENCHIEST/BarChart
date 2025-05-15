import java.io.File;
import java.io.FileNotFoundException;
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
         
         Runner charecter = new Runner(title, xAxis, source, chart, userIn, sc);

         // draw the bar chart
         StdDraw.setCanvasSize(1000, 700);
         StdDraw.enableDoubleBuffering();

         charecter.runScript();
   }
   catch (FileNotFoundException e) {
      System.out.println("File not found: " + e.getMessage());
 }
}
}