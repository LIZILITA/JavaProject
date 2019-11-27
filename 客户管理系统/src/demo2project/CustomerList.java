package demo2project;

public class CustomerList {
    Customer[] customers;
    int total=0;

//初始化数组的长度
    public CustomerList(int totalCustomer){
   this.customers=new Customer[totalCustomer];
    }
//添加用户
    public boolean addCustomer(Customer customer){
        //检查
        if(total>=customers.length){
            return false;
        }
        customers[total++]=customer;
        return true;
    }
//替换用户
    public boolean replaceCustomer(int index,Customer cust){
        //检查
        if(index<0||index>=total){
            return false;
        }
        if(cust==null){
            return false;
        }
        this.customers[index]=cust;
        return true;
    }
    //获取用户数组
    public Customer[] getAllCustomers(){
        //原数组的长度为新数组的长度
        Customer[] c=new Customer[total];
        for (int i = 0; i < total; i++) {
            c[i]=customers[i];
        }
        return c;
    }
    //获取索引处的用户
    public Customer getCustomer(int index){
        //检查
        if(index<0||index>=total){
            return null;
        }
        return customers[index];
    }
    public boolean deleteCustomer(int index){
        //校验
        if(index<0||index>=total){
            return false;
        }
        //用后一个用户替换前一个用户
        for (int i = 0; i < index; i++) {
            customers[i]=customers[i+1];
        }
        //total用户数量减一
        total--;
        return true;
    }
}
