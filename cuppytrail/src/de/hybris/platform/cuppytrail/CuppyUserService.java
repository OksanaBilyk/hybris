package de.hybris.platform.cuppytrail;

import de.hybris.platform.cuppytrail.model.CuppyTrUserModel;

public interface CuppyUserService {
    boolean isExistingUser(String name, String password);

    void addUser(CuppyTrUserModel cuppyUserModel);

    void deleteOldUsers();
}
