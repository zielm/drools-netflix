package netflix;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
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
	    
	   public void start(JFrame frame, JTextPane endText) {
		   setkSession(kcontainer.newKieSession("netflix-rules"));
		   kSession.setGlobal("endText", endText);
		   kSession.setGlobal("frame", frame);
	       getkSession().fireAllRules();

	   }
	}
	
 

}
