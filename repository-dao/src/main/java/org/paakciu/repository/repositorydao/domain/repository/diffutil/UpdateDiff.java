package org.paakciu.repository.repositorydao.domain.repository.diffutil;

/**
 * @author paakciu
 * @ClassName: UpdateDiff
 * @date: 2022/4/27 19:51
 */

public class UpdateDiff<T> extends AbstractDiff {
    public UpdateDiff(T source,T target) {
        super(source, target, DiffType.UPDATE);
    }
}