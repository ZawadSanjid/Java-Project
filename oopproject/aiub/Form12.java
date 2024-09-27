package aiub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form12 extends JFrame implements ActionListener {
    JLabel receiptLabel, nameLabel, phoneLabel, addressLabel, skillTradeLabel;
    JButton repurchaseButton, exitButton, confirmButton;
    JPanel panel;
    String firstName, lastName, phone, address, skillTrade, totalCost, selectedPayment;
    JLayeredPane layeredPane;
    JLabel imageLabel;

    public Form12(String firstName, String lastName, String phone, String address, String skillTrade, String totalCost, String selectedPayment) {
        super("Receipt");

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.skillTrade = skillTrade;
        this.totalCost = totalCost;
        this.selectedPayment = selectedPayment;

        this.setSize(747, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(747, 500));

        ImageIcon imageIcon = new ImageIcon("E:\\JAVA programing\\OOPProject\\3d-pay-money-mobile-phone-260nw-2145447033.jpg");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 747, 500);
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(0, 0, 747, 500);

        receiptLabel = new JLabel("<html><b>Congratulations, your purchase has succeeded!</b></html>");
        receiptLabel.setBounds(100, 20, 400, 30);
        panel.add(receiptLabel);

        nameLabel = new JLabel("Name: " + firstName + " " + lastName);
        nameLabel.setBounds(50, 70, 400, 30);
        panel.add(nameLabel);

        phoneLabel = new JLabel("Phone Number: " + phone);
        phoneLabel.setBounds(50, 110, 400, 30);
        panel.add(phoneLabel);

        addressLabel = new JLabel("Address: " + address);
        addressLabel.setBounds(50, 150, 400, 30);
        panel.add(addressLabel);

        skillTradeLabel = new JLabel("Skill Trade: " + skillTrade + " - " + totalCost + " taka paid with " + selectedPayment);
        skillTradeLabel.setBounds(50, 190, 400, 30);
        panel.add(skillTradeLabel);

        // Adding Confirm Button
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(100, 250, 120, 30);
        confirmButton.addActionListener(this);
        panel.add(confirmButton);

        repurchaseButton = new JButton("Repurchase");
        repurchaseButton.setBounds(100, 300, 120, 30);
        repurchaseButton.addActionListener(this);
        panel.add(repurchaseButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(250, 300, 120, 30);
        exitButton.addActionListener(this);
        panel.add(exitButton);

        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);
        this.add(layeredPane); // Add the layeredPane to the JFrame
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == confirmButton) {
            // Display message when Confirm is clicked
            JOptionPane.showMessageDialog(this, "Congratulations You Have Traded Your Skill Successfully.\nTo Repurchase Again Click Repurchase Button.");
        } else if (ae.getSource() == repurchaseButton) {
            // Open Form10 for a new purchase
            new Form10(firstName, lastName, phone, address);
            this.dispose(); // Close Form12 after opening Form10
        } else if (ae.getSource() == exitButton) {
            // Exit the application
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        // Test Form12 independently with example data
        String firstName = "John";
        String lastName = "Doe";
        String phone = "1234567890";
        String address = "123 Main St";
        String skillTrade = "Guitar Lesson";
        String totalCost = "5000";
        String selectedPayment = "bKash";
        
        new Form12(firstName, lastName, phone, address, skillTrade, totalCost, selectedPayment);
    }
}
