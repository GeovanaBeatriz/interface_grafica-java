package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestaoA {

	private JFrame frame;
	private JTextField txFNumero;
	private JTextField txFResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestaoA window = new QuestaoA();
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
	public QuestaoA() {
		initialize();
	}
	
	public class InvalidNumberException extends Exception {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public InvalidNumberException(String message) {
	        super(message);
	    }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VERIFICAÇÃO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(149, 0, 135, 82);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Digite um número:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 82, 147, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		txFNumero = new JTextField();
		txFNumero.setBounds(137, 96, 147, 20);
		frame.getContentPane().add(txFNumero);
		txFNumero.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 135, 129, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		txFResultado = new JTextField();
		txFResultado.setEditable(false);
		txFResultado.setBounds(137, 146, 282, 20);
		frame.getContentPane().add(txFResultado);
		txFResultado.setColumns(10);
		
		JButton btnPerfeito = new JButton("Perfeito");
		btnPerfeito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					int num = Integer.parseInt(txFNumero.getText());
					int soma = 0;
				
					 for(int y = 1; y < num; y = y + 1){
				            if(num % y == 0){
				            	soma = soma + y;
				            }
				        }
					 
					 if(soma == num) {
		                	txFResultado.setText(String.valueOf(soma));
		                	JOptionPane.showMessageDialog(null, "Número é perfeito");
		                }
		                else {
		                	txFResultado.setText(String.valueOf(soma));
		                	JOptionPane.showMessageDialog(null, "Número não é perfeito");
		                }
					   
				    }catch (NumberFormatException erro1) {
				       txFResultado.setText("Digite valores válidos. Não se pode inserir letras, informe apenas números");
				    }
			}
		});
		btnPerfeito.setBounds(31, 207, 89, 23);
		frame.getContentPane().add(btnPerfeito);
		
		JButton btnDsu = new JButton("DSU");
		btnDsu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int num = Integer.parseInt(txFNumero.getText());
				try {
					if (num < 10 || num > 99) {
		                throw new InvalidNumberException("O número deve ter dois dígitos.");
		            }
						//entra 16
						
					    int unidade = num % 10; //6 -> unidade
				        int dezena = num / 10; //1 -> dezena
				        int soma = unidade + dezena;
				        
				        JOptionPane.showMessageDialog(null, "Número: " + num);
				        JOptionPane.showMessageDialog(null, "Digito da dezena: " + dezena);
				        JOptionPane.showMessageDialog(null, "Digito da dezena: " + unidade);
				        JOptionPane.showMessageDialog(null, "Soma da dezena com unidade: " + soma);
				        txFResultado.setText(String.valueOf(dezena) + String.valueOf(soma) + String.valueOf(unidade));
				        
				        
					   
				    }catch (NumberFormatException erro1) {
				       txFResultado.setText("Digite valores válidos. Não se pode inserir letras, informe apenas números");
				    }
					catch (InvalidNumberException erro2) {
						JOptionPane.showMessageDialog(null, "Erro: " + erro2.getMessage());
		        }
			}
		});
		btnDsu.setBounds(132, 207, 89, 23);
		frame.getContentPane().add(btnDsu);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txFNumero.setText("");
				txFResultado.setText("");
			}
		});
		btnLimpar.setBounds(231, 207, 89, 23);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(330, 207, 89, 23);
		frame.getContentPane().add(btnSair);
	}

}
