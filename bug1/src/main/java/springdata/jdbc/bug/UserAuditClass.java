package springdata.jdbc.bug;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

public final class UserAuditClass {
    @LastModifiedBy
    private final String modifiedUser;
    @LastModifiedDate
    private final Instant modifiedDate;
    @CreatedBy
    private final String createdUser;
    @CreatedDate
    private final LocalDateTime createdDate;

    public UserAuditClass(String modifiedUser,
                          Instant modifiedDate,
                          String createdUser,
                          LocalDateTime createdDate) {
        this.modifiedUser = modifiedUser;
        this.modifiedDate = modifiedDate;
        this.createdUser = createdUser;
        this.createdDate = createdDate;
    }

    @LastModifiedBy
    public String modifiedUser() {
        return modifiedUser;
    }

    @LastModifiedDate
    public Instant modifiedDate() {
        return modifiedDate;
    }

    @CreatedBy
    public String createdUser() {
        return createdUser;
    }

    @CreatedDate
    public LocalDateTime createdDate() {
        return createdDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UserAuditClass) obj;
        return Objects.equals(this.modifiedUser, that.modifiedUser) &&
               Objects.equals(this.modifiedDate, that.modifiedDate) &&
               Objects.equals(this.createdUser, that.createdUser) &&
               Objects.equals(this.createdDate, that.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modifiedUser, modifiedDate, createdUser, createdDate);
    }

    @Override
    public String toString() {
        return "UserAuditClass[" +
               "modifiedUser=" + modifiedUser + ", " +
               "modifiedDate=" + modifiedDate + ", " +
               "createdUser=" + createdUser + ", " +
               "createdDate=" + createdDate + ']';
    }


}
