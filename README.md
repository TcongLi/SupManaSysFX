# SupManaSysFX

这是一个整合了 [mvvmFX](https://github.com/sialcasa/mvvmFX) 和 [Mybatis](http://www.mybatis.org/mybatis-3/) 的 DEMO, 模拟供应商管理系统, 用于数据库课程设计.

---------

* GUI: JavaFX8 & [ControlsFX](http://fxexperience.com/controlsfx/) & [JFoenix](https://github.com/jfoenixadmin/JFoenix) & [SceneBuilder](http://gluonhq.com/labs/scene-builder/).
* 表示层架构模式: MVVM.
* 持久层框架: Mybatis, [Mybatis-generator插件](http://generator.sturgeon.mopaas.com/).
* DB: Sql Server (DDL在根目录).

# 项目依赖
用 Gradle 构建:
* 'de.saxsys:mvvmfx:1.5.2'   //一个实现了 MVVM 架构模式的 JavaFX 框架.
* group: 'org.mybatis', name: 'mybatis', version: '3.4.2'   //Mybatis
* group: 'org.mybatis', name: 'mybatis-typehandlers-jsr310', version: '1.0.2' //用于 Mybatis 对 java.time.LocalDateTime 的 Typehandler 类型支持.
* 'org.controlsfx:controlsfx:8.40.12'   //一个优秀的 JavaFX 控件库.
* 'com.jfoenix:jfoenix:1.0.0'   //一个 [Material Design](https://material.io/guidelines/) 风格的 JavaFX 控件库.

# NOTE

该项目并未做完整,只分别实现了一个基本的单表和多表 CRUD.

代码略混乱,有待重构.

# LICENSE
GPL v3.0
