package ro.adiz.ddr.configuration;

import liquibase.Liquibase;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author adrian.zamfirescu
 * @since 28.09.2014
 */
public class CustomLiquibase extends SpringLiquibase{

    private String configChangeLog;
    private String cleanUpChangeLog;

    public CustomLiquibase(){
        super();
        setShouldRun(false);
    }

    public void executeCurrentChangeLog(){
        setShouldRun(true);
        try{
            afterPropertiesSet();
        } catch (LiquibaseException e){
            e.printStackTrace();
        }
    }

    public void setConfigChangeLog(){
        setChangeLog(configChangeLog);
    }

    public void setCleanUpChangeLog(){
        setChangeLog(cleanUpChangeLog);
    }

    public void setConfigChangeLogAndExecute(){
        setConfigChangeLog();
        executeCurrentChangeLog();
    }

    public void setCleanUpChangeLogAndExecute(){
        setCleanUpChangeLog();
        executeCurrentChangeLog();
    }

    public String getConfigChangeLog() {
        return configChangeLog;
    }

    public void setConfigChangeLog(String configChangeLog) {
        this.configChangeLog = configChangeLog;
    }

    public String getCleanUpChangeLog() {
        return cleanUpChangeLog;
    }

    public void setCleanUpChangeLog(String cleanUpChangeLog) {
        this.cleanUpChangeLog = cleanUpChangeLog;
    }
}
