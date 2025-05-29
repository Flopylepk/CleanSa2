package GUI;

import java.awt.EventQueue;
import BLL.*;
import DLL.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class compra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					compra frame = new compra();
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
	public compra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 479);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Compra");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(182, 69, 212, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(126, 110, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextPane txtpnEnEsteApartado = new JTextPane();
		txtpnEnEsteApartado.setBackground(SystemColor.controlShadow);
		txtpnEnEsteApartado.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtpnEnEsteApartado.setText("En este apartado podras realizar la compra y agregar lo productos al carrito");
		txtpnEnEsteApartado.setBounds(109, 171, 341, 62);
		contentPane.add(txtpnEnEsteApartado);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btnNewButton.setBounds(206, 302, 92, 43);
		contentPane.add(btnNewButton);
	}
}
