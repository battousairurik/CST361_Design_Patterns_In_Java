package utils;

import java.util.HashMap;
import java.util.Map;
 
import models.UserAccountV2;
import config.SecurityConfig;
 
public class DataDAO {
 
   private static final Map<String, UserAccountV2> mapUsers = new HashMap<String, UserAccountV2>();
 
   static {
      initUsers();
   }
 
   private static void initUsers() {
 
      // This user has a role as EMPLOYEE.
      UserAccountV2 emp = new UserAccountV2("employee1", "123", UserAccountV2.GENDER_MALE, //
            SecurityConfig.ROLE_EMPLOYEE);
 
      // This user has 2 roles EMPLOYEE and MANAGER.
      UserAccountV2 mng = new UserAccountV2("manager1", "123", UserAccountV2.GENDER_MALE, //
            SecurityConfig.ROLE_EMPLOYEE, SecurityConfig.ROLE_MANAGER);
 
      mapUsers.put(emp.getUserName(), emp);
      mapUsers.put(mng.getUserName(), mng);
   }
 
   // Find a User by userName and password.
   public static UserAccountV2 findUser(String userName, String password) {
      UserAccountV2 u = mapUsers.get(userName);
      if (u != null && u.getPassword().equals(password)) {
         return u;
      }
      return null;
   }
 
}
