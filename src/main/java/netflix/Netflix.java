package netflix;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;

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
	
	
	public static class NetflixCallback {
		
	    private KieContainer kcontainer;
//	    private KieSession kSession;
	
	    public NetflixCallback(KieContainer kcontainer) {
	        this.kcontainer = kcontainer;
	    }
	    
	   public void start(JPanel contentPane, JTextPane textPane, List<JRadioButton> buttons, 
			   JTextPane endText, JToggleButton buttonOK, ButtonGroup buttonGroup) {
		   setkSession(kcontainer.newKieSession("netflix-rules"));
		   kSession.setGlobal("contentPane", contentPane);
		   kSession.setGlobal("buttons", buttons);
		   kSession.setGlobal("textPane", textPane);
		   kSession.setGlobal("endText", endText);
		   kSession.setGlobal("buttonOK", buttonOK);
		   kSession.setGlobal("buttonGroup", buttonGroup);
		   ThreadDRL thread = new ThreadDRL();
		   thread.start();
	       

	   }
	    /*
	    public void accept(Question question) {
	        kSession.insert( question );
	        kSession.fireAllRules();
	    }
	    */
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
 
	public static class ThreadDRL extends Thread {

		    public void run(){
		    	getkSession().fireAllRules();
		    }
		  }
}
