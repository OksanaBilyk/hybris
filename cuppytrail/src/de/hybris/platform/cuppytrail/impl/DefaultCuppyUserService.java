package de.hybris.platform.cuppytrail.impl;

import de.hybris.platform.cuppytrail.CuppyUserService;
import de.hybris.platform.cuppytrail.daos.CuppyUserDao;
import de.hybris.platform.cuppytrail.model.CuppyTrUserModel;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DefaultCuppyUserService implements CuppyUserService {
    private CuppyUserDao cuppyUserDao;

    @Autowired
    private ModelService modelService;

    @Override
    public boolean isExistingUser(String name, String password) {
        return cuppyUserDao.isExistingUser(name, password);
    }

    @Override
    public void addUser(CuppyTrUserModel cuppyUserTrModel) {
        modelService.save(cuppyUserTrModel);
    }

    @Override
    public void deleteOldUsers() {
        List<CuppyTrUserModel> allUsers = cuppyUserDao.getAllUsers();
        List<CuppyTrUserModel> usersToRemove = new ArrayList<>();

        for (CuppyTrUserModel cuppyTrUserModel : allUsers) {
            if (DateUtils.addDays(new Date(), -5).compareTo(cuppyTrUserModel.getCreationtime()) > 0 ) {
                usersToRemove.add(cuppyTrUserModel);
            }
        }
        modelService.removeAll(usersToRemove);
    }

    public void setCuppyUserDao(final CuppyUserDao cuppyUserDao) {
        this.cuppyUserDao = cuppyUserDao;
    }
}
