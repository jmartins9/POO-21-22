package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack {

    private List<String> stack;

    public Stack(List<String> stack){
        this.stack = new ArrayList<>();
        for(String str : stack) {
            this.stack.add(str);
        }
    }

    public Stack(){
        this.stack = new ArrayList<>();
    }

    public Stack(Stack s){
        this.stack = new ArrayList<>();
        for(String str : s.stack) {
            this.stack.add(str);
        }
    }

    public String top(){
        return this.stack.get(this.lenght()-1);
    }

    public void push (String s){
        this.stack.add(s);
    }

    public void pop (){
        this.stack.remove(this.lenght()-1);
    }

    public boolean empty(){
        return this.lenght()==0;
    }

    public int lenght(){
        return this.stack.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack stack1 = (Stack) o;
        return this.stack.equals(stack1.stack);
    }

    @Override
    public String
    toString() {
        final StringBuilder sb = new StringBuilder("Stack{");
        sb.append("stack=").append(stack.toString());
        sb.append('}');
        return sb.toString();
    }

    public Stack clone() {
        return new Stack(this);
    }

}
