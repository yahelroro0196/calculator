package com.company;

public class Pair<L, R> {

    private final L left;
    private final R right;

    public Pair(L left, R right) {
        assert left != null;
        assert right != null;

        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        return left.hashCode() ^ right.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairObject = (Pair) o;
        return this.left.equals(pairObject.getLeft()) &&
                this.right.equals(pairObject.getRight());
    }

    @Override
    public String toString() {
        return "<%s, %s>".formatted(this.left, this.right);
    }
}