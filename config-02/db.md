对mybatis配置文件的优化
<!--引⼊外部配置⽂件-->
<properties resource="db.properties">
<!--可以给实体类起别名-->
<typeAliases>
<typeAlias type="com.pn.entity.User" alias="User"/>
</typeAliases>
<!--每⼀个Mapper.XML都需要在Mybatis核⼼配置⽂件中注册！-->
<mappers> <mapper resource="com/pn/dao/UserMapper.xml"/>
</mappers>
