
package br.com.pontoEletronico.dal;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public final class EntityManagerFactoryService implements Serializable{

    private static final long serialVersionUID = -6451288415731404127L;
    private static final Logger LOG = Logger.getLogger(EntityManagerFactoryService.class.getName());
    private static final Map<String, EntityManagerFactory> FACTORY = new HashMap<String, EntityManagerFactory>();

    public static EntityManagerFactory getEntityManagerFactory(String persistenceUnitName, Map<String, String> propMap) {
        if (FACTORY.containsKey(persistenceUnitName)) {
            return FACTORY.get(persistenceUnitName);
        }

        EntityManagerFactory emf = null;

        if (!propMap.isEmpty()) {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName, propMap);
        } else {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        }

        FACTORY.put(persistenceUnitName, emf);
        return emf;
    }

    public static void closeFactories() {
        LOG.info("Fechando todas as Entity Manager Factories");
        FACTORY.values().stream().forEach(fc -> {
            fc.close();
        });
        FACTORY.clear();
    }

}
