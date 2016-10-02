package com.yy.pattern.client;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import com.yy.pattern.facade.CustomerFacade;

public class UserGUI extends JFrame {
    private JScrollPane dataPane, usrPane;
    private JSplitPane  splitPane;
    private JPanel usrInfoPanel;
    private JTextArea  txtAreaData;
    private Dimension   minimumSize;

    private JComboBox cmbCardType;
    private JTextField txtFirstName, txtLastName, txtAddress,
                                  txtCity, txtState,txtZipCode, txtCardNumber;
    private JLabel lblCardType;
    private JLabel lblFirstName, lblLastName;
    private JLabel lblAddress, lblCity, lblState,lblZipCode;
    private JLabel lblCardNumber;

    public static final String SUBMIT = "Submit";
	public static final String EXIT = "Exit";
	public static final String VISA = "Visa";
	public static final String DISCOVER = "Discover";
	public static final String MASTER = "Master";
    public static final String VALIDCARD = "Valid Card";

    public UserGUI(){
	      super(" Facade Pattern - validation of user info ");
          minimumSize = new Dimension(130, 100);
          setUpChoicePanel();
          setUpScrollPanes();
    }

    private void setUpChoicePanel(){
		  usrInfoPanel = new JPanel();
		  usrInfoPanel.setBackground(Color.gray);
		  cmbCardType = new JComboBox();
		  cmbCardType.addItem(VISA);
		  cmbCardType.addItem(MASTER);
		  cmbCardType.addItem(DISCOVER);

		  txtFirstName = new JTextField(20);
		  txtLastName = new JTextField(20);
		  txtAddress = new JTextField(20);
		  txtCity = new JTextField(20);
		  txtState = new JTextField(20);
		  txtZipCode=new JTextField(20);
		  txtCardNumber = new JTextField(20);

		  lblCardType = new JLabel("Card Type:");
		  lblFirstName = new JLabel("First Name:");
		  lblLastName = new JLabel("Last Name:");
		  lblAddress = new JLabel("Address:");
		  lblCity = new JLabel("City:");
		  lblState = new JLabel("State:");
		  lblZipCode=new JLabel("Zip code:");
		  lblCardNumber = new JLabel("Card Number:");

		  //Create the open button
		  JButton validateSaveButton =new JButton(SUBMIT);
		  validateSaveButton.setMnemonic(KeyEvent.VK_V);
		  JButton exitButton = new JButton(EXIT);
		  exitButton.setMnemonic(KeyEvent.VK_X);
		  ButtonHandler objButtonHandler = new ButtonHandler(this);
		  validateSaveButton.addActionListener(objButtonHandler);
		  exitButton.addActionListener(new ButtonHandler());

		  //For layout purposes, put the buttons in a separate panel
		  JPanel buttonPanel = new JPanel();
		  //****************************************************
		  GridBagLayout gridbag = new GridBagLayout();
		  usrInfoPanel.setLayout(gridbag);
		  GridBagConstraints gbc = new GridBagConstraints();
		  gbc.anchor = GridBagConstraints.WEST;

		  usrInfoPanel.add(lblCardType);
		  usrInfoPanel.add(cmbCardType);
		  usrInfoPanel.add(lblFirstName);
		  usrInfoPanel.add(txtFirstName);
		  usrInfoPanel.add(lblLastName);
		  usrInfoPanel.add(txtLastName);
		  usrInfoPanel.add(lblAddress);
		  usrInfoPanel.add(txtAddress);
		  usrInfoPanel.add(lblCity);
		  usrInfoPanel.add(txtCity);
		  usrInfoPanel.add(lblState);
		  usrInfoPanel.add(txtState);
		  usrInfoPanel.add(lblZipCode);
		  usrInfoPanel.add(txtZipCode);
		  usrInfoPanel.add(lblCardNumber);
		  usrInfoPanel.add(txtCardNumber);
		  usrInfoPanel.add(validateSaveButton);
		  usrInfoPanel.add(exitButton);

		  gbc.insets.top = 6;
		  gbc.insets.bottom = 6;
		  gbc.insets.left = 6;
		  gbc.insets.right = 6;

		  gbc.gridx = 0;
		  gbc.gridy = 0;
		  gridbag.setConstraints(lblFirstName, gbc);
		  gbc.gridx = 1;
		  gbc.gridy = 0;
		  gridbag.setConstraints(txtFirstName, gbc);
		  gbc.gridx = 0;
		  gbc.gridy = 1;
		  gridbag.setConstraints(lblLastName, gbc);
		  gbc.gridx = 1;
		  gbc.gridy = 1;
		  gridbag.setConstraints(txtLastName, gbc);

		  gbc.gridx = 0;
		  gbc.gridy = 2;
		  gridbag.setConstraints(lblAddress, gbc);
		  gbc.gridx = 1;
		  gbc.gridy = 2;
		  gridbag.setConstraints(txtAddress, gbc);
		  gbc.gridx = 0;
		  gbc.gridy = 3;
		  gridbag.setConstraints(lblCity, gbc);
		  gbc.gridx = 1;
		  gbc.gridy = 3;
		  gridbag.setConstraints(txtCity, gbc);
		  gbc.gridx = 0;
		  gbc.gridy = 4;
		  gridbag.setConstraints(lblState, gbc);
		  gbc.gridx = 1;
		  gbc.gridy = 4;
		  gridbag.setConstraints(txtState, gbc);
		  
		  gbc.gridx=0;
		  gbc.gridy=5;
		  gridbag.setConstraints(lblZipCode, gbc);
		  gbc.gridx=1;
		  gbc.gridy=5;
          gridbag.setConstraints(txtZipCode, gbc);
		  
		  gbc.gridx = 0;
		  gbc.gridy = 6;
		  gridbag.setConstraints(lblCardType, gbc);
		  gbc.gridx = 1;
		  gbc.gridy = 6;
		  gridbag.setConstraints(cmbCardType, gbc);
		  gbc.gridx = 0;
		  gbc.gridy = 7;
		  gridbag.setConstraints(lblCardNumber, gbc);
		  gbc.gridx = 1;
		  gbc.gridy = 7;
		  gridbag.setConstraints(txtCardNumber, gbc);

		  gbc.insets.left = 2;
		  gbc.insets.right = 2;
		  gbc.insets.top = 40;
		  gbc.anchor = GridBagConstraints.EAST;
		  gbc.gridx = 0;
		  gbc.gridy = 10;
		  gridbag.setConstraints(validateSaveButton, gbc);
		  gbc.anchor = GridBagConstraints.WEST;
		  gbc.gridx = 1;
		  gbc.gridy = 10;
		  gridbag.setConstraints(exitButton, gbc);
  }

   // All the scroll panes are set up
   private void setUpScrollPanes(){
		  txtAreaData = new JTextArea(3,10);
		  txtAreaData.setLineWrap(true);
	      dataPane = new JScrollPane(txtAreaData);
	      dataPane.setMinimumSize(minimumSize);

	      usrPane = new JScrollPane(usrInfoPanel);
	      usrPane.getViewport().setBackground(Color.green);

	      splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	      splitPane.setLeftComponent(usrPane);
	      splitPane.setRightComponent(dataPane);
	      splitPane.setDividerLocation(300);
	      splitPane.setPreferredSize(new Dimension(500, 200));

	      getContentPane().add(splitPane);
	      setSize(new Dimension(500, 200));
	      setVisible(true);
    }
    public String getFirstName() {
          return txtFirstName.getText();
    }
    public String getLastName() {
          return txtLastName.getText();
    }
    public String getAddress() {
          return txtAddress.getText();
    }
    public String getCity() {
          return txtCity.getText();
    }
    public String getAddrState() {
          return txtState.getText();
    }
    public String getZipCode(){
    	return txtZipCode.getText();
    }
    
    public String getCardNumber() {
          return txtCardNumber.getText();
    }
    public String getCardType() {
          return (String) cmbCardType.getSelectedItem();
    }
    public void setResultDisplay(String msg) {
          txtAreaData.setText(msg);
    }

    public static void main(String args[]){
		  try {
			   UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		  }
		  catch (Exception evt) {}

		  UserGUI frame = new UserGUI();
		  frame.addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent e){
			System.exit(0);
		  } });
		  frame.setSize(500, 400);
		  frame.setVisible(true);
    }
}

class ButtonHandler implements ActionListener {
	      UserGUI objClientGUI;
	      public void actionPerformed(ActionEvent e) {
		  String validationResult = null;

		  if (e.getActionCommand().equals(UserGUI.EXIT)) {
		       System.exit(1);
		  }
		  if (e.getActionCommand().equals(UserGUI.SUBMIT)) {
				  //get input values
				  String firstName = objClientGUI.getFirstName();
				  String lastName = objClientGUI.getLastName();
				  String address = objClientGUI.getAddress();
				  String city = objClientGUI.getCity();
				  String state = objClientGUI.getAddrState();
				  String zipCode=objClientGUI.getZipCode();
				  String cardType = objClientGUI.getCardType();
				  String cardNumber = objClientGUI.getCardNumber();
				  

				  // Create a facade instance
				  CustomerFacade facade = new CustomerFacade();
				  facade.setFName(firstName);
				  facade.setLName(lastName);
				  facade.setAddress(address);
				  facade.setCity(city);
				  facade.setState(state);
				  facade.setZipCode(zipCode);
				  facade.setCardType(cardType);
				  facade.setCardNumber(cardNumber);

				  //Client is not required to access subsystem components.
				  boolean result = facade.saveCustomerData();
				  String[] msg = facade.getErrorMsg();
				  if (result) {
					validationResult = msg[0]+msg[1]+msg[2]+
					  "\nValid user info format: Data Saved Successfully ";
		  }
		  else {
			      validationResult = msg[0]+msg[1]+msg[2]+
			                                  "\nInvalid user info format: Data was dropped ";
		  }
		  objClientGUI.setResultDisplay(
		  validationResult);
		}
	  }
	  public ButtonHandler() {
	  }
	  public ButtonHandler(UserGUI inobjClientGUI) {
		objClientGUI = inobjClientGUI;
	  }
} // End of class ButtonHandler

