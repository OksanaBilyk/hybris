package de.hybris.platform.cuppytrail.facades.impl;

import de.hybris.platform.cuppytrail.CuppyUserService;
import de.hybris.platform.cuppytrail.data.CuppyUserData;
import de.hybris.platform.cuppytrail.facades.CuppyUserFacade;
import de.hybris.platform.cuppytrail.model.CuppyTrUserModel;

import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultCuppyUserFacade implements CuppyUserFacade {
    private CuppyUserService cuppyUserService;

    @Autowired
    private ModelService modelService;

    @Override
    public boolean isExistingUser(String name, String password) {
        return cuppyUserService.isExistingUser(name, password);
    }

    @Override
    public void addUser(CuppyUserData cuppyUserData) {
        CuppyTrUserModel cuppyTrUserModel = modelService.create(CuppyTrUserModel.class);
        cuppyTrUserModel.setName(cuppyUserData.getName());
        cuppyTrUserModel.setUsername(cuppyUserData.getUsername());
        cuppyTrUserModel.setLogin(cuppyUserData.getLogin());
        cuppyTrUserModel.setPhone(cuppyUserData.getPhone());
        cuppyTrUserModel.setPassword(cuppyUserData.getPassword());

        cuppyUserService.addUser(cuppyTrUserModel);
    }

    public void setCuppyUserService(final CuppyUserService cuppyUserService) {
        this.cuppyUserService = cuppyUserService;
    }
}
