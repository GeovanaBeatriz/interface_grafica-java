package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela1 {

	private JFrame frame;
	private JTextField nome;
	private JTextField peso;
	private JTextField altura;
	private JTextField mensagem;

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
		
		JLabel lblNewLabel = new JLabel("Indice de Massa Corporal (IMC)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(78, -24, 391, 116);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(22, 84, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		nome = new JTextField();
		nome.setBounds(88, 81, 336, 20);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Peso:");
		lblNewLabel_2.setBounds(22, 119, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Altura:");
		lblNewLabel_3.setBounds(22, 152, 56, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		peso = new JTextField();
		peso.setBounds(88, 112, 86, 20);
		frame.getContentPane().add(peso);
		peso.setColumns(10);
		
		altura = new JTextField();
		altura.setBounds(88, 149, 86, 20);
		frame.getContentPane().add(altura);
		altura.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Mensagem:");
		lblNewLabel_4.setBounds(22, 200, 72, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		mensagem = new JTextField();
		mensagem.setBackground(new Color(234, 234, 234));
		mensagem.setForeground(new Color(0, 0, 0));
		mensagem.setEditable(false);
		mensagem.setBounds(88, 197, 336, 20);
		frame.getContentPane().add(mensagem);
		mensagem.setColumns(10);
		
		JButton calcular = new JButton("Calcular");
		calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float pesoimc, alturaimc, imc;
				
				pesoimc=Float.parseFloat(peso.getText());
				alturaimc=Float.parseFloat(altura.getText());
				
				imc = pesoimc/(alturaimc*alturaimc);
				
				String nomeField = nome.getText();
				
				if(imc < 16.9) {
					mensagem.setText(String.valueOf(nomeField + " seu IMC é " +  imc + " e você está muito abaixo do peso."));
				}
				else if(imc == 17.0 || imc <= 18.4) {
					mensagem.setText(String.valueOf(nomeField + " seu IMC é " +  imc + " e você está abaixo do peso."));
				}
				else if(imc == 18.5 || imc <= 24.9) {
					mensagem.setText(String.valueOf(nomeField + " seu IMC é " +  imc + " e você está no peso normal."));
				}
				else if(imc == 25.0 || imc <= 29.9) {
					mensagem.setText(String.valueOf(nomeField + " seu IMC é " +  imc + " e você está acima do peso."));
				}
				else {
					mensagem.setText(String.valueOf(nomeField + " seu IMC é " +  imc + " e você está obeso."));
				}
				
				
				
			}
		});
		calcular.setBounds(22, 227, 89, 23);
		frame.getContentPane().add(calcular);
		
		JButton limpar = new JButton("Limpar");
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nome.setText("");
				altura.setText("");
				peso.setText("");
			}
		});
		limpar.setBounds(179, 227, 89, 23);
		frame.getContentPane().add(limpar);
		
		JButton sair = new JButton("Sair");
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		sair.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(sair);
	}
}
