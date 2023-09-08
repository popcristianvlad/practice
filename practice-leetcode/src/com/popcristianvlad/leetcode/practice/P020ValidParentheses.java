package com.popcristianvlad.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class P20ValidParentheses {

    class Queue {
        List<Character> parantheses = new ArrayList<>();

        public void push(Character paranthese) {
            parantheses.add(paranthese);
        }

        public Character pop() {
            if (parantheses.isEmpty()) {
                return null;
            }

            return parantheses.remove(parantheses.size() - 1);
        }

        public boolean isEmpty() {
            return parantheses.isEmpty();
        }
    }

    public boolean isValid(String s) {
        Queue queue = new Queue();
        char[] parantheses = s.toCharArray();
        int numberOfParantheses = parantheses.length;

        for (int i = 0; i < numberOfParantheses; i++) {
            if (parantheses[i] == '(' || parantheses[i] == '[' || parantheses[i] == '{') {
                queue.push(parantheses[i]);
            } else {
                Character paranthese = queue.pop();
                if (paranthese == null) {
                    return false;
                }
                if (parantheses[i] == ')' && paranthese != '(') {
                    return false;
                }
                if (parantheses[i] == ']' && paranthese != '[') {
                    return false;
                }
                if (parantheses[i] == '}' && paranthese != '{') {
                    return false;
                }
            }
        }

        return queue.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new P20ValidParentheses().isValid("()"));
        System.out.println(new P20ValidParentheses().isValid("()[]{}"));
        System.out.println(new P20ValidParentheses().isValid("(]"));
        System.out.println(new P20ValidParentheses().isValid("([)]"));
        System.out.println(new P20ValidParentheses().isValid("{[]}"));
    }
}
