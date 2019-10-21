package de.hybris.platform.cuppytrail.facades.impl;

import de.hybris.platform.cuppy.model.MatchModel;
import de.hybris.platform.cuppy.web.facades.impl.DefaultMatchFacade;
import de.hybris.platform.cuppytrail.data.MatchSummaryData;
import de.hybris.platform.cuppytrail.impl.SpecialMatchService;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class SpecialMatchFacade extends DefaultMatchFacade {
    private SpecialMatchService specialMatchService;

    public List<MatchSummaryData> getMarkedMatches() {
        List<MatchModel> matchModels = specialMatchService.getMarkedMatches();
        List<MatchSummaryData> summaryData = new ArrayList<MatchSummaryData>();

        if (CollectionUtils.isNotEmpty(matchModels)) {
            for (MatchModel matchModel : matchModels) {
                final MatchSummaryData summary = new MatchSummaryData();
                final String homeTeam = matchModel.getHomeTeam().getName();
                final String guestTeam = matchModel.getGuestTeam().getName();
                final String guestGoals = matchModel.getGuestGoals() == null ? "-" : matchModel.getGuestGoals().toString();
                final String homeGoals = matchModel.getHomeGoals() == null ? "-" : matchModel.getHomeGoals().toString();

                summary.setHomeTeam(homeTeam);
                summary.setGuestTeam(guestTeam);
                summary.setHomeGoals(homeGoals);
                summary.setGuestGoals(guestGoals);

                final String matchSummary = homeTeam + " ( " + homeGoals + " )" + " : "+ guestTeam + " ( " + guestGoals + " )";
                summary.setMatchSummaryFormatted(matchSummary);
                summaryData.add(summary);
            }
        }
        return summaryData;
    }

    public void setSpecialMatchService(final SpecialMatchService specialMatchService) {
        this.specialMatchService = specialMatchService;
    }
}
