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
	
	public Result alterar(Long id){
		diretorForm.fill(Director.finder.byId(id));
		Form<Director> alterarform = diretorForm.bindFromRequest();
		if(alterarform.hasErrors()){
			return badRequest(views.html.alterarDiretor.render(id, alterarform));			
		}
		alterarform.get().update();
		flash("sucesso", "Diretor "+alterarform.get().nome+" alterado com sucesso");
		return redirect(routes.DiretorCRUD.list());
		
		
	}
	
	public Result detalhar(Long id){
		diretorForm.fill(Director.finder.byId(id));
		return ok(views.html.alterarDiretor.render(id, diretorForm));
	}
	
	public Result deletar(Long id){
		Director.finder.ref(id).delete();
		flash("sucesso", "Diretor removido com sucesso");
		return redirect(routes.DiretorCRUD.list());
	}
	
}
