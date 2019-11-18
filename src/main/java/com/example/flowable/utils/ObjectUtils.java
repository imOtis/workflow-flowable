package com.example.flowable.utils;

import com.example.flowable.common.core.dto.ProDefiDto;
import com.example.flowable.common.core.dto.ProInstDto;
import com.example.flowable.common.core.dto.ProMoldDto;
import com.example.flowable.common.core.dto.ProTaskDto;
import org.flowable.engine.repository.Model;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: AAS
 * @create: 周四 11月 2019
 * @description: Object工具类
 */
public class ObjectUtils {

    /**
     * Flowable 数据转换
     *
     * @param t    DTO实例
     * @param list Query集合
     * @param <T>
     * @param <M>
     * @return
     */
    public static <T, M> List<T> convert2Dto(T t, List<M> list) {
        List<T> result = new ArrayList<>();
        if (t instanceof ProDefiDto) {
            list.forEach(value -> result.add((T) new ProDefiDto((ProcessDefinition) value)));
        } else if (t instanceof ProInstDto) {
            list.forEach(value -> result.add((T) new ProInstDto((ProcessInstance) value)));
        } else if (t instanceof ProMoldDto) {
            list.forEach(value -> result.add((T) new ProMoldDto((Model) value)));
        } else {
            list.forEach(value -> result.add((T) new ProTaskDto((Task) value)));
        }
        return result;
    }

    /**
     * 判断对象属性是全部为Null
     * 注: 对象属性中任一属性不为null,则返回false,否则返回true
     *
     * @param o
     * @return
     * @throws Exception
     */
    public static boolean isAllNull(Object o) throws Exception {
        boolean result = false;
        Class cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object val = field.get(o);
            if (val == null) {
                result = true;
                continue;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }
}
