package com.zszxz.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zszxz.plus.entity.Customer;
import com.zszxz.plus.mapper.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootMybatisPlusApplicationTests {



    @Autowired
    CustomerMapper customerMapper;

    @Test
    public  void add() {
        Customer customer = new Customer();
        customer.setCustomerName("大牛");
        customer.setGender("男");
        customer.setTelephone("66566");
        customerMapper.insert(customer);
    }

    @Test
    public  void update() {
        Customer customer = new Customer();
        customer.setId(26L);
        customer.setCustomerName("大牛哥");
        customer.setGender("男");
        customer.setTelephone("66566");
        customerMapper.updateById(customer);
    }

    @Test
    public  void delete() {

        customerMapper.deleteById(24L);
    }

    @Test
    public  void selectByid() {

        Customer customer = customerMapper.selectById(26L);
        // Customer(id=26, customerName=大牛哥, gender=男, telephone=66566, registerTime=null)
        System.out.println(customer);
    }

    @Test
    public  void selectByWrapper() {


        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        wrapper.eq("id",26L);
        List<Customer> customers = customerMapper.selectList(wrapper);
        // [Customer(id=26, customerName=大牛哥, gender=男, telephone=66566, registerTime=null)]
        System.out.println(customers);
    }



    @Test
    public  void page() {
        Page<Customer> page = new Page<>(1, 2);
        IPage<Customer> customerIPage = customerMapper.selectPage(page, null);
        System.out.println(customerIPage);
    }


}
