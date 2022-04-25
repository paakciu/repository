package org.paakciu.repository.repositorydao.domain.repository;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author paakciu
 * @InterfaceName: Repository
 * @date: 2022/4/25 23:07
 */
public interface Repository<T extends Aggregate<ID>,ID extends Identifier>{

    T find(@NotNull ID id);

    Boolean remove(@NotNull ID id,String operator);

    ID save(@NotNull T aggregate,String operator);

}
