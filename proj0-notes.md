对于`NBody.java`中的`readPlanets`方法，错误的写法是：

For `readPlanets` method in `NBody.java`, a wrong way to write the method is:

```java
Planet[] planets = new Planet[numberPlanets];
	for (int i = 0; i < numberPlanets; i++) {
			planets[i].xPos = file.readDouble();
			planets[i].yPos = file.readDouble();
			planets[i].xVel = file.readDouble();
			planets[i].yVel = file.readDouble();
			planets[i].mass = file.readDouble();
			planets[i].imgFileName = file.readString();
```

这样写的话会返回`java.lang.NullPointerException`，比较容易理解。用Josh的话来说，第一行的`new Planet[numberPlanets]`只是创造了
一个储存`Planet`实例的“屋子”，里面并没有储存任何东西。因此，应该使用constructors来创建对象。

Writing the method in this way raises `java.lang.NullPointerException`. As Josh said, `new Planet[numberPlanets]` creates a house 
for several `Planet` instances so you still have to use constructors to create instances.

```java
Planet[] planets = new Planet[numberPlanets];

	for (int i = 0; i < numberPlanets; i++) {
		double xPos = file.readDouble();
		double yPos = file.readDouble();
		double xVel = file.readDouble();
		double yVel = file.readDouble();
		double mass = file.readDouble();
		String imgFileName = file.readString();

		planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, imgFileName);
	}
```

----------------------------------------------------------------------------------

`StdDrawDemo.java`中，`StdDraw.enableDoubleBuffering()`提供缓冲，使动画展示更加流畅。删去后画面会闪烁（没有加载好）。

`StdDraw.enableDoubleBuffering()` provides buffering for the animation and makes it more smooth.

----------------------------------------------------------------------------------

在编译`StdDrawDemo.java`的时候报错出现“GBK”字样，网上查询后应该是system locale的问题，改变encoding使用UTF8即可以解决。

When compiling `StdDrawDemo.java`, some errors with "GBK" in it raised. The issue is caused by system locale. Compile it this way:

```
javac -encoding UTF8 StdDrawDemo.java
```
