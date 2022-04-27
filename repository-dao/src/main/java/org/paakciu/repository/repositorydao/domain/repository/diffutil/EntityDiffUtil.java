package org.paakciu.repository.repositorydao.domain.repository.diffutil;

import org.paakciu.repository.repositorydao.domain.repository.Entity;
import org.paakciu.repository.repositorydao.domain.repository.Identifier;

import java.util.*;

/**
 * @author paakciu
 * @ClassName: EntityDiffUtil
 * @date: 2022/4/25 23:10
 */
public class EntityDiffUtil {

    public static final DiffEquals DEFAULT_EQUALS=(s,t)->Boolean.FALSE;

    public static <T extends Entity<ID> , ID extends Identifier>
            List<AbstractDiff<T>> diff(List<T> source,List<T> target,DiffEquals<T> diffEquals,Boolean ignoreEquals){
        Objects.requireNonNull(source,"source mast not be null!");
        Objects.requireNonNull(target,"target mast not be null!");
        Objects.requireNonNull(diffEquals,"diffEquals mast not be null!");
        Objects.requireNonNull(ignoreEquals,"ignoreEquals mast not be null!");

        List<AbstractDiff<T>> changes=new ArrayList<>();
        Map<ID,T> sourceMap=new HashMap<>();
        Map<ID,T> targetMap=new HashMap<>();
        //source 进map
        for (T sourceItem : source) {
            ID identifier = sourceItem.getIdentifier();
            Objects.requireNonNull(identifier,"source identifier mast not be null!");
            sourceMap.put(identifier,sourceItem);
        }
        //target 进map
        for (T targetItem : target) {
            ID identifier = targetItem.getIdentifier();
            if(identifier == null){
                //没有id意味着纯新增
                changes.add(new InsertDiff<T>(targetItem));
            } else{
                targetMap.put(identifier,targetItem);
            }
        }
        //比较
        for (ID id : targetMap.keySet()) {
            T targetItem = targetMap.get(id);
            T sourceItem = sourceMap.getOrDefault(id,null);
            if (sourceItem==null){
                changes.add(new InsertDiff<T>(targetItem));
            } else{
                //id相等 ID类一定要重写hash equals
                if(diffEquals.compute(sourceItem,targetItem)){
                    if(!ignoreEquals){
                        changes.add(new EqualsDiff<T>(sourceItem,targetItem));
                    }
                } else{
                    //不相等
                    changes.add(new UpdateDiff<T>(sourceItem,targetItem));
                }
                sourceMap.remove(id,sourceItem);
            }
        }
        //剩下的删除
        for (ID id : sourceMap.keySet()) {
            T sourceItem = sourceMap.get(id);
            changes.add(new DeteleDiff<T>(sourceItem));
        }
        return changes;
    }
}
