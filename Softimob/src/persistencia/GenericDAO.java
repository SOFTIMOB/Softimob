package persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class GenericDAO {

	private static Session iniciaTransacao() throws Exception{
		Session session = SessionFactoryManager.getInstance().openSession();
		Transaction tx = session.getTransaction();
		
		tx.begin();
		
		return session;
	}
	
	private static Session fechaTransacao() throws Exception{
		Session session = SessionFactoryManager.getInstance().openSession();
		Transaction tx = session.getTransaction();
		
		tx.begin();
		
		return session;
	}
	
	public static <T> void salvar(List<T> objetos) {
		Session session = SessionFactoryManager.getInstance().openSession();
		Transaction tx = session.getTransaction();
		
		try {
			tx.begin();
			
			for (T object : objetos) {
				session.save(object);
			}
			
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}
	
	public static <T> void delete(List<T> objetos) {
		Session session = SessionFactoryManager.getInstance().openSession();
		Transaction tx = session.getTransaction();
		
		try {
			tx.begin();
			
			for (T object : objetos) {
				session.delete(object);
			}
			
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}
	
	public static <T> void update(List<T> objetos) {
		Session session = SessionFactoryManager.getInstance().openSession();
		Transaction tx = session.getTransaction();
		
		try {
			tx.begin();
			
			for (T object : objetos) {
				session.update(object);
			}
			
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}
	
}
