package de.hybris.platform.cuppytrail.facades.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cuppy.model.MatchModel;
import de.hybris.platform.cuppy.model.TeamModel;
import de.hybris.platform.cuppytrail.data.MatchSummaryData;
import de.hybris.platform.cuppytrail.impl.SpecialMatchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class SpecialMatchFacadeUnitTest {
    @InjectMocks
    private SpecialMatchFacade specialMatchFacade;

    @Mock
    private SpecialMatchService specialMatchService;

    private static final String HOMETEAM = "Barselona";
    private static final String GUESTTEAM = "Real";

    @Mock
    private TeamModel homeTeam;
    @Mock
    private TeamModel guestTeam;

    @Test
    public void testGetMarkedMatches() {
        List<MatchModel> list = new ArrayList<>();
        MatchModel model = new MatchModel();
        model.setHomeTeam(homeTeam);
        model.setGuestTeam(guestTeam);
        list.add(model);

        when(specialMatchService.getMarkedMatches()).thenReturn(list);
        when(homeTeam.getName()).thenReturn(HOMETEAM);
        when(guestTeam.getName()).thenReturn(GUESTTEAM);

        List<MatchSummaryData> matchDataList = specialMatchFacade.getMarkedMatches();

        assertNotNull(matchDataList);
        assertEquals(list.size(), matchDataList.size());
        assertEquals(HOMETEAM, matchDataList.get(0).getHomeTeam());
        assertEquals(GUESTTEAM, matchDataList.get(0).getGuestTeam());
    }
}