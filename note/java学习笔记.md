# java学习笔记

## 集合容器

#### Java集合框架 

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

#### Collection接口api

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
  
  - 返回Iterator接口实现的类对象(在此接口上的迭代器————用来遍历集合中的元素)
  
  - next()方法
  
    - 指针下移
    - 获取指针指向的元素
    - 如果指针超出集合的长度，则会报错
  
  - hasnext()方法
  
    - 判断是否还有下一个元素，如果有就返回true，否则返回false
  
  - 常见使用错误，
  
    - ```
      while(c.iterator.hasNext){
      System.out.println(c.iterator.next())
      }
      //会无限输出集合中的第一个元素
      ```
  
      - 调用的不是一个对象(Iterator实现类的对象)
      - 调用一次iterator()底层就会返回给我们一个新的Iterator对象
  
    - ```
      while(iterator.next()!=null){
      System.out.println(iterator.next());
      }
      //调用一次next指针就会往下移动一次，
      ```
  
    - 
  
- 增强for循环

  - foreach循环

    - 格式

    - ```
      for(元素类型 临时变量:集合/数组的对象){
      
      }
      ```

    - ```
      for (Object obj:c){    //将C中的元素取出来赋值给obj
      System.out.println(obj);
      }
      ```

  - 注意的细节

    - 取出来的obj只是临时变量更改临时变量并不会更改集合中的元素

#### iterator迭代器接口

#### Collection子接口之一:List接口

##### ArrayList

###### ListAPI

- List list=new ArrayList();

- add();
  - 接收两种参数
    - obj
    - index,obj
      - 在指定位置插入obj，把之前在index位置上的obj向后移动一位
- addAll();
  - list.addAll(list2)
    - 在list的结尾插入list2
  - list.addAll(0,list2)
    - 在list开头插入list2
- get(int index)
  - 获取到集合中指定位置的元素
- int indexOf(Object obj)
  - 返回obj在集合中首次出现的位置
- int lastIndexOf(Object obj)
  - 返回obj在集合中首次出现的位置
- Object remove(int index)
  - 移除指定index位置的元素，并返回此元素
- Object set(int index,Object ele)
  - 设置指定index位置的元素ele
- List subList(int fromIndex,int toIndex)
  - 返回从fromIndex到toIndex位置的子集合
  - 左闭右开
- remove(int index||Object)
  - 默认传入的为索引值
  - 如果要删除集合中的int元素，则使用remove(new Integer(0));

#####  ArrayList和LinkedList和Vector的不同

-  ArrayList
  - 是List的主要实现类，ArrayList的底层是数组。
  - 线程不安全的
  - 查找快增删慢
- LinkedList
  - 底层是一个双向链表
  - 内部储存了三个值，为上个值 的地址，下个值的地址值，和value
  - 增删快查找慢   
- Vector
  - 是一个古老的实现类，Vector底层是数组
  - 是线程安全的
  - 查找快增删慢

- 共同点
  - 都实现了List接口，所以储存元素都是有序可重复的

##### ArrayList的底层实现

- 当我们通过空参构造器创建对象时，会在底层会创建一个长度为10的数组
- 当我们向集合中添加第11个元素的时候，底层会进行扩容为原数组的1.5倍，同时将原数组中的内容复制到虚拟的数组中

##### LinkedListAPI

- void addFirst(Object obj)
  - 向头部添加一个元素
- void addLast(Object obj)
  - 向尾部添加一个元素
- Object getFirst()
  - 获取第一个元素
- Object getLast()
  - 获取最后一个元素
- Object removeFirst()
  - 删除第一个元素，并返回
- Object removeLast()
  - 删除最后一个元素，并返回

##### Collection子接口之二:Set接口

##### HashSet：Set的主要实现类

- Set储存元素的特点:储存的元素是无序的且不可重复的

- 说明
  - set接口是Collection的子接口，set接口没有提供额外方法
  - 无序性不是指的随机性，指的是按hashcode方法得到的hash值决定元素存储的位置(存放的位置是无序的)
  - 不可重复:指的是调用对象的equals方法，如果返回true则说明两个对象相同，则不能存放，如果返回false则说明两个对象不同，则可以存放
- Set接口的实现类
  - HashSet
    - LinkedHashSet
  - TreeSet
- HashSet的底层实现原理
  - 当我们向HashSet中添加一个对象时，首先会调用该对象中的hashCode方法来计算当前对象的储存位置。
  - 如果该位置上没有其他元素，则直接存放。如果该位置上已经存在其他元素。那么调用该对象的equals方法进行比较
  - 如果返回值是true则不能存放，如果返回值是false则以链表的形式存放在该位置上
- 创建一个HashMap
  
- hashCode方法的实现原理
  - 重写hashCode方法的基本原则
    - 在程序运行时，同一个对象多次调用hashCode方法应该返回相同的值
    - 当两个对象的equals方法返回true时，这两个对象的hashCode方法的返回值也应该相同
    - 对象中用作equals方法比较的Field，都应该计算hashCode值

##### LinkedHashSet

- LinkedHashSet继承了HashSet，底层实现原理和HashSet
- LinkedHashSet可以按照添加元素的顺序进行遍历。因为底层维护了一张链表用来记录添加的顺序，在储存对象的时候同时储存了下个元素的索引

##### TreeSet

- 概述

  - 可以按照添加的对象的指定属性进行排序
  - TreeSet的底层是红黑树
  - TreeSet添加的元素类型必须都是相同的

-  给集合中对象添加implement Comparable

  - 完善 Comparable方法

  - 自然排序

    -  步骤
  
      - 创建一个类并实现Comparable接口
      - 重写compareTo方法、
      - 在compareTo方法按照指定的属性进行排序
      - 向集合中添加元素
  
    -  Comparable方法
  
    - ```
          @Override    public int compareTo(Object o) {        System.out.println("__compareTo____");
          //        return 0;//如果返回0则表示这两个对象是相同的则不能添加        
          //按照年纪排序        
          if (o instanceof Animal){            
          //向下转型            
          Animal a=(Animal)o;            
          //按照年纪进行排序         
          return  this.age-a.age;//升序            
          return -(this.age-a.age);//降序            
          //按照名字进行排序           
          return this.name.compareTo(a.name);//升序
          return -(this.name.compareTo(a.name));//降序            
          //如果名字相同按照年纪排序            
        int n=this.name.compareTo(a.name);            
          if (n==0){                
        return this.age-a.age;            
          }           
          return 0;        
          }       
         return 0;//如果两个对象都不是同一个类型则不添加   
         }
      ```
  
  - 定制排序
  
    - 步骤
      - 创建一个comparator接口的实现类的对象
      - 重写compare方法
      - 在compare方法中按照指定的属性进行排序
      - 将Comparator接口实现类的对象作为实参传给TreeSet的构造器中
      - 向集合中添加元素
      
    - 实例
    
    - ```
      public static void test(){
              Comparator c=new Comparator(){
      
                  @Override
                  public int compare(Object o1, Object o2) {
                      if (o1 instanceof Person&&o2 instanceof Person){
                          Person p1=(Person) o1;
                          Person p2=(Person) o2;
                          //按照年纪排序
                          return p1.age-p2.age;
                      }
                      return 0;
                  }
              };
              TreeSet set=new TreeSet(c);
              set.add(new Person("cc",10));
              set.add(new Person("dd",11));
              set.add(new Person("aa",12));
              set.add(new Person("ff",13));
              System.out.println(set);
          }
      ```
    
    - 
    
  - ![](C:\Users\86176\AppData\Roaming\Typora\typora-user-images\image-20191209195900578.png)
  
    - 已完成
  
  - 集合和数组之间的相互转换
  
    - 集合转数组
      - toArray
    - 数组转集合
      - Arrays.asList(Object ... obj)





#### Map接口

##### 说明

- Map中所有的Key可以看成是Set集合。无序的且不可重复的。在Map中存放的Key数据(自定义类对象)必须重写hashCode和equals方法
- Map中所有的value可以看成Collcetion集合，无序的且可重复的。在Map中存放的value数据(自定义类对象)必须重写equals方法
- Map中的键值对(一对一的)可以看成是一个个的Entry。Entry是无序的不可重复的。Entry的位置是由key决定的

##### API

- 增删操作
  - Object put(Object key,Object value)
    - 向集合中添加键值对 -如果key相同后面的value会覆盖前面的value
  - Object remove(Object key)
    - 删除当前集合中键值为key的那对元素
  - void putAll(Map t)
    - 将t中所有的元素添加到当前集合中
  - void clear()
    - 清除集合中所有的元素
- 元素查询操作
  - Object get(Object k)
    - 得到集合中键值为k的元素的value值
  - boolean containKey(Object k)
    - 当前集合中是否包含key为k的元素
  - boolean containValue(Object v)
    - 当前集合中是否包含value为 v的元素
  - int size()
    - 集合中元素的个数
  - boolean isEmpty()
    - 当前集合是否为空
  - boolean equals(Object obj)
    - 比较两个集合中的内容 
    - 不比较顺序(因为是根据hashCode方法比较的)

- 元视图操作的方法
  - Set keySet()
    - 获取当前集合中所有的key
  - Collection values()
    - 获取当前集合中所有的value
  - Set entrySet()
    - 获取当前集合中所有的entry(键值对)
    - 注意：每个元素都是entry(键值对) 需要向下转型
      - Map.Entry e=(Entry) object(元素)

##### HashMa

- Map的主要实现类
- 底层实现原理
  - new HashMap()：底层实现了一个长度为16的数组(node类型)加载因子为0.75
    - 加载因子表示超出长度的75%就会自动扩容为原来的两倍
  - 

##### 	LinkedHashMap	

##### TreeMap 

##### Hashtable

##### 	Properties

#### Collection工具类

