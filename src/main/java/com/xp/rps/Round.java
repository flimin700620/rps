package com.xp.rps;

import java.util.Objects;

public class Round {
    int id;
    Throw p1;
    Throw p2;
    Result result;

    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", result=" + result +
                '}';
    }

    public Round() {
    }

    public Round(Throw p1, Throw p2, Result result) {
        this.p1 = p1;
        this.p2 = p2;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Round(Throw p1, Throw p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return p1 == round.p1 &&
                p2 == round.p2 &&
                result == round.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(p1, p2, result);
    }

    public Throw getP1() {
        return p1;
    }

    public void setP1(Throw p1) {
        this.p1 = p1;
    }

    public Throw getP2() {
        return p2;
    }

    public void setP2(Throw p2) {
        this.p2 = p2;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
