package persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public abstract class DAO {

	private static SessionFactory sessionFactory;
	
	protected SessionFactory getSessionFactory(){
		if(sessionFactory == null)
			sessionFactory = new AnnotationConfiguration().buildSessionFactory();
		return sessionFactory;
	}

	public void operacaoBancoDados(Transacao transacao){
		Session session = sessionFactory.openSession();
		
		Transaction trx = session.getTransaction();
		trx.begin();
		
		try{
			transacao.run(session);
			
			trx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	protected void delete(Transacao transacao){
		Session session = sessionFactory.openSession();
		
		Transaction trx = session.getTransaction();
		trx.begin();
		
		try{
			transacao.run(session);
			
			trx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public abstract <T> List<T> findAll();
	
}
