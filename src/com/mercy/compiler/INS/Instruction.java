package com.mercy.compiler.INS;

import com.mercy.compiler.BackEnd.Translator;
import com.mercy.compiler.INS.Operand.Reference;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by mercy on 17-4-25.
 */
abstract public class Instruction {
    protected List<Instruction> predessor = new LinkedList<>();
    protected List<Instruction> sucessor = new LinkedList<>();

    protected Set<Reference> in = new HashSet<>();
    protected Set<Reference> out = new HashSet<>();

    protected Set<Reference> use;
    protected Set<Reference> def;

    /*
     * getter and setter
     */
    public List<Instruction> predessor() {
        return predessor;
    }

    public List<Instruction> sucessor() {
        return sucessor;
    }

    public Set<Reference> in() {
        return in;
    }

    public Set<Reference> out() {
        return out;
    }

    public Set<Reference> use() {
        if (use == null) {
            use = new HashSet<>();
            def = new HashSet<>();
            this.calcDefAndUse();
        }
        return use;
    }

    public Set<Reference> def() {
        if (def == null) {
            use = new HashSet<>();
            def = new HashSet<>();
            this.calcDefAndUse();
        }
        return def;
    }

    abstract public void calcDefAndUse();

    public void setIn(Set<Reference> in) {
        this.in = in;
    }

    public void setOut(Set<Reference> out) {
        this.out = out;
    }

    abstract public void accept(Translator translator);
}
