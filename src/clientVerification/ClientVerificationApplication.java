package clientVerification;

import org.restlet.Application;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;
import org.restlet.routing.Router;

import com.google.gson.Gson;

public class ClientVerificationApplication extends Application{

	static Gson gson = new Gson();
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
		router.attach("/verify", new Restlet() {
		    public void handle(Request request, Response response) {
		        if (request.getMethod().equals(Method.POST)) {
		            System.out.println(request.getEntityAsText());
		        } 
		    }
		});
		return router;
	}

}
