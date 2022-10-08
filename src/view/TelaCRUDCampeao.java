package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CampeaoController;
import modelo.Campeao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.SpinnerNumberModel;

public class TelaCRUDCampeao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;

	private CampeaoController campeaoController;
	private JTable table;
	private DefaultTableModel tableCampeoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCRUDCampeao frame = new TelaCRUDCampeao();
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
	public TelaCRUDCampeao() {
		super("Tela de Cadastro - Campeões");

		this.campeaoController = new CampeaoController();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(33, 82, 150, 30);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome do campeão");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(33, 53, 150, 18);
		contentPane.add(lblNewLabel);

		JLabel lblVidainteiro = new JLabel("Vida (Inteiro)");
		lblVidainteiro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblVidainteiro.setBounds(207, 53, 150, 18);
		contentPane.add(lblVidainteiro);

		JLabel lblAtaqueinteiro = new JLabel("Ataque (Inteiro)");
		lblAtaqueinteiro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblAtaqueinteiro.setBounds(382, 123, 150, 18);
		contentPane.add(lblAtaqueinteiro);

		JLabel lblDefesainteiro = new JLabel("Defesa (Inteiro)");
		lblDefesainteiro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDefesainteiro.setBounds(382, 53, 150, 18);
		contentPane.add(lblDefesainteiro);

		JLabel lblRotainteiro = new JLabel("Rota (Inteiro)");
		lblRotainteiro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblRotainteiro.setBounds(556, 53, 150, 18);
		contentPane.add(lblRotainteiro);

		JLabel lblClasseinteiro = new JLabel("Classe (Inteiro)");
		lblClasseinteiro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblClasseinteiro.setBounds(556, 123, 150, 18);
		contentPane.add(lblClasseinteiro);

		JLabel lblNewLabel_1 = new JLabel("CRUD League of Java - Campeões");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1.setBounds(301, 11, 353, 30);
		contentPane.add(lblNewLabel_1);

		JSpinner spinnerVida = new JSpinner();
		spinnerVida.setFont(new Font("Verdana", Font.BOLD, 12));
		spinnerVida.setBounds(207, 82, 150, 30);
		contentPane.add(spinnerVida);

		JSpinner spinnerAtaque = new JSpinner();
		spinnerAtaque.setFont(new Font("Verdana", Font.BOLD, 12));
		spinnerAtaque.setBounds(382, 152, 150, 30);
		contentPane.add(spinnerAtaque);

		JSpinner spinnerDefesa = new JSpinner();
		spinnerDefesa.setFont(new Font("Verdana", Font.BOLD, 12));
		spinnerDefesa.setBounds(382, 82, 150, 30);
		contentPane.add(spinnerDefesa);

		JSpinner spinnerRota = new JSpinner();
		spinnerRota.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinnerRota.setFont(new Font("Verdana", Font.BOLD, 12));
		spinnerRota.setBounds(556, 82, 150, 30);
		contentPane.add(spinnerRota);

		JSpinner spinnerClasse = new JSpinner();
		spinnerClasse.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinnerClasse.setFont(new Font("Verdana", Font.BOLD, 12));
		spinnerClasse.setBounds(556, 152, 150, 30);
		contentPane.add(spinnerClasse);

		JSpinner spinnerId = new JSpinner();
		spinnerId.setFont(new Font("Verdana", Font.BOLD, 12));
		spinnerId.setBounds(33, 152, 324, 30);
		contentPane.add(spinnerId);
		
		JLabel lblObsPreencherEm = new JLabel("Obs: Preencher ID em caso de Edição/Deleção");
		lblObsPreencherEm.setForeground(new Color(255, 0, 128));
		lblObsPreencherEm.setFont(new Font("Verdana", Font.BOLD, 12));
		lblObsPreencherEm.setBounds(33, 187, 324, 18);
		contentPane.add(lblObsPreencherEm);


		JLabel lblIdCampeointeiro = new JLabel("ID Campeão (Inteiro)");
		lblIdCampeointeiro.setFont(new Font("Verdana", Font.BOLD, 12));
		lblIdCampeointeiro.setBounds(33, 123, 297, 18);
		contentPane.add(lblIdCampeointeiro);

		table = new JTable();
		tableCampeoes = (DefaultTableModel) table.getModel();
		tableCampeoes.addColumn("ID");
		tableCampeoes.addColumn("Nome");
		tableCampeoes.addColumn("Vida");
		tableCampeoes.addColumn("Ataque");
		tableCampeoes.addColumn("Defesa");
		tableCampeoes.addColumn("ID Rota");
		tableCampeoes.addColumn("ID Classe");

		preencherTabela();

		table.setBounds(33, 248, 673, 209);
		contentPane.add(table);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(255, 128, 64));
		panel.setBounds(33, 217, 96, 30);
		contentPane.add(panel);

		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(lblNewLabel_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBounds(129, 217, 96, 30);
		contentPane.add(panel_1);

		JLabel lblNewLabel_2_1 = new JLabel("Nome");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_1.add(lblNewLabel_2_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(new Color(255, 128, 64));
		panel_2.setBounds(224, 217, 96, 30);
		contentPane.add(panel_2);

		JLabel lblNewLabel_2_2 = new JLabel("Vida");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_2.add(lblNewLabel_2_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(new Color(255, 128, 64));
		panel_3.setBounds(610, 217, 96, 30);
		contentPane.add(panel_3);

		JLabel lblNewLabel_2_6 = new JLabel("ID Classe");
		lblNewLabel_2_6.setForeground(Color.WHITE);
		lblNewLabel_2_6.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_3.add(lblNewLabel_2_6);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBackground(new Color(255, 128, 64));
		panel_4.setBounds(513, 217, 96, 30);
		contentPane.add(panel_4);

		JLabel lblNewLabel_2_5 = new JLabel("ID Rota");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_4.add(lblNewLabel_2_5);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.setBackground(new Color(255, 128, 64));
		panel_5.setBounds(416, 217, 96, 30);
		contentPane.add(panel_5);

		JLabel lblNewLabel_2_4 = new JLabel("Defesa");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_5.add(lblNewLabel_2_4);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_6.setBackground(new Color(255, 128, 64));
		panel_6.setBounds(320, 217, 96, 30);
		contentPane.add(panel_6);

		JLabel lblNewLabel_2_3 = new JLabel("Ataque");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Verdana", Font.BOLD, 12));
		panel_6.add(lblNewLabel_2_3);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setForeground(new Color(255, 0, 0));
		btnDeletar.setFont(new Font("Verdana", Font.BOLD, 14));
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer valorId = (Integer) spinnerId.getValue();

				boolean statusD = deletar(valorId);
				if (statusD) {
					limparTabela();
					preencherTabela();
					spinnerVida.setValue(Integer.parseInt("0"));
					spinnerAtaque.setValue(Integer.parseInt("0"));
					spinnerDefesa.setValue(Integer.parseInt("0"));
					spinnerId.setValue(Integer.parseInt("0"));
					spinnerRota.setValue(Integer.parseInt("1"));
					spinnerClasse.setValue(Integer.parseInt("1"));
					txtNome.setText("");
				}
			}
		});

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer valorVida = (Integer) spinnerVida.getValue();
				Integer valorAtaque = (Integer) spinnerAtaque.getValue();
				Integer valorDefesa = (Integer) spinnerDefesa.getValue();
				Integer valorId = (Integer) spinnerId.getValue();
				Integer valorRota = (Integer) spinnerRota.getValue();
				Integer valorClasse = (Integer) spinnerClasse.getValue();
				
				boolean statusE = editar(valorVida, valorAtaque, valorDefesa, valorId, valorRota, valorClasse);
				if(statusE) {
					limparTabela();
					preencherTabela();
					spinnerVida.setValue(Integer.parseInt("0"));
					spinnerAtaque.setValue(Integer.parseInt("0"));
					spinnerDefesa.setValue(Integer.parseInt("0"));
					spinnerId.setValue(Integer.parseInt("0"));
					spinnerRota.setValue(Integer.parseInt("1"));
					spinnerClasse.setValue(Integer.parseInt("1"));
					txtNome.setText("");
				}
			}
		});
		btnEditar.setForeground(new Color(0, 64, 128));
		btnEditar.setFont(new Font("Verdana", Font.BOLD, 14));
		btnEditar.setBounds(270, 487, 200, 40);
		contentPane.add(btnEditar);

		btnDeletar.setBounds(748, 487, 200, 40);
		contentPane.add(btnDeletar);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(new Color(0, 128, 128));
		btnSalvar.setFont(new Font("Verdana", Font.BOLD, 14));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer valorVida = (Integer) spinnerVida.getValue();
				Integer valorAtaque = (Integer) spinnerAtaque.getValue();
				Integer valorDefesa = (Integer) spinnerDefesa.getValue();
				Integer valorRota = (Integer) spinnerRota.getValue();
				Integer valorClasse = (Integer) spinnerClasse.getValue();

				boolean statusS = salvar(valorVida, valorAtaque, valorDefesa, valorRota, valorClasse);
				if (statusS) {
					limparTabela();
					preencherTabela();
					spinnerVida.setValue(Integer.parseInt("0"));
					spinnerAtaque.setValue(Integer.parseInt("0"));
					spinnerDefesa.setValue(Integer.parseInt("0"));
					spinnerId.setValue(Integer.parseInt("0"));
					spinnerRota.setValue(Integer.parseInt("1"));
					spinnerClasse.setValue(Integer.parseInt("1"));
					txtNome.setText("");
				}
			}
		});
		btnSalvar.setBounds(33, 487, 200, 40);
		contentPane.add(btnSalvar);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBackground(new Color(255, 128, 64));
		panel_7.setBounds(748, 84, 205, 194);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_2_7 = new JLabel("Rotas");
		lblNewLabel_2_7.setBounds(75, 17, 60, 16);
		lblNewLabel_2_7.setForeground(new Color(128, 0, 255));
		lblNewLabel_2_7.setFont(new Font("Verdana", Font.BOLD, 16));
		panel_7.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_7_1 = new JLabel("1 - Rota Superior");
		lblNewLabel_2_7_1.setForeground(Color.WHITE);
		lblNewLabel_2_7_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_7_1.setBounds(26, 45, 152, 16);
		panel_7.add(lblNewLabel_2_7_1);
		
		JLabel lblNewLabel_2_7_1_1 = new JLabel("2 - Selva");
		lblNewLabel_2_7_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_7_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_7_1_1.setBounds(26, 73, 152, 16);
		panel_7.add(lblNewLabel_2_7_1_1);
		
		JLabel lblNewLabel_2_7_1_1_1 = new JLabel("3 - Rota do Meio");
		lblNewLabel_2_7_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_7_1_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_7_1_1_1.setBounds(26, 100, 152, 16);
		panel_7.add(lblNewLabel_2_7_1_1_1);
		
		JLabel lblNewLabel_2_7_1_1_1_1 = new JLabel("4 - Rota Inferior");
		lblNewLabel_2_7_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_7_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_7_1_1_1_1.setBounds(26, 128, 152, 16);
		panel_7.add(lblNewLabel_2_7_1_1_1_1);
		
		JLabel lblNewLabel_2_7_1_1_1_1_1 = new JLabel("5 - Suporte");
		lblNewLabel_2_7_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_7_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_7_1_1_1_1_1.setBounds(26, 156, 152, 16);
		panel_7.add(lblNewLabel_2_7_1_1_1_1_1);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7_1.setBackground(new Color(255, 128, 64));
		panel_7_1.setBounds(748, 294, 205, 163);
		contentPane.add(panel_7_1);
		
		JLabel lblNewLabel_2_7_2 = new JLabel("Classes");
		lblNewLabel_2_7_2.setForeground(new Color(128, 0, 255));
		lblNewLabel_2_7_2.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_2_7_2.setBounds(68, 17, 77, 16);
		panel_7_1.add(lblNewLabel_2_7_2);
		
		JLabel lblNewLabel_2_7_1_2 = new JLabel("1 - Tank");
		lblNewLabel_2_7_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_7_1_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_7_1_2.setBounds(26, 45, 152, 16);
		panel_7_1.add(lblNewLabel_2_7_1_2);
		
		JLabel lblNewLabel_2_7_1_1_2 = new JLabel("2 - Off-Tank");
		lblNewLabel_2_7_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_7_1_1_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_7_1_1_2.setBounds(26, 73, 152, 16);
		panel_7_1.add(lblNewLabel_2_7_1_1_2);
		
		JLabel lblNewLabel_2_7_1_1_1_2 = new JLabel("3 - Mago");
		lblNewLabel_2_7_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_7_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_7_1_1_1_2.setBounds(26, 100, 152, 16);
		panel_7_1.add(lblNewLabel_2_7_1_1_1_2);
		
		JLabel lblNewLabel_2_7_1_1_1_1_2 = new JLabel("4 - Assassino");
		lblNewLabel_2_7_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_7_1_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2_7_1_1_1_1_2.setBounds(26, 128, 152, 16);
		panel_7_1.add(lblNewLabel_2_7_1_1_1_1_2);
		
		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtNome.getText().equals("")) {
					limparTabela();
					preencherTabelaPorNome();
				} else {
					limparTabela();
					preencherTabela();
				}
			}
		});
		btnProcurar.setForeground(new Color(128, 0, 255));
		btnProcurar.setFont(new Font("Verdana", Font.BOLD, 14));
		btnProcurar.setBounds(506, 487, 200, 40);
		contentPane.add(btnProcurar);
	}

	private boolean salvar(Integer vida, Integer ataque, Integer defesa, Integer rota, Integer classe) {
		boolean sucesso = false;
		if (!txtNome.getText().equals("") && !vida.equals(0) && !ataque.equals(0) && !defesa.equals(0)
				&& !rota.equals(0) && !classe.equals(0)) {
			Campeao campeao = new Campeao(vida, ataque, defesa, txtNome.getText(), rota, classe);
			this.campeaoController.salvar(campeao);
			JOptionPane.showMessageDialog(this, "Salvo com sucesso!");
			sucesso = true;
		} else {
			JOptionPane.showMessageDialog(this, "Algum dos parâmetros não foi informado, tente novamente.");
		}
		return sucesso;
	}

	private boolean deletar(Integer id) {
		boolean sucesso = false;
		if (!id.equals(0)) {
			this.campeaoController.deletar(id);
			JOptionPane.showMessageDialog(this, "Campeão deletado com sucesso!");
			sucesso = true;
		} else {
			JOptionPane.showMessageDialog(this, "Digite o ID do campeão para deleção.");
		}
		return sucesso;
	}
	
	private boolean editar(Integer vida, Integer ataque, Integer defesa, Integer id, Integer rota, Integer classe) {
		boolean sucesso = false;
		
		if (!txtNome.getText().equals("") && !vida.equals(0) && !ataque.equals(0) && !defesa.equals(0)
				&& !id.equals(0)) {
			Campeao campeao = new Campeao(id, vida, ataque, defesa, txtNome.getText(), rota, classe);
			this.campeaoController.alterar(campeao);
			JOptionPane.showMessageDialog(this, "Editado com sucesso!");
			sucesso = true;
		} else {
			JOptionPane.showMessageDialog(this, "Algum dos parâmetros não foi informado, tente novamente.");
		}
		
		return sucesso;
	}

	private List<Campeao> listarCampeao() {
		return this.campeaoController.listar();
	}
	
	private List<Campeao> listarCampeaoPorNome() {
		return this.campeaoController.listarEspecifico(txtNome.getText());
	}

	private void preencherTabela() {
		List<Campeao> campeoes = listarCampeao();
		try {
			for (Campeao campeao : campeoes) {
				tableCampeoes.addRow(new Object[] { campeao.getId(), campeao.getNome(), campeao.getVida(),
						campeao.getAtaque(), campeao.getDefesa(), campeao.getRotaId(), campeao.getClasseId() });
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void preencherTabelaPorNome() {
		List<Campeao> campeoes = listarCampeaoPorNome();
		try {
			for (Campeao campeao : campeoes) {
				tableCampeoes.addRow(new Object[] { campeao.getId(), campeao.getNome(), campeao.getVida(),
						campeao.getAtaque(), campeao.getDefesa(), campeao.getRotaId(), campeao.getClasseId() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void limparTabela() {
		tableCampeoes.setRowCount(0);
	}
}
