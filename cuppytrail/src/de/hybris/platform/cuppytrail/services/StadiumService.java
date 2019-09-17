package de.hybris.platform.cuppytrail.services;

import de.hybris.platform.cuppytrail.model.StadiumModel;

import java.util.List;

/**
 * This interface belongs to the Source Code Trail documented at https://wiki.hybris.com/display/pm/Source+Code+Tutorial
 * and describes the interface required to satisfy the StadiuServiceIntegrationTest
 */
public interface StadiumService
{
    List<StadiumModel> getAllStadium();

    StadiumModel getStadiumDetails(String code);
}
