package de.hybris.platform.cuppytrail.daos;

import de.hybris.platform.cuppytrail.model.CuppyTrUserModel;

import java.util.List;

public interface CuppyUserDao {

    boolean isExistingUser(String name, String password);

    List<CuppyTrUserModel> getAllUsers();
}
