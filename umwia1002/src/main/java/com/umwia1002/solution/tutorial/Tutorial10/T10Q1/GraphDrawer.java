package com.umwia1002.solution.tutorial.Tutorial10.T10Q1;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.*;

public class GraphDrawer extends ApplicationFrame {

	private static final long serialVersionUID = 7961411087546750801L;

	public GraphDrawer(String applicationTitle, String chartTitle, String xAxisLabel, String yAxisLabel,
			String[] series, int[] xAxis, long[][] yAxis, int numberOfSize, int numberOfMethod) {
		super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(chartTitle, xAxisLabel, yAxisLabel,
				createDataset(series, xAxis, yAxis, numberOfSize, numberOfMethod), PlotOrientation.VERTICAL, true, true,
				false);
		
		CategoryPlot plot = (CategoryPlot) lineChart.getPlot();
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
		renderer.setSeriesStroke(0, new BasicStroke(3.0f)); // set stroke width of the line
		renderer.setSeriesPaint(0, Color.BLUE); // set color of the line
		
		ChartPanel chartPanel = new ChartPanel(lineChart);
		setContentPane(chartPanel);
	}

	public void draw() {
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.setVisible(true);
	}

	private DefaultCategoryDataset createDataset(String[] series, int[] xAxis, long[][] yAxis, int numberOfSize,
			int numberOfMethod) {

//		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//		for (int i = 0; i < numberOfMethod; i++)
//			for (int j = 0; j < numberOfSize; j++)
//				dataset.addValue(yAxis[i][j], series[i], String.valueOf(xAxis[i]));
//
//		return dataset;
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		// sort the data by the x-axis values
		Map<Integer, List<Long>> dataMap = new TreeMap<>();
		for (int i = 0; i < numberOfMethod; i++) {
			for (int j = 0; j < numberOfSize; j++) {
				if (!dataMap.containsKey(xAxis[j])) {
					dataMap.put(xAxis[j], new ArrayList<>());
				}
				dataMap.get(xAxis[j]).add(yAxis[i][j]);
			}
		}

		// add the data to the dataset
		for (Integer xValue : dataMap.keySet()) {
			List<Long> yValues = dataMap.get(xValue);
			for (int i = 0; i < yValues.size(); i++) {
				dataset.addValue(yValues.get(i), series[i], String.valueOf(xValue));
			}
		}

		return dataset;
	}
}
