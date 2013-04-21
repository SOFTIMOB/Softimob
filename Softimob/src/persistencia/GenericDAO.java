package persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class GenericDAO {

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
			session.close();
		}
	}
}
