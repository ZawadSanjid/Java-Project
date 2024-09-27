package aiub;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Form3 extends JFrame implements ActionListener {
    JLabel welcomeLabel, usernameLabel, passwordLabel;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton signInButton, signUpButton;
    JLayeredPane layeredPane;
    JPanel contentPanel;

    private Map<String, String> userCredentials = new HashMap<>();
    private Map<String, String[]> userDetails = new HashMap<>();

    public Form3() {
        super("Login Page");

        this.setSize(600, 375);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(600, 375));

        contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setBounds(0, 0, 600, 375);
        contentPanel.setLayout(null);

        ImageIcon imageIcon = new ImageIcon("E:\\JAVA programing\\OOPProject\\85398dca-81f8-495d-b9f8-299a158b57c8.jpeg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());

        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(contentPanel, JLayeredPane.PALETTE_LAYER);

        welcomeLabel = new JLabel("Welcome To Skill Swap Network");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setBounds(100, 30, 400, 40);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(welcomeLabel);

        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        usernameLabel.setForeground(Color.white);
        usernameLabel.setBounds(100, 80, 150, 20);
        contentPanel.add(usernameLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        passwordLabel.setForeground(Color.white);
        passwordLabel.setBounds(100, 120, 150, 20);
        contentPanel.add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setBounds(220, 80, 150, 25);
        contentPanel.add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(220, 120, 150, 25);
        contentPanel.add(passwordField);

        signInButton = new JButton("Sign In");
        signInButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        signInButton.setForeground(Color.white);
        signInButton.setBackground(new Color(0, 128, 0));
        signInButton.setBounds(130, 180, 100, 25);
        signInButton.addActionListener(this);
        contentPanel.add(signInButton);

        signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        signUpButton.setForeground(Color.white);
        signUpButton.setBackground(new Color(0, 128, 0));
        signUpButton.setBounds(250, 180, 100, 25);
        signUpButton.addActionListener(this);
        contentPanel.add(signUpButton);

        this.add(layeredPane);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        // For testing, add a hardcoded user
        addUser("testuser", "testpassword", new String[]{"testpassword", "Test", "User", "01234567890", "Test Address"});
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signUpButton) {
            Form4 signUpForm = new Form4(this);
            signUpForm.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == signInButton) {
            String enteredUsername = usernameField.getText();
            String enteredPassword = new String(passwordField.getPassword());

            if (userCredentials.containsKey(enteredUsername) && userCredentials.get(enteredUsername).equals(enteredPassword)) {
                String[] details = userDetails.get(enteredUsername);
                String firstName = details[1];
                String lastName = details[2];
                String phone = details[3];
                String address = details[4];

                Form5 skillsForm = new Form5(firstName, lastName, phone, address);
                skillsForm.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void addUser(String username, String password, String[] details) {
        userCredentials.put(username, password);
        userDetails.put(username, details);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Form3());
    }
}
