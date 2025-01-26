# Lab5 - Stack

There are three types of question:

## Implementing a Stack

Implements a stack using `java.util.LinkedList`. Basically, you'll have to implement:

- `.peek()` - get the last element pushed into the stack
- `.pop()` - get and remove the last element pushed into the stack
- `.push()` - put an element into the stack

Source code: [Q1 - Stack](https://github.com/fyiernzy/UM-WIA1002/blob/main/Version2/Lab5%20-%20Stack/Q1/MyStack.java)

## Fundamentals of Stack

Fundamentals of Stack

Utilizie the `.peek()`, `.pop()` and `.push()`.

Questions:

- [Q2 - Postfix Evaluaton](https://github.com/fyiernzy/UM-WIA1002/blob/main/Version2/Lab5%20-%20Stack/Q2/Main.java) 
- [Q4 - Syntax Checker](https://github.com/fyiernzy/UM-WIA1002/blob/main/Version2/Lab5%20-%20Stack/Q4/Q4.java)
- [Q5 - XML validator](https://github.com/fyiernzy/UM-WIA1002/blob/main/Version2/Lab5%20-%20Stack/Q5/Q5.java)

FYI, [Q2 - Postfix Evaluaton](https://github.com/fyiernzy/UM-WIA1002/blob/main/Version2/Lab5%20-%20Stack/Q2/Main.java) is a classical and great practice for those who want to master stack.

## Backtracking

There are a few points for writing a backtracking program using stack:

### A `makeMove()` method

### A `backtrack()` method

### An array of choices

### Termination condition

### Valid condition

There must be a condition in which the computer can take next move.

`Q3_2.java` (N Queen Problem)

```java
public static boolean isSafe(Stack<Integer> stack, int col) {
    int row = stack.size();
    for(int i = 0; i < row; i++) {
        int tmp = stack.get(i);
        if(tmp == col || Math.abs(tmp - col) == row - i)
            return false;
    }
    return true;
}
```

```java
for( ; col < N; col++) {
    if(isSafe(stack, col)) {
        stack.push(col);
        break;
    }
}
```

### Invalid condition