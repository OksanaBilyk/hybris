package de.hybris.platform.cuppytrail.facades;

import de.hybris.platform.cuppytrail.data.CuppyUserData;

public interface CuppyUserFacade {
    boolean isExistingUser(String name, String password);

    void addUser(CuppyUserData cuppyUserData);
}
