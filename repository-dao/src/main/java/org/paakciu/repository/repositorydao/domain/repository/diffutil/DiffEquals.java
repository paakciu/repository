package org.paakciu.repository.repositorydao.domain.repository.diffutil;

/**
 * @author paakciu
 * @InterfaceName: DiffEquals
 * @date: 2022/4/25 23:12
 */
public interface DiffEquals <T>{

    Boolean compute(T source,T target);
}
