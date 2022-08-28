package Design;
/*
  描述：
  设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
  实现 MinStack 类:
     * MinStack() 初始化堆栈对象。
     * void push(int val) 将元素val推入堆栈。
     * void pop() 删除堆栈顶部的元素。
     * int top() 获取堆栈顶部的元素。
    * int getMin() 获取堆栈中的最小元素。
 */

import java.net.InetAddress;
import java.util.Stack;

public class tp155 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> help;
        public MinStack() {
            stack = new Stack<>();
            help = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (help.isEmpty() || help.peek() >= val){
                help.push(val);
            }else {
                help.push(help.peek());
            }
        }

        public void pop() {
            help.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return help.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
