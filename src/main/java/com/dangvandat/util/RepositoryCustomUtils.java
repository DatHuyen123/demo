package com.dangvandat.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

public class RepositoryCustomUtils<T> {

    /*@Autowired
    @Qualifier("transactionManager")
    private JpaTransactionManager jpaTransactionManager;*/

    public <T> List<T> getResultList(EntityManager entityManager,String sql){
        return this.getResultList(entityManager,sql ,"", null);
    }

    public <T> List<T> getSingleResult(EntityManager entityManager,String sql , String resultSetMappingName){
        return this.getSingleResult(entityManager, sql , resultSetMappingName , null);
    }

    public <T> List<T> getResultList(EntityManager entityManager,String sql , Class<?> classZ , Map<String , Object> parameter){
        try{
            //entityManager = jpaTransactionManager.getEntityManagerFactory().createEntityManager();
            Query query = createQuery(entityManager , sql , classZ , parameter);
            return query.getResultList();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }

    public <T> List<T> getResultList(EntityManager entityManager,String sql, String resultSetMappingName, Map<String, Object> parameters) {
        try {
            //entityManager = jpaTransactionManager.getEntityManagerFactory().createEntityManager();
            Query query = createQuery(entityManager, sql, resultSetMappingName, parameters);
            return query.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private Query createQuery(EntityManager entityManager, String sql, String resultSetMappingName,
                              Map<String, Object> parameters) {
        Query query = null;
        if (StringUtils.isEmpty(resultSetMappingName)) {
            query = entityManager.createNativeQuery(sql);
        } else {
            query = entityManager.createNativeQuery(sql, resultSetMappingName);
        }

        if (parameters == null) {
            return query;
        }

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query;
    }

    private Query createQuery(EntityManager entityManager, String sql, Class<?> classZ,
                              Map<String, Object> parameters) {
        Query query = entityManager.createNativeQuery(sql, classZ);

        if (parameters == null) {
            return query;
        }

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query;
    }

    public <T> T getSingleResult(EntityManager entityManager,String sql , String resultSetMappingName , Map<String , Object> parameter){
        try{
            //entityManager = jpaTransactionManager.getEntityManagerFactory().createEntityManager();
            Query query = createQuery(entityManager , sql , resultSetMappingName , parameter);
            return (T) query.getSingleResult();
        }catch (Exception ex){
            return null;
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
    }
}
