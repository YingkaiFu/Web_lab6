# 项目介绍
本项目为南昌大学计算机系Java web程序设计期中作业。
## 如何使用
1. Clone下项目，checkout 到lab7分支
2. 修改项目结构中的Modules,加入tomcat,和项目中lib目录下的sqlite.jar文件
3. 在Artifacts中，新建Web_lab6:war exploded，选择from modules,确认
4. 在文件getBook.jsp和index.jsp中，修改数据库的路径
```java
String url = "jdbc:sqlite:${你的数据库的绝对目录}";
```
5. 双击index.jsp,右击选择run 'index.jsp'打开网站
## 实现功能
* 客户端
- [X] 书籍信息浏览(首页显示书籍类别，点击类别显示该类别书籍信息)()
- [X] 完成用户登录
- [X] 完成用户注册
- [X] 完成添加书籍信息到购物车(购物车可不用数据库保存)
- [X] 完成登录用户查看购物车功能(购物车可删除商品和修改商品数量)
- [X] 完成用户注销功能
- [X] 完成登录用户通过购物车提交订单功能
- [X] 登录用户可查看自己的订单信息
* 服务端
- [X] 完成书籍录入功能(包括书籍类别和书籍信息功能)
- [X] 后台查看全部用户订单功能(可按类型查询，初始订单、已完成订单)
- [ ] 后台修改订单状态功能(可将初始订单修改为已完成)
- [X] 后台用户信息查询
## 实验要求
* 需要在12周的时候开始检查
* 数据库和前端技术框架不做限定
