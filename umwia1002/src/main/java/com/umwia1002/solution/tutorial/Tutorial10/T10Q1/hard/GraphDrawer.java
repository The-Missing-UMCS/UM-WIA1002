package com.umwia1002.solution.tutorial.tutorial10.T10Q1.hard;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

public class GraphDrawer extends ApplicationFrame {

    // You can optionally omit/modify this if you prefer a different approach to serialization.
    private static final long serialVersionUID = 7961411087546750801L;

    /**
     * Constructs a graph-drawing window that displays a line chart with the given
     * parameters and data.
     *
     * @param applicationTitle Window title
     * @param chartTitle       Title of the chart
     * @param xAxisLabel       Label for x-axis
     * @param yAxisLabel       Label for y-axis
     * @param seriesNames      Names of the series (e.g., "Linear Search", "Binary Search", etc.)
     * @param xAxisValues      Array of x-axis categories (e.g., array sizes)
     * @param yAxisValues      2D array of data points for each series
     * @param numberOfSize     Number of points on the x-axis
     * @param numberOfMethod   Number of data series
     */
    public GraphDrawer(String applicationTitle,
                       String chartTitle,
                       String xAxisLabel,
                       String yAxisLabel,
                       String[] seriesNames,
                       int[] xAxisValues,
                       long[][] yAxisValues,
                       int numberOfSize,
                       int numberOfMethod) {

        super(applicationTitle);

        // Create the dataset from the x/y values provided
        DefaultCategoryDataset dataset = createDataset(seriesNames, xAxisValues, yAxisValues, numberOfSize, numberOfMethod);

        // Create the chart
        JFreeChart lineChart = ChartFactory.createLineChart(
            chartTitle,
            xAxisLabel,
            yAxisLabel,
            dataset,
            PlotOrientation.VERTICAL,
            true,   // include legend
            true,   // generate tooltips
            false   // generate URLs
        );

        // Customize the plot
        CategoryPlot plot = lineChart.getCategoryPlot();
        customizePlot(plot);

        // Wrap chart in a panel and set as content
        ChartPanel chartPanel = new ChartPanel(lineChart);
        setContentPane(chartPanel);
    }

    /**
     * Displays the chart window.
     */
    public void draw() {
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Creates a dataset for the chart. Each row in the 2D yAxis array corresponds
     * to a single series, and each column corresponds to a particular x-axis value.
     *
     * <p>Because a line chart in JFreeChart's CategoryPlot will treat each unique
     * category label as a discrete step, we simply map the integer x-values to
     * Strings. We also sort them via a {@code TreeMap} so the line chart will
     * move in ascending order of x-values.</p>
     *
     * @param seriesNames    Names of the series
     * @param xAxis          x-axis values
     * @param yAxis          2D array of y-values
     * @param numberOfSize   Number of x-axis data points
     * @param numberOfMethod Number of series
     * @return A {@link DefaultCategoryDataset} that can be used by a CategoryPlot
     */
    private DefaultCategoryDataset createDataset(String[] seriesNames,
                                                 int[] xAxis,
                                                 long[][] yAxis,
                                                 int numberOfSize,
                                                 int numberOfMethod) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Use a TreeMap to sort x-values so the lines are drawn left to right
        Map<Integer, long[]> sortedData = new TreeMap<>();
        for (int j = 0; j < numberOfSize; j++) {
            sortedData.putIfAbsent(xAxis[j], new long[numberOfMethod]);
            for (int i = 0; i < numberOfMethod; i++) {
                sortedData.get(xAxis[j])[i] = yAxis[i][j];
            }
        }

        // Populate the dataset
        for (Map.Entry<Integer, long[]> entry : sortedData.entrySet()) {
            Integer xValue = entry.getKey();
            long[] methodValues = entry.getValue();
            for (int i = 0; i < methodValues.length; i++) {
                dataset.addValue(methodValues[i], seriesNames[i], String.valueOf(xValue));
            }
        }
        return dataset;
    }

    /**
     * Applies various stylistic and functional customizations to the {@link CategoryPlot}.
     *
     * @param plot The chart plot to customize
     */
    private void customizePlot(CategoryPlot plot) {
        // Set chart background colors
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinesVisible(true);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

        // Use a NumberAxis for numeric y-axis and keep ticks in integer increments
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // Rotate the category labels if desired (useful if many data points)
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        // Configure line renderer
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();

        // Show shapes at data points
        renderer.setDefaultShapesVisible(true);
        renderer.setDefaultShapesFilled(true);

        // Optionally add tooltips and item labels
        renderer.setDefaultToolTipGenerator(new StandardCategoryToolTipGenerator());
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true);

        // Adjust the stroke and colors for each series if you want
        // Here we apply the same stroke width to all series
        for (int seriesIndex = 0; seriesIndex < renderer.getPlot().getDataset().getRowCount(); seriesIndex++) {
            renderer.setSeriesStroke(seriesIndex, new BasicStroke(2.0f));
        }
    }
}
