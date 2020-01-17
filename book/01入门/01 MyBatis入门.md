### `一，MyBatis介绍`
- `MyBatis 是支持普通SQL查询,存储过程和高级映射的优秀持久层框架。`
- `MyBatis消除了几乎所有的JDBC代码和参数的手工设置以及结果集的检索。`
- `MyBatis 使用简单的XML或注解用于配置和原始映射,将接口和 Java 的 POJOs映射成数据库中的记录。`

### `二，配置MyBatis环境`
##### `（1）创建Maven项目`
##### `（2）添加架包依赖`
`在pom.xml添加配置文件`
```
	<dependencies>
		<!--2: 数据库相关 -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.35</version>
			<scope>runtime</scope>
		</dependency>
		<!-- DAO框架:MyBatis -->
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.3.1</version>
		</dependency>
		<!-- junit测试 -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.0</version>
				<configuration>
					<!-- jdk的版本 -->
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
		</plugins>
	</build>
```

### `三，在资源文件中创建mybatis.xml的配置文件`


```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<environments default="development">
		<environment id="development">
			<transactionManager type="JDBC" >
				<property name="autoCommit" value="false" />
			</transactionManager>
			<dataSource type="POOLED">
				<property name="driver" value="com.mysql.jdbc.Driver" />
				<property name="url" value="jdbc:mysql://127.0.0.1:3306/xhdb?useUnicode=true&amp;characterEncoding=UTF-8" />
				<property name="username" value="root" />
				<property name="password" value="123" />
			</dataSource>
		</environment>
	</environments>
	<mappers>
		<mapper resource="mapper/TeacherMapping.xml" />
	</mappers>
</configuration>
```

### `四，配置对象的配置文件`


```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.xxx.mapper.TeacherMapper">
	<!-- 在增加中的参数传递 --> 
	<insert id="insertTeacher">
		insert into teacher(name, sex, age, pwd)values(#{name},#{sex},#{age},#{pwd})	
	</insert>
	<!-- 查询 -->
	<select id="selectAllTeacher" resultType="com.xxx.po.Teacher">
		select id, name, sex, age, pwd from teacher
	</select>
</mapper>

```

### `五，创建TeacherMapper接口`

```
public interface TeacherMapper {
	//返回值表示成功插入了多少条
	public int insertTeacher(Teacher teacher);
	//查询出所有的老师
	public List<Teacher> selectAllTeacher();
}
```
### `六，创建Teacher对象` 

`Teacher`
```
public class Teacher {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String pwd;
}
```

### `七，创建工具类`

```
public class DBUtil {
	private static SqlSessionFactory factory = null;
	public static SqlSessionFactory getSqlSessionFactory() {
		try {
			if (factory == null) {
				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
				InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis.xml");
				factory = builder.build(inputStream);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return factory;
	}
}
```