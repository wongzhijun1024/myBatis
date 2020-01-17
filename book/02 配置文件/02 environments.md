实例：

![](https://github.com/hwdeveloper/myBatis/blob/master/book/imgs/environments%E9%85%8D%E7%BD%AE.png?raw=true)

### 一，environments内可以设置多个environment

每个<environment>都使用id设置环境唯一的名字。项目运行过程中只有一个<environment>生效，即<environments default="???">中default值指定的<environment>生效。

