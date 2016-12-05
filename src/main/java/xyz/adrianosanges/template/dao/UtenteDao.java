package xyz.adrianosanges.template.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.adrianosanges.template.model.Utente;

@Repository("utenteDao")
public class UtenteDao extends AbstractDao {
		
	 public void saveCliente(Utente cliente) {
	        persist(cliente);
	    }
	 
	 @SuppressWarnings("unchecked")
		public Utente findByUserName(String username) {
			List<Utente> users = new ArrayList<Utente>();
	 
			users = getSession()
				.createQuery("from Utente where upper(email)=:us")
				.setParameter("us", username.toUpperCase())
				.list();
			
			if (users.size() > 0) {
				return users.get(0);
			} else {
				return null;
			}
	 
		}

}
