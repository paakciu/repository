package org.paakciu.repository.repositorydao.domain.repository.diffutil;

/**
 * @author paakciu
 * @ClassName: InsertDiff
 * @date: 2022/4/27 19:48
 */
public class InsertDiff<T> extends AbstractDiff {
    public InsertDiff(T target) {
        super(null, target, DiffType.INSERT);
    }
}
