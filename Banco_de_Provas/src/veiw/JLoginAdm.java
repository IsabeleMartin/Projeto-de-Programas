package veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Criptografia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JLoginAdm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JLoginAdm frame = new JLoginAdm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JLoginAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		lblNewLabel.setBounds(199, 0, 105, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setBounds(40, 53, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(40, 68, 201, 19);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setBounds(40, 121, 45, 13);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(40, 144, 201, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Criptografia criptografia = new Criptografia(passwordField.getText(),Criptografia.MD5);
				System.out.println(criptografia.criptografar());
				if(textFieldUser.getText()!=null && 
				   !textFieldUser.getText().isEmpty() &&
				   passwordField.getText()!=null &&
				   !passwordField.getText().isEmpty()) {
					
					if(criptografia.criptografar().equals("827CCB0EEA8A706C4C34A16891F84E7B")) {
						dispose();					
					
						AdmProvas jadmprovas = new AdmProvas();
						jadmprovas.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(btnNewButton, "Informações inválidas","Avisos", JOptionPane.WARNING_MESSAGE);

					}
										
					
					
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "Campo de informações vazio","Avisos", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(206, 201, 85, 21);
		contentPane.add(btnNewButton);
	}
}
