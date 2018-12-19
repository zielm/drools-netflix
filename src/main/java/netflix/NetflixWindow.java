package netflix;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import netflix.Netflix.NetflixCallback;

public class NetflixWindow extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NetflixCallback callback;

	private JPanel contentPane;
	private JButton buttonStart;
	private JPanel panelStart;
	private JPanel panelEnd;
	private JTextPane endText;
	
	/**
	 * Create the frame.
	 */	
	
	public NetflixWindow(NetflixCallback callback) {
		setResizable(false);
		this.callback = callback;
        initUI();	
        
    }


	/**
	 * Create UI
	 */
	private void initUI() {
		setTitle("What Netlix sci-fi show should you watch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		panelStart = new JPanel();		
		buttonStart = new JButton("START");
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonStartActionPerformed(e);
			}
		});
		contentPane.add(panelStart, "name_60576469743805");
		GroupLayout gl_panelStart = new GroupLayout(panelStart);
		gl_panelStart.setHorizontalGroup(
			gl_panelStart.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelStart.createSequentialGroup()
					.addGap(126)
					.addComponent(buttonStart, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(144, Short.MAX_VALUE))
		);
		gl_panelStart.setVerticalGroup(
			gl_panelStart.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelStart.createSequentialGroup()
					.addGap(95)
					.addComponent(buttonStart, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(109, Short.MAX_VALUE))
		);
		panelStart.setLayout(gl_panelStart);
		
		panelEnd = new JPanel();
		contentPane.add(panelEnd, "name_14516770409146");
		
		endText = new JTextPane();
		endText.setEditable(false);
		
		JButton buttonRestart = new JButton("Restart");
		buttonRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonRestartActionPerformed(e);
			}
		});
		GroupLayout gl_panelEnd = new GroupLayout(panelEnd);
		gl_panelEnd.setHorizontalGroup(
			gl_panelEnd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEnd.createSequentialGroup()
					.addGroup(gl_panelEnd.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelEnd.createSequentialGroup()
							.addContainerGap()
							.addComponent(endText, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelEnd.createSequentialGroup()
							.addGap(153)
							.addComponent(buttonRestart, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelEnd.setVerticalGroup(
			gl_panelEnd.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEnd.createSequentialGroup()
					.addContainerGap()
					.addComponent(endText, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonRestart)
					.addContainerGap(165, Short.MAX_VALUE))
		);
		panelEnd.setLayout(gl_panelEnd);
	}
	

	/*
	 * Show a window
	 */
	public void create() {
		try {
			this.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Start the quiz
	 * @param e
	 */
	private void buttonStartActionPerformed(ActionEvent e) {
		CardLayout cardLayout = (CardLayout)contentPane.getLayout();
		cardLayout.next(contentPane);
		callback.start(this, endText);
	}
	
	private void buttonRestartActionPerformed(ActionEvent e) {
		endText.setText("");
		CardLayout cardLayout = (CardLayout)contentPane.getLayout();
		cardLayout.next(contentPane);
	}
}
