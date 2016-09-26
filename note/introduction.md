### 实习项目

主要负责凌虚管理平台的开发与维护，主要使用java语言进行开发。

凌虚管理平台是爱奇艺内部的运维管理平台，在该平台上，用户可以进行资源的申请、管理，比如虚拟机、负载均衡等的申请和管理；还有一些ticket申请、审核的流程管理等功能，使用该平台，开发人员可以快速的申请资源、使用资源，提高了公司的工作效率。

在实习期间，自己负责的重要工作有下面几个：

* OpenStack Flavor的创建管理功能

Flavor是Openstack的主机模版，包含RAM大小、硬盘大小、CPU核数等信息，OpenStack可以根据Flavor的信息，创建虚机，对于公司的大量OpenStack集群来说，如果单个手动创建和管理Flavor效率非常低下。所以借助凌虚平台，可以实现Flavor的增加、管理、创建以及定时同步。管理员在凌虚平台新增一个Flavor后，凌虚后台会自动启动多线程，实现在该Flavor的全集群的创建，并记录该Flavor在各个集群的创建情况。还有一个定时任务，会定期执行，同步未创建成功的Flavor信息。

重点内容：

（1）每一个新增的Flavor都有一个唯一的id，而需要在CMDB中配置一个初始ID值，每创建一个flavor，会取出CMDB中配置的当前值，并在该值的基础上+1，当该flavor创建成功后，将新的id值写回到CMDB中。这就需要考虑到多线程并发的情况下，多个用户同时创建flavor，就有可能导致多个flavor的id是相同的。所以需要注意多线程并发时的操作的原子性问题。

（2）使用多线程实现Flavor的全集群创建，使用线程池管理线程。在创建Flavor时，为每一个集群开启一个线程，然后读取该集群中不存在的Flavor信息，然后为该集群创建该Flavor，在创建时，需要读取到每一个集群执行的结果，在这里使用[Future和Callable机制](http://www.cnblogs.com/dolphin0520/p/3949310.html)，得到执行结果写入到数据库

（3）Flavor的创建实现：在凌虚平台，调用OpenStack提供的restful api，向openstack发送json字符串，json字符串中包含flavor的信息，包括ram, cpu, disk信息。在调用api时，首先需要获取token，然后发送Http post请求，携带token，上传json字符串，openstack处理完请求后，返回json数据。

（4）定时同步：使用[crontab](http://www.cnblogs.com/chenshishuo/p/5152068.html)，在java中使用[JCrontab框架](http://blog.csdn.net/e_wsq/article/details/7538785)，crontab执行的时间，可以在凌虚平台上配置，并将数据保存到数据库，当需要执行时，jcrontab会读取数据库的信息，然后启动osgi相应的bundle去执行

* Rpm包上线发布管理流程功能

Rpm包部署到repo上，需要经过申请审批的流程才可以成功部署。但是，为了让开发人员可以对rpm进行测试，所以将rpm包上线发布管理分为两步，首先是申请一个rpm预发布，预发布申请后，rpm包会上传并部署到repo的测试环境，开发人员测试正常后，可以在申请一个正式的上线流程，选择预发布成功的表单，经过相关人员审批后，将预发布环境的rpm包上传到上线环境中，并部署rpm包。

重点内容：

（1）RPM预发布申请：申请一个预发布，上传rpm文件到ftp server，暂时保存该文件（可以支持删除取消等功能，不至于直接部署到real server上），使用Ftp协议上传到server上；然后提交申请，提交申请后，该申请不会走审批流程，（ticket分为两部分，有审批流程和无审批流程，而且所有的流程可以在lingxu CMDB中配置，可扩展性好），读取lingxu cmdb中配置的该流程的处理的bundle，然后启动该bundle，执行部署功能，后端异步执行。

（2）具体部署流程：首先会读取申请表单信息，得到rpm文件列表、保存路径信息，然后download所有的rpm，然后将rpm上传到repo server测试环境中（repo server 上部署了一个web服务，go编写的，上传的方式是表单提交的方式，将rpm文件放在request body中），上传完成后，调用接口，发送json串，告诉 repo server在某个路径执行create repo动作。上述完成之后，部署成功，会向相关申请人或负责人发送邮件提醒，相关人员可以进行测试rpm工作

（3）RPM上线申请：在一个预发布完成之后，测试正常，可以申请一个上线申请，将rpm包部署到正式的生产环境中。用户提交一个申请，会选择预发布的表单信息，然后提交。该申请需要进行审核处理才可以通过上线功能，审核可以在lingxu中配置几级的审核，而lingxu后台会依次读取每一级审核的人员，发送邮件提醒，并在对应审核人员的页面上显示需要处理的申请；当所有的审核处理完成后，最后一步，会触发rpm部署的相关代码块，调用repo server接口，告诉repo server需要将测试环境的rpm拷贝到生产环境，并调用create repo，实现部署。成功后，发送邮件通知。

### android项目

* 设备故障流程管理的app

用于工厂的设备维修，机器down机后，相关人员会报修该机器，之前直接电话通知，有可能不到位，而且没有记录和考核机制，而且在维修过程中，很多维修人员不严格按照维修手册的流程，所以导致记录的数据混乱，管理混乱的现象。所以开发一款app，可以实现通过app报修，通知相关人员；然后维修人员可以通过app，调出对应问题的处理流程（该流程根据维修手册转换成xml文件形式，app会从远程数据库下载相关的流程文件，然后一步步load每一步的信息），然后根据流程的提示，一步步处理，并且在流程中定义了某一步需要记录哪些数据等，也可以拍摄现场图片、视频、语音等信息进行保存。根据流程，每一步更新完成后，都会向远程server更新当前的状态，并上传相关的数据等。另外开发一个桌面版的C#软件，可以让办公室的管理人员查看所有机器的维修情况以及相关的处理人员，处理时间等。

重要内容：

（1）如何根据现有的维修手册定义一套统一格式的文件，可以让android软件解析并一步步加载。抽象出流程中每一步为一个节点，每个节点包含处理信息，以及处理结果所对应的不同的下一个处理节点，有点类似于树的结构，使用xml文件定义，每一步个子模块包含这些信息。

（2）报修之后，会自动根据报修的问题描述，去数据库下载对应的xml文件和流程图文件，然后解析xml文件，加载图片，然后根据每一步的检查结果，选择加载下一步的内容。目前只支持的检查结果为两个，yes or no，对应加载不同的处理流程

（3）数据与server进行交互，是使用jdbc的方式连接远程数据库，直接进行数据的读取。由于当时时间比较紧，而且这个项目自己负责，所以没有时间去写一个server端的程序。如果现在去改进的话，会在server端增加一个web service，web service完成数据增删改查的功能，而且把c#端的软件省略掉，直接在web端显示这些信息即可。也可以使用restful框架，搭建web service服务。而且消息通知，推送，以及xml文件管理可以直接在web上进行

（4）这种方式访问数据库，对并发支持不好，当并发量大的时候，数据库无法承受这么大的并发量。

（5）对于视频、图片等大文件，无法直接保存到数据库中，所以使用ftp的方式保存到ftp server上，而在数据库中保存文件的索引和path

（6）针对没有上传成功的数据，本地数据库保存一份，然后待网络正常之后，重新上传数据

* 车载搅拌筒控制app

用于工程车辆的管理与控制，比如搅拌筒的控制。搅拌车上有相关控制设备控制搅拌筒的转速、转动方向等，但是只是能实现车辆搅拌筒的控制功能，为公司开发了一款app，在该app中，可以实现通过app控制搅拌筒的转速、方向等，可以通过app与底层的控制器进行蓝牙socket通讯，向控制发送控制指令，app也可以接收来自控制器的数据，并显示在界面上。而且，app可以记录车辆的行驶信息，位置信息，以及作业情况（根据装卸次数），并将该数据上传到远程server上，远程server是搭建了一个web网站，asp.net编写，post方式发送数据，远程server上会记录车辆的状态等信息，便于管理人员进行调度和管理。还支持远程诊断的功能，比如车辆发生故障，app可以在远程诊断功能中，实时向web服务器上传车辆的数据，维修人员可以远程了解车辆的问题等。

（1）蓝牙socket通信。开启一个后台的服务，service，该服务接收到数据后，处理成帧数据，然后通过广播的方式发出，activity接收到广播消息后，动态的更改界面等处理。——————出现内存泄漏的问题，原因是注册的广播没有反注册，而且，后台的service一直在运行，导致虽然activity关闭，但是一直在接收数据，因为广播里面有activity对象的引用

（2）发送数据到web服务器，发送Http 的 post请求，回调机制，调用一个监听器，使用AsyncTask上传，这个也有可能导致内存泄漏。

---

TODO

* lingxu架构：servlet---->反射----->每个bundle----->对应的action
* OSGI如何注册服务：DS
* 设计模式温习：工厂、单例、策略、组合、适配器、装饰者、
* java常见面试点——突击
* sql常见面试点——突击
* http常见面试点——突击
* http请求，request body, response body
	* Session&Cookie:

Cookie 的作用我想大家都知道，通俗地说就是当一个用户通过 HTTP 协议访问一个服务器的时候，这个服务器会将一些 Key/Value键值对返回给客户端浏览器，并给这些数据加上一些限制条件，在条件符合时这个用户下次访问这个服务器的时候，数据又被完整地带回给服务器。Cookie 是 HTTP 协议头中的一个字段，虽然 HTTP 协议本身对这个字段并没有多少限制，但是 Cookie 最终还是存储在浏览器里，所以不同的浏览器对 Cookie 的存储都有一些限制.

保存的数据通过 HTTP 协议的头部从客户端传递到服务端，又从服务端再传回到客户端，所有的数据都存储在客户端的浏览器里，所以这些 Cookie 数据可以被访问到，就像我们前面通过 Firefox 的插件 HttpFox 可以看到所有的 Cookie 值。不仅可以查看 Cookie，甚至可以通过 Firecookie 插件添加、修改 Cookie，所以 Cookie 的安全性受到了很大的挑战。

相比较而言 Session 的安全性要高很多，因为 Session 是将数据保存在服务端，只是通过 Cookie 传递一个 SessionID 而已，所以 Session 更适合存储用户隐私和重要的数据。

* ajax

AJAX：异步的javascript和xml，

* future callable
* servlet
* [线程池](http://blog.csdn.net/touch_2011/article/details/6914468/)

![线程声明周期](http://files.jb51.net/file_images/article/201410/201410311002063.png)

* web service & restful & websocket
* android service机制
* android binder机制，广播机制
* android socket机制
* 内存泄漏的原因
* [线程死锁的原因](http://cache.baiducontent.com/c?m=9f65cb4a8c8507ed4fece7631046893b4c4380146d96864968d4e414c422461e1060a6ec7c6a4a538fd82f2747f41802bded602571507be9dad58f4adab9972b298e33712d5cd04e43c419dfdc4655d620e14d99aa0e96b8e74497b9a2d8c85523dd23736df4fa9c2a0103bb1ee71541f4d7e95f645d07cb9d2711f5&p=882a9647dc8759fc57efc13e4d409f&newp=8e759a46d4c901f71faac52d02149c231611d63f6fbada126b82c825d7331b001c3bbfb427211601d5cf7d6307a45d1a87b1613038547ce1db90cf0d8c&user=baidu&fm=sc&query=C%2B%2B+%B7%C0%D6%B9%BD%F8%B3%CC%CB%C0%CB%F8&qid=ed4f10260000622e&p1=6)

	* 四个必要条件：互斥，请求与保持，不可剥夺，循环等待
	* 避免方法：打破其中一个任意一个条件;安全序列（系统中的所有进程能够按照某一种次序分配资源，并且依次地运行完毕），银行家算法

* Java数据结构

	* Collection
		* Set
			* HashSet
			* TreeSet
		* List
			* Vector
			* ArrayList
			* LinkedList
	* Map
		* HashMap
		* HashTable
		* TreeMap

* mysql加索引

	* 创建和删除索引：索引的创建可以在CREATE TABLE语句中进行，也可以单独用CREATE INDEX或ALTER TABLE来给表增加索引。删除索引可以利用ALTER TABLE或DROP INDEX语句来实现
	* 三种创建索引的格式：普通索引、UNIQUE索引和PRIMARY KEY索引
	``` sql
	alter table table_name add index index_name (column_list) ;
	alter table table_name add unique (column_list) ;
	alter table table_name add primary key (column_list) ;

	create index index_name on table_name (column_list) ;
	create unique index index_name on table_name (column_list) ;

	drop index index_name on table_name ;
	alter table table_name drop index index_name ;
	alter table table_name drop primary key ;
	```
	

* hibernate机制和作用
* mybatis机制和作用
* osgi
* JCrontab

* 网络编程中设计并发服务器，使用多进程 与 多线程 ，请问有什么区别？ 

答案一:
1，进程：子进程是父进程的复制品。子进程获得父进程数据空间、堆和栈的复制品。
2，线程：相对与进程而言，线程是一个更加接近与执行体的概念，它可以与同进程的其他线程共享数据，但拥有自己的栈空间，拥有独立的执行序列。
两者都可以提高程序的并发度，提高程序运行效率和响应时间。
线程和进程在使用上各有优缺点：线程执行开销小，但不利于资源管理和保护；而进程正相反。同时，线程适合于在SMP机器上运行，而进程则可以跨机器迁移。

答案二:
根本区别就一点：用多进程每个进程有自己的地址空间(address space)，线程则共享地址空间。所有其它区别都是由此而来的：
1。速度：线程产生的速度快，线程间的通讯快、切换快等，因为他们在同一个地址空间内。
2。资源利用率：线程的资源利用率比较好也是因为他们在同一个地址空间内。
3。同步问题：线程使用公共变量/内存时需要使用同步机制还是因为他们在同一个地址空间内。

* [阻塞、非阻塞、同步、异步浅析](http://www.cnblogs.com/bizhu/archive/2012/05/17/2506197.html)