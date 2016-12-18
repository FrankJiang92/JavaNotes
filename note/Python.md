# python基础编程1小时快速实战

## 一、Python概述

* 面向对象的解释型的编程语言
* 应用领域
	* WEB应用：Django
	* 系统应用
	* GUI程序
	* 大数据分析
	* 数据挖掘
	* 机器学习
	* 自动化运维
	* 爬虫

## 二、基本语法与编程基础

### 2.1 变量

* 数

``` python
i=5
print(i)
```

* 字符串

``` python
a='hello'
print(a)
b="hello"
print(b)
```

### 2.2 数据类型

* 列表：相当于数组，存储数据；`[]`指定列表；下标从零开始；列表中数据可以修改

``` python
students=["frank","cherry","jiangfan"]
print(students[2])
students[2]="liu"
print(students[2])
```

* 元组：元组中的数据不能修改，只能读取；`()`指定元组，下标从零开始

``` python
students=("frank","cherry","jiangfan")
print(students[1])
```

* 集合

``` python
a=set("abcdefgh")
print(a)
b=set("acdxyz")
print(b)
```

* 交集：`c=a&b`

* 并集：`d=a|b`

* 差集：`e=a-b`

* 字典

## 三、Python函数与模块

### 3.1 函数

* 函数定义：函数体必须要缩进

``` python
def FuncName([参数列表]):
	函数内容
	函数内容
	[return sth]
```

* 全局变量和局部变量
	* 作用域：变量可以使用的区域
	* 局部变量：定义在函数内部
	* 全局变量：定义在函数外部；如果想在函数中使用全局变量，在函数中使用`global`指定变量

* 形参与实参

## 四、Python控制结构

### 4.1 顺序结构

### 4.2 选择结构

``` python
if 条件1:
	执行操作 1
elif 条件2:
	执行操作 2
else:
	执行操作 3

```

### 4.3 循环结构

* for基本结构

``` python
for i in 集合:
	执行操作
[else:
	执行操作]
```

* for使用range函数

``` python
for i in range(1,7):
	print(i)	

for i in range(1,10,3) #其中3为i每次跳跃的大小
	print(i)
```

* while

``` python
while 条件1:
	执行操作
[else:
	执行操作]
```

## 五、面向对象编程

### 5.1 类与对象

* 类的实现

``` python
class man:
	pass		# pass为空语句，无意义，占位语句
print(man)
```

* 对象的实现

``` python
class woman:
	pass
w = woman()
print(w)
```

* 类属性：
	* 单独修改某一个实例的属性时，其他实例属性不受影响；
	* 如果修改类的属性，则该类的所有实例均受影响

``` python
print(w.__dict__)	# 查看所有属性
w.name="aaaa"		# 添加属性
```

* 类方法：类中所有方法的第一个参数都要使用self，表示所有实例共享该方法

``` python
class man:
	def func(self):	
		print("this is a function.")
```

* 继承的实现：在子类的名称后面使用`()`包含继承的父类的名称；支持多继承，使用`,`分割

``` python
class a:
	def sing(self):
		print("i can sing a song")
class b(a):
	def eat(self):
		print("i like eating")
```