# java学习笔记

## 集合容器

##### Java集合框架 

- 容器：数组与集合
  - 数组的特点
    - 数组一旦创建成功，那么数组的长度就不可变
    - 数组声明时的类型，就决定了数组储存元素的类型’
  - 数组的缺点(集合的特点)
    - 数组的长度不可变，不能很好的扩容‘
    - 数组的属性和方法较少，比如缺少像，增，删，改，查，插等这样的方法
    - 数组中只能用来储存的元素是有序的可重复

- Java集合概述
  - 描述
    - 一方面，面向对象语言对事物的体现都是以对象的形式，为了方便对多个对象的操作，就要对对象进行储存，另一方面，使用Array储存对象方面具有一些弊端，而Java集合就像一种容器，可以动态地把多个对象的引用放入容器中
    - Java集合类可以用于储存数量不等的多个对象，还可用于保存具有映射关系的关联数组
  - Java集合可分为Collection和Map两种体系
    - Collection接口
      - set:元素无序，不可重复的集合
      - List:元素有序，可重复性的集合
    - Map接口、
      - 具有映射关系"key-value对"的集合
  - Collection接口继承树
    - Collection
      - list
        - Vector
        - Array
        - LinkedList
      - set
        - Hashset
          - LinkedHashSet
        - SortedSet
          - TreeSet

##### Collection接口api

- add(Object obj);

  - 向集合中添加元素(obj);

- addAll(Collection collection)

  - 将Collection中的元素分别放入到当前集合中

- size()

  - 当前集合中元素的个数

- clear()

  - 清除数组中的所有元素

- contains(Object obj)

  - 当前集合中是否包含obj这个元素
  - 原理是使用equals方法
    - 根据调用equals的不同比较内容，
      - 比较内容返回tue
      - 比较地址值返回false
    - 以后只要Collection集合中储存的是自定义类的对象，那么该对象所在的类必须重写equals方法

- containsAll(Collection collection)

  - 当前集合中是否包含了collection中所有的元素
  - conllection如果有相同的元元素，当前对象一个顶俩，true

- equals(Collection collection)

  - 两个对象中的元素，个数，顺序，内容都必须相同结果才为true

- hashcode()

  - 同一个对象无论调用多少次，hashcode的值都是一样的、
  - 不同的对象调用hashcode()方法它扥值是不一样的

  - 获取对象的地址值

- isEmpty()
  - 判断当前集合是否为空
- remove(Object obj)
  - 删除当前集合中的元素
  - 根据地址值删除元素，如果要根据内容删除，需要重写equals方法
- removeAll(Collection collection)
  - 从当前集合中删除当前集合和collection集合中交集的部分(相同的元素)
- retainAll(Collection collection )
  - 在当前集合中只保留和collection集合中交集的部分，其他元素删除
- toArray()
  - 将集合转成数组
- iterator()
  - 

##### iterator迭代器接口

##### Collection子接口之一:List接口

###### ArrayList

###### LinkedList

###### Vector

##### Collection子接口之二:Set接口

###### HashSet

###### LinkedHashSet

###### TreeSet

##### Map接口

###### HashMap

###### LinkedHashMap

###### TreeMap

###### Hashtable

##### Collection工具类

