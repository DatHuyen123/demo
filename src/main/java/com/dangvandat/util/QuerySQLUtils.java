package com.dangvandat.util;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.text.DateFormat;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class QuerySQLUtils {

    private final static Logger logger = Logger.getLogger(QuerySQLUtils.class);

    public static String formatLikeStringSql(String value){
        String valueLike = escapeSQL(value);
        return "'%"+valueLike+"%'";
    }

    public static String escapeSQL(String value){
        String result = value.trim().replace("/", "\\/").replace("_", "\\_").replace("%", "\\%");
        return result;
    }

    public static Timestamp convertStringToTimestamp(String date , String dateFormat){
        try{
            if(!StringUtils.isNotBlank(date)){
                return null;
            }else{
                DateFormat formatter = new SimpleDateFormat(dateFormat);
                Timestamp result = null;
                if(date.contains("T")){
                    Date dateAfterFormat = (Date) formatter.parse(date.trim().replaceAll("Z$", "+0000"));
                    result = new Timestamp(dateAfterFormat.getTime());
                }else{
                    Date dateAfterFormat = (Date) formatter.parse(date);
                    result = new Timestamp(dateAfterFormat.getTime());
                }
                return result;
            }
        }catch (Exception ex){
            logger.error("format date error " + ex);
            return null;
        }
    }

    /*public static StringBuilder createSqlFindAll(Map<String, Object> properties){
        StringBuilder result = new StringBuilder("");
        if(properties.isEmpty() && properties.size() > 0){
            for(Map.Entry<?,?> item : properties.entrySet()){
                if(item.getValue() instanceof String){
                    result.append(" AND LOWER("+item.getKey()+") LIKE '%"+((String) item.getValue()).toString().toLowerCase()+"%' ");
                }else if(item.getValue() instanceof  Integer || item.getValue() instanceof Long){
                    result.append(" AND "+item.getKey()+" = "+item.getValue()+" ");
                }
            }
        }
        return result;
    }*/

    public static StringBuilder createSqlString(Map<String, Object> properties){
        StringBuilder result = new StringBuilder();
        properties.forEach((key , value) -> {
            if(value instanceof String){
                result.append(" AND LOWER("+key+") LIKE "+formatLikeStringSql(((String) value)).toLowerCase()+" ");
            }else if(value instanceof  Integer || value instanceof Long){
                result.append(" AND "+key+" = "+value+" ");
            }
        });
        return result;
    }
}
