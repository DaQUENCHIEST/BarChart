public class BarChartRunner {
   public static void main(String[] args) {
      // create the bar chart
      String title = "The 10 most populous cities";
      String xAxis = "Population (thousands)";
      String source = "Source: United Nations";
      BarChart chart = new BarChart(title, xAxis, source);
      chart.setCaption("2018");

      // add the bars to the bar chart
      chart.add("Tokyo",       38194, "East Asia");
      chart.add("Delhi",       27890, "South Asia");
      chart.add("Shanghai",    25779, "East Asia");
      chart.add("Beijing",     22674, "East Asia");
      chart.add("Mumbai",      22120, "South Asia");
      chart.add("São Paulo",   21698, "Latin America");
      chart.add("Mexico City", 21520, "Latin America");
      chart.add("Osaka",       20409, "East Asia");
      chart.add("Cairo",       19850, "Middle East");
      chart.add("Dhaka",       19633, "South Asia");

      // draw the bar chart
      StdDraw.setCanvasSize(1000, 700);
      StdDraw.enableDoubleBuffering();
      chart.draw();
      StdDraw.show();
   }
}