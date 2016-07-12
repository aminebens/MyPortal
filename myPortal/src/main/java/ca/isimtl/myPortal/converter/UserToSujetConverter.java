package ca.isimtl.myPortal.converter;

import ca.isimtl.myPortal.model.User;
import ca.isimtl.myPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToSujetConverter implements Converter<Object, User> {

    @Autowired
    UserService userService;
    
    public User convert(Object s) {
        Integer id = Integer.parseInt((String)s);
        User role = userService.findById(id);
        return role; 
    }
    
   
}
