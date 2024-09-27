package aiub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form13 extends JFrame implements ActionListener {
    JLabel paymentLabel, methodLabel;
    JRadioButton bkashButton, nagadButton, rocketButton;
    ButtonGroup paymentGroup;
    JButton confirmButton;
    String firstName, lastName, phone, address, skillTrade;
    int totalCost;
    JLayeredPane layeredPane;
    JPanel panel;
    JLabel imageLabel;

    public Form13(String firstName, String lastName, String phone, String address, String skillTrade, int totalCost) {
        super("Payment Confirmation");

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.skillTrade = skillTrade;
        this.totalCost = totalCost;

        this.setSize(600, 477);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 477));

        // Load image
        ImageIcon imageIcon = new ImageIcon("E:\\JAVA programing\\OOPProject\\hand-holding-phone-with-digital-wallet-service-sending-money-payment-transaction-transfer-through-mobile-app-flat-illustration_74855-20589.jpg");
        if (imageIcon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            imageLabel = new JLabel(imageIcon);
        } else {
            System.out.println("Image not found or failed to load.");
            imageLabel = new JLabel("Image not found.");
        }
        imageLabel.setBounds(0, 0, 600, 477);
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 477);

        paymentLabel = new JLabel("<html>Total Cost for " + skillTrade + ": " + totalCost + " tk</html>");
        paymentLabel.setBounds(20, 20, 400, 30);
        paymentLabel.setForeground(Color.black);
        panel.add(paymentLabel);

        methodLabel = new JLabel("Select Payment Method:");
        methodLabel.setBounds(20, 70, 200, 30);
        methodLabel.setForeground(Color.black);  // Changed to white for visibility
        panel.add(methodLabel);

        // Create the radio buttons for bKash, Nagad, and Rocket
        bkashButton = new JRadioButton("bKash");
        nagadButton = new JRadioButton("Nagad");
        rocketButton = new JRadioButton("Rocket");
        
        bkashButton.setBounds(20, 120, 100, 30);
        nagadButton.setBounds(140, 120, 100, 30);
        rocketButton.setBounds(260, 120, 100, 30);

        // Add the radio buttons to a ButtonGroup to allow only one selection
        paymentGroup = new ButtonGroup();
        paymentGroup.add(bkashButton);
        paymentGroup.add(nagadButton);
        paymentGroup.add(rocketButton);

        // Add the radio buttons to the panel
        panel.add(bkashButton);
        panel.add(nagadButton);
        panel.add(rocketButton);

        // Add a confirm button
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(20, 170, 100, 30);
        confirmButton.addActionListener(this);
        panel.add(confirmButton);

        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);
        this.add(layeredPane); // Add the layeredPane to the JFrame
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String selectedPayment = "";

        // Check which radio button is selected
        if (bkashButton.isSelected()) {
            selectedPayment = "bKash";
        } else if (nagadButton.isSelected()) {
            selectedPayment = "Nagad";
        } else if (rocketButton.isSelected()) {
            selectedPayment = "Rocket";
        } else {
            // Show an error if no option is selected
            JOptionPane.showMessageDialog(this, "Please select a payment method", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Open Form11 for payment confirmation with the selected payment method
        new Form11(firstName, lastName, phone, address, skillTrade, selectedPayment, totalCost);
        this.dispose(); // Close Form13 after selecting payment
    }

    public static void main(String[] args) {
        // Test Form13 independently
        new Form13("John", "Doe", "1234567890", "123 Main St", "Guitarist", 5000);
    }
}
