/*
 * Copyright 2017-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package springdata.jdbc.bug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Demonstrates bug on @Embeddable and Audit annotation + record
 */
@SpringBootTest(classes = BugConfiguration.class)
@AutoConfigureJdbc
class BugEmbeddableTests {

    @Autowired
    CarRepository repository;
    @Autowired
    CarOkRepository repositoryOk;

    @Test
    void testCar_Ok() {
        // create some categories
        var car = repositoryOk.save(new CarOk(null, "MyCar", null, null, null, null));
        // save car
        var carPersisted = repositoryOk.findById(car.id()).orElse(null);
        assertNotNull(carPersisted);
        assertNotNull(carPersisted.id());
        assertEquals("MyCar", carPersisted.name());
        assertEquals("Bob", carPersisted.createdUser());
        assertEquals("Bob", carPersisted.modifiedUser());
        assertNotNull(carPersisted.modifiedDate());
        assertNotNull(carPersisted.createdDate());
    }

    @Test
    void testAuditAwareWithEmbedded_KO() {
        // create some categories
        var car = repository.save(new Car(null, "MyCar", new UserAudit(null, null, null, null)));
        // save car
        var carPersisted = repository.findById(car.id()).orElse(null);
        assertNotNull(carPersisted);
        assertNotNull(carPersisted.id());
        assertEquals("MyCar", carPersisted.name());
        assertEquals("Bob", carPersisted.userAudit().createdUser());
        assertEquals("Bob", carPersisted.userAudit().modifiedUser());
        assertNotNull(carPersisted.userAudit().modifiedDate());
        assertNotNull(carPersisted.userAudit().createdDate());
    }


}
