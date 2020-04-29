## 2.1 

GRoE (golden rule of equals) -- equals: copy all the bits.

Everything else than primitive types is a reference type.

Basically in java, you always pass by value.

-------------------------------------------------------------------

## 2.1 Exercises

The extra exercises are implementing the incrList() function and the dincrList() function. 
At first I was doing both in an iterative way and it turned out that for me, writing incrList() 
iteratively is kind of tortuous for me in the beginning. 

After I solved them, it occurred to me that using recusion method might be 
more natual. Therefore, I figured out incrRecursionList() but still have no idea about the dincrRecursionList(). 
Looks unsolvable to me because IntList L passed to the function are changing everytime we run it (didn't realize that 
pass by value won't change it).

04.26 -- updated IntList.java with dincrRecursionList() method and simplified part of the main method.

Due to pass by value, L remains unchanged after we call the dincrRecursionList() method.

-------------------------------------------------------------------

## 2.2 SLLists, Access Control, Nested Classes, Sentinel Nodes

Making the variable private doesn't mean you cannot alter it. Instead, you can alter it by given public methods such as 
addFirst().

Nested Classes -- useful when a class doesn't stand on its own and is obviously a 
subordinate to another class.

Make the nested class private if other classes should never use the nested class.

Why use the keyword static in Nested Classes?

When a sentinel node is implemented, the first item of the list is always (if exists) at sentinel.next. (哨兵节点)
