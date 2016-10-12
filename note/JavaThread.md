# Java线程

## 1. 线程与进程

## 2. Java线程实现方式

## 3. Java中的锁（JMM Lock）

* 参考：http://blog.csdn.net/fw0124/article/details/6671447

## 4. synchronized、lock、atomic的区别

### 4.1 synchronized

* synchronized: Java中的关键字，用来修饰一个**方法**或者一个**代码块**，保证同一时刻最多只有一个线程执行该段代码

* synchronized修饰**方法**
	* 同一时刻对于某一个object，其所声明为synchronized的成员函数至多只有一个处于可执行状态，其他非synchronized的方法可以正常执行
	* 每一个synchronized方法需要获得object的锁，一旦执行，就独占该锁，方法返回时释放该锁
	* 有效类成员变量的访问冲突（只要所有可能访问类成员的方法均被声明为synchronized）
	* synchronized方法获得的锁是调用该方法的object的锁（**对象锁**），不同的对象调用同一个synchronized方法是可以执行的
	* synchronized的静态成员函数，所获得的锁为类的锁（**类锁**），所有该类的实例对象都不能同时执行该方法，可以控制对该类静态成员变量的访问

* synchronized修饰**代码块**
	* synchronized代码块：其中的代码**必须获得对象的锁**方能执行；且可**任意指定上锁的对象**
	* 两个并发线程访问同一个object中的synchronized(this)代码块时，同一时间只能有一个线程可以执行；另一个线程必须等待当前线程执行完这个代码块后才可以执行该代码块
	* 一个线程访问object的一个synchronized(this)同步代码块时，另一个线程可以访问该object的非synchronized(this)代码块
	* 一个线程访问object的一个synchronized(this)代码块时，其他线程对该object中其他synchronized(this)同步代码块的访问将被阻塞
	* 一个线程访问object的一个synchronized(this)代码块时，它就获得该object的对象锁，其他线程对该object对象的所有同步代码部分的访问都暂时阻塞
	
* 对象锁与类锁
	* 如果一个类中定义了synchronized的static函数A，也定义了synchronized的函数B，则**函数A获得的锁为类锁，函数B获得的锁为对象锁**
		* 在多线程中，这个类的同一个对象分别访问A和B两个函数，不会构成同步，因为使用的锁不一样
	* `.class`和`getClass`的区别？？（《Effective Java》）
		* `synchronized(Foo.class)`
		* `synchronized(f.getClass())` 

* 共享资源同步访问安全的技巧
	* 定义private的instance变量和get方法，不要定义为public/protected；否则，对象在外界可以绕过同步方法的控制而直接取得它并改动它，这也是JavaBean的标准实现方式
	* 如果instance变量是一个对象，那上述方法仍不安全，因为外界get到的时这个instance的引用；这时候需要将get方法也加上synchronized同步，并只返回这个private对象的clone()，调用端使用的就是对象副本的引用

* 参考：[Java synchronized详解](http://www.cnblogs.com/GnagWang/archive/2011/02/27/1966606.html)

### 4.2 lock

* `java.util.concurrent.locks.Lock`：Lock接口
	* `void lock()`：获取锁；如果锁已被其他线程获取，则进行等待；获取锁后，必须主动释放锁，并且在异常时，不会自动释放锁
	* `void lockInterruptibly() throws InterruptedException`：通过该方法去获取锁时，如果线程正在等待获取锁，这个线程可以响应中断，即中断等待状态；调用thread.interrupt()可以中断等待；会抛出异常InterruptedException；如果线程获取到锁之后，是不会被interrupt()方法中断的
	* `boolean tryLock()`：有返回值的尝试获取锁，获取成功，返回true，获取失败，返回false；该方法会立即返回，拿不到锁时不会等待
	* `boolean tryLock(long time, TimeUnit unit) throws InterruptedException`：与tryLock类似，不过该方法在拿不到锁时会等待一定时间，在时间期限内拿不到锁，就返回false
	* `void unlock()`：释放锁，**一旦锁获取，必须主动释放锁**，在try...finally中实现
	* `Condition newCondition()`：

* `java.util.concurrent.locks.ReentrantLock`：ReentrantLock，可重入锁，实现Lock接口，Lock的具体实现类

* `java.util.concurrent.locks.ReadWriteLock`：读写锁
	* `Lock readLock()`：读锁，多个线程可以同时进行读操作
	* `Lock writeLock()`：写锁
	* 注意：
		* 多个线程可以同时进行读操作，提高读操作的效率
		* 如果一个线程A占用读锁，其他线程申请写锁，则会一直等待线程A释放读锁 
		* 如果一个线程A占用写锁，其他线程申请读锁或写锁，都要一直等待线程A释放写锁
* `java.util.concurrent.locks.ReentrantReadWriteLock`：实现读写锁接口
	* `public ReentrantReadWriteLock.WriteLock writeLock()`：获取读锁
    * `public ReentrantReadWriteLock.ReadLock  readLock()`：获取写锁

* 锁相关概念
	* 可重入锁：如果锁具备可重入性，则成为可重入锁，synchronized和ReentrantLock都是可重入锁
		* 锁分配机制：基于线程的分配，不是基于方法调用的分配；如果线程执行到某个synchronized的方法A时，同时A中调用另一个synchronized的方法B，则线程不需要重新申请锁，而是直接执行方法B（防止一个线程永远等待自己已拿到的一个锁）
	
	``` java
	 public synchronized void A() {
        B();
    }
    public synchronized void B() {
    }
	``` 
		
	* 可中断锁:synchronized不可中断锁，Lock是可中断锁
	
	* 公平锁与非公平锁
		* 公平锁：尽量以请求锁的顺序获取锁，即多个线程等待一个锁，这个锁释放时，等待时间最久的线程（最先请求）获得该锁
		
		* 非公平锁：无法保证锁的获取是按照请求锁的顺序执行，这就可能导致某个线程永远无法获得锁；
		* synchronized为非公平锁
		* ReentrantLock和ReentrantReadWriteLock默认是非公平锁，但是也可以设置为公平锁
	

* 参考：[Java并发编程： Lock](http://www.cnblogs.com/dolphin0520/p/3923167.html)

### 4.3 atomic

### 4.4 区别

## 5. 线程池

* 参考：
	* http://blog.csdn.net/touch_2011/article/details/6914468/
	* http://blog.csdn.net/escaflone/article/details/10418651

## 6. atomic

## 7. volatile

## 8. wait与sleep

## 9. 线程间通信

## 10. synchronized详解