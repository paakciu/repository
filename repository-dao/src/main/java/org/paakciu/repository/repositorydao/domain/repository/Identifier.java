package org.paakciu.repository.repositorydao.domain.repository;

import java.io.Serializable;

/**
 * @author paakciu
 * @InterfaceName: Identifier
 * @date: 2022/4/25 23:02
 */
public interface Identifier extends Serializable {

    boolean equals(Object identifier);
}
