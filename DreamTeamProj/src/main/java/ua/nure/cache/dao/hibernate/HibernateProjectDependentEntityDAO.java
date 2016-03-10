package ua.nure.cache.dao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.cache.dao.ProjectDependentEntityDAO;

import java.util.List;

@Transactional
public class HibernateProjectDependentEntityDAO<T> extends HibernateDAO<T>
        implements ProjectDependentEntityDAO<T> {

    public HibernateProjectDependentEntityDAO(Class<T> classInstance, SessionFactory sessionFactory) {
        super(classInstance, sessionFactory);
    }

    @Override
    public List<T> getByProject(int projectId) {
        return (List<T>)this.getSession().createCriteria(this.classInstance)
                .add(Restrictions.eq("projectId", projectId))
                .list();
    }

    @Override
    public T getByProject(final int projectId, final int id) {
        return (T)this.getSession().createCriteria(this.classInstance)
                .add(Restrictions.eq("projectId", projectId))
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }
}