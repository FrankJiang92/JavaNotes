### 命令模式

---

#### 定义

* 命令模式（Command Pattern）是一种数据驱动的设计模式，它属于行为型模式。
* 请求以命令的形式包裹在对象中，并传给调用对象。
* 调用对象寻找可以处理该命令的合适的对象，并把该命令传给相应的对象，该对象执行命令。
* 意图：将一个请求封装成一个对象，从而使您可以用不同的请求对客户进行参数化。

#### UML图

![command](res/command.gif)

#### 组成结构

* Receiver类，真正的命令执行对象
	* `Font`：字体功能类
	* `Background`：背景功能类
	
* Command接口，抽象的命令接口
	* `Command`：命令接口
	
* CommandImpl类，命令实现类，实现具体的命令功能
	* `NormalFontCmd`：正常字体命令类
	* `BigFontCmd`：大字体命令类
	* `WhiteBackgroundCmd`：白色背景命令类
	* `BlackBackgroundCmd`：黑色背景功能类
	
* Invoker类，命令的调用者
	* `Invoker`：含有Command的List列表，具体命令的调用者
	
* 执行顺序：`（客户）Client--->调用者（Invoker）--->命令（CommandImpl）--->接受者（Receiver）`

* 参考源码：`src/designpattern/command`

#### 优缺点

* 优点：
	* 1、降低了系统耦合度。 
	* 2、新的命令可以很容易添加到系统中去。
	
* 缺点：使用命令模式可能会导致某些系统有过多的具体命令类。

#### 使用场景：

* 认为是命令的地方都可以使用命令模式，比如： 1、GUI 中每一个按钮都是一条命令。 2、模拟 CMD。
* 在某些场合，比如要对行为进行"记录、撤销/重做、事务"等处理，这种无法抵御变化的紧耦合是不合适的。
* 如何将"行为请求者"与"行为实现者"解耦？将一组行为抽象为对象，可以实现二者之间的松耦合。

##### 参考

* http://www.jianshu.com/p/3fd3166c7662
* http://www.runoob.com/design-pattern/command-pattern.html

---

[@Frank Jiang](https://github.com/FrankJiang92)

2016-10-10