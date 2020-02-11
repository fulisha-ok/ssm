package com.ssm.test;

import com.ssm.dao.AccountDao;
import com.ssm.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class Mybatis {
    @Test
    public void test1() throws Exception{
        //加载Mybatis配置文件 注意导入的包时io
        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession对象
        SqlSession session=factory.openSession();
        //获取代理对象
        AccountDao accountDao=session.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> list=accountDao.findAll();
        for (Account account:list){
            System.out.println(account);
        }
        //关闭西资源
        session.close();
        inputStream.close();

    }


    @Test
    public void test2() throws Exception{
        Account account=new Account();
        account.setUsername("meili");
        account.setMoney(100d);
        //加载Mybatis配置文件 注意导入的包时io
        InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession对象
        SqlSession session=factory.openSession();
        //获取代理对象
        AccountDao accountDao=session.getMapper(AccountDao.class);
        //保存数据
        accountDao.saveAccount(account);

        //提交事务
        session.commit();
        //关闭西资源
        session.close();
        inputStream.close();

    }

}
