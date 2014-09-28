package ro.adiz.ddr.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Date;

/**
 * @author adrian.zamfirescu
 * @since 28/09/2014
 */
public class CustomRoutingDataSource extends AbstractRoutingDataSource{

    @Override
    protected Object determineCurrentLookupKey() {

        Date now = new Date();
        if (now.getMinutes()%2==0)
            return "DETACHABLE";

        return "PERSISTENT";

    }

}
