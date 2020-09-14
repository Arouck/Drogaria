package util;

import javax.persistence.EntityManager;

import org.junit.Test;

public class JPAUtilTest {

	@Test
	public void conectar() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		em.close();
	}

}
