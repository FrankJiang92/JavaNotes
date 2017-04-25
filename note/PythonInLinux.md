## Use python in Centos

### 安装pip

* `sudo yum -y install epel-release`：安装epel-release源
* `yum install python-pip`：安装pip
* [参考](http://www.cnblogs.com/Rsean/articles/5635904.html)

### 安装matplotlib

* `ImportError: No module named matplotlib.pyplot`：未安装python-matplotlib模块
* 使用`pip install python-matplotlib`失败：`could not find a version that satisfies the requirement python-matplotlib`
* 正确方法：`pip install matplotlib==1.3.1 --allow-external matplotlib --allow-unverified matplotlib`
* [参考](https://github.com/matplotlib/matplotlib/issues/2715)

### 安装twisted

* 
