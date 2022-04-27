package org.paakciu.repository.repositorydao.domain.repository.diffutil;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author paakciu
 * @ClassName: FieldDiffEquals
 * @date: 2022/4/27 20:16
 */
public class FieldDiffEquals implements DiffEquals{

    private static final Logger logger = LoggerFactory.getLogger(FieldDiffEquals.class);

    @Override
    public Boolean compute(Object source, Object target) {
        Objects.requireNonNull(source,"source mast not be null!");
        Objects.requireNonNull(target,"target mast not be null!");

        Class clazz = source != null ? source.getClass() : target.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object targetItem = field.get(target);
                Object sourceItem = field.get(source);
                if(targetItem==null|| sourceItem==null || String.valueOf(targetItem).equals(String.valueOf(sourceItem))){
                    continue;
                }
                return Boolean.FALSE;
            }
            return Boolean.TRUE;
        } catch (IllegalAccessException e){
            logger.error("FieldDiffEquals.compute error!",e);
            throw new RuntimeException("FieldDiffEquals.compute error!");
        }
    }
}
