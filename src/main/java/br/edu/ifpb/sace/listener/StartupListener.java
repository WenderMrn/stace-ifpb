package br.edu.ifpb.sace.listener;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import br.edu.ifpb.sace.bean.OfertaEstagioBean;
import br.edu.ifpb.sace.bean.UtilBean;
import br.edu.ifpb.sace.dao.PersistenceUtil;

@WebListener
public class StartupListener implements ServletContextListener {
	private static Logger logger = Logger.getLogger(StartupListener.class);

	public void contextDestroyed(ServletContextEvent arg0) {
		EntityManagerFactory emf = PersistenceUtil.getEntityManagerFactory();
		if (emf != null) {
			emf.close();
			logger.info("Fábrica de EntityManagers fechada.");
		}
		
		
	}

	public void contextInitialized(ServletContextEvent event) {
		// Inicia a criação da fábrica de EntityManagers da JPA
		PersistenceUtil.createEntityManagerFactory("sace");
		logger.info("Fábrica de EntityManagers instanciada.");
		event.getServletContext().setAttribute("utilBean", new UtilBean());
		event.getServletContext().setAttribute("ofertaEstagioBean", new OfertaEstagioBean());
	}

}
