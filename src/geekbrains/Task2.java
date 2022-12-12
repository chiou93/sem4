package geekbrains;

import java.util.Stack;

public class Task2 {
    class MyQueue {
        Stack<Integer> in;
        Stack<Integer> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        private int front;

        public void push(int x) {
            if (in.empty()) {
                front = x;
            }
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            out.push(x);
            while (!out.isEmpty()) {
                in.push(out.pop());
            }
        }

        public int pop() {
            int ans = in.pop();
            if (!in.empty()) {
                front = in.peek();
            }
            return ans;
        }

        public int peek() {
            return front;
        }

        public boolean empty() {
            return (in.isEmpty() && out.isEmpty());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
