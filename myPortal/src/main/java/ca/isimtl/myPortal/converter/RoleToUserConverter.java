package ca.isimtl.myPortal.converter;

import ca.isimtl.myPortal.model.UserRole;
import ca.isimtl.myPortal.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleToUserConverter implements Converter<Object, UserRole> {

    @Autowired
    UserRoleService userRoleService;
    
    public UserRole convert(Object s) {
        Integer id = Integer.parseInt((String)s);
        UserRole role = userRoleService.findById(id);
        return role; 
    }
    
}
