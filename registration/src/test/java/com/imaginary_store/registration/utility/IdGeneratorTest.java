package com.imaginary_store.registration.utility;

import com.imaginary_store.registration.repositories.customer.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class IdGeneratorTest {

    CustomerRepository customerRepositoryMock;
    MockedStatic<IdGenerator> idGenerator;

    @BeforeEach
    void setUp() {
        customerRepositoryMock = mock(CustomerRepository.class);
        idGenerator = mockStatic(IdGenerator.class, CALLS_REAL_METHODS);
    }

    @AfterEach
    void tearDown() {
        idGenerator.close();
    }

    @Test
    void testIdGenerate() {

        String year = String.valueOf(LocalDate.now().getYear() - 2000);
        String month = String.valueOf(LocalDate.now().getMonth().getValue());
        String count = String.format("%06X", customerRepositoryMock.count());



        idGenerator.when(() -> IdGenerator.generateId(customerRepositoryMock)).thenReturn(year+month+count);

        //String id = IdGenerator.generateId(customerRepository);
        assertEquals(year+month+count, IdGenerator.generateId(customerRepositoryMock));
    }
}
