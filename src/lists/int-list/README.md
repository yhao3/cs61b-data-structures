## ****IntLists****

Let’s quick build a list class.

It turns out that a very basic list is trivial to implement, as shown below: 

```java
public class IntList {
    public int first;
    public IntList rest;        

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }
}
```

You may remember something like this from 61a called a "Linked List".

Such a list is ugly to use. For example, if we want to make a list of the numbers 5, 10, and 15, we can either do: 

```java
IntList list = new IntList(5, null);
list.rest = new IntList(10, null);
list.rest.rest = new IntList(15, null);
```

![01](/src/lists/int-list/01.png)

Alternately, we could build our list backwards, yielding slightly nicer but harder to understand code: 

```java
IntList list = new IntList(15, null);
list = new IntList(10, L);
list = new IntList(5, L);
```

## ****size and iterativeSize****

We'd like to add a method `size` to the `IntList` class so that if you call `L.size()`, you get back the number of items in `L`.

Consider writing a `size` and `iterativeSize` method before reading the rest of this chapter. `size` should use recursion, and `iterativeSize` should not.

### `size` method is as shown below:

```java
/**
 * Return the size of the list using recursion
 */
public int size() {
    if (rest == null) {
        return 1;
    }
    return 1 + this.rest.size(); // 1 + however big the reset of the list is
}
```

The key thing to remember about recursive code is that **you need a base case**. In this situation, the most reasonable base case is that rest is `null`, which results in a size 1 list.

> 💡**Exercise**:
> 
> 
> You might wonder why we don't do something like `if (this == null) return 0;`. Why wouldn't this work?
> 
> **Answer**: 
> 
> Think about what happens when you call size. You are calling it on an object, for example `L.size()`. If L were `null`, then you would get a `NullPointer` error!
> 

### `iterativeSize` method is as shown below

> ℹ️NOTE:
> 
> 
> I recommend that when you write iterative data structure code that you use the name `p` to remind yourself that the variable is holding a pointer. You need that pointer because you can't reassign "this" in Java. The followups in [this Stack Overflow Post](https://stackoverflow.com/questions/23021377/reassign-this-in-java-class) offer a brief explanation as to why.
> 


```java
/** 
 * Return the size of the list using no recursion
 */
public int iterativeSize() {
    IntList p = this; // pointer variable
    int totalSize = 0;
    while (p != null) {
        totalSize += 1;
        p = p.rest;
    }
    return totalSize;
}
```

## get the i-th item of this intList

### `get` method

Write a method `get(int i)` that returns the ith item of the list. For example, if `L` is `5 -> 10 -> 15`, then `L.get(0)` should return 5, `L.get(1)` should return 10, and `L.get(2)` should return 15. It doesn't matter how your code behaves for invalid `i`, either too big or too small. 

> ℹ️NOTE:
> 
> 
> The method we've written takes linear time! That is, if you have a list that is 1,000,000 items long, then getting the last item is going to take much longer than it would if we had a small list. We'll see an alternate way to implement a list that will avoid this problem in a future lecture. 
> 

### recursive solution

base case: 

It turns out that the most natural base case has nothing to do with the `tail` or the `first`. Instead, it’s if someone asks for zeroth item, we should just return `this.first`

```java
// base case: 
if (index == 0) {
    return this.first;
}
```

complete code: 

```java
/**
 * return the i-th item of this intList
 * @param index
 */
public int get(int index) {
    if (index == 0) {
        return this.first;
    }
    return this.rest.get(index - 1);
}
```

example: `get(2)`

![02](/src/lists/int-list/02.png)

Java Visualizer: 

[Online Python Tutor - iframe embed page](https://cscircles.cemc.uwaterloo.ca/java_visualize/iframe-embed.html?faking_cpp=false#data={%22user_script%22%3A%22public%20class%20IntList%20{\n%20public%20int%20first%3B\n%20public%20IntList%20rest%3B%20\n\n%20public%20IntList(int%20first%2C%20IntList%20rest)%20{\n%20this.first%20%3D%20first%3B\n%20this.rest%20%3D%20rest%3B\n%20}\n%20\n%20public%20int%20get(int%20index)%20{\n%20if%20(index%20%3D%3D%200)%20{\n%20return%20this.first%3B\n%20}\n%20return%20this.rest.get(index%20-%201)%3B\n%20}\n%20\n%20public%20static%20void%20main(String[]%20args)%20{\n%20IntList%20list%20%3D%20new%20IntList(5%2C%20null)%3B\n%20list.rest%20%3D%20new%20IntList(10%2C%20null)%3B\n%20list.rest.rest%20%3D%20new%20IntList(15%2C%20null)%3B\n\n%20%2F%2F%20test%20get(int%20index)\n%20System.out.println(\%22item%3A%20\%22%20%2B%20list.get(2))%3B%5Cn%20%20%20%20%7D%5Cn%7D%20%22%2C%22options%22%3A%7B%22showStringsAsValues%22%3Atrue%2C%22showAllFields%22%3Afalse%7D%2C%22args%22%3A%5B%5D%2C%22stdin%22%3A%22%22%7D&cumulative=false&heapPrimitives=false&drawParentPointers=false&textReferences=false&showOnlyOutputs=false&py=3&curInstr=0&resizeContainer=true&highlightLines=true&rightStdout=true)

1. index = 2
    - `this`: `item1`
    - `this.rest`: `item2`
    - `this.rest.get(2 - 1)`: `item2.get(1)`
2. index = 1
    - `this`: `item2`
    - `this.rest`: `item3`
    - `this.rest.get(1 - 1)`: `item3.get(0)`
3. index = 0
    - `this`: `item3`
    - because `index == 0` is `true`, return `this.first`  `item3.first`  `15`