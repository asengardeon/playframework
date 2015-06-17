package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public Result sobre(){
    	//return ok("Sobre");
    	return ok(views.html.sobre.render("Top 1000 filmes cult", play.core.PlayVersion.current()));
    }

}
