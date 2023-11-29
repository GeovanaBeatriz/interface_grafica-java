package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela1 {

	private JFrame frame;
	private JTextField num2;
	private JTextField num1;
	private JTextField resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela1 window = new Tela1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Soma números");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(108, 11, 203, 38);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Número 1:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(34, 76, 92, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Número 2:\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(34, 120, 92, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Resultado:\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(34, 157, 92, 38);
		frame.getContentPane().add(lblNewLabel_3);
		
		num2 = new JTextField();
		num2.setBounds(123, 128, 86, 20);
		frame.getContentPane().add(num2);
		num2.setColumns(10);
		
		num1 = new JTextField();
		num1.setBounds(123, 88, 86, 20);
		frame.getContentPane().add(num1);
		num1.setColumns(10);
		
		resultado = new JTextField();
		resultado.setEditable(false);
		resultado.setBounds(123, 169, 86, 20);
		frame.getContentPane().add(resultado);
		resultado.setColumns(10);
		
		JButton somar = new JButton("Somar\r\n");
		somar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float numero1, numero2, res;
				
				numero1=Float.parseFloat(num1.getText());
				numero2=Float.parseFloat(num2.getText());
				
				res = numero1+numero2;
				
				resultado.setText(String.valueOf(res));
			}
		});
		somar.setBounds(34, 214, 89, 23);
		frame.getContentPane().add(somar);
		
		JButton limpar = new JButton("Limpar\r\n");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1.setText("");
				num2.setText("");
				resultado.setText("");
				
			}
		});
		limpar.setBounds(181, 214, 89, 23);
		frame.getContentPane().add(limpar);
		
		JButton sair = new JButton("Sair\r\n");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		sair.setBounds(318, 214, 89, 23);
		frame.getContentPane().add(sair);
	}

}
