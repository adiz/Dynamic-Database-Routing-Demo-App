package ro.adiz.ddr.dao;

import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.adiz.ddr.configuration.CustomLiquibase;
import ro.adiz.ddr.model.AppUser;

import java.util.Date;

import static org.junit.Assert.fail;

/**
 * @author adrian.zamfirescu
 * @since 28/09/2014
 */
@ContextConfiguration(locations = {"classpath:spring-repository.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DatabaseRoutingTest {

    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private CustomLiquibase customLiquibase;

    @Test
    public void should_select_a_persistent_appuser_or_throw_exception(){

        try{

            // when
            AppUser selectedAppUser = appUserRepository.findOne(1);

            // then
            if (new Date().getMinutes()%2==1){
                Assertions.assertThat(selectedAppUser.getUsername()).isEqualTo("persistent_usr");
                System.out.println("Persistent user selected");
            }
            else
                fail("Should have not been able to connect to the second database");

        } catch (Exception e){
            System.out.println("OK - the connection to the database wasn't supposed to succeed");
        }

    }

    @Test
    public void should_select_one_of_the_two_different_appusers_based_on_the_current_connection(){

        // given
        Date now = new Date();

        if (now.getMinutes()%2==0)
            customLiquibase.setConfigChangeLogAndExecute();

        // when
        AppUser selectedAppUser = appUserRepository.findOne(1);

        // then
        if (now.getMinutes()%2==1){
            Assertions.assertThat(selectedAppUser.getUsername()).isEqualTo("persistent_usr");
            System.out.println("Persistent user selected");
        }
        else{

            Assertions.assertThat(selectedAppUser.getUsername()).isEqualTo("detachable_usr");
            System.out.println("Detachable user selected");

            // cleanUp
            customLiquibase.setCleanUpChangeLogAndExecute();
            try{
                appUserRepository.findOne(1);
                fail("Should have wiped up the database content!");
            } catch (Exception e){
                System.out.println("Successfully emptied the database");
            }

        }

    }

}
