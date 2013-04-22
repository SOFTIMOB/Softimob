package persistencia;

import org.hibernate.Session;

public interface Transacao {

	void run(Session session);

}
