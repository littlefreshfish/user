package com.js.mail.userapp.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class BeanCopyUtil {

    /**
     * 复制一个对象
     * @param obj  源对象
     * @param clazz  字节码就是是需要转换生成的对象的类型
     * @return
     * @param <T>
     */
    public static <T>T copyObject(Object obj,Class<T> clazz){
        T t = null;
        try {
            t = clazz.newInstance();
            BeanUtils.copyProperties(obj,t);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    /**
     * 复制一个集合
     * @param objs
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T>List<T> copyList(List objs,Class<T> clazz){
        ArrayList<T> ts = new ArrayList<>();
        try {
            for (Object obj : objs) {
                T t = clazz.newInstance();
                BeanUtils.copyProperties(obj,t);
                ts.add(t);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return ts;
    }

    /**
     * 复制一个page
     * @param page
     * @param clazz
     * @return
     * @param <T>
     */
    public static <T> Page<T> copyPage(Page page, Class<T> clazz){
        List<T> ts = new ArrayList<>();
        List records = page.getRecords();
        try {
            for (Object obj : records) {
                T t = clazz.newInstance();
                BeanUtils.copyProperties(obj,t);
                ts.add(t);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Page<T> tPage = new Page<>();
        tPage.setRecords(ts);
        tPage.setTotal(page.getTotal());
        tPage.setCurrent(page.getCurrent());
        tPage.setSize(page.getSize());
        tPage.setPages(page.getPages());
        return tPage;
    }



}
