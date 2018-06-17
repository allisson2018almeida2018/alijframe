
package br.com.pontoEletronico.dal;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;


public final class EntityManagerHelper<T> implements Serializable {

    private static final long serialVersionUID = -2907167054223287951L;
    private final Map<String, ThreadLocal<EntityManager>> sessions = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(EntityManagerHelper.class.getName());
    private static final Map<String, String> propMap = new HashMap();
    public final static String MYSQL_PU = "MYSQL_PU";
    public final static int SALVAR = 0, ATUALIZAR = 1, DELETAR = 2;

    public EntityManagerHelper() {
    }

    public boolean getOperation(int operation_type, Object object, String persistence_unit) {
        EntityManager session = getSession(persistence_unit);
        try {
            session.getTransaction().begin();
            switch (operation_type) {
                case SALVAR:
                    LOG.info("Salvando registro no banco de dados");
                    session.persist(object);
                    session.getTransaction().commit();
                    break;
                case ATUALIZAR:
                    LOG.info("Atualizando registro no banco de dados");
                    session.merge(object);
                    session.getTransaction().commit();
                    break;
                case DELETAR:
                    LOG.info("Deletando registro no banco de dados");
                    session.remove(session.merge(object));
                    session.getTransaction().commit();
                    break;
            }
            this.closeSession(persistence_unit);
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            this.closeSession(persistence_unit);
            e.printStackTrace();
            return false;
        }
    }

    private EntityManager getSession(String persistence_unit) {
        EntityManager session = null;
        if (sessions.isEmpty()) {
            sessions.put(persistence_unit, new ThreadLocal<>());
            session = sessions.get(persistence_unit).get();
            session = session == null ? EntityManagerFactoryService.getEntityManagerFactory(persistence_unit, propMap).createEntityManager() : session;
        } else {
            session = sessions.get(persistence_unit).get();
            session = session == null ? EntityManagerFactoryService.getEntityManagerFactory(persistence_unit, propMap).createEntityManager() : session;
        }
        return session;
    }

    private void closeSession(String persistence_unit) {
        EntityManager session = null;
        if (!sessions.isEmpty()) {
            session = sessions.get(persistence_unit).get();
            LOG.info("Encerrando sessão do banco de dados");
            if (session != null) {
                if (session.isOpen()) {
                    session.close();
                }
            }
        }
        LOG.info("Removendo Entity Manager desta sessão");
        sessions.remove(persistence_unit);
    }

    public void closeAll() {
        LOG.info("Encerrando todas as sessões");
        sessions.clear();
    }

    public Connection getConnection(String persistence_unit) {
        try {
            EntityManager entityManager = getSession(persistence_unit);
            Connection conn = ((EntityManagerImpl) (entityManager.getDelegate())).getServerSession().getAccessor().getConnection();
            return conn;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<T> getObjectList(String strHQL, String persistence_unit) {
        try {
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            List<T> objects = query.getResultList();
            this.closeSession(persistence_unit);
            return objects;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public List<T> getObjectList(String strHQL, String strParam, Object valor, String persistence_unit) {
        try {
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            query.setParameter(strParam, valor);
            List<T> objects = query.getResultList();
            this.closeSession(persistence_unit);
            return objects;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public List<?> getObjectListNamedQuery(Class<?> classType, String namedQuery, String[] strParam, Object[] valor, String persistence_unit) {
        try {
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createNamedQuery(namedQuery, classType);
            int cont = 0;
            if (strParam != null) {
                for (String p : strParam) {
                    query.setParameter(p, valor[cont++]);
                }
            }
            List<?> objects = query.getResultList();
            this.closeSession(persistence_unit);
            return objects;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            e.printStackTrace();
            return null;
        }
    }

    public T getObjectNamedQuery(Class<T> classType, String namedQuery, String strParam, Object valor, String persistence_unit) {
        try {
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createNamedQuery(namedQuery, classType);
            int cont = 0;
            if (strParam != null) {
                query.setParameter(strParam, valor);
            }
            T object = (T) query.getSingleResult();
            this.closeSession(persistence_unit);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public List<T> getObjectList(String strHQL, String strParam, Boolean valor, String persistence_unit) {
        try {
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            query.setParameter(strParam, valor);
            List<T> objects = query.getResultList();
            this.closeSession(persistence_unit);
            return objects;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public Object getObject(String strHQL, String persistence_unit) {
        try {
            Object temp;
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            List<T> objects = query.getResultList();
            this.closeSession(persistence_unit);
            temp = objects.get(0);
            return temp;
        } catch (Exception e) {
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public Object getObject(String strHQL, String strParam, Object valor, String persistence_unit) {
        try {
            Object temp;
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            query.setParameter(strParam, valor);
            List<T> objects = query.getResultList();
            this.closeSession(persistence_unit);
            temp = objects.get(0);
            return temp;
        } catch (Exception ex) {
            this.closeSession(persistence_unit);
            return null;
        }
    }

    public Object getObject(String strHQL, String[] strParam, String[] valor, String persistence_unit) {
        try {
            Object temp;
            EntityManager session = this.getSession(persistence_unit);
            session.getTransaction().begin();
            Query query = session.createQuery(strHQL);
            for (int i = 0; i < strParam.length; i++) {
                if (strParam[i] != null) {
                    query.setParameter(strParam[i], valor[i]);
                }
            }
            Object objects = query.getSingleResult();
            this.closeSession(persistence_unit);
            temp = objects;
            return temp;
        } catch (Exception ex) {
            this.closeSession(persistence_unit);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

}
