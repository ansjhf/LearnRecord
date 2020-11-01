成都杉众创联科技有限公司
成都市锦江区汇源北路99号环球汇天誉5栋2508

Spring
Map m = Collections.synchronizedMap(new HashMap()); 
Map<String> m = new HashMap<String>();
Map<String> unmodList = Collections.unmodifiableMap(m);

ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内
部的副本变量。

Spring AOP可以做的事
	日志记录，性能统计，安全控制，异常处理，数据库事务处理

Spring可以做的事
	传统程序开发，创建对象及对象间依赖管理 
	日志记录，权限管理，性能统计

Spring优点
	轻量级容器
	AOP面向切面编程
	简单的数据库事务管理
	JDBC抽象及ORM框架支持
	灵活的Web层支持
	简化各种技术集成
	简化运用开发

Spring初始化过程，主要就是读取xml资源并解析，最终注册到BeanFactory中
XML-->读取Resource-->解析BeanDefinition-->注册BeanFactory

Spring 隔离级别：
		ISOLATION_DEFAULT 默认
		ISOLATION_READ_COMMITTED  读未提交内容
		ISOLATION_READ_UNCOMMITTED  读取提交内容
		ISOLATION_REPEATABLE_READ  可重读 (默认)
		ISOLATION_SERIALIZABLE  可串行化

Spring 事务传播行为
	PROPAGATION_MANDATORY 如果没有，就抛出异常；如果有，就使用当前事务
	PROPAGATION_NEVER 如果没有，就以非事务方式执行；如果有，就抛出异常
	PROPAGATION_SUPPORTS 如果没有，就以非事务方式执行；如果有，就使用当前事务
	PROPAGATION_NOT_SUPPORTED 如果没有，就以非事务方式执行；如果有，就将当前事务挂起
	PROPAGATION_NESTED 如果没有，就新建一个事务；如果有，就在当前事务嵌套其它事务
	PROPAGATION_REQUIRED 如果没有，就新建一个事务；如果有，就加入当前事务
	PROPAGATION_REQUIRES_NEW 	
		如果没有，就新建一个事务；如果有，就将当前事务挂起且只直到新的事务提交或者回滚才恢复执行。				意思就是创建了一个新事务，它和原来的事务没有任何关系了。

//redis 
-->String :
Set
	set key value --设置指定 key 的值
	setnx key value --只有在 key 不存在时设置 key 的值
	setex key seconds value --将值 value 关联到 key ，并将 key 的过期时间设为 seconds (以秒为单位)
	psetex key milliseconds value --将值 value 关联到 key ，并将 key 的过期时间设为 milliseconds (以毫秒为单位)
	mset key value [key2 value2 ...] --同时设置一个或多个 key-value 对
	msetnx key value [key2 value2...] --同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在
	setrange key offset value --用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始
	setbit key offset value --对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)
	append key value --如果 key 已经存在并且是一个字符串， APPEND 命令将指定的 value 追加到该 key 原来值（value）的末尾
Get
	get key --获取指定 key 的值
	mget key1 [key2...] --获取所有(一个或多个)给定 key 的值
	getset key value --将给定 key 的值设为 value ，并返回 key 的旧值(old value)
	strlen key --返回 key 所储存的字符串值的长度
	getrange key start end --返回 key 中字符串值的子字符
	getbit key offset --对 key 所储存的字符串值，获取指定偏移量上的位(bit)
Del 
	del key --通过 key，删除键值对
Incr
	incr key --将 key 中储存的数字值增一
	incrby key increment --将 key 所储存的值加上给定的增量值（increment）
	incrbyfloat key increment --将 key 所储存的值加上给定的浮点增量值（increment）
Decr
	decr key --将 key 中储存的数字值减一
	decrby key decremnet --key 所储存的值减去给定的减量值（decrement）

-->Hash :
Set
	hset key field value --将哈希表 key 中的字段 field 的值设为 value 
	hsetnx key field value --只有在字段 field 不存在时，设置哈希表字段的值
	hmset key field value [field2 value2...] --同时将多个 field-value (域-值)对设置到哈希表 key 中

Get
	hget key field --获取存储在哈希表中指定字段的值
	hkeys key --获取所有哈希表中的字段
	hgetall key --获取在哈希表中指定 key 的所有字段和值
	hexists key field --查看哈希表 key 中，指定的字段是否存在
	hlen key --获取哈希表中字段的数量
	hmget key field [field2...] --获取所有给定字段的值
	hvals key --获取哈希表中所有值
Del
	hdel key field [dield2...] --删除一个或多个哈希表字段
Incr
	hincrby key field increment --为哈希表 key 中的指定字段的整数值加上增量 increment 
	hincrbyfloat key field increment --为哈希表 key 中的指定字段的浮点数值加上增量 increment 
	HSCAN key cursor [MATCH pattern] [COUNT count] --迭代哈希表中的键值对

-->List :
Pop 
	blpop key1 [key2...] timeout --移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
	brpop key [key2...] timeout --移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
	brpoplpush source destination timeout --从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 
											如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止
	lindex key index --通过索引获取列表中的元素
	linsert key beforeiafter pivot value --在列表的元素前或者后插入元素
	llen key --获取列表长度
	lpop key --移出并获取列表的第一个元素
	rpop key --移除列表的最后一个元素，返回值为移除的元素
	rpoplpush source destination --移除列表的最后一个元素，并将该元素添加到另一个列表并返回

Push
	lpush key value [value2...] --将一个或多个值插入到列表头部
	lpushx key value --将一个值插入到已存在的列表头部
	rpush key value [value2...] --在列表中添加一个或多个值
	rpushx key value --为已存在的列表添加值
Get 
	lrange key start stop --获取列表指定范围内的元素
Set
	lset key index value --通过索引设置列表元素的值
	ltrim key start stop --对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除
Del
	lrem key count value --移除列表元素

-->Set
Set
	sadd key member [member2..] --向集合添加一个或多个成员
	smove source destination member --将 member 元素从 source 集合移动到 destination 集合
	srem key member [member2...] --移除集合中一个或多个成员

Get
	scard key --获取集合的成员数
	sdiff key [key2...] --返回给定所有集合的差集
	sdiffstore destination key [key2...] --返回给定所有集合的差集并存储在 destination 中
	sinter key [key2...] --返回给定所有集合的交集
	sinterstore destination key [key2...] --返回给定所有集合的交集并存储在 destination 中
	sismember key member --判断 member 元素是否是集合 key 的成员
	smembers key --返回集合中的所有成员
	spop key --移除并返回集合中的一个随机元素
	srandmember key[count] --返回集合中一个或多个随机数
	sunion key [key2] --返回所有给定集合的并集
	sunionstore destination key [key2..] --所有给定集合的并集存储在 destination 集合中
	SSCAN key cursor [MATCH pattern] [COUNT count] --迭代集合中的元素

-->Zset
Set
	ZADD key score1 member1 [score2 member2] --向有序集合添加一个或多个成员，或者更新已存在成员的分数
	ZCOUNT key min max --计算在有序集合中指定区间分数的成员数
	ZINCRBY key increment member --有序集合中对指定成员的分数加上增量 increment
	ZINTERSTORE destination numkeys key [key ...] --计算给定的一个或多个有序集的交集并将结果集存储在新的有序集合 key 中
	ZLEXCOUNT key min max --在有序集合中计算指定字典区间内成员数量
	ZREM key member [member ...] --移除有序集合中的一个或多个成员
	ZREMRANGEBYLEX key min max --移除有序集合中给定的字典区间的所有成员
	ZREMRANGEBYRANK key start stop --移除有序集合中给定的排名区间的所有成员
	ZREMRANGEBYSCORE key min max--移除有序集合中给定的分数区间的所有成员
	ZUNIONSTORE destination numkeys key [key ...] --计算给定的一个或多个有序集的并集，并存储在新的 key 中
	ZSCAN key cursor [MATCH pattern] [COUNT count] --迭代有序集合中的元素（包括元素成员和元素分值）
Get
	ZCARD key --获取有序集合的成员数
	ZRANGE key start stop [WITHSCORES] --通过索引区间返回有序集合指定区间内的成员
	ZRANGEBYLEX key min max [LIMIT offset count] --通过字典区间返回有序集合的成员
	ZRANGEBYSCORE key min max [WITHSCORES] [LIMIT]--通过分数返回有序集合指定区间内的成员
	ZRANK key member --返回有序集合中指定成员的索引
	ZREVRANGE key start stop [WITHSCORES] --返回有序集中指定区间内的成员，通过索引，分数从高到低
	ZREVRANGEBYSCORE key max min [WITHSCORES] --返回有序集中指定分数区间内的成员，分数从高到低排序
	ZREVRANK key member --返回有序集合中指定成员的排名，有序集成员按分数值递减(从大到小)排序
	ZSCORE key member --返回有序集中，成员的分数值

Redis 事务命令
	DISCARD --取消事务，放弃执行事务块内的所有命令。回滚事务.
	EXEC --执行所有事务块内的命令。
	MULTI --标记一个事务块的开始。
	UNWATCH --取消 WATCH 命令对所有 key 的监视。
	WATCH key [key ...] --监视一个(或多个) key ，如果在事务执行之前这个(或这些) key 被其他命令所改动，那么事务将被打断。


//TCP/IP
TCP/IP对比OSI参考模型：
	网络接入层 --> 物理层，数据链路层
	网际互联层 --> 网络层
	传输层 --> 传输层
	运用层 --> 会话层，表示层，应用层

IP协议是用来查找地址的，对应着网际互联层
TCP协议是用来规范传输规则的对应着传输层

TCP在传输之前会进行三次沟通，传完数据断开的时候要进行四次沟通
	seq：sequence number 所传数据的序号
	ack：acknoledgement number 确认号 
	ACK：确认位，只有ACK=1 的时候ack才起作用
	SYN：同步位，用于建立连接时同步序号
	FIN：终止位，用来在数据传输完毕后释放连接
TCP的传输是双全工模式
用于传输层的协议除了TCP还有UDP

//HTTP
HTTP协议是应用层的协议
HTTP中报文分为请求报文和响应报文，两种类型都包括三部分：
	首行:
		-->请求行：方法(请求类型),URL,HTTP 版本
		-->响应行：状态行(HTTP版本，状态码，简短原因)
	头部:保存一些键值对属性参数，用冒号“：”分割
	主体:保存具体内容
	
	请求报文主要保存POST类型的参数
	响应报文保存页面要显示的结果

	请求报文的主要方法：GET,HEAD,POST,PUT,DELETE
	响应报文中的状态码：
		1XX：信息性状态码
		2XX：成功状态码，如200表示成功
		3XX：重定向状态码，如301表示重定向
		4XX：客户端错误状态码，如404表示没有找到请求的资源
		5XX：服务端错误状态码，如500表示内部错误

// Socket
Java中的网络通讯是通过Socket实现的，Socket分为ServerSocket和Socket
	ServerSocket用于服务端，可以用通过accept方法监听请求，监听请求后返回Socket
	ServerSocket使用步骤：
		1，创建ServerSocket
		2，调用创建出来的ServerSocket的accept方法进行监听
		3，使用accept方法返回的Socket与客户端进行通讯
	TODO...


//Servlet
Servlet表示一个服务器应用
ServletConfig,Servlet
	-->GenericServlet
		 -->HttpServlet

Servlet接口：
	init():初始化，只调用一次
	getServletConfig():获取ServletConfig
	service():处理请求
	getServletInfo():获取Servlet相关信息
	destroy():用于Servlet销毁


//Tomcat
Tomcat中顶层容器叫Server，代表整个服务器，Server中至少包含一个Service，用于提供具体服务。

Service 
	Connector：用于处理连接相关，并提供Socket与request、response的转换
	Container：用于封装和管理Servlet，以及具体的request请求

Container的子容器是逐层包含的关系
	Engine：引擎，用来管理多个站点
	Host：虚拟主机，站点
	Context：应用程序，或者一个WEB-INF目录以及下面的 web.xml 文件
	Wrapper：封装着一个Servlet

Engine和Host的配置都在conf/server.xml文件中

//Mybatis
核心组件：
	SqlSessionFactoryBuilder : 构造器
	SqlSessionFactory : 工厂接口
	SqlSession  
	SQLMapper

public static SqlSessionFactory sqlSessionFactory ;
public static Reader reader;
try{
	reader = Resouces.getResourceAsReader("resourceXmlPath");
	sqlSessionFactory = SqlSessionFactoryBuilder.build(resource);

}catch( Exception e){
	e.printStackTrace();
}
SqlSession session = sqlSessionFactory.openSession();
User user = (User)session.selectOne();




























海量数据解决方案
	缓存和页面静态化
	数据库优化
		表结构优化
		SQL语句优化
		分区和分表
		索引优化
	分离活跃数据
	批量读取和延迟修改
	读写分离
	分布式数据库
	NoSQL和Hadoop

高并发解决方案
	应用和静态资源分离
	页面缓存
	集群与分布式
	反向代理
	CDN

DNS协议的作用是将域名解析为IP

















JAVA基础
SpringBoot
SpringMVC
MySQL 
事务的四个性质
	Atomicity 原子性: 要么全部成功，要么全部失败
	Consistency 一致性: 事务执行的成功或失败的状态是一致的
	Isolation 隔离性: 两个事务之间互不相干，不能互相影响
	Durability 持久性: 事务对数据的更改应该是持久的

事务隔离级别:
	ISOLATION_DEFAULT 默认 REPEATABLE可重读
	ISOLATION_READ_UNCOMMITTED  读未提交
	ISOLATION_READ_COMMITTED  读已提交
	ISOLATION_REPEATABLE_READ  可重读
	ISOLATION_SERIALIZABLE  可串行化

MyISAM
	不支持事务
	不支持行级锁，只支持表级锁
	不支持外键
	不支持崩溃后的安全恢复
	在表有关读取查询的同时，支持往表中插入新记录
	支持 BLOB 和 TEXT 的前500各字符索引
	支持全文索引
	支持储存总行数
	支持延迟更新索引，极大提升写入性能
	对不会进行修改的表，支持压缩表，极大较少磁盘空间占用
InnoDB
	支持事务
	支持行锁，表级锁，采用 MVCC 来支持高并发
	支持崩溃后的安全恢复
	支持外键
	不支持全文索引
	不支持总行数
		总的来说，MyISAM 适合 SELECT 密集型的表，
		而 InnoDB 适合 INSERT 和 UPDATE 密集型的表


MySQL索引使用的数据结构主要有B+Tree和哈希索引

数据库优化
	字段:
		VARCHAR的长度只分配真正需要的空间
		单表不要有太多的字段
		避免使用NULL
		尽量使用TIMESTAMP而非DATETIME
		使用枚举或整数代替字符串类型 ??
		用整形来存IP
	索引:
		索引不是越多越好，要根据查询有针对性的创建
		尽量避免在WHERE字句中对字段进行NULL判断
		值分布很稀少的字段不适合键索引
		字符字段只键前缀索引
		不用外键，由程序保证约束
		尽量不用UNIQUE
		使用多列索引是注意顺序和查询条件保持一致，同时删除不必要的索引
	查询SQL:
		可通过开启慢查询日志来找出较慢的SQL: 
			set global slow_query_log = on
		不做列运算
		sql语句要尽量简单，大语句拆分成小语句，减少锁时间
		不用SELECT *
		OR 改成 IN ，IN的个数控制在200以内
		不用函数和触发器，在应用程序实现
		避免 %xx 式查询
		少用JOIN
		使用同类型比较
		尽量避免在WHERE字句中使用 != 或 <> 
		对连续数值，使用 BETWEEN 不用 IN
		列表数据不要拿全表，要使用 LIMIT 分页，每页数量也不要太大

数据库三范式
	1NF, 第一范式
		字段不能再分，就满足第一范式。
	2NF, 第二范式
		满足第一范式的前提下，不能出现部分依赖。
		消除复合主键就可以避免部分依赖。增加单列关键字。
	3NF, 第三范式
		满足第二范式的前提下，不能出现传递依赖。
		某个字段依赖于主键，而有其他字段依赖于该字段。这就是传递依赖。
		将一个实体信息的数据放在一个表内实现。

五种类型及常用命令：
	String：set/get/decr/incr/mget
	Hash: hget/hset/hgetall
	List: lpush/rpush/lpop/rpop/lrange
	Set: sadd/spop/smembers/sunion
	SortSet: zadd/zrange/zrem/zcard

有哪些类型的通知（Advice）？
 Before - 这些类型的 Advice 在 joinpoint 方法之前执行，并使用
@Before 注解标记进行配置。
 After Returning - 这些类型的 Advice 在连接点方法正常执行后执
行，并使用@AfterReturning 注解标记进行配置。
 After Throwing - 这些类型的 Advice 仅在 joinpoint 方法通过抛出
异常退出并使用 @AfterThrowing 注解标记配置时执行。
 After (finally) - 这些类型的 Advice 在连接点方法之后执行，无论方
法退出是正常还是异常返回，并使用 @After 注解标记进行配置。
 Around - 这些类型的 Advice 在连接点之前和之后执行，并使用
@Around 注解标记进行配置。

数据库 SQL 开发规范
	1. 建议使用预编译语句进行数据库操作
	2. 避免数据类型的隐式转换
	3. 充分利用表上已经存在的索引
	4. 数据库设计时，应该要对以后扩展进行考虑
	5. 程序连接不同的数据库使用不同的账号，禁止跨库查询
	6. 禁止使用 SELECT * 必须使用 SELECT <字段列表> 查询
	7. 禁止使用不含字段列表的 INSERT 语句
	8. 避免使用子查询，可以把子查询优化为 join 操作
	9. 避免使用 JOIN 关联太多的表
	10. 减少同数据库的交互次数
	11. 对应同一列进行 or 判断时，使用 in 代替 or
	12. 禁止使用 order by rand() 进行随机排序
	13. WHERE 从句中禁止对列进行函数转换和计算
	14. 在明显不会有重复值时使用 UNION ALL 而不是 UNION
	15. 拆分复杂的大 SQL 为多个小 SQL

分表 
	MyCat 端口 8066
	mybatis的插件【shardbatis2.0】


//多线程
进程与线程
	进程是操作系统分配资源的最小单元，线程是操作系统调度的最小单元
	一个程序至少有一个进程，一个进程至少有一个线程


死锁：指两个或者两个以上的进程(或线程)在执行的过程中，因争夺资源而造成相互等待的现象，
	若无外力作用，他们都将无法推进下去。
死锁产生的条件：
	互斥条件：进程在某一时间内独占资源
	请求与保持条件：一个进程因请求资源而阻塞时，对已获得资源保持不放
	不剥夺条件：进程已获得资源，在未使用完之前，不能强行剥夺
	循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系

活锁：任务或者执行者没有被阻塞，由于某些条件没有满足，导致一直重复尝试--失败--尝试


FileReader fr = null;

try{
	char[] buf = new char[1024];
	int len = 0;
	fr = new FileReader("path.file");
	while(len=(fr.reader(buf)) != -1){
		System.out.println(new String(buf,0,len));
	}
}catch(IOException e)｛
	e.printStackTrace();
｝finally{
	if(fr != null){
		try{
			fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
 
 FileWriter fw = null;
 try{
 	fw = new FileWriter("file.txt");
 	fw.write("String text");
 }catch(IOException e){
 	e.printStackTrace();
 }finally{
 	if (fw != null) {
 		try{
 			fw.close();
 		}catct(IOException e){
 			e.printStackTrace();
 		}
 	}
 }


//对象序列化
 ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.text"));
 Person p = new Person("zhangsan",25);
 oos.writeObject(p);
 oos.flush();
 oos.close();
 //反系列化
ObjectInputStream ois = new  ObjectInputStream(new FileInputStream("file.txt"));
Person p = (Person)ois.readObject();
System.out.println(p.toString());
ois.close();


//BIO read
File file =  new File("file.txt");
InputStream input = new FileInputStream(file);
byte[] buf = new byte[1024];
int len;
StringBuilder sb = new StringBuilder();
while((len=input.read(buf)) != -1){
	sb.append(new String(buf,0,len,"UTF_8"));
}
in.close();

//BIO write
File file = new File("file.txt");
OutputStream output = new FileOutputStream(file);
String str = "data>..";
output.write(str);
output.close();

//NIO write
File file = new File("file.txt");
FileOutputStream outStream = new FileOutputStream(file);
FileChannel channel = outStream.getChannel();
ByteBuffer buffer = ByteBuffer.allocate(1024);
String string = "java nio";
buffer.put(string.getBytes());
buffer.flip();
channel.write(buffer);
channel.close();
outStream.close();

############################

//nio 分片操作
//创建一个长度为10的ByteBuffer
ByteBuffer buffer = ByteBuffer.allocate(10);
//使用数据来填充这个缓冲区
for (int i=0; i<buffer.capacity(); ++i){
	buffer.put((byte)i);
}
//对缓冲区进行分片以创建一个包含3-6的子缓冲区
buffer.position(3);
buffer.limit(7);
ByteBuffer sliceBuffer = buffer.slice();
//历遍子缓冲区，将每个元素乘以11以改变它
for(int i=0;i<sliceBuffer.capacity();++i){
	byte b = sliceBuffer.get(i);
	b *= 11;
	sliceBuffer.put(i,b);
}
//查看缓冲区的内容
buffer.position(0);
buffer.limit(buffer.capacity());
while(buffer.remaining() > 0){
	System.out.print(buffer.get()+“ ”);
}

//输出结果：只有字缓冲区的数据被更改
0 1 2 33 44 55 66 7 8 9

//nio channel and buffer
RandomAccessFile aFile = new RandomAccessFile("data_file.txt","rw");
FileChannel inChannel = aFile.getChannel();
ByteBuffer buf = ByteBuffer.allocate(48);
int bytesRead = inChannel.read(buf);
while(bytesRead != -1){
	System.out.println("Read : "+bytesRead);
	buf.flip();
	while(buf.hasRemaining()){
		System.out.println((char) buf.get());
	}
	buf.clear();
	bytesRead = inChannel.read(buf);
}
aFile.close();

//NIO Channel transferFrom() ,transferTo()
RandomAccessFile fromFile = new RandomAccessFile("src_data_file.txt","rw");
FileChannel fromChannel = fromFile.getChannel();
RandomAccessFile toFile = new RandomAccessFile("des_data_file.txt","rw");
FileChannel toChannel = toFile.getChannel();
long position = 0;
long count = fromChannel.size();
//toChannel.transferFrom(position,count,fromChannel);
fromChannel.transferTo(position,count,toChannel);

//NIO Selector
//第一步：创建Selector
Selector selector = Selector.open();
//第二步：向Selector注册通道
channel.configureBlocking(false);
SelectionKey key = channel.register(selector,Selector.OP_READ);
while(true){
	int readChannels = selector.select();
	if(readChannels == 0) 
		continue;
	Set selectedKeys = selector.selectedKeys();
	Iterator keyIterator = selectedKeys.iterator();
	while(keyIterator.hasNext()){
		SelectionKey key = keyIterator.next();
		if (key.isAcceptable()) {
			// a connection was accepted by a ServerSocketChannel.
		}else if (key.isConnectable()) {
			// a connection was established with a remote server.
		}else if (key.isReadable()) {
			// a channel is ready for reading
		}else if (key.isWriteable()) {
			// a channel is ready for writing
		}
		keyIterator.remove();
	}
}

############################
//Socket通讯示例
//SocketServer服务器端
int port = 5533;
ServerSocket server = new ServerSocket(port);
Socket socket = server.accept();
InputStream input = socket.getInputStream();
byte[] bytes = new byte[1024];
int len;
StringBuilder sb = new StringBuilder();
while((len=input.read(bytes)) != -1){
	sb.append(new String(bytes,0,len,"UTF-8"));
}
Syttem.out.println("get message from client: "+sb);

OutputStream output = socket.getOutputStream();
output.write("Hello Client,I get the message.".getBytes("UTF_8"));

input.close();
output.close();
socket.close();
server.close();

//SocketClient客户端
String host = "127.0.0.1";
int port = 5533;
//与服务器端建立连接
Socket socket = new Socket(host,post);
OutputStream output = socket.getOutputStream();
String message = "Hello !";
socket.getOutputStream().write(message.getBytes("UTF_8"));

InputStream input = socket.getInputStream();
byte[] bytes = new byte[1024];
int len;
StringBuilder sb = new StringBuilder();
while((len=input.read(bytes)) != -1){
	sb.append(new String(bytes,0,len,"UTF_8"));
}
System.out.println("get the message from server: "+sb);

input.close();
output.close();
socket.close();


##########################

//Map的历遍
Map map = new HashMap();
map.put("key1","value1");
map.put("key2","value2");
……
//KeySet()历遍(需两次)
Iterator it = map.keySet().iterator();
while(it.hasNext()){
	Object key = it.next();
	System.out.println(map.get(key));
}
//entrySet()历遍 (推荐)
Interator it = map.entrySet().iterator();
while(it.hasNext()){
	Entry e = (Entry)it.next();
	System.out.println("键："+e.getKey()+" 值："+e.getValue());

}


//JUC lock
class Dept{
	private int capacity;
	private int size;
	private Lock lock;
	private Condition fullCondition;
	private Condition emptyCondition;

	public Dept(int capacity){
		this.capacity = capacity;
		this.size = 0;
		this.lock = new ReentronLock();
		this.fullCondition = lock.newCondition();
		this.emptyCondition = lock.newCondition();
	}

	public void produce(int val){
		lock.lock();
		try{
			int left = val;
			while(left > 0){
				while(size >= capacity)
					fullCondition.await();
				int inc = (left+size)>capacity ? (capacity-size) : left;
				size += inc;
				left -= inc;
				System.out.printf("%s produce (%3d) --> left=%3d,inc=%3d,size=%3d",
					Thread.currentThread().getName(),val,val,inc,size);
				emptyCondition.signal();
			}
		}catch(InterruptedException e){

		}finally{
			lock.unlock();
		}
	}

	public void consume(int val){
		lock.lock();
		try{
			int left = val;
			while(left > 0){
				while(size <= 0)
					emptyCondition.await();
				des = (size<left) ? size : left;
				size -= des;
				left -= des;
				System.out.printf("%s consume (%3d) <-- left=%3d,dec=%3d,size=%3d",
					Thread.currentThread().getName(),val,left,dec,size);
				fullCondition.signal();
			}
		}catch(InterruptedException e){

		}finally{
			lock.unlock();
		}
	}

	public String toString(){
		return "capacity:"+capacity+",actual size:"+size;
	}

class Producer{
	private Dept dept;
	public Producer(Dept dept){
		this.dept = dept;
	}
	public void produce(final int val){
		new Thread(){
			public void run(){
				dept.produce(val);
			}
		}.start();
	}
}

calss Customer{
	private Dept dept;
	public Customer(Dept dept){
		this.dept = dept;
	}
	public void customer(final int val){
		new Thread(){
			public void run(){
				dept.customer(val);
			}
		}.start();
	}
}

public static void main(String[] args){
	Dept mDept = new Dept(100);
	Producer mPro = new Producer(mDept);
	Customer mCus = new Customer(mDept);

	mPro.produce(60);
	mPro.produce(120);
	mCus.sonsume(90);
	mCus.consume(150);
	mPro.produce(110);
}
}


//线程池
Executor 
	--> ExecutorService <-- Executors
		--> AbstractExecutorService | ScheduledExecutorService --> ScheduledThreadPoolExecutor
			-->ThreadPoolExecutor

// 线程池状态
Running --> Shutdown --> Stop --> Tidying --> Terminated

//深复制
public class CloneUtils{
	@SupperessWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj){
		T cloneObj = null;
		try{
			//系列化
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();

			//反系列化
			ByteArrayInputStream bais = new ByteArrayInputStream();
			ObjectInputStream ois = new ObjectInputStream(bais);
			cloneObj = (T)ois.readObject();
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return cloneObj;
	}
}

//统计字符串在文件中出现的次数
public final class CountWordsInFile{
	private CountWordsInFile(){
		throw new AssertionError();
	}

	public static int countWordsInFile(String fileName,String words){
		int counter = 0;
		try(FileReader fr = new FileReader(fileName)){
			try(BufferedReader br = new BufferedReader(fr)){
				String line = null;
				while((line = br.readLine()) != null){
					int index = -1;
					while(line.length() >= word.length() && 
						(index = line.indexOf(word)) >=0){
						counter++;
						line = line.substring(index+word.length());
					}
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return counter;
	}
}


//列出一个文件中的所有文件名
public void listFiles(String srcPath){
	File f = new File(srcPath);
	for(File temp : f.listFiles()){
		if(temp.isFile()){
			System.out.println(temp.getName());
		}
	}
}

//冒泡排序
public class BubbleSort implements IArraySort{
	public int[] sort(int[] sourceArray) throws Exception{
		int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
		for(int i=1;i<arr.length;i++){
			boolean flag = true;
			for(int j=0;j<arr.length-i;j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;

					flag = flase;
				}
			}
			if(flag){
				break;
			}
		}
		return arr;

	}
}

public class BubbleSort{
	public <T extends Comparable<T>> void sort(T[] list){
		boolean swapped = true;
		for(int i,len=list.length;i<len&&swpped;++i){
			swapped = false;
			for(int j=0;j<len-i;++j){
				if(list[j].compareTo(list[j+1])){
					T temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					swapped = true;
				}
			}
		}
	}
}

//选择排序
public class SelectSort{
	public int[] sort(int[] sourceArray){
		int[] arr = Arrays.copyOf(sourceArray,sourceArray.length);
		for(int i = 0;i<arr.length-1;i++){
			int min = i ;
			for(int j = i+1;j<arr.length;j++){
				if(arr[j]<arr[min]){
					min = j;
				}
			}
			if(i != min){
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		return arr;
	}
}

//插入排序
public class InsertSort {
	public int[] sort(int[] sourceArray){
		int arr[] = Arrays.copyOf(sourceArray,sourceAray.length);

		for(int i = 1;i<arr.length;i++){
			int temp = arr[i];
			int j = i;
			while(j>0 && temp<arr[j-1]){
				arr[j] = arr[j-1];
				j--;
			}
			if(j != i){
				arr[j] = temp;
			}
		}
		return arr;
	}
}

//循环实现二分查找


//Mybatis
public static SqlSessionFactory sqlSessionFactory ;
public static Reader reader;
try{
	reader = Resouces.getResourceAsReader("resourceXmlPath");
	sqlSessionFactory = SqlSessionFactoryBuilder.build(resource);

}catch( Exception e){
	e.printStackTrace();
}
SqlSession session = sqlSessionFactory.openSession();
User user = (User)session.selectOne();

Mybatis执行顺序：应用程序-->mybatis-config.xml
	-->sqlSessionFactory=new SqlSessionFactoryBuilder.build(inputStream)
	-->sqlSession=sqlSessionFactory.openSession()
	-->sqlSession.getMapper()
Mybatis xml标签：
ResultMap/parameterMap/sql/selectKey/include
动态标签：when/set/trim/where/if/choose/foreach/otherwise/bind

//Redis
五种类型及常用命令：
	String：set/get/decr/incr/mget
	Hash: hget/hset/hgetall
	List: lpush/rpush/lpop/rpop/lrange
	Set: sadd/spop/smembers/sunion
	SortSet: zadd/zrange/zrem/zcard

Redis 几种数据淘汰策略
	noeviction:返回错误当内存限制达到，并且客户端尝试执行会让更多内存被使用的命令。
	allkeys-lru: 尝试回收最少使用的键（ LRU），使得新添加的数据有空间存放。
	volatile-lru: 尝试回收最少使用的键（ LRU），但仅限于在过期集合的键,使得新添加的数据有空间存
放。
	allkeys-random: 回收随机的键使得新添加的数据有空间存放。
	volatile-random: 回收随机的键使得新添加的数据有空间存放，但仅限于在过期集合的键。
	volatile-ttl: 回收在过期集合的键，并且优先回收存活时间（ TTL）较短的键,使得新添加的数据有空间
存放.

redis使用场景
	会话缓存
	全页缓存
	队列
	排行榜/计数器
	发布/订阅


//Spring
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
自动扫描注解两种方式：
	1.配置文件加入 <context:component-scan base-package=""/>
	2.在applicationContext.xml中声明 <context:component-scan.../>
@Commponent 组件，没有明确角色（都可以用）
@Service 在业务逻辑层使用
@Repository 在数据访问层使用
@Controller 在控制层使用 

基于注解的自动装配的三种方式： 
	1.在Bean标签内加入autowire属性
	2.在Bean配置文件中加入<context:annotation-config/>配置
	3.在Bean配置文件中配置AutowiredAnnotationBeanPostProcessor bean 
@Autowired 该注解为byType类型
@Qualifier 该注解为byName类型


<context:component-scan/>已包含<context:annotation-config/>的全部功能

Spring 5种标准事件：
	ContextStartedEvent 上下文开始事件
	ContextRefreshEvent 上下文属性更新事件
	ContextStoppedEvent 上下文停止事件
	ContextClosedEvent 上下文关闭事件
	RequestHandledEvent 请求处理事件
	也可以继承ApplicationEvent类来自定义事件

IOC 控制反转： 将成员变量赋值的控制权从代码中反转（转移）到配置文件中来进行赋值
			  把对象的创建、初始化、销毁交给 spring 来管理，而不是由开发者控制，实现控制反转

DI 依赖注入：当依赖某个对象时，可以把它作为成员变量	
Bean的作用域 Scope 值：singleton 单例 整个应用中只创建一个Bean实例
		    Prototype 原型 每次注入或通过Spring应用上下文获取的时候都会创建一个新的Bean实例
		    Session 会话  在web应用中，为每个Session会话创建一个Bean实例
		    Request 请求 在web应用中，为每个请求创建一个Bean实例

@Required 注解的 bean 属性是否被正确的设置了
带有@Autowired 注解的构造方法意味着在创建一个 bean 时将会被自动装配
@Qualifier 注解意味着可以在被标注 bean 的字段上可以自动装配。


AOP 面向切面编程 该思想是考虑改善程序结构，是对OOP面向对象编程的一个补充，
				AOP重点关注的是切面，OOP重点关注的是类

Spring AOP可以做的事
	日志记录，性能统计，安全控制，异常处理，数据库事务处理

AOP通知类型Advice
	@Before 在连接点方法之前执行
	@AfterReturning 在连接点方法执行之后执行
	@AfterThrowing 在连接点抛出异常之后执行
	@After 在连接点方法之后执行 
	@Around 在连接点之前和之后执行

Spring框架的好处
	轻量级
	控制反转，实现松耦合
	面向切面编程AOP，把应用业务逻辑和系统服务分开
	容器，管理应用对象的生命周期和配置
	MVC框架
	事务管理
	异常处理

数据库事务的特性（ACID）：
	Atomicity 原子性
	Consistency 一致性
	Isolation 隔离性
	Durability 持久性

Spring事务的规则（【传播行为（七种）】、【隔离级别（五种）】）、【只读属性】、
			【超时属性】、【不影响提交的异常】、【导致回滚的异常】）
传播行为是唯一必须设置的属性，其他都可以忽略，Spring为我们提供了合理的默认值。
Spring事务传播行为 ：
		PROPAGATION_MANDATORY 如果没有，就抛出异常；如果有，就使用当前事务
		PROPAGATION_NEVER 如果没有，就以非事务方式执行；如果有，就抛出异常
		PROPAGATION_SUPPORTS 如果没有，就以非事务方式执行；如果有，就使用当前事务
		PROPAGATION_NOT_SUPPORTED 如果没有，就以非事务方式执行；如果有，就将当前事务挂起
		PROPAGATION_NESTED 如果没有，就新建一个事务；如果有，就在当前事务嵌套其它事务
		PROPAGATION_REQUIRED 如果没有，就新建一个事务；如果有，就加入当前事务
		PROPAGATION_REQUIRES_NEW 如果没有，就新建一个事务；如果有，就将当前事务挂起且只直到新的事务提交或者回滚才恢复执行。
								意思就是创建了一个新事务，它和原来的事务没有任何关系了。
		
Spring事务隔离级别：
		ISOLATION_DEFAULT 默认
		ISOLATION_READ_COMMITTED  读未提交内容
		ISOLATION_READ_UNCOMMITTED  读取提交内容
		ISOLATION_REPEATABLE_READ  可重读
		ISOLATION_SERIALIZABLE  可串行化

事务回滚规则：默认回滚RuntimeException异常，而Checked Exception异常不回滚，
		捕获异常不抛出也不会回滚，但可以强制事务回滚：TransactionAspectSupport.currentTransactionStatus().isRollbackOnly();

事务的配置方式：
	注解元数据驱动的声明式事务 @Transactional
	XML元数据驱动的声明式事务



OSI参考模型 ：(应用层、表示层、会话层)、传输层、网络层、(数据链路层、物理层)
TCP/IP 模型 ： 应用层、传输层、网际互连层、网络接入层

数据库优化： 表结构优化，SQL语句优化，分区、分表、索引优化、使用存储过程代替直接操作
			分离活跃数据、批量读取和延迟修改、读写分离、分布式数据库、NoSQL和Hadoop

高并发解决方案： 应用和静态资源分离、页面缓存、集群与分布式、方向代理、CDN

DNS协议的作用是将域名解析为IP 
	nslookup命令来查看DNS解析结果 如： nslookup www.baidu.com 

IP协议是用来查找地址的，对应网际互连层

TCP协议是用来规范传输规则的，对应传输层

TCP在传输之前会进行三次沟通，传完数据断开的时候要进行四次沟通，俗称三次握手四次挥手

TCP传输的两个序号三个标志位
	seq:sequence number 所传数据的序号
	ack:acknoledgement number 确认号
	ACK:确认位，只有ACK=1时ack才起作用。正常通讯时ACK为1，第一次法强请求时没有需要确认接收的数据所以ACK为0
	SYN:同步位，用于在简历连接时同步序号，SYN在前两次握手时都为1，这是因为通讯双方的ack都需要设置一个初始值
	FIN：终止位，用来在数据传输完毕后释放连接

三次握手中前两次可以保证服务端可以正确接收并返回请求，后两次保证客服端可以正确接收并返回请求
四次挥手就是双方分别发送FIN标值来关闭连接并让对方确认
三次握手和四次挥手保证了连接的可靠性，缺点是在传输效率上会比较低
	并且在三次握手时需要客服端发送两次数据才可以建立连接，这种特性可能会被利用带来不安全性
	DDOS攻击中的SYN Flood攻击
	解决方案就是设置第二次请请求的次数

UDP单向传输，传输速度更快，不安全

HTTP是在应用层解析内容

HTTP报文分为请求报文和响应报文 request message,response message
	报文结构分为三部分：
		首行:
			request message:请求行<方法（请求类型），URL，HTTP版本>
			response message:状态行<HTTP版本，状态码，简短原因(可有可无)>
		头部:保存一些关键键值对属性，用 “：”分割
		主体:保存具体内容
			request message:主要保存POST类型参数
			response message:保存页面要显示的结果
	首行，头部和主体以及头部的各项内容用回车换行(\r\n)分割，头部和主体之间多一个空行

请求报文的方法：GET,POST,HEAD,PUT,DELETE等
响应报文中的状态码:
	1XX:信息性状态码
	2XX:成功状态码，200表示成功
	3XX:重定向状态码，301表示重定向
	4XX:客服端错误状态妈，404表示没找到请求资源
	5XX:服务端错误站台吗，500表示内部错误

Servlet作用是对接收到的数据进行处理并生成要返回给客户端的结果

HttpServlet-->GenericServlet-->{Servlet,ServletConfig}

Servlet接口：init(),getServletConfig(),service(),
			getServletInfo(),destroy()

Servlet接口：getServletName(),getServletContext(),
			getInitParameter(String name),getInitParameterNames()

GenericServlet是Servlet默认实现：
	1.实现ServletConfig接口
	2.提供无参init方法
	3.提供两个log方法，一个记录日志，一个记录异常，具体实现是给ServletContext的日志实现的


//Tomcat
Tomcat顶层容器-->Server 代表整个服务器
	-->Connector:处理连接相关的事情，并提供Socket与request，response的转换
		Container:用于封装和管理Servlet
Server由Catalina管理，load，start，stop来管理整个服务器的生命周期

Container的四个子容器是逐层包含的：
	Engine:引擎，最顶层，用来管理站点，一个Server最多只能有一个Engine
	Host: 站点，每个host代表一个虚拟主机
	Context: 应用程序，对应开发的一个程序，或一个WEB-INF目录以及下面的web.xml文件
	Wrapper:每个Wrapper封装一个Servlet
Engine和Host的配置都在conf/server.xml 文件中


//SpringMVC
<mvc:annotation-driven/> 自动注册组件
<context:component-scan base-package=""/> 扫描通过注释配置的包或类

DispatcherServlet : 作用是初始化自身的九个组件，doServer给request设置属性并将请求交给doDispatch()
-->FrameworkServlet :作用是初始化WebApplicationContext,将不同类型的请求合并到processRequest()统一处理
	-->{
		ApplicationContextAware-->Aware,
		HttpServletBean : 作用是将Servlet中的配置设置到相应的属性，并没有参与实际的请求处理
			-->{	
				HttpServlet-->GenericServlet-->{Servlet,ServletConfig}
				EnvironmentCapable--Aware
				EnvironmentAware-->Aware
			}
		} 

DispatcherServlet入口方法是doServer()转交给doDispatch()进行具体处理
doServer()：对request设置属性，如果是include请求还会对request当前属性做快照备份，
			并在处理结束后恢复，最后将请求转发给doDispatch()
doDispatch()核心任务：
	1.根据request找到Handler
	2.根据Handler找到对应的HandlerAdaoter
	3.用HandlerAdapter处理Handler
	4.调用processDispatchResult处理前三步处理之后的结果(包含找到View并渲染输出给用户)

使用HandlerMapping找到Handler，找到使用Handler的HandlerAdapter，
让HandlerAdapter使用Handler，最后通过View展示数据

Handler:处理器

HandlerMapping: url与控制权的映射
	根据request找到相应的处理器Handler和Interceptors
	接口只有一个方法：getHandler(HttpServletRequest request) throws Exception
	返回HandlerExcutionChain

HandlerAdapter:适配器
	supports()判断是否可以使用某个Handler
	handler()具体使用Handler
	getLastModified（）获取资源的Last-Modified
其实现类RequestMappingHandlerAdapter:解析参数，执行请求，处理返回值

View:用来展示数据
VrewResolver:用来查找View

HandlerExceptionResolver 异常解析组件

MultipartResolver 处理上传请求，将上传请求包装成可以直接获取File的Request

HandlerInterceptor:拦截器

LocaleResolover 使用request解析出Locale

ThemeResolver 根据request解析Theme

swagger 文档接口编写

//Windows服务
启动MySQL
	net start mysql 
创建Windows服务
	sc create mysql binPath = mysqlId_bin_path
连接与断开服务
	mysql -h 地址 -P 端口 -u 用户名 -p 密码

//数据库操作
查看当前数据库
	SELECT DATABASE();
显示当前时间，用户名，数据库版本
	SELECT NOW(),USER(),VERSION();
创建库
	CREATE DATABASE [IF NOT EXISTS] 数据库名称 数据库选项；
	数据库选项：
		CHARACTER SET charset_name
		COLLATE collation_name
查看已有库
	SHOW DATABASE;
查看当前库信息
	SHOW CREATE DATABASE 数据库名；
查看修改库的选项信息
	ALTER DATABASE 库名 选项信息
删除库
	DROP DATABASE [ IF EXISTS ]数据库名

//表操作
创建表
	CREATE TABLE [ IF NOT EXISTS ] [库名.]表名 (表结构定义) [表选项] 
	-->CREATE TABLE [ IF NOT EXISTS ] yiibaidb.test (
		id INT(10) NOT NULL AUTO_INCREAMENT,
		name VARCHAR(30) NOT NULL DEFAULT "abc" COMMENT="注释",
		age TINYINT(2) NOT NULL DAFAULT 0 COMMENT="注释"，
		PRIMARY KEY (id)
		)ENGINES = InnoDb CHARSET = utf8;
查看所有表
	SHOW TABLES [ LIKE ‘pattern’];
	SHOW TABLES FROM 库名；
查看表结构
	SHOW CREATE TABLE 表名；-->创建时的语句
	DESC 表名；
	DESCRIBE 表名；
	EXPLAIN 表名；
	SHOW CREATE TABLE 表名；
修改表
	修改表本身的选项
		ALTER TABLE 表名 表选项
		-->ALTER TABLE 表名 ENGINE=MYSIAM;
	对表进行重命名
		RENAME TABLE 原表名 TO 新表名
		RENAME TABLE 原表名 TO 库名.表名 (可将表移动到另一个数据库)
	修改表字段结构
		ALTER TABLE 表名 操作名
		-->操作名
			ADD [ COLUMN ] 字段定义  --增加字段
				AFTER 字段名
				FIRST	--表示增加在第一个
			ADD PRIMARY KEY(字段名)	--创建主键
			ADD UNIQUE [索引名] (字段名)	--创建唯一索引
			ADD INDEX [索引名] (字段名)	--创建普通索引
			DROP [ CLUMN ] 字段名	 --删除字段
			MODIFY [ COLUMN ] 字段名	字段属性		--支持对字段属性修改
			CHANG [ COLUNM ] 原字段名 新字段名 字段属性 	--对字段名修改
			DROP PRIMARY KEY	--删除主键(删除主键前需要删除其AUTO_INCREMENT属性)
			DROP INDEX 索引名	--删除索引
			DROP FOREIGN KEY	--删除外键
删除表
	DROP TABLE [ IF EXISTS ] 表名
清空表结构
	TRUNCATE [ TABLE ] 表名
复制表结构
	CREATE TABLE 表名 LIKE 要复制的表名
复制表结构和数据
	CREATE TABLE 表名 [ AS ] SELECT * FROM 要复制的表名
检查表是否有错误
	CHECK TABLE tbl_name [, tbl_name ] ... [option] ...
优化表
	OPTMIZE [ LOCAL | NO_WRITE_TO_BINLOG ] TABLE 
修复表
	REPAIR [ LOCAL | NO_WRITE_TO_BINLOG ] TABLE tbl_name [, tbl_name ] ...[ QUICK ]
分析表
	ANALYZE [LOCAL | NO_WRITE_TO_BINLOG] TABLE tbl_name [, tbl_name] ...

//数据库操作
增
	INSERT [INTO] 表名 [(字段列表)] VALUES (值列表)[, (值列表), ...]
		-- 如果要插入的值列表包含所有字段并且顺序一致，则可以省略字段列表。
		-- 可同时插入多条数据记录！
		REPLACE 与 INSERT 完全一样，可互换。
		INSERT [INTO] 表名 SET 字段名=值[, 字段名=值, ...]
查
	SELECT 字段列表 FROM 表名[ 其他子句]
		-- 可来自多个表的多个字段
		-- 其他子句可以不使用
		-- 字段列表可以用*代替，表示所有字段
删
	DELETE FROM 表名[ 删除条件子句]
	没有条件子句，则会删除全部
改
	UPDATE 表名 SET 字段名=新值[, 字段名=新值] [更新条件]
constrant foreign reference

--1NF, 第一范式
	字段不能再分，就满足第一范式。
-- 2NF, 第二范式
	满足第一范式的前提下，不能出现部分依赖。
	消除复合主键就可以避免部分依赖。增加单列关键字。
-- 3NF, 第三范式
	满足第二范式的前提下，不能出现传递依赖。
	某个字段依赖于主键，而有其他字段依赖于该字段。这就是传递依赖。
	将一个实体信息的数据放在一个表内实现
	
定义：
	主键–唯一标识一条记录，不能有重复的，不允许为空
	外键–表的外键是另一表的主键, 外键可以有重复的, 可以是空值
	索引–该字段没有重复值，但可以有一个空值
作用：
	主键–用来保证数据完整性
	外键–用来和其他表建立联系用的
	索引–是提高查询排序的速度
个数：
	主键–主键只能有一个
	外键–一个表可以有多个外键
	索引–一个表可以有多个唯一索引

数据库优化：
	表设计优化：
		选择合适的表引擎，查询多而增删改较少用MyISAM，增删改多用InnoDB
		表字段不易过多
		数据库和表字符集要统一
		每个InnoDB表都应设置一个自增主键
		表字段都要为 NOT NULL
		
	SQL优化：
		使用 EXPLAIN 来查看SQL执行计划
		SELECT 语句中 IN 包含的值不宜过多
		SELECT 查询语句尽指明具体字段，避免使用 SELECT * 查询
		如果查询结果只有一条或者只要最大/最小一条记录，可使用 LIMIT 1 限制查询结果集
		避免在 WHERE 字句中使用 OR 来连接条件
		避免在 WHERE 字句中对字段进行表达式操作，这将导致系统放弃使用索引而进行全表扫描
		LEFT JOIN 查询左表结果应尽可能的小
		如果已知结果中没有重复记录，可使用 UNION ALL 代替 UNION 
		不使用 ORDER BY RAND()，
		不建议使用 % 前缀的模糊查询，可创建全文索引来满足相应的查询
		
	索引：
		一张表的索引不宜过多，一般不超过5个

EXPLAIN :
type列，连接类型。一个好的SQL语句至少要达到range级别。杜绝出现all级别。
key列，使用到的索引名。如果没有选择索引，值是NULL。可以采取强制索引方式。
key_len列，索引长度。
rows列，扫描行数。该值是个预估值。
extra列，详细说明。注意，常见的不太友好的值，如下：Using filesort，Using temporary。



Git

git init -->初始化 git目录

git config --global user.name -->设置全局用户名
git config --global user.email -->设置全局邮箱
git add <file> -->将file添加到Stage暂存区
git commit -m "message" -->将暂存区提交到repository仓库
		-m -->添加备注
git status -->查看仓库当前状态
git diff <file> -->对比工作区和暂存区里file的改动内容
git log -->查看完整提交日志
git log --pretty=oneline -->简化查看提交日志
git reset --hard HEAD^ -->回退到上一个提交的版本
git reset --hard <commit id> -->回退到指定版本号的版本
git reflog -->查看命令历史
git diff HEAD --<file> -->查看工作区和版本库里最新版本的区别
git checkout --<file> -->撤销工作区的修改,
				<用版本库里的版本替换工作区的版本，无论工作区是修改还是删除，都可以“一键还原”>
git rm <file> -->从版本库中删除文件 

git remote add origin git@server-name:path/repo-name.git -->关联一个远程库
git push -u origin master -->第一次推送master分支的所有内容
		git push -->将当前分支推送到远程
		-u 参数 -->将本地分支和远程分支关联起来
git push origin master -->推送最新修改
git clone git@server-name:path/repo-name.git -->从远程克隆一份仓库到本地
git remote -->查看远程库的信息
git remote -v -->查看更详细远程库的信息

git branch dev -->创建dev分支
git checkout dev -->切换到dev分支
git checkout -b dev -->创建dev分支并切换到该分支上
	git switch -c dev -->创建dev分支并切换到该分支上<新版本2.23以后git才支持该命令>
	git switch dev -->切换到dev分支<新版本2.23以后git才支持该命令>
git branch -->列出所有分支，并查看当前分支*
git merge dev -->将dev分支合并到当前分支,以Fast-forward快进方式合并
		Fast forward模式合并，在这种模式下，删除分支后，会丢掉分支信息
git merge --no-ff -m "message" dev -->禁用Fast-forward模式的合并
		--no-ff -->禁用Fast-forward
git branch -d dev -->删除dev分支
git log --graph -->查看分支合并图
git branch -D dev -->强制删除dev分支<丢弃一个没有被合并过的分支>

git stash -->将当前分支工作现场冻藏起来
git stash list -->查看当前分支工作现场列表
git stash apply -->恢复当前分支工作现场，但是stash内容并不删除
git stash apply stash@{0} -->恢复指定的stash
git stash drop -->删除stash内容
git stash pop -->恢复工作现场的同时将stash内容也一并删除
git cherry-pick 4c805e2 -->复制一个特定的提交4c805e2到当前分支
git pull -->拉取分支
git rebase -->把本地未push的分叉提交历史整理成直线；
		目的是使得我们在查看历史提交的变化时更容易，因为分叉的提交需要三方对比。
		特点：把分叉的提交历史“整理”成一条直线，看上去更直观。缺点是本地的分叉提交已经被修改过了。

git log --grapg --pretty=oneline --abbrev-commit -->以简化图形方式查看分支commit记录日志

git tag v1.0 -->将最新commit打上 v1.0标签
git tag v1.0 commitId -->给commitId打上v1.0标签
git tag -->查看所有标签
git show v1.0 -->查看标签信息
git tag -a v0.1 -m "message" commitId -->创建带有说明的标签
		-a 指定标签名
git tag -d tag v0.1 -->删除v0.1标签
git push origin v1.0 -->推送v1.0标签到远程
git push origin --tags -->一次性推送全部尚未推送的本地标签到远程
git push origin:refs/tags/v0.9 -->删除远程分支 rsfs -->reference参照
	如果标签已经推送到远程，要先从本地删除 git tag -d v0.9
	然后，从远程删除


git config --global alias.st status --> 给status取别名为st
		此时 git st == git status 
	git config --global alias.unstage 'reset HEAD'
		此时 git unstage <file> == git reset HEAD <file>
		也可以在配置文件里直接修改别名以简化命令输入


多人协作的工作模式通常是这样：
	1.首先，可以试图用git push origin <branch-name>推送自己的修改；
	2.如果推送失败，则因为远程分支比你的本地更新，需要先用git pull试图合并；
	3.如果合并有冲突，则解决冲突，并在本地提交；
	4.没有冲突或者解决掉冲突后，再用git push origin <branch-name>推送就能成功！
		如果git pull提示no tracking information，则说明本地分支和远程分支的链接关系没有创建，
		用命令git branch --set-upstream-to <branch-name> origin/<branch-name>


























ssh -keygen -t rsa -C "emailname@example.com" -->创建SSH Key

pwd -->显示当前位置路径
ls -->查看目录里的文件; ls -l -->列出目录里的文件; ls -ah -->查看目录里的文件(包括隐藏文件)










































ssh简单实用教程
进入命令行环境后，我们执行以下操作来创建 SSH 密钥。

1.进入SSH目录
cd ~/.ssh
（1）如果还没有 ~/.ssh 目录，可以手工创建一个(mkdir ~/.ssh)，之后再通过cd ~/.ssh进入SSH目录
（2）可以通过ls -l命令查看SSH目录下的文件，来确认你是否已经生成过SSH密钥；如果SSH目录为空，我们开始第二步，生成 SSH 密钥；如果存在id_rsa.pub这个文件，说明你之前生成过SSH密钥，后面有介绍如何添加多个sshkey
2.生成SSH密钥
我们通过下面的命令生成密钥，请将命令中的YOUR_EMAIL@YOUREMAIL.COM替换为你自己的Email地址。
ssh-keygen -t rsa -C "YOUR_EMAIL@YOUREMAIL.COM"
在SSH生成过程中会出现以下信息，按屏幕的提示操作即可；
$ ssh-keygen -t rsa -C "YOUR_EMAIL@YOUREMAIL.COM"
Generating public/private rsa key pair.
Enter passphrase (empty for no passphrase):
Enter same passphrase again:
Your identification has been saved in /Users/USERNAME/.ssh/id_rsa.
Your public key has been saved in /Users/USERNAME/.ssh/id_rsa.pub.
The key fingerprint is:
15:81:d2:7a:c6:6c:0f:ec:b0:b6:d4:18:b8:d1:41:48 YOUR_EMAIL@YOUREMAIL.COM
说明：
（1）一般情况下，在命令行中输入密码、口令一类的信息时是没有信息回显的。在我们这一步的操作中，输入passphrase口令时，命令行界面上不会随着键盘敲入密码而有什么反馈。
（2）当提示Enter passphrase (empty for no passphrase) :时，可以直接按两次回车键输入一个空的 passphrase；也可以选择输入一个 passphrase 口令，如果此时你输入了一个passphrase，请牢记，之后每次提交时都需要输入这个口令来确认。
3.获取SSH公钥信息
SSH密钥生成结束后，你可以在SSH目录下看到私钥id_rsa和公钥id_rsa.pub这两个文件，不要把私钥文件id_rsa的信息透露给任何人。我们可以通过文本编辑器或cat命令来查看id_rsa.pub公钥信息。
（1）通过编辑器。使用你熟悉的文本编辑器，比如 记事本、Sublime Text等软件打开id_rsa.pub，复制里面的所有内容以备下一步使用。
（2）通过cat命令。在命令行中敲入cat id_rsa.pub，回车执行后命令行界面中会显示id_rsa.pub文件里的内容，复制后在下一步使用。
（3）通过直接使用命令将id_rsa.pub文件里的内容复制到剪切板中
Windows:clip < ~/.ssh/id_rsa.pub
Mac:pbcopy < ~/.ssh/id_rsa.pub
GNU/Linux (requires xclip):xclip -sel clip < ~/.ssh/id_rsa.pub
4.添加SSH公钥到gitlab

作者：YH简简单单的生活
链接：https://www.jianshu.com/p/142b3dc8ae15
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


//rabbitmq 简历连接的两种方式
public class ConnectionFactoryUtil{
	//方式一
	public static Connection GetRabbitConnection(){
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername(Config.Username);
		factory.setPassword(Config.Password);
		factory.setVirtualHost(Congfig.VHost);
		factory.setPort(Config.Port);

		Connection conn = null;

		try{
			conn = factory.newConnection();

		}catch(Exception e){
			e.printStacTrace();
		}
		return conn;
	}

	//方式二
	public static Connection GetRabbitConnection2(){
		ConnectionFactory factory = new ConnectionFactory();
		String uri = String.format("amqp://%s:%s@%s:%d%s",
			Config.Username,Config.Password,Config.Host,Config.port,Config.Vhost);
		Connection conn = null;
		try{
			factory.setUrl(uri);
			factory.setVirtualHost(Config.VHost);
			conn = factory.newConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}

//发布和消费消息
public class PublisherAndConsumer{
	public static void main(String[] args){
		Publisher(); //推送消息
		Consumer(); //消费消息
	}
	public static void Publisher(){
		Connection conn = ConnectionFactoryUtil.GetRabbitConnection();
		if( conn!= null ){
			try{
				//创建通道
				Channel channel = conn.createChannel();
				//声明队列
				channel.queueDeclare(Config.QueueName,false,false,false,null);
				String content = String.format("当前时间:%s",new Date().getTime());
				//发送内容
				channel.basicPublish("",Config.Queueame,null,content.getBytes("UTF-8"));
				System.out.println("已发送消息:"+content);
				channel.close();
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static void Consumer(){
		Connection conn = ConnectionFactoryUtil.GetRabbitConnection();
		if(conn!=null){
			try{
				Channel channel = conn.createChannel();
				channel.queueDeclare(Config.Queue,false,false,false,null);
				//创建订阅器
				channel.basicConsume(Config.QueueName,false,"",new DefaultConsumer(channel){
					@Override
					public void handleDelivery(String consumerTag,Envelop envelop,
						AMQP.BasicProperties properties,byte[] body)throws IOException{
						String roytingKey = envelope.getRoutingKey();
						String contentType = properties.getContentType();
						String content = new String(body,"utf-8");
						System.out.println("消息正文",content);
						channel.basicAck(envelope.getDelveryTag(),false);
					};
				}
			}catch(Exception e){
				e.printStacTrace();
			}
		}
	}
}




4/ Mybatis--> Redis
5/ SpringMVC --> SpringBoot-->Dubbo --> SpringCloud
6/ JVM --> Tomcat
7/ SpringMVC --> SpringBoot






JVM
TomCat
Maven
Git
MyBatis
Redis