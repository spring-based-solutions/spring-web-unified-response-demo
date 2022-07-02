# 快速入门

## 背景
本项目是为了解决`HTTP`接口返回统一格式的`JSON body`这个问题。

## 运行环境
1. `JDK 1.8`或以上版本
2. `maven 3.1.0`或以上版本
3. 需要开发工具安装`lombok`插件 

## 快速启动
1. 运行`SpringWebParamValidateDemoApplication`的`main`方法即可启动项目
2. 然后在浏览器中进行以下操作就可以看到统一响应体的示例运行效果了
    1. 在浏览器直接访问`http://127.0.0.1:8080/users/0`，则返回结果如下（结果经过格式化处理）：
        ```
        {
          "code": 10001,
          "msg": "资源不存在",
          "data": null
        }
        ```
## 单元测试
TODO

## Swagger接入
访问地址：`http://localhost:8080/swagger-ui/index.html`
