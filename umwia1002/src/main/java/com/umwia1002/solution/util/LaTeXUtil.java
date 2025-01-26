package com.umwia1002.solution.util;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LaTeXUtil {
    public static String format(String expression) {
        return "$%s$".formatted(expression);
    }

    public static void renderLatex(String latex) {
        // Create a TeXFormula object from the LaTeX string
        TeXFormula formula = new TeXFormula(latex);

        // Create an icon representing the formula
        TeXIcon icon = formula.createTeXIcon(TeXFormula.SERIF, 30); // Adjust size here
        icon.setInsets(new Insets(10, 10, 10, 10)); // Add padding around the formula

        // Create a BufferedImage to draw the formula
        BufferedImage image = new BufferedImage(
            icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);

        // Draw the formula on the image
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        g2.setColor(Color.WHITE); // Set the background color to white
        g2.fillRect(0, 0, image.getWidth(), image.getHeight());
        icon.paintIcon(new JLabel(), g2, 0, 0); // Paint the formula onto the image
        g2.dispose();

        // Create a JLabel to hold the image
        JLabel label = new JLabel(new ImageIcon(image));

        // Create a JFrame to display the label
        JFrame frame = new JFrame("LaTeX Render");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack(); // Automatically size the frame to fit the content
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    public static void render(String latexExpression) {
        SwingUtilities.invokeLater(() -> {
            // Create a TeXFormula from the LaTeX string
            TeXFormula formula = new TeXFormula(latexExpression);

            // Create an icon to render the formula
            Icon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);

            // Display the icon in a JLabel inside a JFrame
            JLabel label = new JLabel(icon);
            JFrame frame = new JFrame("LaTeX Renderer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(label);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

