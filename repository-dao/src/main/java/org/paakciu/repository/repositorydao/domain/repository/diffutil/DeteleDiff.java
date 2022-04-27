package org.paakciu.repository.repositorydao.domain.repository.diffutil;

/**
 * @author paakciu
 * @ClassName: DeteleDiff
 * @date: 2022/4/27 19:52
 */
public class DeteleDiff<T> extends AbstractDiff {
    public DeteleDiff(T source) {
        super(source, null, DiffType.DELETE);
    }
}