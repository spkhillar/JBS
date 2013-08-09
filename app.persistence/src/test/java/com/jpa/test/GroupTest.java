package com.jpa.test;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.entities.Group;
import com.jpa.entities.Groups;
import com.jpa.repositories.GroupDAO;

public class GroupTest extends BaseTest {

	@Autowired
	private GroupDAO groupDAO;

	@Test
	public void testGroups() {
		findParent(2L);
		findChild(2L);
	}

	private void findParent(Long childId) {
		Group grp = groupDAO.findOne(childId);
		if (grp != null) {
			Set<Groups> groups = grp.getGroupsesForGroupId();
			for (Groups groups2 : groups) {
				if (groups2.getGroupByParentGroupId() != null) {
					System.err.println("...parent groups2..."
							+ groups2.getGroupByParentGroupId().getId());
					findParent(groups2.getGroupByParentGroupId().getId());
				}
			}
		}
	}
	
	private void findChild(Long parentId) {
		Group grp = groupDAO.findOne(parentId);
		if (grp != null) {
			Set<Groups> groups = grp.getGroupsesForParentGroupId();
			for (Groups groups2 : groups) {
				if (groups2.getGroupByGroupId() != null) {
					System.err.println("...child groups2..."
							+ groups2.getGroupByGroupId().getId());
					findChild(groups2.getGroupByGroupId().getId());
				}
			}
		}
	}

}
