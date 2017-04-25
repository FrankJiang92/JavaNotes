## Linux安装图形界面 & 配置VNC登录

* 安装Gnome桌面
	* `yum grouplist`：查看可用的组
	* `yum groupinstall "Desktop"`
	* `yum groupinstall "X Window System"`
	* `yum groupinstall "Chinese Support"`
	* `startx`：重启，也可在配置vnc之后进行
	* [参考](http://blog.csdn.net/kimsoft/article/details/8020014)

* 安装配置VNC
	* `rpm -q vnc vnc-server`：查看vnc是否安装
	* `yum install vnc vnc-server trigervnc-server`：安装vnc
	* `vncserver`：启动vnc，第一次需设置密码
	* `vncserver -kill :1`：杀死刚才运行的vncserver，id为1
	* `vim ~/.vnc.xstartup`：编辑当前用户的vnc配置脚本文件，配置使远程登录为gnome桌面还是kde桌面
	* `vim /etc/sysconfig/vncservers`：vnc配置文件
	```
	VNCSERVERS="1:root "  
 	VNCSERVERARGS[1]="-geometry 1024x768" 
	```
	* `/sbin/service vncserver restart`：启动vncserver
	* `chkconfig vncserver on`：设置开机自动启动
	* [参考](http://www.centoscn.com/image-text/config/2015/0704/5794.html)
	
* 连接vnc
	* 使用chrome的vnc viewer
	* server地址：`ip:5901`
