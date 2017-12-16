package com.infoshareacademy.searchengine.incterceptors;

import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class AddUserInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        Object[] parameters = context.getParameters();

        User user  = (User) parameters[0]; //metoda addUser w UsersRepositoryDaoBean ma usera przekazywanego jako pierwszy parametr

        if(user.getGender()==null){
            if(user.getName().toString().endsWith("a")){
                user.setGender(Gender.WOMAN);
            }else user.setGender(Gender.MAN);
        }



        Logger logger = Logger.getLogger(AddUserInterceptor.class.getName());

        logger.info("Add user has been invoked!");
        return context.proceed();




    }


}
