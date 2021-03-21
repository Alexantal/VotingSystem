package ru.graduation.topjava.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEnabledEntity extends AbstractNamedEntity {

    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    @NotNull
    private Date registered = new Date();

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    protected boolean enabled = true;

    protected AbstractEnabledEntity() {
    }

    protected AbstractEnabledEntity(Integer id, String name, boolean enabled, Date registered) {
        super(id, name);
        this.enabled = enabled;
        this.registered = registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return super.toString() + '(' + enabled + ')';
    }
}
