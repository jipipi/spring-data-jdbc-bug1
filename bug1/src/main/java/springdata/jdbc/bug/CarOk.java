package springdata.jdbc.bug;

import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Embedded;

import java.time.Instant;
import java.time.LocalDateTime;

public record CarOk(
        @Id Long id,
        String name,
        @LastModifiedBy String modifiedUser,
        @LastModifiedDate Instant modifiedDate,
        @CreatedBy String createdUser,
        @CreatedDate LocalDateTime createdDate
){
}
