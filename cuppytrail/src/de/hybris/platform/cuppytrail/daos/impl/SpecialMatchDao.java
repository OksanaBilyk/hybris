package de.hybris.platform.cuppytrail.daos.impl;

import de.hybris.platform.cuppy.daos.impl.DefaultMatchDao;
import de.hybris.platform.cuppy.model.MatchModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "specialMatchDao")
public class SpecialMatchDao extends DefaultMatchDao {
    @Autowired
    private FlexibleSearchService flexibleSearchService;

    public List<MatchModel> findMarkedMatches() {
        final String queryString = //
                "SELECT {p:" + MatchModel.PK + "} "
                        + "FROM {" + MatchModel._TYPECODE + " AS p} "//
                        + "WHERE " + "{p:" + MatchModel.MARK + "}=true";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);

        return flexibleSearchService.<MatchModel>search(query).getResult();
    }
}
