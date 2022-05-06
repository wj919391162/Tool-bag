# Redis学习

## redis基础命令

EXISTS XXX 查找是否存在

EXPIRE xxx 10 设置xxx 10s后过期

ttl xxx 查看当前key的剩余时间

## redis数据类型

### String 类型

> set key xx #设置值
>
> EXISTS xx  #判断一个值是否存在
>
> APPEND xxx “xxx”   #追加字符串 如果当前key不存在则相当于setkey
>
> Incr xx   |    dear xx.      #自增/自减
>
> INCRBY XXX  #设置步长
>
> GETRANGE XXX 0 1   #截取字符串 [0,3]
>
> GETRANGE XXX 0 -1   #获取全部字符串
>
> SETRANGE XXX 1  XX   #替换指定位置开始的字符串
>
> setex #设置过期时间   ｜     setnx  #不存在在设置（常在分布式锁中使用）
>
> setex key 30 "ppx"  #设置key的值为ppx 30s后过期
>
> setnx mykey "ppx"   #设置mykey不存在则创建mykey
>
> mset/mget    #同时设置获取多个值
>
> msetnx   #是一个原子性操作，要么一起成功要么一起失败
>
> 对象： set user:1 {name:px,age:3}   #值为json字符保存一个对象
>
> mset user:1:name ppx user:1:age 21   #key的一个小设计 user:{id}:{filed}
>
> Getset db redis    #如果不存在值则返回nil/若存在值则返回原来的值

数据结构是相同的，value可以说值或者字符串

+ 做计数器
+ 统计多单位的数量 uid:8888:follow 0
+ 粉丝数
+ 对象缓存存储
