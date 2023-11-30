package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class QuestaoBPedido {

	static JFrame frame;
	private JTextField txtNome;
	private JTextField txtCPF;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestaoBPedido window = new QuestaoBPedido();
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
	public QuestaoBPedido() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(253, 245, 230));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(575,500);
		frame.getContentPane().setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 434, 27);
		frame.getContentPane().add(toolBar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestaoB window = new QuestaoB();
				
				window.frame.setVisible(true);	
				
				QuestaoBPedido.frame.setVisible(false); //tela anterior fechar
			}
			
		});
		toolBar.add(btnSair);
		
		JTextArea txtObs = new JTextArea();
		txtObs.setToolTipText("Observação");
		txtObs.setBounds(38, 321, 493, 87);
		frame.getContentPane().add(txtObs);
		
		JLabel lblNewLabel = new JLabel("Observação");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(38, 296, 111, 27);
		frame.getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(22, 64, 199, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(309, 64, 185, 20);
		frame.getContentPane().add(txtCPF);
		txtCPF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 38, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(309, 38, 54, 15);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.setBackground(new Color(255, 20, 147));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(132, 419, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar\r\n");
		btnNewButton_1.setBackground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(313, 419, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Menu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(22, 118, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JCheckBox boxTradicional = new JCheckBox("Coxinha Tradicional");
		boxTradicional.setBounds(22, 139, 127, 23);
		frame.getContentPane().add(boxTradicional);
		
		JCheckBox boxCarne = new JCheckBox("Coxinha de Carne Seca");
		boxCarne.setBounds(194, 139, 142, 23);
		frame.getContentPane().add(boxCarne);
		
		JCheckBox boxCalabresa = new JCheckBox("Coxinha de Calabresa");
		boxCalabresa.setBounds(375, 139, 138, 23);
		frame.getContentPane().add(boxCalabresa);
		
		JCheckBox boxQueijo = new JCheckBox("Coxinha de Queijo");
		boxQueijo.setBounds(313, 190, 117, 23);
		frame.getContentPane().add(boxQueijo);
		
		JCheckBox boxVeg = new JCheckBox("Coxinha Vegana");
		boxVeg.setBounds(110, 190, 111, 23);
		frame.getContentPane().add(boxVeg);
		
		JLabel lblNewLabel_3 = new JLabel("Forma de Pagamento");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(22, 231, 185, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		JRadioButton rdbDebito = new JRadioButton("Cartão de Débito/Pix\r\n\r\n");
		buttonGroup.add(rdbDebito);
		rdbDebito.setBounds(38, 265, 134, 23);
		frame.getContentPane().add(rdbDebito);
		
		JRadioButton rdbCredito = new JRadioButton("Cartão de Crédito\r\n");
		buttonGroup.add(rdbCredito);
		rdbCredito.setBounds(219, 265, 117, 23);
		frame.getContentPane().add(rdbCredito);
		
		JRadioButton rdbDinheiro = new JRadioButton("Dinheiro");
		buttonGroup.add(rdbDinheiro);
		rdbDinheiro.setBounds(404, 265, 109, 23);
		frame.getContentPane().add(rdbDinheiro);
		
		JLabel lblNewLabel_4 = new JLabel("R$ 5,00");
		lblNewLabel_4.setBounds(22, 164, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("R$ 6,00");
		lblNewLabel_4_1.setBounds(204, 166, 46, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("R$ 5,00");
		lblNewLabel_4_1_1.setBounds(375, 164, 46, 14);
		frame.getContentPane().add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("R$ 7,00");
		lblNewLabel_4_1_2.setBounds(110, 210, 46, 14);
		frame.getContentPane().add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("R$ 4,00");
		lblNewLabel_4_1_2_1.setBounds(313, 210, 46, 14);
		frame.getContentPane().add(lblNewLabel_4_1_2_1);
	}
}
