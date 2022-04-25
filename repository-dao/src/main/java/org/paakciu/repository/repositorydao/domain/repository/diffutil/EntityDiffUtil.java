package org.paakciu.repository.repositorydao.domain.repository.diffutil;

import org.paakciu.repository.repositorydao.domain.repository.Entity;
import org.paakciu.repository.repositorydao.domain.repository.Identifier;

import java.util.List;

/**
 * @author paakciu
 * @ClassName: EntityDiffUtil
 * @date: 2022/4/25 23:10
 */
public class EntityDiffUtil {

    public static final DiffEquals DEFAULT_EQUALS=(s,t)->Boolean.FALSE;

    public static <T extends Entity<ID>,ID extends Identifier>
        List<AbstractDiff<T>> diff(List<T> source,List<T> target,DiffEquals<T> diffEquals,Boolean ignoreEquals){

        return null;
    }
}
