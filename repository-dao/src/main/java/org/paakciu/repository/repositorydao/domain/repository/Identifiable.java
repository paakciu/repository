package org.paakciu.repository.repositorydao.domain.repository;

/**
 * @author paakciu
 * @InterfaceName: Identifiable
 * @date: 2022/4/25 23:04
 */
public interface Identifiable <ID extends Identifier>{
    ID getIdentifier();
}
