package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class QuestaoB2 {

	static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestaoB2 window = new QuestaoB2();
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
	public QuestaoB2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 434, 27);
		toolBar.setRollover(true);
		frame.getContentPane().add(toolBar);
		
		JButton btnPedido = new JButton("Pedido\r\n");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestaoBPedido window = new QuestaoBPedido();
				
				window.frame.setVisible(true);	
				
				QuestaoB2.frame.setVisible(false); //tela anterior fechar
			}
		});
		btnPedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar.add(btnPedido);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				QuestaoB window = new QuestaoB();
				
				window.frame.setVisible(true);	
				
				QuestaoB2.frame.setVisible(false); //tela anterior fechar
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		toolBar.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("Liga das Coxinhas");
		lblNewLabel.setForeground(new Color(255, 20, 147));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(126, 32, 190, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane txtpnComoInserirTexto = new JTextPane();
		txtpnComoInserirTexto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnComoInserirTexto.setBackground(new Color(250, 240, 230));
		txtpnComoInserirTexto.setEditable(false);
		txtpnComoInserirTexto.setText("Em nossa cozinha, a criatividade é o nosso superpoder e cada coxinha é uma obra-prima culinária digna de heróis. Na Liga das Coxinhas, convidamos você a embarcar em uma jornada de sabores extraordinários, onde cada mordida é uma aventura e cada encontro com o cardápio é uma missão deliciosa.");
		txtpnComoInserirTexto.setBounds(20, 78, 414, 144);
		frame.getContentPane().add(txtpnComoInserirTexto);
		
		JLabel lblNewLabel_1 = new JLabel("EXPERIMENTE NOSSOS PRODUTOS!");
		lblNewLabel_1.setForeground(new Color(255, 20, 147));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(80, 138, 283, 112);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
