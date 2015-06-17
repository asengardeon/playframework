package controllers;

import java.util.List;

import models.Director;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class DiretorCRUD extends Controller {
	
	private static final Form<Director> diretorForm = Form.form(Director.class);

	public Result list(){
		List<Director> diretores = Director.finder.findList();
		return ok(views.html.diretor.render(diretores));
	}
	
	public Result novoDiretor(){
		Form<Director> form = diretorForm.bindFromRequest();
		if (form.hasErrors()){
			flash("Erro", "Foram identificados problemas no cadastro");
			return ok(views.html.novo.render(diretorForm));
		}	
		List<Director> diretores = Director.finder.findList();
		return ok(views.html.diretor.render(diretores));
	}
	
	public Result gravar(){
		Form<Director> form = diretorForm.bindFromRequest();
		Director diretor = form.get();
		diretor.save();
		flash("sucesso", "Registro gravado com sucesso");
		return redirect(routes.DiretorCRUD.list());
	}
	
	public Result detalhar(Long id){
		return TODO;
	}
}
