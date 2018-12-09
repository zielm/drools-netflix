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

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class Netflix {
	
	private static KieSession kSession;
	
	public static void main(String[] args) {
		// KieServices is the factory for all KIE services
        KieServices ks = KieServices.Factory.get();

        // From the kie services, a container is created from the classpath
        KieContainer kc = ks.getKieClasspathContainer();

        new Netflix().init(kc, true);
	}
	
	public Netflix() {
		
	}
	
	public static void setkSession(KieSession kSession) {
		Netflix.kSession = kSession;
	}
	
	public static KieSession getkSession() {
		return Netflix.kSession;
	}
	
	public void init(KieContainer kc, boolean exitOnClose) {
		NetflixWindow ui = new NetflixWindow(new NetflixCallback(kc));
		ui.create();
	}
	
	public static class NetflixWindow extends JFrame {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private NetflixCallback callback;

		private JPanel contentPane;
		private ButtonGroup buttonGroup = new ButtonGroup();
		private List<JRadioButton> buttons = new ArrayList<>();
		private JTextPane textPane;
		private JButton buttonOK;
		private JButton buttonStart;
		private JPanel panelQuestion;
		private JPanel panelStart;
		
		/**
		 * Create the frame.
		 */	
		
		public NetflixWindow(NetflixCallback callback) {
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
			
			buttonOK = new JButton("OK");
			buttonOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonOKActionPerformed(e);
				}
			});
			
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
			
			//callback.start((JFrame)this);
			callback.start(textPane, buttons);
		}
		
		/**
		 * Choose the answer
		 * @param e
		 */
		private void buttonOKActionPerformed(ActionEvent e) { 
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
		
	}
	
	public static class NetflixCallback {
		
	    private KieContainer kcontainer;
//	    private KieSession kSession;
	
	    public NetflixCallback(KieContainer kcontainer) {
	        this.kcontainer = kcontainer;
	    }
	    
	   public void start(JTextPane textPane, List<JRadioButton> buttons) {
		   setkSession(kcontainer.newKieSession("netflix-rules"));
		   kSession.setGlobal("buttons", buttons);
		   kSession.setGlobal("textPane", textPane);
	       getkSession().fireAllRules();

	   }
	    
	    public void accept(Question question) {
	        kSession.insert( question );
	        kSession.fireAllRules();
	
	    }
	}
	

	public static class Question {
		
		public String description;
		public List<String> choices;
		public String selected;
		
		public Question() {
			description = "";
			choices = null;
			selected = "";
		}
		
		public Question(String description, List<String> choices) {
			this.description = description;
			this.choices = choices;
			selected = "";
		}
		
	}
 

}
