package com.example.config;

import com.example.shiro.UserRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //创建一个shiroFilter，负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //设置请求方形规则
        Map<String,String> map = new HashMap<>();
        map.put("/user/login","anon");
        map.put("/user/register","anon");

        //把请求放行规则放入到shiroFilter中
        filterFactoryBean.setFilterChainDefinitionMap(map);
        return filterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    @Bean
    public Realm realm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
}
