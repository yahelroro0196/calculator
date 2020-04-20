package com.company;

public class Pair<L, R> {

    private final L value;
    private final R type;

    public Pair(L value, R type) {
        assert value != null;
        assert type != null;

        this.value = value;
        this.type = type;
    }

    public L getValue() {
        return value;
    }

    public R getType() {
        return type;
    }

    @Override
    public String toString() {
        return "<%s, %s>".formatted(this.value, this.type);
    }
}
