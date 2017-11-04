package clientVerification;

import org.restlet.Component;
import org.restlet.data.Protocol;


public class ClientVerficationServer {
	public static void main(String args[]) {
		Component component = new Component();
        component.getServers().add(Protocol.HTTP, 9000);
        component.getDefaultHost().attach("", new ClientVerificationApplication());
        try {
			component.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
