package aiub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Form7 extends JFrame implements ActionListener {
    JButton closeButton;
    JPanel panel;
    JLayeredPane layeredPane;
    JLabel imageLabel;

    public Form7() {
        super("Cooking Skill Upgrade");

        this.setSize(650, 420); // Set size to 650x400
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the frame on the screen

        // Create and configure layered pane
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(650, 400));

        // Create and configure the image label
        ImageIcon imageIcon = new ImageIcon("E:\\JAVA programing\\OOPProject\\c1179485-4734-486c-8e32-0da1752b2b73.jpg");
        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 650, 400); // Set the image dimensions

        // Add the image label to the layered pane
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);

        // Create and configure panel
        panel = new JPanel();
        panel.setOpaque(false); // Make the panel transparent
        panel.setLayout(null); // Use null layout
        panel.setBounds(0, 0, 650, 400); // Cover the whole area

        // Add text label
        JLabel infoLabel = new JLabel("<html><h3 style='color:white;'>Your Cooking Skill Has Been Upgraded!</h3></html>");
        infoLabel.setBounds(20, -10, 600, 100);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text
        panel.add(infoLabel);

        // Text area for relaxation techniques
        JTextArea relaxationTechniques = new JTextArea();
        relaxationTechniques.setText("Cooking Special Techniques:\n\n"
            + "1. Searing: Quickly brown meat at high heat to lock in flavor.\n"
            + "2. Deglazing: Add liquid to a hot pan to release flavorful bits.\n"
            + "3. Blanching: Boil vegetables briefly, then immerse in ice water.\n"
            + "4. Braising: Slow-cook meat or vegetables in liquid for tenderness.\n"
            + "5. Poaching: Gently cook food in simmering liquid to retain moisture.\n"
            + "6. Reduction: Simmer liquids to concentrate flavor.\n"
            + "7. Sous Vide: Cook food in a vacuum-sealed bag in low-temperature water.\n"
            + "8. Fermenting: Use natural fermentation to preserve and flavor food.\n"
            + "9. Caramelization: Heat sugars to create a rich, sweet flavor.\n"
            + "10. Emulsifying: Mix liquids that usually separate, like oil and vinegar.");
        relaxationTechniques.setBounds(20, 130, 600, 200);
        relaxationTechniques.setLineWrap(true);
        relaxationTechniques.setWrapStyleWord(true);
        relaxationTechniques.setBackground(new Color(0, 0, 0, 0)); // Make background transparent
        relaxationTechniques.setForeground(Color.WHITE); // Set text color to white
        relaxationTechniques.setEditable(false); // Make it non-editable
        panel.add(relaxationTechniques);

        // Close button
        closeButton = new JButton("Close");
        closeButton.setBounds(250, 340, 150, 30); // Adjusted position
        closeButton.setForeground(Color.BLACK); // Black font color
        closeButton.setBackground(Color.WHITE); // White background color
        closeButton.addActionListener(this);
        panel.add(closeButton);

        // Add the panel to the layered pane
        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER); // Add panel on top of the image

        // Add layered pane to frame
        this.add(layeredPane);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        this.dispose(); // Close the form
    }

    public static void main(String[] args) {
        new Form7(); // For testing the Form7 independently
    }
}
