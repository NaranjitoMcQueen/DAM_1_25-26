package conversor;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainApp extends JFrame {

	private static final double V_Euro = 1.17;
	private static final double V_Dolar = 0.85;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQuantitat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp frame = new MainApp();
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
	public MainApp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtQuantitat = new JTextField();
		txtQuantitat.setText("Quantitat");
		txtQuantitat.setBounds(103, 90, 132, 25);
		contentPane.add(txtQuantitat);
		txtQuantitat.setColumns(10);

		JLabel lblResultat = new JLabel("Resultat");
		lblResultat.setBounds(121, 163, 193, 15);
		contentPane.add(lblResultat);

		JComboBox comboConversio = new JComboBox();
		comboConversio.setBounds(233, 90, 81, 24);
		contentPane.add(comboConversio);

		comboConversio.addItem("$ → €");
		comboConversio.addItem("€ → $");

		comboConversio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String qt = (String) comboConversio.getSelectedItem();
				try {
					if (qt == "$ → €") {
						double res = Double.parseDouble(txtQuantitat.getText());
						lblResultat.setText("Conversió: " + res * V_Euro + " €");
					} else {
						double res = Double.parseDouble(txtQuantitat.getText());
						lblResultat.setText("Conversió: " + res * V_Dolar + " $");
					}
				} catch (Exception e0) {
					lblResultat.setText("Error.");
				}
			}
		});

	}
}
