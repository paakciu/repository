package org.paakciu.repository.repositorydao.domain.repository.diffutil;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author paakciu
 * @ClassName: AbstractDiff
 * @date: 2022/4/25 23:15
 */
@Getter
@AllArgsConstructor
public abstract class AbstractDiff<T> {

    private final T source;

    private final T target;

    private final DiffType type;

}
