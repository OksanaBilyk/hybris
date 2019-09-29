package de.hybris.platform.cuppytrail.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.cuppytrail.StadiumService;
import de.hybris.platform.cuppytrail.model.StadiumModel;
import de.hybris.platform.impex.jalo.ImpExException;
import de.hybris.platform.impex.jalo.Importer;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.util.CSVReader;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class AddStadiumsFromImpexJob extends AbstractJobPerformable<CronJobModel> {
    private static final Logger LOG = Logger.getLogger(AddStadiumsFromImpexJob.class);

    private StadiumService stadiumService;

    @Required
    public void setStadiumService(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @Override
    public PerformResult perform(final CronJobModel cronJob) {
        LOG.info("Try to add stadiums from Impex");
        List<StadiumModel> stadiums = stadiumService.getStadiums();

        if (CollectionUtils.isNotEmpty(stadiums)) {
            LOG.info("Stadiums have already added.");
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        }
//        File file = new File("/impex/projectdataStadium.impex");
        File file = new File("C:\\hybris\\bin\\custom\\cuppytrail\\resources\\impex\\projectdataStadium.impex");
        try {
//            Importer importer = new Importer(new CSVReader("projectdataStadium.impex", "utf-8"));
            Importer importer = new Importer(new CSVReader(file, "utf-8"));
            importer.importAll();
            System.out.println("Processed items: " + importer.getProcessedItemsCountOverall());
            LOG.info("Stadiums are added");
        } catch (UnsupportedEncodingException e) {
            LOG.info("Unsupported Encoding format");
        } catch (FileNotFoundException e) {
            LOG.info("Such file is not found");
        } catch (ImpExException e) {
            LOG.info("ImpEx Exception");
        }
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}