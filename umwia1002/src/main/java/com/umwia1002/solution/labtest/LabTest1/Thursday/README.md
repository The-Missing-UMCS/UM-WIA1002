# Solution Overview

The complexity of the LabTest is exacerbated by a 7-page question filled with dense jargon and incorporating the concept of linear algebra, making it challenging for candidates to comprehend and analyze the question requirements. Moreover, the introduction of a new class and intricate conditions further compounds the difficulty of the test. Nonetheless, with the assistance of ChatGPT, once we have grasped the question's essence, they should be able to solve it with ease.

## `CpuInt` and `GpuInt`

let's examine the `CpuInt.java` file.

```java
class CpuInt {
    @Override
    public String toString() {
        return String.format("%s[%d]" , getDevice(), this.value);
    }

    public String getDevice() {
        return "CPU";
    }

    public CpuInt add(CpuInt o) {
        System.out.printf("CPU Debug: %d + %d = %d\n", this.value, o.value, this.value + o.value);
        return new CpuInt(this.value + o.value);
    }

    public CpuInt mul(CpuInt o) {
        System.out.printf("CPU Debug: %d * %d = %d\n", this.value, o.value, this.value * o.value);
        return new CpuInt(this.value * o.value);
    }
}
```

Essentially, CpuInt functions similarly to an Integer object that stores an integer value and performs basic arithmetic operations such as addition and multiplication through its `add()` and `mul() methods`, respectively. To better comprehend this concept, let us examine the following examples:

**`add()`**

```java
int a = 5;
int b = 6;
int c = a + b;
System.out.print(c); // Output: 11;

CpuInt aa = new CpuInt(5);
CpuInt bb = new CpuInt(6);
CpuInt cc = aa.add(bb); // Output: CPU Debug: 5 + 6 = 11
System.out.print(cc.toString()); // Output: CPU[11];
```

**`mul()`**

```java
int a = 5;
int b = 6;
int c = a * b;
System.out.print(30); // Output: 11;

CpuInt aa = new CpuInt(5);
CpuInt bb = new CpuInt(6);
CpuInt cc = aa.mul(bb); // Output: CPU Debug: 5 * 6 = 30
System.out.print(cc.toString()); // Output: CPU[30];
```

Similarly, the concept of `CpuInt.java` is applied to `GpuInt.java`. In essence, both classes operate similarly to the `Integer` class, enabling basic arithmetic operations and returning values of the same data type.

## Basic Linear Algebra

To gain a better understanding of the question, we should possess a fundamental comprehension of linear algebra and familiarize themselves with terminologies such as scalar and dot product. Furthermore, it is essential to know how to execute the multiplication between a vector and scalar, between two vectors, as well as the dot product between two vectors.

[Definition of scalar](https://www.britannica.com/science/scalar)
> Scalar is a physical quantity that is completely described by its magnitude.

### **Theory**

Multiplication between vector and scalar:

Given a vector $\vec{v} = \begin{pmatrix} v_1 \\ v_2 \\ \vdots \\ v_n \end{pmatrix}$ and a scalar $a$, the multiplication between $\vec{v}$ and $a$ is defined as:

$$a\vec{v} = \begin{pmatrix} av_1 \\ av_2 \\ \vdots \\ av_n \end{pmatrix}$$

Multiplication between vector and vector:

Given two vectors $\vec{v} = \begin{pmatrix} v_1 \\ v_2 \\ \vdots \\ v_n \end{pmatrix}$ and $\vec{w} = \begin{pmatrix} w_1 \\ w_2 \\ \vdots \\ w_n \end{pmatrix}$, the multiplication between $\vec{v}$ and $\vec{w}$ is defined as:

$$\vec{v}\vec{w}^T = \begin{pmatrix} v_1w_1 & v_1w_2 & \cdots & v_1w_n \\ v_2w_1 & v_2w_2 & \cdots & v_2w_n \\ \vdots & \vdots & \ddots & \vdots \\ v_nw_1 & v_nw_2 & \cdots & v_nw_n \end{pmatrix}$$

Note that this operation is also known as the outer product of $\vec{v}$ and $\vec{w}$.

Dot product between two vectors:

Given two vectors $\vec{v} = \begin{pmatrix} v_1 \\ v_2 \\ \vdots \\ v_n \end{pmatrix}$ and $\vec{w} = \begin{pmatrix} w_1 \\ w_2 \\ \vdots \\ w_n \end{pmatrix}$, the dot product between $\vec{v}$ and $\vec{w}$ is defined as:

$$\vec{v} \cdot \vec{w} = \sum_{i=1}^n v_iw_i = v_1w_1 + v_2w_2 + \cdots + v_nw_n$$

This operation is also known as the inner product or scalar product of $\vec{v}$ and $\vec{w}$.

Sure, here are some examples of vectors of three with low-magnitude values substituted into the equations:

### **Examples**

#### Example 1 - Multiplication between vector and scalar

Let $\vec{v} = \begin{pmatrix} 1 \\ 2 \\ 3 \end{pmatrix}$ and $a = 0.5$. Then, the multiplication between $\vec{v}$ and $a$ is:

$$a\vec{v} = 0.5 \begin{pmatrix} 1 \\ 2 \\ 3 \end{pmatrix} = \begin{pmatrix} 0.5 \\ 1 \\ 1.5 \end{pmatrix}$$

#### Example 2: Multiplication between two vectors

When both vectors have the dimension of $3 \times 1$, their multiplication is not well-defined. Instead, we can consider the Hadamard (element-wise) product between the two vectors, which is an operation that produces a new vector of the same dimension as the original vectors, by multiplying the corresponding elements of the vectors.

Let $\vec{v} = \begin{pmatrix} 1 \\ 2 \\ 3 \end{pmatrix}$ and $\vec{w} = \begin{pmatrix} 4 \\ 5 \\ 6 \end{pmatrix}$. Then, the Hadamard product between $\vec{v}$ and $\vec{w}$ is:

$$\vec{v} \circ \vec{w} = \begin{pmatrix} 1 \\ 2 \\ 3 \end{pmatrix} \circ \begin{pmatrix} 4 \\ 5 \\ 6 \end{pmatrix} = \begin{pmatrix} 1 \cdot 4 \\ 2 \cdot 5 \\ 3 \cdot 6 \end{pmatrix} = \begin{pmatrix} 4 \\ 10 \\ 18 \end{pmatrix}$$

Note that the resulting vector has the same dimension $3 \times 1$ as the original vectors.

#### Example 3: Dot product between two vectors

Let $\vec{v} = \begin{pmatrix} 1 \\ 2 \\ 3 \end{pmatrix}$ and $\vec{w} = \begin{pmatrix} 4 \\ 5 \\ 6 \end{pmatrix}$. Then, the dot product between $\vec{v}$ and $\vec{w}$ is:

$$\vec{v} \cdot \vec{w} = (1 \cdot 4) + (2 \cdot 5) + (3 \cdot 6) = 32$$

Note that the dot product is a scalar value.

## Code explanation I - Generic

So, let's take a look into the hardest code snippet, which the code snippet for the `VecUtil.java`, which stands for "Vector Utilities". Personally, the hardest part will be the following:

### .arr2vec(Class<E> c, int[] array)

```java
public static <E> ArrayList<E> arr2vec(Class<E> c, int[] array) {
        ArrayList<E> vec = new ArrayList<E>(array.length);
        for (int i : array) {
            try {
                E elem = c.getDeclaredConstructor(int.class).newInstance(i);
                vec.add(elem);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }
        return vec;
    }
```

The purpose of the `arr2vec` method, as its name suggests, is to convert an array of integers into a vector of integers, representing the concept of a vector in linear algebra. For instance, given the vector representation v = <x1, x2, x3>, converting the integer array `int[] arr = {1, 2, 3}` to a vector would result in v = <1, 2, 3>.

### .ones(Class<E> c, int size)

```java
public static <E> ArrayList<E> ones(Class<E> c, int size) {
        ArrayList<E> vec = new ArrayList<E>(size);
        for (int i = 0; i < size; i++) {
            try {
                E elem = c.getDeclaredConstructor(int.class).newInstance(1);
                vec.add(elem);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return vec;
    }
```

Similarly, the `ones()` method generates a vector of 1's with a size of `size`. For example, if the given `size` is 3, the method should produce the vector <1, 1, 1>. Conversely, if the `size` is 4, the method should generate the vector <1, 1, 1, 1>.

### Class.java

The most challenging aspect of the code lies in the invocation of the `c.getDeclaredConstructor(int.class).newInstance(i)` method and the `ReflectiveOperationException class`. Essentially, the `Class<E>` is a generic class that can represent the class of an object. Typically, we use the `instanceof` operator to check if an object is a subclass of another class, as shown in the example:

```java
Integer val = 5;
System.out.println(val instanceof Integer); // Output: true
System.out.println(val instanceof Number); // Output: true
```

The method `.getClass()` and the use of equals sign `==` can do the similar function as well. For illustration:

```java
Integer val = 5;
System.out.println(val.getClass() == Integer.class); // Output: true
System.out.println(val.getClass() == Number.class); // Output: false
```

### .getDeclaredConstructor()

The method `c.getDeclaredConstructor(int.class).newInstance(i)` is a part of Java's Reflection API, which allows you to access and manipulate classes and objects dynamically, at runtime.

The `getDeclaredConstructor(int.class)` method returns a `Constructor` object that represents the constructor of the class `c` that takes an int parameter. The `newInstance(i)` method creates a new instance of the class `c` by invoking the constructor with the int value `i` as the argument.

### ReflectiveOperationException.java

The `ReflectiveOperationException` class is an exception that is thrown when an error occurs during reflection, such as when a method or constructor cannot be found, or when there is a security violation. It is a checked exception, which means that it must be caught or declared to be thrown by the calling method.

It is important to note that 
                                 
- `Class.newInstance()` can only invoke the zero-argument constructor, while `Constructor.newInstance()` can invoke any constructor, regardless of the number of parameters. 
- Additionally, `Class.newInstance()` throws any exception thrown by the constructor, while `Constructor.newInstance()` always wraps the thrown exception with an `InvocationTargetException`. 
- Finally, `Class.newInstance()` requires that the constructor be visible, while `Constructor.newInstance()` may invoke private constructors under certain circumstances.

### Conclusion

Hence, basically, the code just take the `Class<E>` parameter and invokes the constructor to wrap the `int` value within either `CPUInt` or `GPUInt` for subsequent operations.

## Code Explanation II - Linear Algebra

Below are the implementations of the linear algebra formulas that we have discussed in the previous sections.

### Multiplication between Vector and Scalar

```java
public static <E extends NumberInterface<E>> ArrayList<E> mul(ArrayList<E> vec, E scalar) {
    ArrayList<E> newVec = new ArrayList<>();
    for (NumberInterface<E> obj : vec)
        newVec.add(obj.mul(scalar));
    return newVec;
}
```

### Multiplication between Vectors

```java
public static <E extends NumberInterface<E>> ArrayList<E> mul(ArrayList<E> vec1, ArrayList<E> vec2) {
    ArrayList<E> newVec = new ArrayList<>();
    for (int i = 0; i < vec1.size(); i++)
        newVec.add(vec1.get(i).mul(vec2.get(i)));
    return newVec;
}
```

### Dot Product

```java
public static <E extends NumberInterface<E>> NumberInterface<E> dot(ArrayList<E> vec1, ArrayList<E> vec2) {
    ArrayList<E> newVec = VecUtil.mul(vec1, vec2);
    E dotProduct = newVec.get(0).fromInteger(0);
    for (NumberInterface<E> obj : newVec) 
        dotProduct = obj.add(dotProduct);
    return dotProduct;
}
```
