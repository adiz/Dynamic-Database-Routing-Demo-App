package ro.adiz.ddr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.adiz.ddr.model.AppUser;

/**
 * @author adrian.zamfirescu
 * @since 28/09/2014
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Integer>{}