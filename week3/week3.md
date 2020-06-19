## AList

Good habit: Think about the Invariants when you do programming.

Example: In AList, the position of the next item to be inserted is always `size`.

General Resizing Method: `size` --> `size * REFACTOR`

Usage ratio `R = items / length`. Typical solution: Half array size when `R < 0.25`

## Generic AList

Generic AList: when instantiating generic Alist, for example, `AList <Item>`, it should be like this:

```java
public class AList<Item> {
	private Item[] items;
	private int size;

	pubilc Alist() {
		items = (Item []) new Object[8];
		size = 0;
	}
}
```

Note that

```java
items = new Item[8];
```

won't work. (will learn about the reason later)

Null out deleted items to avoid loitering(游荡).

## Testing

To check if two arrays match, use

```java
java.util.Arrays.equals(array1, array2)
```

which returns true if these two are equal, otherwise false.

In a test, use the following method to check if two arrays matched

```java
org.junit.Assert.assertArrayEquals(array1, array2)
```

Development is an incremental process that involves lots of task switching and on the fly design modification.

Tests provide stability and scaffolding.

Annotate each test with `@org.junit.Test` and change all test methods to **non-static**.

To avoid typing out the name of the library repeatedly, use

```java
import org.junit.Test;
import static org.junit.Assert.*;
```

## Inheritance, Implements

**Overloading** - allows multiple methods with the same name, but different parameters.

**Overriding** only applies to inheritance relationships.

When using **Interface Inheritance**, subclasses must override all of these methods and subclasses inherits 
signatures but NOT implementation.

Implementaion Inheritance - use keyword `default` to specify a method that subclasses should inherit from an **interface**.

Dynamic Method Selection

Suppose we call a method of an object using a variable with:

- compile-time type X
- run-time type Y

Then if Y **overrides** the method, Y's method is used instead.

In both inheritance cases, we specify "is-a" relationships, not "has-a".