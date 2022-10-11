package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import modelo.Login;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastraLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JPasswordField txtSenha;
	private LoginController loginController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastraLogin frame = new TelaCadastraLogin();
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
	public TelaCadastraLogin() {
		super("Tela de Cadastro - Login");
		
		this.loginController = new LoginController();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro Login");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel.setBounds(148, 22, 138, 29);
		contentPane.add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(89, 92, 250, 30);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBounds(89, 67, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(89, 158, 250, 30);
		contentPane.add(txtNome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(89, 133, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(89, 224, 250, 30);
		contentPane.add(txtCpf);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(89, 199, 46, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Senha");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(89, 265, 46, 14);
		contentPane.add(lblNewLabel_1_3);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(89, 290, 250, 30);
		contentPane.add(txtSenha);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton.setBounds(148, 342, 150, 30);
		contentPane.add(btnNewButton);
	}
	
	private void salvar () {
		if(!txtNome.getText().equals(null) && !txtLogin.getText().equals(null) && !txtCpf.getText().equals(null) && !txtSenha.getPassword().equals(null)) {
			Login login = new Login(txtLogin.getText(), txtNome.getText(), txtCpf.getText(), String.valueOf(txtSenha.getPassword()));
			this.loginController.cadastrar(login);
			JOptionPane.showMessageDialog(this, "Cadastrado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Algum dos parâmetros não foi informado, tente novamente.");
		}
	}
}
