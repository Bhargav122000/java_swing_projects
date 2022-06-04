package com.bhargav.sharpeye.ui;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;

public class SharpEyeModel {
	private static Random random = new Random();
	private static ArrayList<ImageIcon> shapeIcons;
	private static ArrayList<ImageIcon> adjustedShapeIcons;

	private static void createIcons() {
		shapeIcons = new ArrayList<ImageIcon>();
		adjustedShapeIcons = new ArrayList<ImageIcon>();
		Image tempImage, tempNewImage;

		shapeIcons.add(new ImageIcon("D:\\myFiles\\filesForJavaProjects\\triangle.png"));
		shapeIcons.add(new ImageIcon("D:\\myFiles\\filesForJavaProjects\\square.png"));
		shapeIcons.add(new ImageIcon("D:\\myFiles\\filesForJavaProjects\\pentagon.png"));
		shapeIcons.add(new ImageIcon("D:\\myFiles\\filesForJavaProjects\\star.png"));
		shapeIcons.add(new ImageIcon("D:\\myFiles\\filesForJavaProjects\\circle.png"));

		for (int i = 0; i < shapeIcons.size(); i++) {
			tempImage = shapeIcons.get(i).getImage();
			tempNewImage = tempImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			adjustedShapeIcons.add(new ImageIcon(tempNewImage));
		}
	}

	private ImageIcon[] icons;
	private int[] shapeCounts;
	private int score;
	private ImageIcon requiredIcon;
	private int remainingRequiredIconCount;

	public SharpEyeModel() {
		SharpEyeModel.createIcons();
		icons = new ImageIcon[56];
		shapeCounts = new int[5];
	}

	public ImageIcon[] getIcons() {
		return icons;
	}

	public void setIcons(ImageIcon[] icons) {
		this.icons = icons;
	}

	public int[] getShapeCounts() {
		return shapeCounts;
	}

	public void setShapeCounts(int[] shapeCounts) {
		this.shapeCounts = shapeCounts;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ImageIcon getRequiredIcon() {
		return requiredIcon;
	}

	public void setRequiredIcon(ImageIcon requiredIcon) {
		this.requiredIcon = requiredIcon;
	}

	public int getRemainingRequiredIconCount() {
		return remainingRequiredIconCount;
	}

	public void setRemainingRequiredIconCount(int remainingRequiredIconCount) {
		this.remainingRequiredIconCount = remainingRequiredIconCount;
	}

	public void updateShapeCounts() {
		int index;
		for (int i = 0; i < icons.length; i++) {
			index = adjustedShapeIcons.indexOf(icons[i]);
			shapeCounts[index] += 1;
		}
	}

	public void generateIcons() {
		int index;
		for (int i = 0; i < icons.length; i++) {
			index = SharpEyeModel.random.nextInt(SharpEyeModel.adjustedShapeIcons.size());
			icons[i] = adjustedShapeIcons.get(index);
		}
		Arrays.fill(shapeCounts, 0);
		updateShapeCounts();
	}

	public void generateRequiredIcon() {
		int index = SharpEyeModel.random.nextInt(SharpEyeModel.adjustedShapeIcons.size());
		requiredIcon = adjustedShapeIcons.get(index);
		remainingRequiredIconCount = shapeCounts[index];
	}

	public void updateScore(ImageIcon obtainedIcon) {
		if (obtainedIcon.equals(requiredIcon)) {
			score += 100;
			remainingRequiredIconCount -= 1;
		} else {
			score -= 50;
			if (score < 0) {
				score = 0;
			}
		}
	}

	public boolean isFinished() {
		boolean result = false;
		if (remainingRequiredIconCount == 0) {
			result = true;
		}
		return result;
	}
}
