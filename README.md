# Java Web 分支
#### 此分支专用于 Java Web 的各种要求，将有更多的中文注释和更简洁的实现逻辑，若此分支能够帮助到你，不如点个 Star 或者 Follow 一下  
#### 特点

- MyBatis Generator 自动生成 model, dao, mapper 代码
- 完善的全局错误处理和身份验证，身份验证基于 JWT
- RESTful 风格 API，统一的全局返回格式，错误代码溯源 
- 前后端分离开发模式
- 覆盖不全的单元测试

#### 结构
- controller, dao, model, service 遵循标准的 Spring MVC 架构
- errorhandle: 全局错误处理
- interceptor: MVC 拦截器，身份验证
- util: 实用工具

#### 开发
- 首先更新 maven 依赖，修改数据库配置。  
- blog.sql 为数据库结构，推荐使用自己已设计好的数据库  
- resource/generatorConfig.xml 为 MyBatis Generator(MBG) 配置文件，你需要根据数据库改动。若不熟悉 MBG，亦推荐自行完成 model, dao, mapper 层的编码  
- 若使用 MBG 自动生成代码，执行 `mvn mybatis-generator:generate` 命令生成代码  
- 后续开发仅需对 service, controller 增加业务即可  

#### 注意
你可以任意使用开源代码，更加建议根据该分支进行改动