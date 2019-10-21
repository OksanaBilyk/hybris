package de.hybris.platform.cuppytrail.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cuppytrail.CuppyUserService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import org.apache.log4j.Logger;

public class DeleteOldUsersJob extends AbstractJobPerformable<CronJobModel> {
    private CuppyUserService cuppyUserService;

    private static final Logger LOG = Logger.getLogger(DeleteOldUsersJob.class);

    @Override
    public PerformResult perform(final CronJobModel cronJob) {
        LOG.info("Deleting users older then 5 days");
        cuppyUserService.deleteOldUsers();

        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    public void setCuppyUserService(final CuppyUserService cuppyUserService) {
        this.cuppyUserService = cuppyUserService;
    }
}
