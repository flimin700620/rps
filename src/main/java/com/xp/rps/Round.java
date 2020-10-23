package com.xp.rps;

import java.util.Objects;

public class Round {
    int id;
    Throw throw1;
    Throw throw2;
    Result result;

    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", p1=" + throw1 +
                ", p2=" + throw2 +
                ", result=" + result +
                '}';
    }

    public Round() {
    }

    public Round(Throw p1, Throw p2, Result result) {
        this.throw1 = p1;
        this.throw2 = p2;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Round(Throw p1, Throw p2) {
        this.throw1 = p1;
        this.throw2 = p2;
    }

    public Round(int id, Throw throw1, Throw throw2, Result result) {
        this.id = id;
        this.throw1 = throw1;
        this.throw2 = throw2;
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return throw1 == round.throw1 &&
                throw2 == round.throw2 &&
                result == round.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(throw1, throw2, result);
    }

    public Throw getThrow1() {
        return throw1;
    }

    public void setThrow1(Throw throw1) {
        this.throw1 = throw1;
    }

    public Throw getThrow2() {
        return throw2;
    }

    public void setThrow2(Throw throw2) {
        this.throw2 = throw2;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
