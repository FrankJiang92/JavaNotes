# SpringMVC

## MVC

* View:
* Model:业务数据的信息表示
* Controller:调用业务逻辑产生合适数据，传送数据给view
![](http://images.cnitblog.com/blog/434101/201410/121640507182810.png)

## SpringMVC基本概念

### SpringMVC静态概念

* `DispatcherServlet`：前端控制器
* `Controller`
* `HandlerAdapter`
* `HandlerInterceptor`:拦截器，在controller之前和之后工作
* `HandlerMapping`：Controller与DispatcherServlet关联
* `HandlerExecutionChain`：执行链
* `ModelAndView`：model的具体表现
* `ViewResolver`：选择需要的视图对象
* `View`：呈现页面，jsp,jstl

### SpringMVC动态概念

* 流程图

![](http://img.my.csdn.net/uploads/201304/13/1365825529_4693.png)


## Maven

* POM：Project Object Model，处理传递依赖
* 依赖管理：直接依赖，传递依赖
* 坐标：定位
	* groupId
	* artifactId
	* version
	* packaging

## SpringMVC创建

### Maven创建WebApp项目

* 创建webapp项目

```
mvn archetype:generate -DgroupId=HelloSpringMVC -DartifactId=HelloSpringMVC -DarchetypeArtifactId=maven-archetype-webapp
```

* 使用jetty启动服务器，前提是在pom文件中引入jetty插件

```
mvn jetty:run
```

### 修改pom文件

* 增加jstl依赖
* 增加servlet依赖（如果需要使用HttpServletRequest）

### 完成业务逻辑编写

* model
* service：`@Service`
* service implements：`@Service("name")`
* controller：
	* `@Controller`
	* `@RequestMapping("")`
	* 定义service，并set service：`@AutoWired`
	* 新建处理方法：`@RequestMapping(value="url",method=RequestMethod.GET)`
	* 指定传递参数：`@RequestParam("courseId") Integer courseId`
	* restful风格传递参数：
		* `@RequeatMapping(value="/{courseId}", method=RequestMethod.GET)`
		* `@PathVariable("courseId")`

### Binding

* 将请求中的字段按照名字匹配的原则填入模型对象
* 自动绑定
* `@ModelA`

### 使用json方式进行数据交互

### ajax异步获取json数据

## 参考

* http://www.cnblogs.com/sunniest/p/4555801.html
