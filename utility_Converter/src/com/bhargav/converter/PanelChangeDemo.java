package com.bhargav.converter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelChangeDemo implements ActionListener {
	
	JFrame frame;
	JPanel firstPanel, secondPanel, optionOnePanel, optionTwoPanel;
	JLabel firstLabel;
	JRadioButton firstRadioButton, secondRadioButton;
	ButtonGroup buttonGroup;
	JButton submitButton;
	JComboBox<String> languagesComboBox;
	JButton submitLanguagesButton;
	JTextField languagesField;
	JComboBox<String> coursesComboBox;
	JButton submitCoursesButton;
	JTextField coursesField;

	String[] languages = {"English", "Telugu", "Hindi", "Tamil", "Kannadam", "Malayalam"};
	String[] courses = {"Mathematics", "Physics", "Chemistry", "Biology", "Social"};
	
	public void createFirstPanel() {
		firstPanel = new JPanel();
		firstLabel = new JLabel("select one");
		firstRadioButton = new JRadioButton("languages");
		secondRadioButton = new JRadioButton("courses");
		buttonGroup = new ButtonGroup();
		submitButton = new JButton("submit");
		
		buttonGroup.add(firstRadioButton);
		buttonGroup.add(secondRadioButton);
		firstPanel.add(firstLabel);
		firstPanel.add(submitButton);
		firstPanel.add(firstRadioButton);
		firstPanel.add(secondRadioButton);
		firstPanel.setLayout(new FlowLayout());
	}
	
	public void createSecondPanel() {
		secondPanel = new JPanel();
		
		secondPanel.setLayout(new FlowLayout());
	}
	
	public void createOptionOnePanel() {
		optionOnePanel = new JPanel();
		languagesComboBox = new JComboBox<String>(languages);
		submitLanguagesButton = new JButton("submit");
		languagesField = new JTextField(10);
		languagesField.setEditable(false);
		
		optionOnePanel.add(languagesComboBox);
		optionOnePanel.add(submitLanguagesButton);
		optionOnePanel.add(languagesField);
		optionOnePanel.setLayout(new FlowLayout());
	}
	
	public void createOptionTwoPanel() {
		optionTwoPanel = new JPanel();
		coursesComboBox = new JComboBox<String>(courses);
		submitCoursesButton = new JButton("submit");
		coursesField = new JTextField(10);
		coursesField.setEditable(false);
		
		optionTwoPanel.add(coursesComboBox);
		optionTwoPanel.add(submitCoursesButton);
		optionTwoPanel.add(coursesField);
		optionTwoPanel.setLayout(new FlowLayout());
	}
	
	public void createFrame() {
		frame = new JFrame("Panel Changes");
		createFirstPanel();
		createSecondPanel();
		
		frame.add(firstPanel);
		frame.add(secondPanel);
		frame.setLayout(new GridLayout(2, 1, 5, 5));
	}
	
	public void addListeners() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
		
		submitButton.addActionListener(this);
	}
	
	public void displayFrame() {
		frame.pack();
		frame.setVisible(true);
	}
	
	public void startProcess() {
		createFrame();
		addListeners();
		displayFrame();
	}
	
	public static void main(String[] args) {
		new PanelChangeDemo().startProcess();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();
		
		if (object == submitButton) {
			frame.setVisible(false);
			if (firstRadioButton.isSelected()) {
				secondPanel.removeAll();
				createOptionOnePanel();
				secondPanel.add(optionOnePanel);
				submitLanguagesButton.addActionListener(this);
			} else if (secondRadioButton.isSelected()) {
				secondPanel.removeAll();
				createOptionTwoPanel();
				secondPanel.add(optionTwoPanel);
				submitCoursesButton.addActionListener(this);
			}
			frame.setVisible(true);
			
		} else if (object == submitLanguagesButton) {
			int index = languagesComboBox.getSelectedIndex();
			languagesField.setText(languages[index]);
		} else if (object == submitCoursesButton) {
			int index = coursesComboBox.getSelectedIndex();
			coursesField.setText(courses[index]);
		}
	}
	
}
