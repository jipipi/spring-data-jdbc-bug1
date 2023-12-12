package springdata.jdbc.bug;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

public record Car (
        @Id Long id,
        String name,
        @Embedded.Empty()
        UserAudit userAudit
){
}
