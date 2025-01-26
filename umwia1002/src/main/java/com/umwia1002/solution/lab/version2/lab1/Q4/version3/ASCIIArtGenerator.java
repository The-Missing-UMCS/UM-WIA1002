package com.umwia1002.solution.lab.version2.lab1.Q4.version3;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ASCIIArtGenerator {
	public static final int ART_SIZE_SMALL = 12;
	public static final int ART_SIZE_MEDIUM = 18;
	public static final int ART_SIZE_LARGE = 24;
	public static final int ART_SIZE_HUGE = 32;
	public static final String DEFAULT_SYMBOL = "*";

	public void printTextArt(String artText, int textHeight, ASCIIArtFont fontType, String artSymbol) {
		String fontName = fontType.getValue();
		int imageWidth = calculateImageWidth(textHeight, artText, fontName);

		BufferedImage image = createTextImage(artText, textHeight, fontName, imageWidth);

		generateASCIIArt(image, artSymbol, textHeight, imageWidth);
	}

	public void printTextArt(String artText, int textHeight) {
		printTextArt(artText, textHeight, ASCIIArtFont.ART_FONT_DIALOG, DEFAULT_SYMBOL);
	}

	private BufferedImage createTextImage(String artText, int textHeight, String fontName, int imageWidth) {
		BufferedImage image = new BufferedImage(imageWidth, textHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		try {
			g2d.setFont(new Font(fontName, Font.BOLD, textHeight));
			g2d.setBackground(Color.BLACK);
			g2d.clearRect(0, 0, imageWidth, textHeight);
			g2d.setColor(Color.WHITE);
			g2d.drawString(artText, 0, getBaselinePosition(g2d, g2d.getFont()));
		} finally {
			g2d.dispose();
		}
		return image;
	}

	private void generateASCIIArt(BufferedImage image, String artSymbol, int textHeight, int imageWidth) {
		for (int y = 0; y < textHeight; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < imageWidth; x++) {
				sb.append(image.getRGB(x, y) == Color.WHITE.getRGB() ? artSymbol : " ");
			}
			if (!sb.toString().trim().isEmpty()) {
				System.out.println(sb);
			}
		}
	}

	private int calculateImageWidth(int textHeight, String artText, String fontName) {
		BufferedImage dummyImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		Graphics g = dummyImage.getGraphics();
		try {
			g.setFont(new Font(fontName, Font.BOLD, textHeight));
			return g.getFontMetrics().stringWidth(artText);
		} finally {
			g.dispose();
		}
	}

	private int getBaselinePosition(Graphics g, Font font) {
		FontMetrics metrics = g.getFontMetrics(font);
		return metrics.getAscent() - metrics.getDescent();
	}
}
