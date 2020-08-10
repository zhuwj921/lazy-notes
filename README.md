# lazy-notes
> 记录平常学习，工作等需要的基础功能以及各种框架，工具的实践代码和例子

> git EOF问题（git config --global https.postBuffer）
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

## 文档管理(lazy-document)

> 记录SQL，Java规范，安装流程等文档

### 功能列表
- 各个模块SQL语句集合
- linux的软件安装记录
- Java开发规范

## 代码生成(lazy-generator)

> 基于mybatis-plus的代码生成

### 依赖模块

| 名称   | 版本                  |
| ------ | -------------------- |
| msyql        | 8.0.20         |
| hutool       | 5.3.5          |
| lombok       | 1.18.8         |
| mybatis-plus | 3.3.1          |
| mybatis-plus-generator| 3.10.3|
| freemarker | 2.3.0.RELEASE    |

### 功能列表
- 自定义模板
- 根据输入参数(模块名称:lazy-auth,包名称:auth,表名称:sys_user),生成自己定义的模板和代码位置

## 启动入口(lazy-bootstrap)

> 动态集成相关模块

### 目前依赖模块

| 名称   | 版本                  |
| ------ | -------------------- |
| lazy-auth    | 1.0.0          |
| lazy-dict    | 1.0.0          |
| lazy-attachment| 1.0.0        |

## 权限管理(lazy-auth)

> SpringSecurity和JWT实现RBAC权限管理功能

### 依赖模块

| 名称   | 版本                  |
| ------ | -------------------- |
| spring-boot  | 2.3.0.RELEASE  |
| msyql        | 8.0.20         |
| hutool       | 5.3.5          |
| lombok       | 1.18.8         |
| mybatis-plus | 3.3.1          |
| java-jwt     | 3.10.3          |
| spring-security | 2.3.0.RELEASE|

### 功能列表
- 用户账号注册，信息管理等功能
- RBAC基于角色的权限管理功能
- 基于SpringSecurity和JWT实现的权限授权登入，权限校验等功能

## 数据字典(lazy-dict)

> 系统中实现配置数据的key-value形式与动态更改

### 依赖模块

| 名称   | 版本                  |
| ------ | -------------------- |
| spring-boot  | 2.3.0.RELEASE  |
| msyql        | 8.0.20         |
| hutool       | 5.3.5          |
| lombok       | 1.18.8         |
| mybatis-plus | 3.3.1          |
| spring-cache | 2.3.0.RELEASE |

### 功能列表
- 数据字典数据的管理与配置
- 数据字典工具类获取字典值的操作
- 数据字典缓存处理

## 任务调度（lazy-quartz）

> 基于quartz，在系统中实现对定时任务的操作，动态的改变定时任务信息

### 依赖模块

| 名称   | 版本                  |
| ------ | -------------------- |
| spring-boot  | 2.3.0.RELEASE  |
| msyql        | 8.0.20         |
| hutool       | 5.3.5          |
| lombok       | 1.18.8         |
| mybatis-plus | 3.3.1          |
| quartz | 2.3.0.RELEASE |

### 功能列表
- 定时任务数据的管理与配置
- 动态修改定时任务信息

## 附件管理（lazy-attachment）

> 处理系统中附件上传，本地上传文件的保存以及其他操作

### 依赖模块

| 名称   | 版本                  |
| ------ | -------------------- |
| spring-boot  | 2.3.0.RELEASE  |
| msyql        | 8.0.20         |
| hutool       | 5.3.5          |
| lombok       | 1.18.8         |
| mybatis-plus | 3.3.1          |

### 功能列表
- 附件数据的管理
- 附件本地上传以及FTP等文件服务器上传操作
- 附件的下载功能


## 工作流（lazy-workflow）

> 基于activity，提供各种流程解决方案

### 依赖模块

| 名称   | 版本                  |
| ------ | -------------------- |
| spring-boot  | 2.3.0.RELEASE  |
| msyql        | 8.0.20         |
| hutool       | 5.3.5          |
| lombok       | 1.18.8         |
| mybatis-plus | 3.3.1          |
| activity | 6.0.0         |

### 功能列表
- 请假流程实例测试

## 事件处理（lazy-event）

> 基于Spring的事件处理机制

### 依赖模块

| 名称   | 版本                  |
| ------ | -------------------- |
| spring-boot  | 2.3.0.RELEASE  |
| msyql        | 8.0.20         |
| hutool       | 5.3.5          |
| lombok       | 1.18.8         |
| mybatis-plus | 3.3.1          |

### 功能列表
- 事件处理的测试demo


