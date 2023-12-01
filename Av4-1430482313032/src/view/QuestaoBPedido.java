package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class QuestaoBPedido {

	static JFrame frame;
	private JTextField txtNome;
	private JTextField txtCPF;
	private static JPanel panelMenu;
	
	
	private final static ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbDebito;
	private JRadioButton rdbCredito;
	private JRadioButton rdbDinheiro;
	private static JPanel panelPagamento;
	private JCheckBox boxCarne_1;
	private JCheckBox boxCalabresa_1;
	private JCheckBox boxVeg_1;
	private JCheckBox boxQueijo_1;
	private JCheckBox boxTradicional_1;
	private JRadioButton rdbDebito_1;

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
		public static String checkBox() {
			String result = "";
			for(Component c : panelMenu.getComponents()) {
				if(c.getClass().equals(JCheckBox.class)) {
					JCheckBox jck = (JCheckBox) c;
					if(jck.isSelected()) {
						result += jck.getText() + ", "; 
					}
				}
			}
			return result;
		}
		
		public static String metodoPagamento() {
			String metodo = "";
			Enumeration<AbstractButton> bg = buttonGroup.getElements();
			while(bg.hasMoreElements()) {
				JRadioButton jrd = (JRadioButton) bg.nextElement();
				if(jrd.isSelected()) {
					metodo += jrd.getText(); 
				}
			}
			return metodo;
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome, cpf, obs;
				
				nome = txtNome.getText();
				cpf = txtCPF.getText();
				obs = txtObs.getText();
		
				
				
				int resultado = JOptionPane.showConfirmDialog(null, "DADOS DO CLIENTE" + "\r\n" +
				"Nome: " + nome + "\r\n" + 
				"CPF: " + cpf + "\r\n" +
				"\r\n" +
				"DADOS DO PEDIDO" + "\r\n" +
						checkBox() + "\r\n" +
						"\r\n" +
				"FORMA DE PAGAMENTO" + "\r\n"+ 
						metodoPagamento() +
				"\r\n" +
				"OBSERVAÇÃO" + "\r\n"+ 
				obs , 
				"Confirmação do Pedido", JOptionPane.YES_NO_OPTION 
						);
				
				if(resultado == JOptionPane.YES_OPTION) {
					
					JOptionPane meuJOPane = new JOptionPane("Confirmado!");
			        final JDialog dialog = meuJOPane.createDialog(null, "Pedido Confirmado! Aguarde seu pedido chegar :)");
			                                                                   
			        dialog.setModal(true);  
			       
			        Timer timer = new Timer(2*1000, new ActionListener() {  
			            public void actionPerformed(ActionEvent ev) {  
			                dialog.dispose();  
			            }  
			        });  
			        timer.start();
			        dialog.setVisible(true);
			        timer.stop();
			        
			        QuestaoB2 window = new QuestaoB2();
					window.frame.setVisible(true);	
					
					QuestaoBPedido.frame.setVisible(false); //tela anterior fechar
				}
				else if(resultado == JOptionPane.NO_OPTION) {
					
					JOptionPane meuJOPane = new JOptionPane("Cancelado!");
			        final JDialog dialog = meuJOPane.createDialog(null, "Pedido Cancelado!");
			                                                                   
			        dialog.setModal(true);  
			       
			        Timer timer = new Timer(2*1000, new ActionListener() {  
			            public void actionPerformed(ActionEvent ev) {  
			                dialog.dispose();  
			            }  
			        });  
			        timer.start();
			        dialog.setVisible(true);
			        timer.stop();
			       
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 20, 147));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(132, 419, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCPF.setText("");
				txtObs.setText("");
				boxTradicional_1.setSelected(false);
				boxCarne_1.setSelected(false);
				boxCalabresa_1.setSelected(false);
				boxVeg_1.setSelected(false);
				boxQueijo_1.setSelected(false);
				buttonGroup.clearSelection();
				
				
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 20, 147));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(313, 419, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		panelMenu = new JPanel();
		panelMenu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelMenu.setBounds(16, 123, 503, 96);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		boxTradicional_1 = new JCheckBox("Coxinha Tradicional");
		boxTradicional_1.setBounds(6, 16, 127, 23);
		panelMenu.add(boxTradicional_1);
		
		boxCarne_1 = new JCheckBox("Coxinha de Carne Seca");
		boxCarne_1.setBounds(178, 16, 142, 23);
		panelMenu.add(boxCarne_1);
		
		boxCalabresa_1 = new JCheckBox("Coxinha de Calabresa");
		boxCalabresa_1.setBounds(359, 16, 138, 23);
		panelMenu.add(boxCalabresa_1);
		
		boxQueijo_1 = new JCheckBox("Coxinha de Queijo");
		boxQueijo_1.setBounds(297, 67, 117, 23);
		panelMenu.add(boxQueijo_1);
		
		boxVeg_1 = new JCheckBox("Coxinha Vegana");
		boxVeg_1.setBounds(94, 67, 111, 23);
		panelMenu.add(boxVeg_1);
		
		panelPagamento = new JPanel();
		panelPagamento.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Forma de Pagamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPagamento.setBounds(22, 240, 497, 45);
		frame.getContentPane().add(panelPagamento);
		panelPagamento.setLayout(null);
		
		rdbDebito_1 = new JRadioButton("Cartão de Débito/Pix\r\n\r\n");
		rdbDebito_1.setBounds(6, 16, 134, 23);
		panelPagamento.add(rdbDebito_1);
		buttonGroup.add(rdbDebito_1);
		
		rdbCredito = new JRadioButton("Cartão de Crédito\r\n");
		rdbCredito.setBounds(187, 16, 117, 23);
		panelPagamento.add(rdbCredito);
		buttonGroup.add(rdbCredito);
		
		rdbDinheiro = new JRadioButton("Dinheiro");
		rdbDinheiro.setBounds(372, 16, 109, 23);
		panelPagamento.add(rdbDinheiro);
		buttonGroup.add(rdbDinheiro);
		
		JLabel lblNewLabel_4 = new JLabel("R$ 5,00");
		lblNewLabel_4.setBounds(22, 166, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("R$ 6,00");
		lblNewLabel_4_1.setBounds(204, 166, 46, 14);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("R$ 5,00");
		lblNewLabel_4_1_1.setBounds(375, 164, 46, 14);
		frame.getContentPane().add(lblNewLabel_4_1_1);
	}
}
