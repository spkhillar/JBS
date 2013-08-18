package com.jpa.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.User;
import com.jpa.repositories.UserDAO;

public class GroupTest extends BaseTest {

  @Autowired
  private UserDAO userDAO;

  @Test
  public void testGroups() {
    findParent(1L);
    findChild(1L);
  }

  private void findParent(Long childId) {
    User grp = userDAO.findOne(childId);
    /* if (grp != null) {
      Set<UserGroups> groups = grp.getUserGroupsesForGroupId();
      if(groups != null && groups.size() > 0){
        for (UserGroups groups2 : groups) {
          if (groups2.getUserByParentGroupId() != null) {
            System.err.println("...parent groups2..."
                + groups2.getUserByParentGroupId().getId());
            findParent(groups2.getUserByParentGroupId().getId());
          }
        }
      }
    }*/
  }

  private void findChild(Long parentId) {
    User grp = userDAO.findOne(parentId);
    /* if (grp != null) {
      Set<UserGroups> groups = grp.getUserGroupsesForParentGroupId();
      if(CollectionUtils.isNotEmpty(groups)){
        for (UserGroups groups2 : groups) {
          if (groups2.getUserByGroupId() != null) {
            System.err.println("...child groups2..."
                + groups2.getUserByGroupId().getId());
            findChild(groups2.getUserByGroupId().getId());
          }
        }
      }
    }*/
  }

}
