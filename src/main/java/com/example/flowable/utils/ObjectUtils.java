package com.example.flowable.utils;

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
 * @description: 对象处理工具类
 */
public class ObjectUtils {

    /**
     *
     * @param t DTO实体
     * @param list Flowable 查询集合
     * @param <T> DTO实体类型
     * @param <M> Flowable 集合类型
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static  <T,M> List<T> convert2Dto(T t, List<M> list) throws InstantiationException, IllegalAccessException {
        List<T> result = new ArrayList<>();
        for (M m : list) {
            try {
                //获取指定方法
                Method declaredMethod = t.getClass().getDeclaredMethod("getDto", m.getClass());
                declaredMethod.setAccessible(true);
                T dto = (T) declaredMethod.invoke(t, m);
                result.add(dto);
            } catch (NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     *
     * @param clazz
     * @param list
     * @param <T>
     * @param <M>
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static  <T,M> List<T> convert2DtoConstruc(Class<T> clazz, List<M> list) throws
            InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<T> result = new ArrayList<>();
        for (M m : list) {
            // invoke constructor
            Object object = clazz.getConstructor(m.getClass()).newInstance(m);
            result.add((T) object);
        }


//        list.forEach(m ->result.add(clazz.newInstance(m)));
        return result;
    }

    public static  <T,M> List<T> convert2DtoMethod(Class<T> clazz, List<M> list) throws InstantiationException, IllegalAccessException {
        List<T> result = new ArrayList<>();
        for (M m : list) {
            try {
                Method method = clazz.getMethod("getDto", m.getClass());
                Object res = method.invoke(clazz.newInstance(), m);
                result.add((T) res);
            } catch (NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 判断对象属性是全部为Null
     * 注: 对象属性中任一属性不为null,则返回false,否则返回true
     * @param
     * @return
     * @throws Exception
     */
    public static boolean isAllNull(Object o) throws Exception{
        boolean result = false;
        Class cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object val = field.get(o);
            if (val == null) {
                result = true;
                continue;
            }else {
                result = false;
                break;
            }
        }
        return result;
    }
}
