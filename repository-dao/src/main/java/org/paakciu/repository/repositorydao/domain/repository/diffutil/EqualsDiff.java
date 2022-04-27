package org.paakciu.repository.repositorydao.domain.repository.diffutil;

/**
 * @author paakciu
 * @ClassName: EqualsDiff
 * @date: 2022/4/27 19:52
 */
public class EqualsDiff<T> extends AbstractDiff {
    public EqualsDiff(T source,T target) {
        super(source, target, DiffType.EQUALS);
    }
}