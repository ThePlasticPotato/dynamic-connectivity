package com.github.btrekkie.connectivity;

public interface SplitEmitter {
    boolean onMerge(ConnVertex vertex1, ConnVertex vertex2, EulerTourNode root1, EulerTourNode root2, EulerTourNode newRoot);
    boolean onSplit(ConnVertex vertex1, ConnVertex vertex2, EulerTourNode root1, EulerTourNode root2, EulerTourNode oldRoot);
}
