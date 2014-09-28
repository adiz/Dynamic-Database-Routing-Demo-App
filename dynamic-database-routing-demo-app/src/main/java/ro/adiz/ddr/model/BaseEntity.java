package ro.adiz.ddr.model;

import javax.persistence.*;

/**
 * @author adrian.zamfirescu
 * @since 28/09/2014
 */
@MappedSuperclass
public abstract class BaseEntity {

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
