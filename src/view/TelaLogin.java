package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;

	private LoginController loginController;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		super("Tela de Login");
		
		this.loginController = new LoginController();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(64, 201, 250, 30);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel.setBounds(64, 170, 250, 20);
		contentPane.add(lblNewLabel);
		
		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(64, 273, 250, 30);
		contentPane.add(txtSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Verdana", Font.BOLD, 14));
		lblSenha.setBounds(64, 242, 250, 20);
		contentPane.add(lblSenha);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCadastrar.setBounds(204, 346, 110, 30);
		contentPane.add(btnCadastrar);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verificaLogin()) {
					TelaCRUDCampeao telaCRUDCampeao = new TelaCRUDCampeao();
					telaCRUDCampeao.setVisible(true);
				}
			}
		});
		btnLogar.setBounds(64, 346, 110, 30);
		contentPane.add(btnLogar);
		
		JLabel lblNewLabel_1 = new JLabel("Bem vindo,");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_1.setBounds(64, 59, 256, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ao League of Java.");
		lblNewLabel_2.setForeground(new Color(255, 128, 0));
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 24));
		lblNewLabel_2.setBounds(64, 87, 256, 30);
		contentPane.add(lblNewLabel_2);
		
	}
	
	private boolean verificaLogin() {
		if (this.loginController.verifica(txtLogin.getText(), txtSenha.getText())) {
			JOptionPane.showMessageDialog(this, "Login efetuado com sucesso!");
			return true;
		} else {
			JOptionPane.showMessageDialog(this, "Login ou senha incorretos, tente novamente;");
			return false;
		}
	}
}
