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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import netflix.Netflix.NetflixCallback;
import javax.swing.JToggleButton;

public class NetflixWindow extends JFrame {


	private static final long serialVersionUID = 1L;

	private NetflixCallback callback;

	private JPanel contentPane;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private List<JRadioButton> buttons = new ArrayList<>();
	private JTextPane textPane;
	private JToggleButton buttonOK;
	private JButton buttonStart;
	private JPanel panelQuestion;
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
		
		panelQuestion = new JPanel();
		
		JRadioButton radioButton1 = new JRadioButton("choice 1");
		buttonGroup.add(radioButton1);
		
		JRadioButton radioButton0 = new JRadioButton("choice 0");
		buttonGroup.add(radioButton0);			
				
		JRadioButton radioButton2 = new JRadioButton("choice 2");
		buttonGroup.add(radioButton2);
				
		JRadioButton radioButton3 = new JRadioButton("choice 3");
		buttonGroup.add(radioButton3);
		
		buttons.add(radioButton0);
		buttons.add(radioButton1);
		buttons.add(radioButton2);
		buttons.add(radioButton3);
		
		buttonOK = new JToggleButton("OK");
		/*
		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOKActionPerformed(e);
			}
		});
		*/
		
		textPane = new JTextPane();
		textPane.setEditable(false);
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
		GroupLayout gl_panelQuestion = new GroupLayout(panelQuestion);
		gl_panelQuestion.setHorizontalGroup(
			gl_panelQuestion.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelQuestion.createSequentialGroup()
					.addGap(147)
					.addGroup(gl_panelQuestion.createParallelGroup(Alignment.LEADING)
						.addComponent(radioButton0, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(radioButton1, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(radioButton2, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(radioButton3, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(buttonOK, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addGap(138))
				.addGroup(Alignment.LEADING, gl_panelQuestion.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelQuestion.setVerticalGroup(
			gl_panelQuestion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelQuestion.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButton0)
					.addComponent(radioButton1)
					.addComponent(radioButton2)
					.addComponent(radioButton3)
					.addGap(2)
					.addComponent(buttonOK)
					.addContainerGap(102, Short.MAX_VALUE))
		);
		panelQuestion.setLayout(gl_panelQuestion);
		contentPane.add(panelQuestion, "name_60576457343619");
		
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
	

	/**
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
	 * Start quiz
	 * @param e
	 */
	private void buttonStartActionPerformed(ActionEvent e) {
		CardLayout cardLayout = (CardLayout)contentPane.getLayout();
		cardLayout.next(contentPane);
		
		callback.start(contentPane, textPane, buttons, endText, buttonOK, buttonGroup);
	}
	
	
	/*
	private void buttonOKActionPerformed(ActionEvent e) {
		
		System.out.println(buttonOK.isSelected());
		
		if (buttonGroup.getSelection() != null) {
			Question question = new Question();
	        question.description = textPane.getText();
	        for (JRadioButton jRadioButton : buttons) {
				if(jRadioButton.isSelected()) {
					question.selected = jRadioButton.getText();
				}
			}
			callback.accept(question);
			buttonGroup.clearSelection();				
			
		}
		
	}
	*/
	
	/**
	 * Restart quiz
	 * @param e
	 */
	private void buttonRestartActionPerformed(ActionEvent e) {
		CardLayout cardLayout = (CardLayout)contentPane.getLayout();
		cardLayout.next(contentPane);
	}
}
