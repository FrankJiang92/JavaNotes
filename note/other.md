
#### Hash

* hash函数方法
	* 数字分析法
	* 平方取中法
	* 分段叠加法
	* 除留余数法
	* 伪随机数法
* hash冲突
	* 开放定址法：再散列法，使用计算得到的hash值在进行hash计算
	* 再哈希法：同时构造多个hash算法，一个冲突使用第二个
	* 链地址法：将hash地址相同的元素构成一个称为同义词链的单链表
	* 建立公共溢出区：建立基本表和溢出表两部分，冲突的元素放入溢出表
* hashmap与hashtable区别
	* 1、HashMap是非线程安全的，HashTable是线程安全的。
	* 2、HashMap的键和值都允许有null值存在，而HashTable则不行。
	* 3、因为线程安全的问题，HashMap效率比HashTable的要高。
* hashmap

* hashtable：使用synchronized

* ConcurrentHashMap：使用lock

* 参考；http://blog.csdn.net/tgxblue/article/details/8479147