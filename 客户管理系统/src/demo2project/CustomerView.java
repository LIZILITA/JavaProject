package demo2project;

import java.awt.color.CMMException;

public class CustomerView {
private CustomerList list;

//构造器对CustomerList对象进行初始化
public CustomerView(){
    list=new CustomerList(10);
}
//进入主菜单
public void enterMainMenu(){
    boolean isFlag=true;
    do {
        System.out.println("——————————客户管理系统——————————");
        System.out.println("            1，添加用户");
        System.out.println("            2，修改用户");
        System.out.println("            3，删除用户");
        System.out.println("            4，客户列表");
        System.out.println("            5，退出");
        System.out.print("           请选择(1-5):");
        //读取菜单项
        char menuSelection=CMUtility.readMenuSelection();
       //判断
        switch (menuSelection){
            case '1'://添加客户
                addNewCustomer();
                break;
            case '2'://修改用户
                modifyCustomer();
                break;
            case '3'://删除用户
                deleteCustomer();
                break;
            case '4'://用户列表
                listAllCustomer();
                break;
            case '5'://退出
                System.out.println("——————————退出——————————");
                System.out.println("确认是否退出(Y/N)");
                //读取是否退出
                char consirmSelection= CMUtility.readConfirmSelection();
                if (consirmSelection=='Y'){
                    System.out.println("退出成功");
                    isFlag=false;
                }
                break;
        }
    }while (isFlag);
}
//添加新用户
public void addNewCustomer(){
    System.out.println("——————————添加用户——————————");
    //读取用户输入信息
    System.out.print("姓名：");
    String name=CMUtility.readString(13);
    System.out.print("性别：");
    char gender=CMUtility.readChar();
    System.out.print("年龄：");
    int age=CMUtility.readInt();
    System.out.print("电话：");
    String phone =CMUtility.readString(13);
    System.out.print("邮箱：");
    String email=CMUtility.readString(15);
    //封装对象
    Customer customer=new Customer(name,gender,age,phone,email);
    boolean addCustomer= list.addCustomer(customer);
    if (addCustomer) {
        System.out.println("——————————添加完成——————————");
    }else{
        System.out.println("——————————添加失败——————————");
    }
}
//修改用户
public void modifyCustomer(){
    System.out.println("——————————修改用户——————————");
     boolean isFlag=true;
    Customer customer=null;
    int id=-1;
     while (isFlag){
         System.out.println("请选择待修改用户编号");
         //读取输入的用户编号
          id=CMUtility.readInt();
         if(id==-1){
             return;
         }else {
             //查用户是否存在——需要传的实参是索引值
              customer=list.getCustomer(id-1);
             if (customer!=null){//找到了该用户
                 break;
             }else {
                 System.out.println("没有找到该用户");//继续执行下一轮循环
             }
         }
     }
     //展示需要修改的用户信息
    System.out.print("姓名（"+customer.getName()+"）：");
     //读取修改后的数据，如果没有输入内容，则表示不修改，如果输入了新内容则返回新的内容
    String name=CMUtility.readString(13,customer.getName());

    System.out.print("性别（"+customer.getGender()+"）：");
    char gender=CMUtility.readChar(customer.getGender());

    System.out.print("年龄（"+customer.getAge()+"）：");
    int age=CMUtility.readInt(customer.getAge());

    System.out.print("电话（"+customer.getPhone()+"）：");
    String phone=CMUtility.readString(20,customer.getPhone());

    System.out.print("邮箱（"+customer.getEmail()+"）");
    String email=CMUtility.readString(20,customer.getEmail());

    //封装对象————把读出来的新的值给到对象
    Customer cus=new Customer(name,gender,age,phone,email);

    //将新的对象替换掉原来的对象
    boolean replaceCustomer=list.replaceCustomer(id-1,cus);
    //判断是否修改成功
    if (replaceCustomer){
        System.out.println("——————————修改完成——————————");
    }else {
        System.out.println("——————————修改失败——————————");
    }


}
//删除用户
public void deleteCustomer(){
    System.out.println("——————————删除用户——————————");
     int id=-1;
    boolean isFlag=true;
    while (isFlag){
        System.out.println("请选择待删除的用户编号(-1退出)");
        id=CMUtility.readInt();
        if(id==-1){
           return;
        }else {
           Customer customer=list.getCustomer(id-1);
           if(customer==null){
               System.out.println("未找到该用户");
           }else {
               break;
           }
        }
    }
    //确认是否删除
    char confirmSelection=CMUtility.readConfirmSelection();
     if (confirmSelection=='Y'){
         boolean deleteCustomer=list.deleteCustomer(id-1);
         if (deleteCustomer){
             System.out.println("——————————删除完成——————————");
         }else{
             System.out.println("——————————删除失败——————————");
         }
     }
}

//列出所有的用户
public void listAllCustomer(){
    System.out.println("——————————客户列表——————————");
    System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
    //获取所有的用户
    Customer[] customers=list.getAllCustomers();
    if(customers.length==0){
        System.out.println("您还没有添加用户");
    }else {
        //输出所有用户的详细信息
        for (int i=0;i<customers.length;i++){
            Customer customer=customers[i];
            System.out.println(i+1+"\t"+customer.getName()
            +"\t"+customer.getGender()
            +"\t"+customer.getGender()
            +"\t"+customer.getPhone()
            +"\t"+customer.getEmail()
            );

        }
    }

    System.out.println("——————————客户列表完成———————");

}

    public static void main(String[] args) {
   new CustomerView().enterMainMenu();

    }

}
