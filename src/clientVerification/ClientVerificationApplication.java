package clientVerification;

import java.util.Map;
import org.json.*;

import org.restlet.Application;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.routing.Router;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.routing.Redirector;
import com.google.gson.Gson;

public class ClientVerificationApplication extends Application{

	static int a = 0;
	static Gson gson = new Gson();
	public Restlet createInboundRoot() {
		Router router = new Router(getContext());
//		router.attach("/index", new Restlet() {
//		    public void handle(Request request, Response response) {
//		        if (request.getMethod().equals(Method.GET)) {
//		        	StringBuilder html = new StringBuilder();
//		        	response.setStatus(Status.SUCCESS_OK);
//		        	html.append("<!DOCTYPE html> <html lang='en'> <head> <meta charset='utf-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'> <meta name='viewport' content='width=device-width, initial-scale=1'> <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags --> <title>Virtual Stock Market</title>\r\n"+"<!-- Bootstrap --> <!-- <link href='css/bootstrap.min.css' rel='stylesheet'> --> <!-- Latest compiled and minified CSS --> <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>"+"<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries --> <!-- WARNING: Respond.js doesn't work if you view the page via file:// --> <!--[if lt IE 9]> <script src='https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js'></script> <script src='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'></script> <![endif]--> </head> <body> <div class='container'> <h1>Virtual Stock Market</h1> <div class='jumbotron'> <div class='row'> <div class='col-xs-5'> <form method='POST' action='http://localhost:9000/home'> <div class='form-group'> <label for='exampleInputEmail1'>Email address</label> <input type='email' class='form-control' name='email' id='exampleInputEmail1' placeholder='Email'> </div> <div class='form-group'> <label for='exampleInputPassword1'>Password</label> <input type='password' class='form-control' name='password' id='exampleInputPassword1' placeholder='Password'> </div> <button type='Login' class='btn btn-default'>Login</button> </form> </div> <div class='col-xs-2'> </div> <div class='col-xs-5'> <form> <div class='form-group'> <div class='row'> <div class='col-xs-6'> <input type='text' class='form-control' id='inputFirstName' placeholder='First Name'> </div> <div class='col-xs-6'> <input type='text' class='form-control' id='inputLastName' placeholder='Last Name'> </div> </div> </div> <div class='form-group'> <input type='email' class='form-control' id='inputEmail' placeholder='Email'> </div> <div class='form-group'> <input type='password' class='form-control' id='inputPassword' placeholder='Password'> </div> <button type='Login' class='btn btn-default'>Register</button> </div> </div> </div> </div> <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> <!-- Include all compiled plugins (below), or include individual files as needed --> <!-- <script src='js/bootstrap.min.js'></script> --> <!-- Latest compiled and minified JavaScript --> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script> <script src='js/index.js'></script> </body> </html>");
//		        	String htmlPage = "<!DOCTYPE html> <html lang='en'> <head> <meta charset='utf-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'> <meta name='viewport' content='width=device-width, initial-scale=1'> <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags --> <title>Virtual Stock Market</title>"+"<!-- Bootstrap --> <!-- <link href='css/bootstrap.min.css' rel='stylesheet'> --> <!-- Latest compiled and minified CSS --> <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'>"+"<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries --> <!-- WARNING: Respond.js doesn't work if you view the page via file:// --> <!--[if lt IE 9]> <script src='https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js'></script> <script src='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'></script> <![endif]--> </head> <body> <div class='container'> <h1>Virtual Stock Market</h1> <div class='jumbotron'> <div class='row'> <div class='col-xs-5'> <form method='POST' action='http://localhost:9000/home'> <div class='form-group'> <label for='exampleInputEmail1'>Email address</label> <input type='email' class='form-control' name='email' id='exampleInputEmail1' placeholder='Email'> </div> <div class='form-group'> <label for='exampleInputPassword1'>Password</label> <input type='password' class='form-control' name='password' id='exampleInputPassword1' placeholder='Password'> </div> <button type='Login' class='btn btn-default'>Login</button> </form> </div> <div class='col-xs-2'> </div> <div class='col-xs-5'> <form> <div class='form-group'> <div class='row'> <div class='col-xs-6'> <input type='text' class='form-control' id='inputFirstName' placeholder='First Name'> </div> <div class='col-xs-6'> <input type='text' class='form-control' id='inputLastName' placeholder='Last Name'> </div> </div> </div> <div class='form-group'> <input type='email' class='form-control' id='inputEmail' placeholder='Email'> </div> <div class='form-group'> <input type='password' class='form-control' id='inputPassword' placeholder='Password'> </div> <button type='Login' class='btn btn-default'>Register</button> </div> </div> </div> </div> <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> <!-- Include all compiled plugins (below), or include individual files as needed --> <!-- <script src='js/bootstrap.min.js'></script> --> <!-- Latest compiled and minified JavaScript --> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script> <script src='js/index.js'></script> </body> </html>";
//		        	String htmlPage = "<html>Here</html>";
//		        	response.setEntity(htmlPage, MediaType.TEXT_HTML);
//		        	response.redirectTemporary("/test");
//		        } 
//		    }
//		});
		
		router.attach("/home", new Restlet() {
		    public void handle(Request request, Response response) {
		        if (request.getMethod().equals(Method.POST)) {
		        	String name = request.getEntityAsText().split("%")[0].split("=")[1];
		        	StringBuilder html = new StringBuilder();
		        	if(true) {
			        	html.append("<!DOCTYPE html> <html lang='en'> <head> <meta charset='utf-8'> <meta http-equiv='X-UA-Compatible' content='IE=edge'> <meta name='viewport' content='width=device-width, initial-scale=1'> <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags --> <title>Virtual Stock Market</title> <!-- Bootstrap --> <!-- <link href='css/bootstrap.min.css' rel='stylesheet'> --> <!-- Latest compiled and minified CSS --> <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css' integrity='sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u' crossorigin='anonymous'> <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries --> <!-- WARNING: Respond.js doesn't work if you view the page via file:// --> <!--[if lt IE 9]> <script src='https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js'></script> <script src='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'></script> <![endif]--> </head> <body> <div class='container'> <div class='jumbotron'> <div class='row'> <div class='col-xs-12'> <h1>Welcome,<span>"+name+"</span></h1> </div> </div> <div class='row'> <div class='col-xs-6'> <h3> Grossing Stocks </h3> <table class='table'> <thead> <tr> <th>Stock</th> <th>Price(euro)</th> <th> </tr> </thead> <tbody> <tr> <td>ABC</td> <td>25</td> </tr> <tr> <td>XYZ</td> <td>50</td> </tr> </tbody> </table> </div> <div class='col-xs-6'> <h3> Leader Board </h3> <table class='table'> <thead> <tr> <th>Name</th> <th>Amount(euro)</th> <th> </tr> </thead> <tbody> <tr> <td>ABC</td> <td>25</td> </tr> <tr> <td>XYZ</td> <td>50</td> </tr> </tbody> </table> </div> </div> <p><a class='btn btn-primary btn-lg' href='#' role='button'>Show All</a></p> </div> </div> <!-- jQuery (necessary for Bootstrap's JavaScript plugins) --> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> <!-- Include all compiled plugins (below), or include individual files as needed --> <!-- <script src='js/bootstrap.min.js'></script> --> <!-- Latest compiled and minified JavaScript --> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js' integrity='sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa' crossorigin='anonymous'></script> </body> </html>");
			        	
		        	}else {
		        		response.redirectTemporary("/loginError");
//		        		router.attach("/indexError", redirector);
		        	}
		        	response.setEntity(html.toString(), MediaType.TEXT_HTML);
		        	
		            System.out.println(request.getEntityAsText());
		        }
		    }
		});
		
		router.attach("/allStocks", new Restlet() {
		    public void handle(Request request, Response response) {
		        if (request.getMethod().equals(Method.GET)) {
//		        	String name = request.getEntityAsText().split("%")[0].split("=")[1];
//		        	StringBuilder html = new StringBuilder();
//		        	if(request.getEntityAsText().startsWith("aname")) {
		        	System.out.println("All Stocks");
//			        	html.append("<HTML>Error Login</HTML>");
			        	
//		        	}else {
//		        		Redirector redirector = new Redirector(getContext(), "<html>error</html>");
//		        		router.attach("/indexError", redirector);
//		        	}
		        	a++;
		        	//Request stockmarket to send all shares data
		        	String jsonString = "{ \"name\":\"John\", \"age\":"+a+", \"city\":\"New York\" }";
		        	JSONObject jsonObj = null;
					try {
						jsonObj = new JSONObject(jsonString);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	response.setEntity(jsonObj.toString(), MediaType.APPLICATION_JSON);
		        	response.setAccessControlAllowOrigin("*");
		        	response.setStatus(Status.SUCCESS_OK);
		        }
		    }
		});
		
		router.attach("/allPlayers", new Restlet() {
		    public void handle(Request request, Response response) {
		        if (request.getMethod().equals(Method.GET)) {
//		        	String name = request.getEntityAsText().split("%")[0].split("=")[1];
//		        	StringBuilder html = new StringBuilder();
//		        	if(request.getEntityAsText().startsWith("aname")) {
		        	System.out.println("All Players");
//			        	html.append("<HTML>Error Login</HTML>");
			        	
//		        	}else {
//		        		Redirector redirector = new Redirector(getContext(), "<html>error</html>");
//		        		router.attach("/indexError", redirector);
//		        	}
		        	a++;
		        	//Request stockmarket to send all shares data
		        	String jsonString = "{ \"name\":\"John\", \"age\":"+a+", \"city\":\"New York\" }";
		        	JSONObject jsonObj = null;
					try {
						jsonObj = new JSONObject(jsonString);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        	response.setEntity(jsonObj.toString(), MediaType.APPLICATION_JSON);
		        	response.setAccessControlAllowOrigin("*");
		        	response.setStatus(Status.SUCCESS_OK);
		        }
		    }
		});
		return router;
	}

}
