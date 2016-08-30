#### 简单工厂/工厂方法/抽象工厂 模式

---

#### 简单工厂

* 组成

	- 工厂类 
		- `ComputerFactory`:`makeComputer()`
	- 抽象产品接口
		- `Computer`：`getComputer()`
	- 具体产品类
		- `LenovoComputer`
		- `AcerComputer`
		
* 特点
	
	- 所有的产品都在一个工厂里面生产
	
* 代码参考：`JavaNotes/src/designpattern/now/simplefactory`

#### 工厂方法

* 组成

	- 抽象工厂接口
		- `ComputerFactory`：`makeComputer()`
	- 具体工厂类
		- `LenovoComputerFactory`
		- `AcerComputerFactory`
	- 抽象产品 接口
		- `Computer`：`getComputer()`
	- 具体产品	类
		- `LenovoComputer`
		- `AcerComputer`
		
* 特点
	
	- 不同产品在不同具体工厂里面实现
	- 不同的具体工厂实现抽象工厂接口里面的方法

* 代码参考：`JavaNotes/src/designpattern/now/factorymethod`

#### 抽象工厂

* 组成

	- 抽象工厂接口
		- `ComputerFactory`：`makeLaptopComputer()`和`makeDesktopComputer()`
	- 具体工厂类
		- `LenovoComputerFactory`
		- `AcerComputerFactory`
	- 抽象产品接口 
		- `Computer`:`getComputer()`
	- 抽象产品类	
		- `LaptopComputer`:`getComputer()`
		- `DesktopComputer`:`getComputer()`
	- 具体产品类：
		- `LenovoLaptopComputer`
		- `LenovoDesktopComputer`
		- `AcerLaptopComputer`
		- `AcerDesktopComputer`
		
* 特点
	
	- 不同产品在不同的工厂里面生产
	- 具体工厂里面可以生产不同类型的产品
	- 产品族的概念
	
	``` json
	|---Computer
	|	|
	|	|---LaptopComputer
	|	|	|
	|	|	|---LenovoLaptopComputer
	|	|	|
	|	|	|---AcerLaptopComputer
	|	|
	|	|---DesktopComputer
	|	|	|
	|	|	|---LenovoDesktopComputer
	|	|	|
	|	|	|---AcerDesktopComputer
	```
* 代码参考：`JavaNotes/src/designpattern/now/abstractfactory`

##### 参考
* [简单工厂](http://blog.csdn.net/silvia0427/article/details/8313358)
* [工厂方法](http://blog.csdn.net/silvia0427/article/details/8313359)
* [抽象工厂](http://blog.csdn.net/silvia0427/article/details/8313362)

---
@Frank Jiang

2016-8-30