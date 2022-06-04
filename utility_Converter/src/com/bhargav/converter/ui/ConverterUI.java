package com.bhargav.converter.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConverterUI implements ActionListener {

	JFrame frame;
	JPanel firstPanel;
	JLabel selectionLabel;
	JRadioButton areaRadioButton, dataRadioButton, lengthRadioButton;
	JRadioButton massRadioButton, temperatureRadioButton, volumeRadioButton;
	ButtonGroup buttonGroup;
	JButton proceedButton;
	JPanel secondPanel, keyBoardPanel, dynamicPanel;
	JButton[] digitsButton;
	JButton decimalButton, zeroesButton, clearButton, clearAllButton, closeButton;
	JPanel areaPanel, dataPanel, lengthPanel;
	JPanel massPanel, temperaturePanel, volumePanel;
	JPanel areaPanelOne, areaPanelTwo;
	JPanel dataPanelOne, dataPanelTwo;
	JPanel lengthPanelOne, lengthPanelTwo;
	JPanel massPanelOne, massPanelTwo;
	JPanel temperaturePanelOne, temperaturePanelTwo;
	JPanel volumePanelOne, volumePanelTwo;
	JComboBox<String> areaComboBoxOne, areaComboBoxTwo;
	JComboBox<String> dataComboBoxOne, dataComboBoxTwo;
	JComboBox<String> lengthComboBoxOne, lengthComboBoxTwo;
	JComboBox<String> massComboBoxOne, massComboBoxTwo;
	JComboBox<String> temperatureComboBoxOne, temperatureComboBoxTwo;
	JComboBox<String> volumeComboBoxOne, volumeComboBoxTwo;
	JLabel areaLabelOne, areaLabelTwo;
	JLabel dataLabelOne, dataLabelTwo;
	JLabel lengthLabelOne, lengthLabelTwo;
	JLabel massLabelOne, massLabelTwo;
	JLabel temperatureLabelOne, temperatureLabelTwo;
	JLabel volumeLabelOne, volumeLabelTwo;
	JTextField areaFieldOne, areaFieldTwo, areaUnitFieldOne, areaUnitFieldTwo;
	JTextField dataFieldOne, dataFieldTwo, dataUnitFieldOne, dataUnitFieldTwo;
	JTextField lengthFieldOne, lengthFieldTwo, lengthUnitFieldOne, lengthUnitFieldTwo;
	JTextField massFieldOne, massFieldTwo, massUnitFieldOne, massUnitFieldTwo;
	JTextField temperatureFieldOne, temperatureFieldTwo, temperatureUnitFieldOne, temperatureUnitFieldTwo;
	JTextField volumeFieldOne, volumeFieldTwo, volumeUnitFieldOne, volumeUnitFieldTwo;
	JButton areaConvertButton, dataConvertButton, lengthConvertButton;
	JButton massConvertButton, temperatureConvertButton, volumeConvertButton;

	String[] areaChoices = { " -- ", "acre", "hectare", "square centimetre", "square foot", "square inch",
			"square metre" };
	String[] dataChoices = { " -- ", "bit", "byte", "kilobyte", "megabyte", "gigabyte", "terabyte" };
	String[] lengthChoices = { " -- ", "millmetre", "centimetre", "metre", "kilometre", "inch", "foot", "yard",
			"mile" };
	String[] massChoices = { " -- ", "ton", "pound", "ounce", "kilogram", "gram" };
	String[] temperatureChoices = { " -- ", "celsius", "fahrenheit", "kelvin" };
	String[] volumeChoices = { " -- ", "gallon", "litre", "milliletre", "cubic centimetre", "cubic metre", "cubic inch",
			"cubic foot" };

	String[] areaUnits = { " -- ", "ac", "ha", "sq cm", "sq ft", "sq in", "sq m" };
	String[] dataUnits = { " -- ", "bit", "B", "KB", "MB", "GB", "TB" };
	String[] lengthUnits = { " -- ", "mm", "cm", "m", "km", "in", "ft", "yd", "mi" };
	String[] massUnits = { " -- ", "t", "lb", "oz", "kg", "g" };
	String[] temperatureUnits = { " -- ", "C", "F", "K" };
	String[] volumeUnits = { " -- ", "Gal", "l", "ml", "cc", "cb m", "cb in", "cb ft" };

	Conversion conversion = null;

	public void createAreaPanel() {
		areaPanel = new JPanel();

		areaPanelOne = new JPanel();
		areaLabelOne = new JLabel("Unit from");
		areaComboBoxOne = new JComboBox<String>(areaChoices);
		areaFieldOne = new JTextField(10);
		areaFieldOne.setEditable(false);
		areaUnitFieldOne = new JTextField(4);
		areaUnitFieldOne.setEditable(false);
		areaConvertButton = new JButton("convert");

		areaPanelTwo = new JPanel();
		areaLabelTwo = new JLabel("Unit to");
		areaComboBoxTwo = new JComboBox<String>(areaChoices);
		areaFieldTwo = new JTextField(10);
		areaFieldTwo.setEditable(false);
		areaUnitFieldTwo = new JTextField(4);
		areaUnitFieldTwo.setEditable(false);

		areaPanelOne.add(areaLabelOne);
		areaPanelOne.add(areaComboBoxOne);
		areaPanelOne.add(areaFieldOne);
		areaPanelOne.add(areaUnitFieldOne);
		areaPanelOne.add(areaConvertButton);
		areaPanelOne.setLayout(new FlowLayout());

		areaPanelTwo.add(areaLabelTwo);
		areaPanelTwo.add(areaComboBoxTwo);
		areaPanelTwo.add(areaFieldTwo);
		areaPanelTwo.add(areaUnitFieldTwo);
		areaPanelTwo.setLayout(new FlowLayout());

		areaPanel.add(areaPanelOne);
		areaPanel.add(areaPanelTwo);
		areaPanel.setLayout(new GridLayout(2, 1, 2, 2));
	}

	public void createDataPanel() {
		dataPanel = new JPanel();

		dataPanelOne = new JPanel();
		dataLabelOne = new JLabel("Unit from");
		dataComboBoxOne = new JComboBox<String>(dataChoices);
		dataFieldOne = new JTextField(10);
		dataFieldOne.setEditable(false);
		dataUnitFieldOne = new JTextField(4);
		dataUnitFieldOne.setEditable(false);
		dataConvertButton = new JButton("convert");

		dataPanelTwo = new JPanel();
		dataLabelTwo = new JLabel("Unit to");
		dataComboBoxTwo = new JComboBox<String>(dataChoices);
		dataFieldTwo = new JTextField(10);
		dataFieldTwo.setEditable(false);
		dataUnitFieldTwo = new JTextField(4);
		dataUnitFieldTwo.setEditable(false);

		dataPanelOne.add(dataLabelOne);
		dataPanelOne.add(dataComboBoxOne);
		dataPanelOne.add(dataFieldOne);
		dataPanelOne.add(dataUnitFieldOne);
		dataPanelOne.add(dataConvertButton);
		dataPanelOne.setLayout(new FlowLayout());

		dataPanelTwo.add(dataLabelTwo);
		dataPanelTwo.add(dataComboBoxTwo);
		dataPanelTwo.add(dataFieldTwo);
		dataPanelTwo.add(dataUnitFieldTwo);
		dataPanelTwo.setLayout(new FlowLayout());

		dataPanel.add(dataPanelOne);
		dataPanel.add(dataPanelTwo);
		dataPanel.setLayout(new GridLayout(2, 1, 2, 2));
	}

	public void createLengthPanel() {
		lengthPanel = new JPanel();

		lengthPanelOne = new JPanel();
		lengthLabelOne = new JLabel("Unit from");
		lengthComboBoxOne = new JComboBox<String>(lengthChoices);
		lengthFieldOne = new JTextField(10);
		lengthFieldOne.setEditable(false);
		lengthUnitFieldOne = new JTextField(4);
		lengthUnitFieldOne.setEditable(false);
		lengthConvertButton = new JButton("convert");

		lengthPanelTwo = new JPanel();
		lengthLabelTwo = new JLabel("Unit to");
		lengthComboBoxTwo = new JComboBox<String>(lengthChoices);
		lengthFieldTwo = new JTextField(10);
		lengthFieldTwo.setEditable(false);
		lengthUnitFieldTwo = new JTextField(4);
		lengthUnitFieldTwo.setEditable(false);

		lengthPanelOne.add(lengthLabelOne);
		lengthPanelOne.add(lengthComboBoxOne);
		lengthPanelOne.add(lengthFieldOne);
		lengthPanelOne.add(lengthUnitFieldOne);
		lengthPanelOne.add(lengthConvertButton);
		lengthPanelOne.setLayout(new FlowLayout());

		lengthPanelTwo.add(lengthLabelTwo);
		lengthPanelTwo.add(lengthComboBoxTwo);
		lengthPanelTwo.add(lengthFieldTwo);
		lengthPanelTwo.add(lengthUnitFieldTwo);
		lengthPanelTwo.setLayout(new FlowLayout());

		lengthPanel.add(lengthPanelOne);
		lengthPanel.add(lengthPanelTwo);
		lengthPanel.setLayout(new GridLayout(2, 1, 2, 2));
	}

	public void createMassPanel() {
		massPanel = new JPanel();

		massPanelOne = new JPanel();
		massLabelOne = new JLabel("Unit from");
		massComboBoxOne = new JComboBox<String>(massChoices);
		massFieldOne = new JTextField(10);
		massFieldOne.setEditable(false);
		massUnitFieldOne = new JTextField(4);
		massUnitFieldOne.setEditable(false);
		massConvertButton = new JButton("convert");

		massPanelTwo = new JPanel();
		massLabelTwo = new JLabel("Unit to");
		massComboBoxTwo = new JComboBox<String>(massChoices);
		massFieldTwo = new JTextField(10);
		massFieldTwo.setEditable(false);
		massUnitFieldTwo = new JTextField(4);
		massUnitFieldTwo.setEditable(false);

		massPanelOne.add(massLabelOne);
		massPanelOne.add(massComboBoxOne);
		massPanelOne.add(massFieldOne);
		massPanelOne.add(massUnitFieldOne);
		massPanelOne.add(massConvertButton);
		massPanelOne.setLayout(new FlowLayout());

		massPanelTwo.add(massLabelTwo);
		massPanelTwo.add(massComboBoxTwo);
		massPanelTwo.add(massFieldTwo);
		massPanelTwo.add(massUnitFieldTwo);
		massPanelTwo.setLayout(new FlowLayout());

		massPanel.add(massPanelOne);
		massPanel.add(massPanelTwo);
		massPanel.setLayout(new GridLayout(2, 1, 2, 2));
	}

	public void createTemperaturePanel() {
		temperaturePanel = new JPanel();

		temperaturePanelOne = new JPanel();
		temperatureLabelOne = new JLabel("Unit from");
		temperatureComboBoxOne = new JComboBox<String>(temperatureChoices);
		temperatureFieldOne = new JTextField(10);
		temperatureFieldOne.setEditable(false);
		temperatureUnitFieldOne = new JTextField(4);
		temperatureUnitFieldOne.setEditable(false);
		temperatureConvertButton = new JButton("convert");

		temperaturePanelTwo = new JPanel();
		temperatureLabelTwo = new JLabel("Unit to");
		temperatureComboBoxTwo = new JComboBox<String>(temperatureChoices);
		temperatureFieldTwo = new JTextField(10);
		temperatureFieldTwo.setEditable(false);
		temperatureUnitFieldTwo = new JTextField(4);
		temperatureUnitFieldTwo.setEditable(false);

		temperaturePanelOne.add(temperatureLabelOne);
		temperaturePanelOne.add(temperatureComboBoxOne);
		temperaturePanelOne.add(temperatureFieldOne);
		temperaturePanelOne.add(temperatureUnitFieldOne);
		temperaturePanelOne.add(temperatureConvertButton);
		temperaturePanelOne.setLayout(new FlowLayout());

		temperaturePanelTwo.add(temperatureLabelTwo);
		temperaturePanelTwo.add(temperatureComboBoxTwo);
		temperaturePanelTwo.add(temperatureFieldTwo);
		temperaturePanelTwo.add(temperatureUnitFieldTwo);
		temperaturePanelTwo.setLayout(new FlowLayout());

		temperaturePanel.add(temperaturePanelOne);
		temperaturePanel.add(temperaturePanelTwo);
		temperaturePanel.setLayout(new GridLayout(2, 1, 2, 2));
	}

	public void createVolumePanel() {
		volumePanel = new JPanel();

		volumePanelOne = new JPanel();
		volumeLabelOne = new JLabel("Unit from");
		volumeComboBoxOne = new JComboBox<String>(volumeChoices);
		volumeFieldOne = new JTextField(10);
		volumeFieldOne.setEditable(false);
		volumeUnitFieldOne = new JTextField(4);
		volumeUnitFieldOne.setEditable(false);
		volumeConvertButton = new JButton("convert");

		volumePanelTwo = new JPanel();
		volumeLabelTwo = new JLabel("Unit to");
		volumeComboBoxTwo = new JComboBox<String>(volumeChoices);
		volumeFieldTwo = new JTextField(10);
		volumeFieldTwo.setEditable(false);
		volumeUnitFieldTwo = new JTextField(4);
		volumeUnitFieldTwo.setEditable(false);

		volumePanelOne.add(volumeLabelOne);
		volumePanelOne.add(volumeComboBoxOne);
		volumePanelOne.add(volumeFieldOne);
		volumePanelOne.add(volumeUnitFieldOne);
		volumePanelOne.add(volumeConvertButton);
		volumePanelOne.setLayout(new FlowLayout());

		volumePanelTwo.add(volumeLabelTwo);
		volumePanelTwo.add(volumeComboBoxTwo);
		volumePanelTwo.add(volumeFieldTwo);
		volumePanelTwo.add(volumeUnitFieldTwo);
		volumePanelTwo.setLayout(new FlowLayout());

		volumePanel.add(volumePanelOne);
		volumePanel.add(volumePanelTwo);
		volumePanel.setLayout(new GridLayout(2, 1, 2, 2));
	}

	public void createFirstPanel() {
		firstPanel = new JPanel();
		selectionLabel = new JLabel("select measurement");
		proceedButton = new JButton("proceed");
		buttonGroup = new ButtonGroup();
		areaRadioButton = new JRadioButton("Area");
		dataRadioButton = new JRadioButton("Data");
		lengthRadioButton = new JRadioButton("Length");
		massRadioButton = new JRadioButton("Mass");
		temperatureRadioButton = new JRadioButton("Temperature");
		volumeRadioButton = new JRadioButton("Volume");

		buttonGroup.add(areaRadioButton);
		buttonGroup.add(dataRadioButton);
		buttonGroup.add(lengthRadioButton);
		buttonGroup.add(massRadioButton);
		buttonGroup.add(temperatureRadioButton);
		buttonGroup.add(volumeRadioButton);

		firstPanel.add(selectionLabel);
		firstPanel.add(areaRadioButton);
		firstPanel.add(dataRadioButton);
		firstPanel.add(lengthRadioButton);
		firstPanel.add(proceedButton);
		firstPanel.add(massRadioButton);
		firstPanel.add(temperatureRadioButton);
		firstPanel.add(volumeRadioButton);
		firstPanel.setLayout(new GridLayout(2, 4, 2, 2));
	}

	public void createDynamicPanel() {
		dynamicPanel = new JPanel();
	}

	public void createKeyBoardPanel() {
		keyBoardPanel = new JPanel();
		digitsButton = new JButton[10];
		for (int i = 0; i < digitsButton.length; i++) {
			digitsButton[i] = new JButton(String.valueOf(i));
		}
		decimalButton = new JButton(".");
		zeroesButton = new JButton("00");
		clearButton = new JButton("clear");
		clearAllButton = new JButton("clear all");
		closeButton = new JButton("close");

		keyBoardPanel.add(digitsButton[9]);
		keyBoardPanel.add(digitsButton[8]);
		keyBoardPanel.add(digitsButton[7]);
		keyBoardPanel.add(clearButton);
		keyBoardPanel.add(clearAllButton);
		keyBoardPanel.add(digitsButton[6]);
		keyBoardPanel.add(digitsButton[5]);
		keyBoardPanel.add(digitsButton[4]);
		keyBoardPanel.add(digitsButton[0]);
		keyBoardPanel.add(zeroesButton);
		keyBoardPanel.add(digitsButton[3]);
		keyBoardPanel.add(digitsButton[2]);
		keyBoardPanel.add(digitsButton[1]);
		keyBoardPanel.add(decimalButton);
		keyBoardPanel.add(closeButton);
		keyBoardPanel.setLayout(new GridLayout(3, 5, 2, 2));
	}

	public void createSecondPanel() {
		secondPanel = new JPanel();
		createDynamicPanel();
		createKeyBoardPanel();

		secondPanel.add(dynamicPanel);
		secondPanel.add(keyBoardPanel);
		secondPanel.setLayout(new GridLayout(2, 1, 5, 5));
	}

	public void createFrame() {
		frame = new JFrame("Converter");
		createFirstPanel();
		createSecondPanel();

		frame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		frame.add(firstPanel, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		frame.add(secondPanel, gbc);
	}

	public void addListeners() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();

		proceedButton.addActionListener(this);
		for (int i = 0; i < digitsButton.length; i++) {
			digitsButton[i].addActionListener(this);
		}
		decimalButton.addActionListener(this);
		zeroesButton.addActionListener(this);
		clearButton.addActionListener(this);
		clearAllButton.addActionListener(this);
		closeButton.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object object = e.getSource();

		if (object == closeButton) {
			actionOfCloseButton();
		} else if (object == proceedButton) {
			actionOfProceedButton();
		} else if (object == areaComboBoxOne || object == areaComboBoxTwo) {
			actionOfAreaComboBox(object);
		} else if (object == dataComboBoxOne || object == dataComboBoxTwo) {
			actionOfDataComboBox(object);
		} else if (object == lengthComboBoxOne || object == lengthComboBoxTwo) {
			actionOfLengthComboBox(object);
		} else if (object == massComboBoxOne || object == massComboBoxTwo) {
			actionOfMassComboBox(object);
		} else if (object == temperatureComboBoxOne || object == temperatureComboBoxTwo) {
			actionOfTemperatureComboBox(object);
		} else if (object == volumeComboBoxOne || object == volumeComboBoxTwo) {
			actionOfVolumeComboBox(object);
		} else if (object == clearButton || object == clearAllButton || object == decimalButton
				|| object == zeroesButton) {
			actionOfOtherButtons(object);
		} else if (object == areaConvertButton) {
			actionOfAreaConvertButton();
		} else if (object == dataConvertButton) {
			actionOfDataConvertButton();
		} else if (object == lengthConvertButton) {
			actionOfLengthConvertButton();
		} else if (object == massConvertButton) {
			actionOfMassConvertButton();
		} else if (object == temperatureConvertButton) {
			actionOfTemperatureConvertButton();
		} else if (object == volumeConvertButton) {
			actionOfVolumeConvertButton();
		} else {
			actionOfDigitsButton(object);
		}
	}

	public void actionOfCloseButton() {
		int response = JOptionPane.showConfirmDialog(frame, "Do you want to close converter?");
		if (response == JOptionPane.YES_OPTION) {
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.dispose();
		}
	}

	public void actionOfProceedButton() {
		dynamicPanel.removeAll();
		if (areaRadioButton.isSelected()) {
			createAreaPanel();
			dynamicPanel.add(areaPanel);
			areaConvertButton.addActionListener(this);
			areaComboBoxOne.addActionListener(this);
			areaComboBoxTwo.addActionListener(this);
		} else if (dataRadioButton.isSelected()) {
			createDataPanel();
			dynamicPanel.add(dataPanel);
			dataConvertButton.addActionListener(this);
			dataComboBoxOne.addActionListener(this);
			dataComboBoxTwo.addActionListener(this);
		} else if (lengthRadioButton.isSelected()) {
			createLengthPanel();
			dynamicPanel.add(lengthPanel);
			lengthConvertButton.addActionListener(this);
			lengthComboBoxOne.addActionListener(this);
			lengthComboBoxTwo.addActionListener(this);
		} else if (massRadioButton.isSelected()) {
			createMassPanel();
			dynamicPanel.add(massPanel);
			massConvertButton.addActionListener(this);
			massComboBoxOne.addActionListener(this);
			massComboBoxTwo.addActionListener(this);
		} else if (temperatureRadioButton.isSelected()) {
			createTemperaturePanel();
			dynamicPanel.add(temperaturePanel);
			temperatureConvertButton.addActionListener(this);
			temperatureComboBoxOne.addActionListener(this);
			temperatureComboBoxTwo.addActionListener(this);
		} else if (volumeRadioButton.isSelected()) {
			createVolumePanel();
			dynamicPanel.add(volumePanel);
			volumeConvertButton.addActionListener(this);
			volumeComboBoxOne.addActionListener(this);
			volumeComboBoxTwo.addActionListener(this);
		} else {
			JOptionPane.showMessageDialog(frame, "please choose a measurement to proceed");
		}
		frame.setVisible(true);
	}

	public void actionOfAreaComboBox(Object object) {
		if (object == areaComboBoxOne) {
			areaUnitFieldOne.setText(areaUnits[areaComboBoxOne.getSelectedIndex()]);
		} else if (object == areaComboBoxTwo) {
			areaUnitFieldTwo.setText(areaUnits[areaComboBoxTwo.getSelectedIndex()]);
		}
	}

	public void actionOfDataComboBox(Object object) {
		if (object == dataComboBoxOne) {
			dataUnitFieldOne.setText(dataUnits[dataComboBoxOne.getSelectedIndex()]);
		} else if (object == dataComboBoxTwo) {
			dataUnitFieldTwo.setText(dataUnits[dataComboBoxTwo.getSelectedIndex()]);
		}
	}

	public void actionOfLengthComboBox(Object object) {
		if (object == lengthComboBoxOne) {
			lengthUnitFieldOne.setText(lengthUnits[lengthComboBoxOne.getSelectedIndex()]);
		} else if (object == lengthComboBoxTwo) {
			lengthUnitFieldTwo.setText(lengthUnits[lengthComboBoxTwo.getSelectedIndex()]);
		}
	}

	public void actionOfMassComboBox(Object object) {
		if (object == massComboBoxOne) {
			massUnitFieldOne.setText(massUnits[massComboBoxOne.getSelectedIndex()]);
		} else if (object == massComboBoxTwo) {
			massUnitFieldTwo.setText(massUnits[massComboBoxTwo.getSelectedIndex()]);
		}
	}

	public void actionOfTemperatureComboBox(Object object) {
		if (object == temperatureComboBoxOne) {
			temperatureUnitFieldOne.setText(temperatureUnits[temperatureComboBoxOne.getSelectedIndex()]);
		} else if (object == temperatureComboBoxTwo) {
			temperatureUnitFieldTwo.setText(temperatureUnits[temperatureComboBoxTwo.getSelectedIndex()]);
		}
	}

	public void actionOfVolumeComboBox(Object object) {
		if (object == volumeComboBoxOne) {
			volumeUnitFieldOne.setText(volumeUnits[volumeComboBoxOne.getSelectedIndex()]);
		} else if (object == volumeComboBoxTwo) {
			volumeUnitFieldTwo.setText(volumeUnits[volumeComboBoxTwo.getSelectedIndex()]);
		}
	}

	public String getTextFromInputField() {
		String text = null;
		if (areaRadioButton.isSelected()) {
			text = areaFieldOne.getText();
		} else if (dataRadioButton.isSelected()) {
			text = dataFieldOne.getText();
		} else if (lengthRadioButton.isSelected()) {
			text = lengthFieldOne.getText();
		} else if (massRadioButton.isSelected()) {
			text = massFieldOne.getText();
		} else if (temperatureRadioButton.isSelected()) {
			text = temperatureFieldOne.getText();
		} else if (volumeRadioButton.isSelected()) {
			text = volumeFieldOne.getText();
		}
		return text;
	}

	public void setTextToInputField(String text) {
		if (areaRadioButton.isSelected()) {
			areaFieldOne.setText(text);
		} else if (dataRadioButton.isSelected()) {
			dataFieldOne.setText(text);
		} else if (lengthRadioButton.isSelected()) {
			lengthFieldOne.setText(text);
		} else if (massRadioButton.isSelected()) {
			massFieldOne.setText(text);
		} else if (temperatureRadioButton.isSelected()) {
			temperatureFieldOne.setText(text);
		} else if (volumeRadioButton.isSelected()) {
			volumeFieldOne.setText(text);
		}
	}

	public void actionOfOtherButtons(Object object) {
		StringBuilder text = new StringBuilder();
		text.append(getTextFromInputField());
		if (object == clearButton && text.length() > 0) {
			text.deleteCharAt(text.length() - 1);
		} else if (object == clearAllButton && text.length() > 0) {
			text.delete(0, text.length());
		} else if (object == decimalButton) {
			if (text.length() == 0) {
				text.append("0.");
			} else {
				if (!text.toString().contains(".")) {
					text.append(".");
				}
			}
		} else if (object == zeroesButton && text.length() > 0) {
			text.append("00");
		}
		setTextToInputField(text.toString());
	}

	public void actionOfAreaConvertButton() {
		conversion = new AreaConversion();
		int indexOne = -1, indexTwo = -1;
		try {
			indexOne = areaComboBoxOne.getSelectedIndex();
			indexTwo = areaComboBoxTwo.getSelectedIndex();

			if (indexOne > 0 && indexTwo > 0) {
				conversion.setConvertUnitFrom(areaChoices[indexOne]);
				conversion.setConvertUnitTo(areaChoices[indexTwo]);
				double value = Double.parseDouble(areaFieldOne.getText());
				conversion.setValue(value);
				conversion.convert();

				double convertedValue = conversion.getConvertedValue();
				if (Math.ceil(convertedValue) == Math.floor(convertedValue)) {
					int result = (int) convertedValue;
					areaFieldTwo.setText(String.valueOf(result));
				} else {
					areaFieldTwo.setText(String.valueOf(convertedValue));
				}
			} else {
				throw new Exception();
			}
		} catch (Exception exception) {
			if (indexOne <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert from");
			} else if (indexTwo <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert into");
			} else {
				JOptionPane.showMessageDialog(frame, "Please provide value to convert");
			}
		} finally {
			conversion = null;
		}
	}

	public void actionOfDataConvertButton() {
		conversion = new DataConversion();
		int indexOne = -1, indexTwo = -1;
		try {
			indexOne = dataComboBoxOne.getSelectedIndex();
			indexTwo = dataComboBoxTwo.getSelectedIndex();

			if (indexOne > 0 && indexTwo > 0) {
				conversion.setConvertUnitFrom(dataChoices[indexOne]);
				conversion.setConvertUnitTo(dataChoices[indexTwo]);
				double value = Double.parseDouble(dataFieldOne.getText());
				conversion.setValue(value);
				conversion.convert();

				double convertedValue = conversion.getConvertedValue();
				if (Math.ceil(convertedValue) == Math.floor(convertedValue)) {
					int result = (int) convertedValue;
					dataFieldTwo.setText(String.valueOf(result));
				} else {
					dataFieldTwo.setText(String.valueOf(convertedValue));
				}
			} else {
				throw new Exception();
			}
		} catch (Exception exception) {
			if (indexOne <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert from");
			} else if (indexTwo <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert into");
			} else {
				JOptionPane.showMessageDialog(frame, "Please provide value to convert");
			}
		} finally {
			conversion = null;
		}
	}

	public void actionOfLengthConvertButton() {
		conversion = new LengthConversion();
		int indexOne = -1, indexTwo = -1;
		try {
			indexOne = lengthComboBoxOne.getSelectedIndex();
			indexTwo = lengthComboBoxTwo.getSelectedIndex();

			if (indexOne > 0 && indexTwo > 0) {
				conversion.setConvertUnitFrom(lengthChoices[indexOne]);
				conversion.setConvertUnitTo(lengthChoices[indexTwo]);
				double value = Double.parseDouble(lengthFieldOne.getText());
				conversion.setValue(value);
				conversion.convert();

				double convertedValue = conversion.getConvertedValue();
				if (Math.ceil(convertedValue) == Math.floor(convertedValue)) {
					int result = (int) convertedValue;
					lengthFieldTwo.setText(String.valueOf(result));
				} else {
					lengthFieldTwo.setText(String.valueOf(convertedValue));
				}
			} else {
				throw new Exception();
			}
		} catch (Exception exception) {
			if (indexOne <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert from");
			} else if (indexTwo <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert into");
			} else {
				JOptionPane.showMessageDialog(frame, "Please provide value to convert");
			}
		} finally {
			conversion = null;
		}
	}

	public void actionOfMassConvertButton() {
		conversion = new MassConversion();
		int indexOne = -1, indexTwo = -1;
		try {
			indexOne = massComboBoxOne.getSelectedIndex();
			indexTwo = massComboBoxTwo.getSelectedIndex();

			if (indexOne > 0 && indexTwo > 0) {
				conversion.setConvertUnitFrom(massChoices[indexOne]);
				conversion.setConvertUnitTo(massChoices[indexTwo]);
				double value = Double.parseDouble(massFieldOne.getText());
				conversion.setValue(value);
				conversion.convert();

				double convertedValue = conversion.getConvertedValue();
				if (Math.ceil(convertedValue) == Math.floor(convertedValue)) {
					int result = (int) convertedValue;
					massFieldTwo.setText(String.valueOf(result));
				} else {
					massFieldTwo.setText(String.valueOf(convertedValue));
				}
			} else {
				throw new Exception();
			}
		} catch (Exception exception) {
			if (indexOne <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert from");
			} else if (indexTwo <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert into");
			} else {
				JOptionPane.showMessageDialog(frame, "Please provide value to convert");
			}
		} finally {
			conversion = null;
		}
	}

	public void actionOfTemperatureConvertButton() {
		conversion = new TemperatureConversion();
		int indexOne = -1, indexTwo = -1;
		try {
			indexOne = temperatureComboBoxOne.getSelectedIndex();
			indexTwo = temperatureComboBoxTwo.getSelectedIndex();

			if (indexOne > 0 && indexTwo > 0) {
				conversion.setConvertUnitFrom(temperatureChoices[indexOne]);
				conversion.setConvertUnitTo(temperatureChoices[indexTwo]);
				double value = Double.parseDouble(temperatureFieldOne.getText());
				conversion.setValue(value);
				conversion.convert();

				double convertedValue = conversion.getConvertedValue();
				if (Math.ceil(convertedValue) == Math.floor(convertedValue)) {
					int result = (int) convertedValue;
					temperatureFieldTwo.setText(String.valueOf(result));
				} else {
					temperatureFieldTwo.setText(String.valueOf(convertedValue));
				}
			} else {
				throw new Exception();
			}
		} catch (Exception exception) {
			if (indexOne <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert from");
			} else if (indexTwo <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert into");
			} else {
				JOptionPane.showMessageDialog(frame, "Please provide value to convert");
			}
		} finally {
			conversion = null;
		}
	}

	public void actionOfVolumeConvertButton() {
		conversion = new VolumeConversion();
		int indexOne = -1, indexTwo = -1;
		try {
			indexOne = volumeComboBoxOne.getSelectedIndex();
			indexTwo = volumeComboBoxTwo.getSelectedIndex();

			if (indexOne > 0 && indexTwo > 0) {
				conversion.setConvertUnitFrom(volumeChoices[indexOne]);
				conversion.setConvertUnitTo(volumeChoices[indexTwo]);
				double value = Double.parseDouble(volumeFieldOne.getText());
				conversion.setValue(value);
				conversion.convert();

				double convertedValue = conversion.getConvertedValue();
				if (Math.ceil(convertedValue) == Math.floor(convertedValue)) {
					int result = (int) convertedValue;
					volumeFieldTwo.setText(String.valueOf(result));
				} else {
					volumeFieldTwo.setText(String.valueOf(convertedValue));
				}
			} else {
				throw new Exception();
			}
		} catch (Exception exception) {
			if (indexOne <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert from");
			} else if (indexTwo <= 0) {
				JOptionPane.showMessageDialog(frame, "Please select unit to convert into");
			} else {
				JOptionPane.showMessageDialog(frame, "Please provide value to convert");
			}
		} finally {
			conversion = null;
		}
	}

	public void actionOfDigitsButton(Object object) {
		for (int i = 0; i < digitsButton.length; i++) {
			if (object == digitsButton[i]) {
				StringBuilder text = new StringBuilder();
				text.append(getTextFromInputField());
				if (text.length() == 0) {
					if (i != 0) {
						text.append(i);
					}
				} else {
					text.append(i);
				}
				setTextToInputField(text.toString());
			}
		}
	}
}
