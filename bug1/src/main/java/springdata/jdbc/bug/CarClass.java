package springdata.jdbc.bug;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.Objects;

public final class CarClass {
    @Id
    private final Long id;
    private final String name;
    @Embedded.Empty()
    private final UserAuditClass userAudit;

    public CarClass(
            Long id,
            String name,
            UserAuditClass userAudit
    ) {
        this.id = id;
        this.name = name;
        this.userAudit = userAudit;
    }

    @Id
    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    @Embedded.Empty()
    public UserAuditClass userAudit() {
        return userAudit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CarClass) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.name, that.name) &&
               Objects.equals(this.userAudit, that.userAudit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userAudit);
    }

    @Override
    public String toString() {
        return "CarClass[" +
               "id=" + id + ", " +
               "name=" + name + ", " +
               "userAudit=" + userAudit + ']';
    }

}
