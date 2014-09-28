package ro.adiz.ddr.model;

import javax.persistence.*;

/**
 * @author adrian.zamfirescu
 * @since 28/09/2014
 */
@Entity
@Table(name = "appuser")
public class AppUser extends BaseEntity{

    private String username;
    private String password;
    private String type;
    private boolean active;

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "active")
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
