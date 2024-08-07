package veiw;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(49, 62, 64));
		contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(73, 27, 301, 209);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IMNconcursos");
		lblNewLabel.setBounds(84, 0, 141, 37);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 70, 78, 21);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Disciplina");
		lblNewLabel_1.setBounds(10, 54, 45, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Assunto");
		lblNewLabel_1_1.setBounds(98, 55, 45, 13);
		panel.add(lblNewLabel_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(98, 70, 78, 21);
		panel.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(186, 70, 78, 21);
		panel.add(comboBox_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Banca");
		lblNewLabel_1_1_1.setBounds(186, 55, 45, 13);
		panel.add(lblNewLabel_1_1_1);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setBounds(10, 116, 78, 21);
		panel.add(comboBox_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Orgão");
		lblNewLabel_1_1_2.setBounds(10, 101, 45, 13);
		panel.add(lblNewLabel_1_1_2);
		
		JComboBox comboBox_1_3 = new JComboBox();
		comboBox_1_3.setBounds(98, 116, 78, 21);
		panel.add(comboBox_1_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Ano");
		lblNewLabel_1_1_3.setBounds(98, 101, 45, 13);
		panel.add(lblNewLabel_1_1_3);
		
		JComboBox comboBox_1_4 = new JComboBox();
		comboBox_1_4.setBounds(186, 116, 78, 21);
		panel.add(comboBox_1_4);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Estado");
		lblNewLabel_1_1_4.setBounds(186, 101, 45, 13);
		panel.add(lblNewLabel_1_1_4);
		
		JComboBox comboBox_1_5 = new JComboBox();
		comboBox_1_5.setBounds(65, 164, 78, 21);
		panel.add(comboBox_1_5);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Nível");
		lblNewLabel_1_1_5.setBounds(65, 149, 45, 13);
		panel.add(lblNewLabel_1_1_5);
		
		JComboBox comboBox_1_6 = new JComboBox();
		comboBox_1_6.setBounds(153, 164, 78, 21);
		panel.add(comboBox_1_6);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("Cargo");
		lblNewLabel_1_1_6.setBounds(153, 149, 45, 13);
		panel.add(lblNewLabel_1_1_6);
		
		JButton btnNewButton = new JButton("Adm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLoginAdm jloginadm = new JLoginAdm();
				jloginadm.setVisible(true);
			}
		});
		btnNewButton.setBounds(232, 11, 59, 21);
		panel.add(btnNewButton);
	}
}
