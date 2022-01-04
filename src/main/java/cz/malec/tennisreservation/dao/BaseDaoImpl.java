/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.malec.tennisreservation.dao;
import cz.malec.tennisreservation.model.Persistence;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jiří Malec
 */
@Repository
public class BaseDaoImpl<T extends Persistence> {

    @Autowired
    protected SessionFactory sessionFactory;
    
    private Class<?> cl;
    
    private static Logger LOG = LoggerFactory.getLogger(BaseDaoImpl.class);
    
    public void setClass(Class<?> cl) {
        this.cl = cl;
        BaseDaoImpl.LOG = LoggerFactory.getLogger(cl);
    }

    public Integer create(Persistence entity) {
        LOG.debug("Create new {}", cl.getSimpleName());
        Session session = sessionFactory.getCurrentSession();
        session.save(this.cl.cast(entity));
        return entity.getId();
    }

    public void update(Persistence entity) {
        LOG.debug("Delete {} with id {}", cl.getSimpleName(), entity.getId());
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(this.cl.cast(entity));
    }
    
    public void delete(Persistence entity) {
        LOG.debug("Delete {} with id {}", cl.getSimpleName(), entity.getId());
        Session session = sessionFactory.getCurrentSession();
        session.delete(this.cl.cast(entity));
    }

    public T find(Integer id) {
        LOG.debug("Find {} by id {}", cl.getSimpleName(), id);
        Session session = sessionFactory.getCurrentSession();
        return (T)session.get(this.cl, id);
    }

    public List<T> all() {
        return this.all(null, null);
    }
    
    public List<T> all(String orderBy, String direction) {
        LOG.debug("Get all {}", cl.getSimpleName());
        StringBuilder sql = new StringBuilder("FROM "+this.cl.getSimpleName());
        Session session = sessionFactory.getCurrentSession();
        if(orderBy != null && direction != null) {
            sql.append(" ORDER BY " + orderBy + " " + direction);
        }
        Query query = session.createQuery(sql.toString());
        List<T> objects = query.list();
        return objects;
    }
    
    public List<T> findBy(Map<String, String> criterias) {
        LOG.debug("Get all {}", cl.getSimpleName());
        Session session = sessionFactory.getCurrentSession();
        StringBuilder sql = new StringBuilder();
        sql.append("FROM ").append(this.cl.getSimpleName()).append(" ");
        if(criterias.size() > 0) {
            sql.append("WHERE ");
        }
        int idx = 0;
        for(Map.Entry<String, String> criteria : criterias.entrySet()) {
            if(idx != 0) {
                sql.append("AND ");
            }
            sql.append(criteria.getKey()).append(" = ").append("'"+criteria.getValue()+"'");
            idx++;
        }
        Query query = session.createQuery(sql.toString());
        List<T> objects = query.list();
        return objects;
    }
    
    public T findOneBy(Map<String, String> criterias) {
        List<T> res = this.findBy(criterias);
        return res.isEmpty() ? null : res.get(0);
    }
    
}
