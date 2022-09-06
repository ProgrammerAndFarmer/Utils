package com.huajie.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * JackSon 对于日期对象，默认返回时间戳 TimeStamp 格式，需要手动修改其格式，才能传回日期的字符串形式给前端页面
 */
public class JsonUtils {
    public static String getJson(Object date) {
        return getJson(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static  String getJson(Object date, String dateFomat) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFomat);
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(date);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
