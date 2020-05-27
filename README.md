# lazy-notes
> 记录平常学习，工作等需要的基础功能以及各种框架，工具的实践代码和例子
***

## 公共模块(lazy-common)

> 各个模块需要共同使用的一些功能或属性等

### 功能列表
- 通用的返回结果
- 通用的异常定义
- 全局常量定义
- 全局处理异常
- 根据阿里的Java编码规范定义的错误码
- 基础的实体类定义信息
- Spring Security用户信息处理的工具类

***

# 权限管理

> Spring Security和JWT实现RBAC权限管理功能


### 依赖模块

| 名称   | 版本                  |
| ------ | -------------------- |
| spring-boot  | 2.3.0.RELEASE  |
| msyql        | 8.0.20         |
| hutool       | 5.3.5          |
| lombok       | 1.18.8         |
| mybatis-plus | 3.3.1          |
| java-jwt     | 3.10.3          |
| spring-security | 2.3.0.RELEASE 

### 功能列表
- 用户账号注册，信息管理等功能
- RBAC基于角色的权限管理功能
- 基于SpringSecurity和JWT实现的权限授权登入，权限校验等功能
