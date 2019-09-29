package de.hybris.platform.cuppytrail.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cuppytrail.StadiumService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.apache.log4j.Logger;


public class DeleteAllStadiumsJob extends AbstractJobPerformable<CronJobModel>
{
    private static final Logger LOG = Logger.getLogger(DeleteAllStadiumsJob.class);

    StadiumService stadiumService;

    public void setStadiumService(final StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @Override
    public PerformResult perform(final CronJobModel cronJobModel){
        LOG.info("Deleting all stadiums");

        stadiumService.deleteAllStadiums();

        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }


}