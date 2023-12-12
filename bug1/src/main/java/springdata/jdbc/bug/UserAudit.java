package springdata.jdbc.bug;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.time.LocalDateTime;

public record UserAudit(@LastModifiedBy String modifiedUser,
                        @LastModifiedDate Instant modifiedDate,
                        @CreatedBy String createdUser,
                        @CreatedDate LocalDateTime createdDate) {

}
