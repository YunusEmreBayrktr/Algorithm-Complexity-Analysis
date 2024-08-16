import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

public class Plotting {
	
	private static double[] doubleX = Arrays.stream(Experiment.sizes).asDoubleStream().toArray();
	private static Color[] colors = {new Color(250, 5, 5),new Color(5, 99, 250),new Color(21, 250, 5)};
	
	private static void plotRandomSort() throws IOException {
		
		XYChart chart = new XYChartBuilder().width(800).height(600).title("Experiments on the Given Random Data")
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();
		
		chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setChartBackgroundColor(new Color(215, 216, 252));
        chart.getStyler().setAntiAlias(true);
        chart.getStyler().setSeriesColors(colors);
        chart.getStyler().setMarkerSize(0);
        
        chart.addSeries("Selection Sort", doubleX, Experiment.randomResults.get("selectionSort")).setLineWidth(4);
        chart.addSeries("Quick Sort", doubleX, Experiment.randomResults.get("quickSort")).setLineWidth(4);
        chart.addSeries("Bucket Sort", doubleX, Experiment.randomResults.get("bucketSort")).setLineWidth(4);
        
        BitmapEncoder.saveBitmap(chart, "Random Data Sort" + ".png", BitmapEncoder.BitmapFormat.PNG);
	}
	
	private static void plotSortedSort() throws IOException {
		
		XYChart chart = new XYChartBuilder().width(800).height(600).title("Experiments on the Sorted Data")
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();
		
		chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setChartBackgroundColor(new Color(215, 216, 252));
        chart.getStyler().setAntiAlias(true);
        chart.getStyler().setSeriesColors(colors);
        chart.getStyler().setMarkerSize(0);
        
        chart.addSeries("Selection Sort", doubleX, Experiment.sortedResults.get("selectionSort"));
        chart.addSeries("Quick Sort", doubleX, Experiment.sortedResults.get("quickSort"));
        chart.addSeries("Bucket Sort", doubleX, Experiment.sortedResults.get("bucketSort"));
        
        BitmapEncoder.saveBitmap(chart, "Sorted Data Sort" + ".png", BitmapEncoder.BitmapFormat.PNG);
	}
	
	private static void plotReversedSort() throws IOException {
		
		XYChart chart = new XYChartBuilder().width(800).height(600).title("Experiments on the Reversely Sorted Data")
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();
		
		chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setChartBackgroundColor(new Color(215, 216, 252));
        chart.getStyler().setAntiAlias(true);
        chart.getStyler().setSeriesColors(colors);
        chart.getStyler().setMarkerSize(0);
        
        chart.addSeries("Selection Sort", doubleX, Experiment.reversedResults.get("selectionSort"));
        chart.addSeries("Quick Sort", doubleX, Experiment.reversedResults.get("quickSort"));
        chart.addSeries("Bucket Sort", doubleX, Experiment.reversedResults.get("bucketSort"));
        
        BitmapEncoder.saveBitmap(chart, "Reversed Data Sort" + ".png", BitmapEncoder.BitmapFormat.PNG);
	}
	
	private static void plotSearching() throws IOException {
		
		XYChart chart = new XYChartBuilder().width(800).height(600).title("Searching Experiments")
                .yAxisTitle("Time in Nanoseconds").xAxisTitle("Input Size").build();
		
		chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setChartBackgroundColor(new Color(215, 216, 252));
        chart.getStyler().setAntiAlias(true);
        chart.getStyler().setSeriesColors(colors);
        chart.getStyler().setMarkerSize(0);
        
        chart.addSeries("Linear Search (Random Data)", doubleX, Experiment.linearResults.get("randomData"));
        chart.addSeries("Linear Search (Sorted Data)", doubleX, Experiment.linearResults.get("sortedData"));
        chart.addSeries("Binary Search (Sorted Data)", doubleX, Experiment.binaryResults.get("sortedData"));
        
        BitmapEncoder.saveBitmap(chart, "Searching Experiments" + ".png", BitmapEncoder.BitmapFormat.PNG);
	}
	
	public static void plot() {

		try {
			plotRandomSort();
			plotSortedSort();
			plotReversedSort();
			plotSearching();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
