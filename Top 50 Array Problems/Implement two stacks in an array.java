class twoStacks {
    private int[] arr;
    private int top1, top2;
    private int capacity;

    // Constructor to initialize two stacks
    twoStacks() {
        capacity = 100; // or any suitable size
        arr = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    // Function to push an integer into stack1
    void push1(int x) {
        if (top1 < top2 - 1) {
            arr[++top1] = x;
        } else {
            System.out.println("Overflow in Stack 1");
        }
    }

    // Function to push an integer into stack2
    void push2(int x) {
        if (top1 < top2 - 1) {
            arr[--top2] = x;
        } else {
            System.out.println("Overflow in Stack 2");
        }
    }

    // Function to pop an element from top of stack1
    int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        } else {
            return -1; // Indicates stack is empty
        }
    }

    // Function to pop an element from top of stack2
    int pop2() {
        if (top2 < capacity) {
            return arr[top2++];
        } else {
            return -1; // Indicates stack is empty
        }
    }
}
