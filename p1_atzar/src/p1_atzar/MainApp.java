package p1_atzar;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainApp.class.getResource("/resource/avion.png")));
		setTitle("Atzar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAnemAVeure = new JLabel("Anem a veure com estàs de sort");
		lblAnemAVeure.setBounds(113, 42, 227, 15);
		lblAnemAVeure.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAnemAVeure);

		JButton btnPlay = new JButton("Provar sort");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int num = (int) (Math.random() * 6) + 1;
				lblAnemAVeure.setText("El nombre és... " + num);
			}
		});
		btnPlay.setBounds(166, 87, 117, 25);
		contentPane.add(btnPlay);

	}
}
