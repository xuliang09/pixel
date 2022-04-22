package com.aliyun.pixel.jndi.inject;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

/**
 * log4j jndi漏洞的本质是lookup参数的url放给用户自定义
 */
public class JndiInject {
    public static void initPerson() throws Exception{
        //配置JNDI工厂和JNDI的url和端口。如果没有配置这些信息，会出现NoInitialContextException异常
        LocateRegistry.createRegistry(6666);
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        System.setProperty(Context.PROVIDER_URL, "rmi://localhost:6666");

        //初始化
        InitialContext ctx = new InitialContext();

        //实例化person对象
        Person p = new Person();
        p.setName("mi1k7ea");
        p.setPassword("Niubility!");

        //person对象绑定到JNDI服务中，JNDI的名字叫做：person。
        ctx.bind("person", p);
        ctx.close();
    }

    public static void findPerson() throws Exception{
        //因为前面已经将JNDI工厂和JNDI的url和端口已经添加到System对象中，这里就不用在绑定了
        InitialContext ctx = new InitialContext();

        //通过lookup查找person对象
        Person person = (Person) ctx.lookup("rmi://localhost:6666/person");

        //打印出这个对象
        System.out.println(person.toString());
        ctx.close();
    }

    public static void main(String[] args) throws Exception {
        initPerson();
        findPerson();
    }
}

class Person implements Remote, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "name:"+name+" password:"+password;
    }
}