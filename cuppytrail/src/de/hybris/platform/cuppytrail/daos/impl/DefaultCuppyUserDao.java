package de.hybris.platform.cuppytrail.daos.impl;

import de.hybris.platform.cuppytrail.daos.CuppyUserDao;
import de.hybris.platform.cuppytrail.model.CuppyTrUserModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component(value = "cuppyUserDao")
public class DefaultCuppyUserDao implements CuppyUserDao {
    @Autowired
    private FlexibleSearchService flexibleSearchService;

    @Override
    public boolean isExistingUser(String name, String password) {
        boolean result;
        final String queryString =
                "SELECT {" + CuppyTrUserModel.PK + "}"
                        + "FROM {" + CuppyTrUserModel._TYPECODE + "} "//
                        + "WHERE {" + CuppyTrUserModel.USERNAME + "}=?username AND {" +CuppyTrUserModel.PASSWORD + "}=?password";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("username", name);
        query.addQueryParameter("password", password);
        Iterator<CuppyTrUserModel> cuppyTrUserModelIterator = flexibleSearchService.<CuppyTrUserModel>search(query).getResult().iterator();
        result = cuppyTrUserModelIterator.hasNext();
        return result;
    }

    @Override
    public List<CuppyTrUserModel> getAllUsers() {
        final String queryString = //
                "SELECT {p:" + CuppyTrUserModel.PK + "} "//
                        + "FROM {" + CuppyTrUserModel._TYPECODE + " AS p} ";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<CuppyTrUserModel>search(query).getResult();
    }
}
