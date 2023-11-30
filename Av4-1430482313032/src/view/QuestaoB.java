package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.Timer; 

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class QuestaoB {

	static JFrame frame;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestaoB window = new QuestaoB();
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
	public QuestaoB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(250, 240, 230));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(111, 155, 102, 0);
		frame.getContentPane().add(list);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(255, 20, 147));
		lblNewLabel.setBounds(189, 11, 62, 53);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuário");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(111, 75, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_2.setBounds(111, 153, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(111, 100, 203, 20);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(111, 178, 203, 20);
		frame.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEntrar.setBackground(new Color(255, 20, 147));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkLogin(txtUsuario.getText(), txtSenha.getText())) {
					
					JOptionPane meuJOPane = new JOptionPane("Acesso permitido!");//instanciando o JOptionPane
			        final JDialog dialog = meuJOPane.createDialog(null, "Bem-vindo(a)!");//aqui uso um JDialog para manipular
			                                                                    //meu JOptionPane
			        dialog.setModal(true);  
			        //Usando o javax.swing.Timer para poder gerar um evento em um tempo determinado
			        //Veja o construtor da classe Timer para mais explicações
			        Timer timer = new Timer(1000, new ActionListener() {  
			            public void actionPerformed(ActionEvent ev) {  
			                dialog.dispose();  //o evento(no caso fechar o meu JDialog)
			            }  
			        });  
			        timer.start();
			        dialog.setVisible(true);
			        timer.stop();
			        
			        QuestaoB2 window2 = new QuestaoB2();
					window2.frame.setVisible(true);	
					
					QuestaoB.frame.setVisible(false); //tela anterior fechar
				}
				else {
					JOptionPane.showMessageDialog(null, "Acesso negado. Tente novamente!");
				}
			}
		});
		btnEntrar.setBounds(174, 227, 89, 23);
		frame.getContentPane().add(btnEntrar);
		
			
	}
	
	public boolean checkLogin(String login, String senha) {
		return login.equals("admin") && senha.equals("123456");
	}
	
}
