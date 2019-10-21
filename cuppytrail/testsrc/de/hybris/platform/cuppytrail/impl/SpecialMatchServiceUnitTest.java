package de.hybris.platform.cuppytrail.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.cuppy.model.MatchModel;
import de.hybris.platform.cuppy.model.TeamModel;
import de.hybris.platform.cuppytrail.daos.impl.SpecialMatchDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class SpecialMatchServiceUnitTest {
    @InjectMocks
    private SpecialMatchService specialMatchService;
    @Mock
    private SpecialMatchDao specialMatchDao;
    @Mock
    private TeamModel homeTeam;
    @Mock
    private TeamModel guestTeam;

    private static final String HOMETEAM = "Barselona";
    private static final String GUESTTEAM = "Real";

    @Test
    public void testGetAllStadiums() {
        MatchModel model = new MatchModel();
        model.setHomeTeam(homeTeam);
        model.setGuestTeam(guestTeam);

        final List<MatchModel> matchModels = Arrays.asList(model);

        when(specialMatchDao.findMarkedMatches()).thenReturn(matchModels);
        when(homeTeam.getName()).thenReturn(HOMETEAM);
        when(guestTeam.getName()).thenReturn(GUESTTEAM);

        final List<MatchModel> result = specialMatchService.getMarkedMatches();

        assertEquals(1, result.size());
        assertEquals(model, result.get(0));
    }
}
