package models;

import javax.persistence.Entity;
import javax.persistence.Id;


import com.avaje.ebean.Model;
import play.data.validation.*;

@Entity
public class Director extends Model {
	
	@Id
	public Long id;
	
	@Constraints.Required
	public String nome;
	
	public static Finder<Long, Director> finder = new Finder<Long, Director>(Long.class, Director.class);

	@Override
	public void save() {
		super.save();
	}	
	
}
