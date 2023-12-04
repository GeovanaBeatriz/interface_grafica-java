/*Enunciado: Cadastro de Livros com Interface Gráfica em Java

Desenvolver uma aplicação de cadastro de livros em Java com uma interface gráfica usando o WindowBuilder. 
A aplicação deve permitir que o usuário insira as informações relevantes sobre um livro, como título, autor, ano de publicação, 
gênero, id, editora e edição.

Além disso, a tela de cadastro deve incluir os seguintes elementos:

Campos de entrada de texto para o título, autor, ano de publicação, gênero, id, editora e edição.
Botão de cadastro para adicionar um novo livro na listagem.
Botão de limpar para redefinir os campos de entrada, além de um botão de limpar para a listagem.

Elementos novos utilizados: JPanel, JCheckBox, JTextArea.*/

package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class QuestaoC {

	private JFrame frame;
	private JTextField txtId_Livro;
	private JTextField txtAutor;
	private JTextField txtAno_Publicacao;
	private JTextField txtEdicao;
	private JTextField txtTitulo;
	private JPanel panel;
	private JTextArea txtListagem;
	private static JPanel panelGeneros_1;
	private JCheckBox boxFiccao;
	private JCheckBox boxFantasia;
	private JCheckBox boxRomance;
	private JCheckBox boxAventura;
	private JCheckBox boxMisterio;
	private JCheckBox boxNaoFic;
	private JCheckBox boxHistoria;
	private JCheckBox boxPoesia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestaoC window = new QuestaoC();
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
	public QuestaoC() {
		initialize();
	}
	
	public static String checkBox() {
		String result = "";
		try {
			for(Component c : panelGeneros_1.getComponents()) {
				if(c.getClass().equals(JCheckBox.class)) {
					JCheckBox jck = (JCheckBox) c;
					if(jck.isSelected()) {
						result += jck.getText() + ", "; 
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static int contagemCheckBox() {
		int soma = 0;
			for(Component c : panelGeneros_1.getComponents()) {
				if(c.getClass().equals(JCheckBox.class)) {
					JCheckBox jck = (JCheckBox) c;
					if(jck.isSelected()) {
						soma = soma + 1;
					}
				}
			}
			return soma;
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(575,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE LIVROS");
		lblNewLabel.setForeground(new Color(106, 90, 205));
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 19));
		lblNewLabel.setBounds(163, 0, 238, 77);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Dados B\u00E1sicos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(17, 52, 532, 126);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID_Livro");
		lblNewLabel_1.setBounds(7, 16, 58, 30);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		txtId_Livro = new JTextField();
		txtId_Livro.setBounds(63, 22, 86, 20);
		panel_1.add(txtId_Livro);
		txtId_Livro.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Autor\r\n");
		lblNewLabel_2.setBounds(169, 24, 46, 14);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		txtAutor = new JTextField();
		txtAutor.setBounds(218, 22, 303, 20);
		panel_1.add(txtAutor);
		txtAutor.setColumns(10);
		
		JLabel ano = new JLabel("Ano de Publicação");
		ano.setBounds(6, 58, 121, 20);
		panel_1.add(ano);
		ano.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		txtAno_Publicacao = new JTextField();
		txtAno_Publicacao.setBounds(126, 57, 86, 20);
		panel_1.add(txtAno_Publicacao);
		txtAno_Publicacao.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Editora");
		lblNewLabel_3.setBounds(243, 60, 58, 14);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		JComboBox cbEditora = new JComboBox();
		cbEditora.setBounds(294, 55, 132, 22);
		panel_1.add(cbEditora);
		cbEditora.setModel(new DefaultComboBoxModel(new String[] {"Companhia das Letras", "Record", "Nova Fronteira", "Intrínseca", "Globo", "Rocco", "Objetiva", "Saraiva", "Abril", "Ática", "Aleph", "Zahar", "Leya", "Martins Fontes", "Paz e Terra"}));
		
		JLabel txt = new JLabel("Edição");
		txt.setBounds(7, 92, 121, 20);
		panel_1.add(txt);
		txt.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		txtEdicao = new JTextField();
		txtEdicao.setBounds(55, 92, 121, 20);
		panel_1.add(txtEdicao);
		txtEdicao.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Título");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_5.setBounds(190, 96, 46, 14);
		panel_1.add(lblNewLabel_5);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(235, 93, 286, 20);
		panel_1.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		panelGeneros_1 = new JPanel();
		panelGeneros_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "G\u00EAnero", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelGeneros_1.setBounds(20, 185, 441, 83);
		frame.getContentPane().add(panelGeneros_1);
		panelGeneros_1.setLayout(null);
		
		boxFiccao = new JCheckBox("Ficção Científica");
		boxFiccao.setBounds(6, 18, 110, 23);
		panelGeneros_1.add(boxFiccao);
		
		boxFantasia = new JCheckBox("Fantasia");
		boxFantasia.setBounds(134, 18, 97, 23);
		panelGeneros_1.add(boxFantasia);
		
		boxRomance = new JCheckBox("Romance");
		boxRomance.setBounds(236, 18, 97, 23);
		panelGeneros_1.add(boxRomance);
		
		boxAventura = new JCheckBox("Aventura");
		boxAventura.setBounds(329, 17, 97, 23);
		panelGeneros_1.add(boxAventura);
		
		boxMisterio = new JCheckBox("Mistério/Thriller");
		boxMisterio.setBounds(6, 50, 97, 23);
		panelGeneros_1.add(boxMisterio);
		
		boxNaoFic = new JCheckBox("Não Ficção");
		boxNaoFic.setBounds(127, 52, 97, 23);
		panelGeneros_1.add(boxNaoFic);
		
		boxHistoria = new JCheckBox("História");
		boxHistoria.setBounds(238, 52, 83, 23);
		panelGeneros_1.add(boxHistoria);
		
		boxPoesia = new JCheckBox("Poesia");
		boxPoesia.setBounds(329, 50, 97, 23);
		panelGeneros_1.add(boxPoesia);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(11, 338, 538, 162);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtListagem = new JTextArea();
		txtListagem.setEditable(false);
		txtListagem.setBounds(6, 53, 521, 98);
		panel.add(txtListagem);
		
		JLabel lblNewLabel_4 = new JLabel("LISTAGEM");
		lblNewLabel_4.setBounds(219, 16, 89, 14);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 15));
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id, ano;
				String titulo, autor, edicao;
				
				if(txtId_Livro.getText().isEmpty() || txtAno_Publicacao.getText().isEmpty() || txtAutor.getText().isEmpty() ||
					txtTitulo.getText().isEmpty() || txtEdicao.getText().isEmpty() || contagemCheckBox() == 0) {
					JOptionPane.showMessageDialog(null, "Preencha os campos!");
					txtId_Livro.requestFocus();
				}
				else {
				
				id = Integer.parseInt(txtId_Livro.getText());
				ano = Integer.parseInt(txtAno_Publicacao.getText());
				autor = txtAutor.getText();
				titulo = txtTitulo.getText();
				edicao = txtEdicao.getText();
				
				
				
				int resultado = JOptionPane.showConfirmDialog(null, "DADOS DO LIVRO" + "\r\n" +
						"ID: " + id + "\r\n" +
						"Título: " + titulo + "\r\n" + 
						"Autor: " + autor + "\r\n" +
						"Ano de Publicacao: " + ano + "\r\n" +
						"Edição: " + edicao + "\r\n" +
						"Editora: " + cbEditora.getSelectedItem().toString() + "\r\n" +
						"Gênero(s): " + checkBox() + "\r\n" 
						, 
						"Confirmação do Pedido", JOptionPane.YES_NO_OPTION 
								);
						
						if(resultado == JOptionPane.YES_OPTION) {
							
							JOptionPane meuJOPane = new JOptionPane("Livro Inserido!");
					        final JDialog dialog = meuJOPane.createDialog(null, "Livro Inserido na Listagem! Dê uma olhadinha :)");
					                                                                   
					        dialog.setModal(true);  
					       
					        Timer timer = new Timer(2*1000, new ActionListener() {  
					            public void actionPerformed(ActionEvent ev) {  
					                dialog.dispose();  
					            }  
					        });  
					        timer.start();
					        dialog.setVisible(true);
					        timer.stop();
					        
					        txtListagem.append(titulo + "\n");
						}
						else if(resultado == JOptionPane.NO_OPTION) {
							
							JOptionPane meuJOPane = new JOptionPane("OPS!");
					        final JDialog dialog = meuJOPane.createDialog(null, "Livro não foi inserido!");
					                                                                   
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
				
			}
		});
		btnInserir.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnInserir.setBounds(111, 290, 89, 23);
		frame.getContentPane().add(btnInserir);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId_Livro.setText("");
				txtAutor.setText("");
				txtAno_Publicacao.setText("");
				txtEdicao.setText("");
				txtTitulo.setText("");
				boxFiccao.setSelected(false);
				boxNaoFic.setSelected(false);
				boxHistoria.setSelected(false);
				boxAventura.setSelected(false);
				boxFantasia.setSelected(false);
				boxMisterio.setSelected(false);
				boxRomance.setSelected(false);
				boxPoesia.setSelected(false);
				
			}
		});
		btnLimpar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnLimpar.setBounds(219, 290, 89, 23);
		frame.getContentPane().add(btnLimpar);
		
		JButton btnLimparListagem = new JButton("Limpar Listagem");
		btnLimparListagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtListagem.setText("");
			}
		});
		btnLimparListagem.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnLimparListagem.setBounds(318, 290, 135, 23);
		frame.getContentPane().add(btnLimparListagem);
	}
}
