package de.hybris.platform.cuppytrail.impl;

import de.hybris.platform.cuppy.model.MatchModel;
import de.hybris.platform.cuppy.services.impl.DefaultMatchService;
import de.hybris.platform.cuppytrail.daos.impl.SpecialMatchDao;

import java.util.List;

public class SpecialMatchService extends DefaultMatchService {
    private SpecialMatchDao specialMatchDao;

    public List<MatchModel> getMarkedMatches(){
        return specialMatchDao.findMarkedMatches();
    };

    public void setSpecialMatchDao(final SpecialMatchDao specialMatchDao)
    {
        this.specialMatchDao = specialMatchDao;
    }
}
