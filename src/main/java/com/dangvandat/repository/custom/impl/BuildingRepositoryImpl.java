package com.dangvandat.repository.custom.impl;

import com.dangvandat.builder.BuildingSearchBuilder;
import com.dangvandat.entity.BuildingEntity;
import com.dangvandat.repository.custom.BuildingRepositoryCustom;
import com.dangvandat.util.QuerySQLUtils;
import com.dangvandat.util.RepositoryCustomUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Repository
public class BuildingRepositoryImpl extends RepositoryCustomUtils<BuildingEntity> implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<BuildingEntity> findAll(Map<String, Object> properties, Pageable pageable, BuildingSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building A ");
        if(StringUtils.isNotBlank(builder.getStaffId())){
            sql.append(" INNER JOIN assignmentstaff as ON A.id = as.buildingid");
        }
        sql.append(" WHERE 1=1 ");
        StringBuilder sqlSearch = QuerySQLUtils.createSqlString(properties);
        sql.append(sqlSearch.toString());
        StringBuilder sqlSpecial = builSqlSpacial(builder);
        sql.append(sqlSpecial.toString());
        Query query = entityManager.createNativeQuery(sql.toString() , BuildingEntity.class);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();
    }

    @Override
    public Long getToltalItems(Map<String, Object> mapSearch , BuildingSearchBuilder builder) {
        StringBuilder sql = createSqlCountByProperties(mapSearch , builder);
        sql.append(builSqlSpacial(builder));
        Query query = entityManager.createNativeQuery(sql.toString());
        Long count = Long.parseLong(query.getSingleResult().toString());
        return count;
    }

    private StringBuilder builSqlSpacial(BuildingSearchBuilder builder) {
        StringBuilder whereClause = new StringBuilder("");
        if(StringUtils.isNotBlank(builder.getCostRentFrom())){
            whereClause.append(" AND costrent >= "+builder.getCostRentFrom()+"");
        }
        if(StringUtils.isNotBlank(builder.getCostRentTo())){
            whereClause.append(" AND costrent <= "+builder.getCostRentTo()+"");
        }

        //SELECT * FROM building b WHERE
        //EXISTS (SELECT * FROM rentarea ra WHERE b.id = ra.buildingid
        //AND (ra.value >= '100' AND ra.value <= '300'))

        if(StringUtils.isNotBlank(builder.getAreaRentFrom()) || StringUtils.isNotBlank(builder.getAreaRentTo())){
            whereClause.append(" AND EXISTS (SELECT * FROM rentarea ra WHERE (A.id = ra.buildingid");
            if(StringUtils.isNotBlank(builder.getAreaRentFrom())){
                whereClause.append(" AND (ra.value >= "+builder.getAreaRentFrom()+"");
            }
            if(StringUtils.isNotBlank(builder.getAreaRentTo())){
                whereClause.append(" AND ra.value <= "+builder.getAreaRentTo()+"");
            }
            whereClause.append(")))");
        }
        if(builder.getBuildingTypes().length > 0){
            whereClause.append(" AND (A.type LIKE '%"+builder.getBuildingTypes()[0]+"%'");
            //java 7
            /*for (String type : builder.getBuildingTypes()){
                if(!type.equals(builder.getBuildingTypes()[0])){
                    whereClause.append(" OR A.type LIKE '%"+type+"%'");
                }
            }*/

            // java 8
            Arrays.stream(builder.getBuildingTypes()).filter(item -> !item.equals(builder.getBuildingTypes()[0]))
                    .forEach(item -> whereClause.append(" OR A.type LIKE '%"+item+"%'"));
            whereClause.append(")");
        }
        return  whereClause;
    }

    private StringBuilder createSqlFindAll(Map<String, Object> properties) {
        StringBuilder result = new StringBuilder("");
        if(properties != null && properties.size() > 0){
            String[] params = new String[properties.size()];
            Object[] value = new Object[properties.size()];
            int i = 0;
            for(Map.Entry<? , ?> item : properties.entrySet()){
                params[i] = (String) item.getKey();
                value[i] = item.getValue();
                i++;
            }
            for(int i1 = 0 ; i1 < params.length ; i1++){
                if(value[i1] != null){
                    if(value[i1] instanceof String){
                        result.append(" AND LOWER("+params[i1]+") LIKE '%"+value[i1].toString().toLowerCase()+"%'");
                    }else if(value[i1] instanceof Integer){
                        result.append(" AND "+params[i1]+" = "+value[i1]+" ");
                    }else if(value[i1] instanceof Long){
                        result.append(" AND "+params[i1]+" = "+value[i1]+" ");
                    }
                }
            }
        }
        return result;
    }

    private StringBuilder createSqlCountByProperties(Map<String , Object> properties , BuildingSearchBuilder builder){
        StringBuilder result = new StringBuilder("SELECT COUNT(*) FROM building A ");
        if(StringUtils.isNotBlank(builder.getStaffId())){
            result.append(" INNER JOIN assignmentstaff as ON A.id = as.buildingid");
        }
        result.append(" WHERE 1=1 ");
        if(properties != null && properties.size() > 0){
            /*String[] params = new String[properties.size()];
            Object[] value = new Object[properties.size()];
            int i = 0;
            for(Map.Entry<? , ?> item : properties.entrySet()){
                params[i] = (String) item.getKey();
                value[i] = item.getValue();
                i++;
            }
            for(int i1 = 0 ; i1 < params.length ; i1++){
                if(value[i1] != null){
                    if(value[i1] instanceof String){
                        result.append(" AND LOWER("+params[i1]+") LIKE '%"+value[i1].toString().toLowerCase()+"%'");
                    }else if(value[i1] instanceof Integer){
                        result.append(" AND "+params[i1]+" = "+value[i1]+" ");
                    }else if(value[i1] instanceof Long){
                        result.append(" AND "+params[i1]+" = "+value[i1]+" ");
                    }
                }
            }*/
            result.append(QuerySQLUtils.createSqlString(properties).toString());
        }
        return result;
    }


}
