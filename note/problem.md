#### web相关

* session & cookie 原理及区别

* sso 单点登录的原理

#### 框架相关

* spring MVC
* OSGi相关原理
* action 反射机制
* struts2

#### DB相关

* CMDB
* MySql 增量 全量 备份
* MySql trigger(参考lingxu vps db 中的lingxu_vm)
* MySql view(参考lingxu vps db 中的lingxu_vwmyvminuse)
* SQL 正则式     regexp
* 如下SQL语句具体含义：

``` sql
CREATE TABLE `lingxu_availvm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `zoneid` int(11) DEFAULT NULL,
  `zone_name` varchar(255) DEFAULT NULL,
  `cluster` varchar(255) DEFAULT NULL,
  `dc` varchar(255) DEFAULT NULL,
  `flavorid` int(11) DEFAULT NULL,
  `flavor_name` varchar(255) DEFAULT NULL,
  `avail_vm` int(11) DEFAULT NULL,
  `avail_vm_with_pubip` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `upd_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `flavorid` (`flavorid`),
  KEY `cluster` (`cluster`) USING BTREE,
  KEY `zoneid` (`zoneid`),
  KEY `dc` (`dc`),
  CONSTRAINT `dc` FOREIGN KEY (`dc`) REFERENCES `lingxu_datacenterusage` (`dc`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lingxu_availvm_ibfk_1` FOREIGN KEY (`flavorid`) REFERENCES `lingxu_flavor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `lingxu_availvm_ibfk_2` FOREIGN KEY (`cluster`) REFERENCES `lingxu_clusterusage` (`cluster`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `zoneid` FOREIGN KEY (`zoneid`) REFERENCES `lingxu_zoneusage` (`zone_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3539 DEFAULT CHARSET=utf8;
```

#### Java相关
* java 命令执行jar [click here](http://www.cnblogs.com/adolfmc/archive/2012/10/07/2713562.html)

#### redis
* [redis快速入门](http://www.yiibai.com/redis/redis_quick_guide.html)
* [redis安装配置](http://www.cnblogs.com/kreo/p/4399612.html)

#### 消息队列

* 生产者消费者模式
* 发布者订阅者模式

#### 其他

 * url路由机制 [click here](http://www.cnblogs.com/powerdk/p/4240431.html)
 
 * eclipse java debug机制 [click here](http://www.ibm.com/developerworks/cn/java/j-lo-jpda1/)
 
##### 参考

- [史上最全的Java&Android面试题搜集整理](http://blog.csdn.net/wdong_love_cl/article/details/52084720)
- [编程之法：面试和算法心得](https://github.com/FrankJiang92/The-Art-Of-Programming-By-July/tree/master/ebook/zh)
- [LearningNotes](https://github.com/FrankJiang92/LearningNotes)
- [java线程50问](http://www.jcodecraeer.com/a/chengxusheji/java/2015/0206/2421.html)
- [wenmingvs的面试经验和题目集锦](http://www.nowcoder.com/discuss/3244)