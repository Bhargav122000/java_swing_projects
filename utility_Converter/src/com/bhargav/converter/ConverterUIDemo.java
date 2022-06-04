package com.bhargav.converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConverterUIDemo implements ActionListener {

	JFrame frame;
	JPanel firstPanel, descriptionPanel, selectionPanel;
	JTextArea descriptionArea;
	JLabel selectionLabel;
	JRadioButton areaRadioButton, dataRadioButton, lengthRadioButton;
	JRadioButton massRadioButton, temperatureRadioButton, volumeRadioButton;
	ButtonGroup buttonGroup;
	JButton proceedButton;
	JPanel secondPanel, convertPanel, convertFromPanel, convertToPanel, keysPanel;
	JLabel convertFromLabel;
	JComboBox<String> convertFromCombo;
	JTextField convertFromField, convertFromUnitField;
	JLabel convertToLabel;
	JComboBox<String> convertToCombo;
	JTextField convertToField, convertToUnitField;
	JButton[] digitsButton;
	JButton decimalButton, zeroesButton, clearButton, clearAllButton, closeButton;

	String[] areaChoices = { "acre", "hectare", "square centimetre", "square foot", "square inch",
			"square metre" };
	String[] dataChoices = { "bit", "byte", "kilobyte", "megabyte", "gigabyte", "terabyte" };
	String[] lengthChoices = { "millmetre", "centimetre", "metre", "kilometre", "inch", "foot", "yard", "mile" };
	String[] massChoices = { "ton", "pound", "ounce", "kilogram", "gram" };
	String[] temperatureChoices = { "celsius", "fahrenheit", "kelvin" };
	String[] volumeChoices = { "gallon", "litre", "milliletre", "cubic centimetre", "cubic metre", "cubic inch",
			"cubic foot" };

	String[] areaUnits = { "ac", "ha", "sq cm", "sq ft", "sq in", "sq m" };
	String[] dataUnits = { "bit", "B", "KB", "MB", "GB", "TB" };
	String[] lengthUnits = { "mm", "cm", "m", "km", "in", "ft", "yd", "mi" };
	String[] massUnits = { "t", "lb", "oz", "kg", "g" };
	String[] temperatureUnits = { "C", "F", "K" };
	String[] volumeUnits = { "Gal", "l", "ml", "cc", "cb m", "cb in", "cb ft" };

	public void createDescriptionPanel() {
		descriptionPanel = new JPanel();
		descriptionArea = new JTextArea(6, 40);
		descriptionArea.setText("Helloo!! I am converter.\n" + "The following measurements are considered:\n"
				+ "[Area, Data, Length, Mass, Temperature, Volume]\n"
				+ "  --First, Choose a measurement\n  --Then, Convert from one unit to other unit");
		descriptionArea.setBackground(Color.LIGHT_GRAY);
		descriptionArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		descriptionArea.setEditable(false);

		descriptionPanel.add(descriptionArea);
		descriptionPanel.setLayout(new FlowLayout());
	}

	public void createSelectionPanel() {
		selectionPanel = new JPanel();
		selectionLabel = new JLabel("select measurement");
		areaRadioButton = new JRadioButton("Area");
		dataRadioButton = new JRadioButton("Data");
		lengthRadioButton = new JRadioButton("Length");
		massRadioButton = new JRadioButton("Mass");
		temperatureRadioButton = new JRadioButton("Temperature");
		volumeRadioButton = new JRadioButton("Volume");
		buttonGroup = new ButtonGroup();
		proceedButton = new JButton("proceed..");

		buttonGroup.add(areaRadioButton);
		buttonGroup.add(dataRadioButton);
		buttonGroup.add(lengthRadioButton);
		buttonGroup.add(massRadioButton);
		buttonGroup.add(temperatureRadioButton);
		buttonGroup.add(volumeRadioButton);
		selectionPanel.add(selectionLabel);
		selectionPanel.add(areaRadioButton);
		selectionPanel.add(dataRadioButton);
		selectionPanel.add(lengthRadioButton);
		selectionPanel.add(proceedButton);
		selectionPanel.add(massRadioButton);
		selectionPanel.add(temperatureRadioButton);
		selectionPanel.add(volumeRadioButton);
		selectionPanel.setLayout(new GridLayout(2, 4, 2, 2));
	}

	public void createConvertFromPanel() {
		convertFromPanel = new JPanel();
		convertFromLabel = new JLabel("from unit");
		convertFromCombo = new JComboBox<String>();
		convertFromField = new JTextField(15);
		convertFromField.setEditable(false);
		convertFromUnitField = new JTextField(4);
		convertFromUnitField.setEditable(false);

		convertFromPanel.add(convertFromLabel);
		convertFromPanel.add(convertFromCombo);
		convertFromPanel.add(convertFromField);
		convertFromPanel.add(convertFromUnitField);
		convertFromPanel.setLayout(new FlowLayout());
	}

	public void createConvertToPanel() {
		convertToPanel = new JPanel();
		convertToLabel = new JLabel("to unit");
		convertToCombo = new JComboBox<String>();
		convertToField = new JTextField(15);
		convertToField.setEditable(false);
		convertToUnitField = new JTextField(4);
		convertToUnitField.setEditable(false);

		convertToPanel.add(convertToLabel);
		convertToPanel.add(convertToCombo);
		convertToPanel.add(convertToField);
		convertToPanel.add(convertToUnitField);
		convertToPanel.setLayout(new FlowLayout());
	}

	public void createKeysPanel() {
		keysPanel = new JPanel();
		digitsButton = new JButton[10];
		for (int i = 0; i < digitsButton.length; i++) {
			digitsButton[i] = new JButton(String.valueOf(i));
		}
		decimalButton = new JButton(".");
		zeroesButton = new JButton("00");
		clearButton = new JButton("clear");
		clearAllButton = new JButton("clear all");
		closeButton = new JButton("exit..");

		keysPanel.add(digitsButton[7]);
		keysPanel.add(digitsButton[8]);
		keysPanel.add(digitsButton[9]);
		keysPanel.add(digitsButton[4]);
		keysPanel.add(digitsButton[5]);
		keysPanel.add(digitsButton[6]);
		keysPanel.add(digitsButton[1]);
		keysPanel.add(digitsButton[2]);
		keysPanel.add(digitsButton[3]);
		keysPanel.add(digitsButton[0]);
		keysPanel.add(decimalButton);
		keysPanel.add(zeroesButton);
		keysPanel.add(clearButton);
		keysPanel.add(clearAllButton);
		keysPanel.add(closeButton);
		keysPanel.setLayout(new GridLayout(5, 3, 2, 2));
	}

	public void createConvertPanel() {
		convertPanel = new JPanel();
		createConvertFromPanel();
		createConvertToPanel();

		convertPanel.add(convertFromPanel);
		convertPanel.add(convertToPanel);
		convertPanel.setLayout(new GridLayout(2, 1, 2, 2));
	}

	public void createFirstPanel() {
		firstPanel = new JPanel();
		createDescriptionPanel();
		createSelectionPanel();

		firstPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		firstPanel.add(descriptionPanel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		firstPanel.add(selectionPanel, gbc);
	}

	public void createSecondPanel() {
		secondPanel = new JPanel();
		createConvertPanel();
		createKeysPanel();

		secondPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		secondPanel.add(convertPanel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		secondPanel.add(keysPanel, gbc);
	}

	public void createFrame() {
		frame = new JFrame("Converter");
		createFirstPanel();
		createSecondPanel();

		frame.add(firstPanel);
		frame.add(secondPanel);
		frame.setLayout(new GridLayout(1, 2, 5, 5));
	}

	public void setInitialRestrictions() {
		proceedButton.setEnabled(false);
		convertFromCombo.setEnabled(false);
		convertToCombo.setEnabled(false);
		for (int i = 0; i < digitsButton.length; i++) {
			digitsButton[i].setEnabled(false);
		}
		decimalButton.setEnabled(false);
		zeroesButton.setEnabled(false);
		clearButton.setEnabled(false);
		clearAllButton.setEnabled(false);
		closeButton.setEnabled(true);
	}

	public void addListeners() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();

		areaRadioButton.addActionListener(this);
		dataRadioButton.addActionListener(this);
		lengthRadioButton.addActionListener(this);
		massRadioButton.addActionListener(this);
		temperatureRadioButton.addActionListener(this);
		volumeRadioButton.addActionListener(this);
		proceedButton.addActionListener(this);
		for (int i = 0; i < digitsButton.length; i++) {
			digitsButton[i].addActionListener(this);
		}
		decimalButton.addActionListener(this);
		zeroesButton.addActionListener(this);
		clearButton.addActionListener(this);
		clearAllButton.addActionListener(this);
		closeButton.addActionListener(this);

		convertFromField.addActionListener(this);

		convertFromCombo.addActionListener(this);
		convertToCombo.addActionListener(this);
	}

	public void displayFrame() {
		frame.pack();
		frame.setVisible(true);
	}

	public void startProcess() {
		createFrame();
		setInitialRestrictions();
		addListeners();
		displayFrame();
	}

	public static void main(String[] args) {
		new ConverterUIDemo().startProcess();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object == closeButton) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.dispose();
		}

		if (object == areaRadioButton || object == dataRadioButton || object == lengthRadioButton
				|| object == massRadioButton || object == temperatureRadioButton || object == volumeRadioButton) {
			if (areaRadioButton.isSelected() || dataRadioButton.isSelected() || lengthRadioButton.isSelected()
					|| massRadioButton.isSelected() || temperatureRadioButton.isSelected()
					|| volumeRadioButton.isSelected()) {
				proceedButton.setEnabled(true);
			}
		} else if (object == proceedButton) {
			convertFromCombo.setEnabled(true);
			convertToCombo.setEnabled(true);
			convertFromCombo.removeAllItems();
			convertToCombo.removeAllItems();

			if (areaRadioButton.isSelected()) {
				for (int i = 0; i < areaChoices.length; i++) {
					convertFromCombo.addItem(areaChoices[i]);
					convertToCombo.addItem(areaChoices[i]);
				}
			} else if (dataRadioButton.isSelected()) {
				for (int i = 0; i < dataChoices.length; i++) {
					convertFromCombo.addItem(dataChoices[i]);
					convertToCombo.addItem(dataChoices[i]);
				}
			} else if (lengthRadioButton.isSelected()) {
				for (int i = 0; i < lengthChoices.length; i++) {
					convertFromCombo.addItem(lengthChoices[i]);
					convertToCombo.addItem(lengthChoices[i]);
				}
			} else if (massRadioButton.isSelected()) {
				for (int i = 0; i < massChoices.length; i++) {
					convertFromCombo.addItem(massChoices[i]);
					convertToCombo.addItem(massChoices[i]);
				}
			} else if (temperatureRadioButton.isSelected()) {
				for (int i = 0; i < temperatureChoices.length; i++) {
					convertFromCombo.addItem(temperatureChoices[i]);
					convertToCombo.addItem(temperatureChoices[i]);
				}
			} else if (volumeRadioButton.isSelected()) {
				for (int i = 0; i < volumeChoices.length; i++) {
					convertFromCombo.addItem(volumeChoices[i]);
					convertToCombo.addItem(volumeChoices[i]);
				}
			}
		}

		if (object == convertFromCombo || object == convertToCombo) {
			for (int i = 0; i < digitsButton.length; i++) {
				digitsButton[i].setEnabled(true);
			}
			decimalButton.setEnabled(true);
			zeroesButton.setEnabled(true);

			int index = -1;
			String text = null;

			if (object == convertFromCombo) {
				index = convertFromCombo.getSelectedIndex();
			} else {
				index = convertToCombo.getSelectedIndex();
			}

			if (areaRadioButton.isSelected()) {
				text = areaUnits[index];
			} else if (dataRadioButton.isSelected()) {
				text = dataUnits[index];
			} else if (lengthRadioButton.isSelected()) {
				text = lengthUnits[index];
			} else if (massRadioButton.isSelected()) {
				text = massUnits[index];
			} else if (temperatureRadioButton.isSelected()) {
				text = temperatureUnits[index];
			} else if (volumeRadioButton.isSelected()) {
				text = volumeUnits[index];
			}

			if (object == convertFromCombo) {
				convertFromUnitField.setText(text);
			} else {
				convertToUnitField.setText(text);
			}

		}

		if (object == clearButton) {
			StringBuilder text = new StringBuilder();
			text.append(convertFromField.getText());

			if (text.length() > 0) {
				text.deleteCharAt(text.length() - 1);
			}
			convertFromField.setText(text.toString());
		} else if (object == clearAllButton) {
			convertFromField.setText("");
		} else if (object == decimalButton) {
			StringBuilder text = new StringBuilder();
			text.append(convertFromField.getText());

			if (text.length() == 0) {
				text.append("0.");
			} else {
				if (!text.toString().contains(".")) {
					text.append(".");
				}
			}
			convertFromField.setText(text.toString());
		} else if (object == zeroesButton) {
			StringBuilder text = new StringBuilder();
			text.append(convertFromField.getText());

			if (text.length() > 0) {
				text.append("00");
			}
			convertFromField.setText(text.toString());
		} else {
			for (int i = 0; i < digitsButton.length; i++) {
				if (object == digitsButton[i]) {
					StringBuilder text = new StringBuilder();
					text.append(convertFromField.getText());
					text.append(i);
					convertFromField.setText(text.toString());
				}
			}
		}

		if (convertFromField.getText().length() > 0) {
			clearButton.setEnabled(true);
			clearAllButton.setEnabled(true);
		} else {
			clearButton.setEnabled(false);
			clearAllButton.setEnabled(false);
		}

	}
}
