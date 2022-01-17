package com.enocklubowa.springcommonexceptions;

import com.enocklubowa.springcommonexceptions.exception.AlreadyExistsException;
import com.enocklubowa.springcommonexceptions.exception.InvalidIdentifierException;
import com.enocklubowa.springcommonexceptions.exception.NotFoundException;
import com.enocklubowa.springcommonexceptions.model.DemoEntity;
import com.enocklubowa.springcommonexceptions.repository.DemoEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DemoServiceTest {

    @Mock
    DemoEntity entity;

    @Mock
    DemoEntityRepository repository;

    DemoService service;

    List<DemoEntity> list;

    @BeforeEach
    void init(){
        service = new DemoService(repository);

        entity = new DemoEntity();
        entity.setId(1L);
        entity.setUsername("enock");
        list = List.of(entity);
    }

    @Test
    public void shouldThrowNotFoundExceptionWhenEntityDoesntExist(){
        given(repository.findById(entity.getId())).willReturn(Optional.of(entity));

        assertThrows(NotFoundException.class, () -> {
            service.getEntityById(2L);
        });
    }

    @Test
    public void shouldNotThrowExceptionWhenCorrectIdIsProvided(){
        given(repository.findById(entity.getId())).willReturn(Optional.of(entity));

        DemoEntity returned = service.getEntityById(entity.getId());

        assertEquals(entity.getId(), returned.getId());
    }

    @Test
    public void shouldThrowAlreadyExistsExceptionWhenUsernameExists(){
        given(repository.findByUsernameEquals(entity.getUsername())).willReturn(Optional.of(entity));

        assertThrows(AlreadyExistsException.class, () -> {
            service.saveEntity(entity);
        });
    }

    @Test
    public void shouldNotThrowExceptionWhenUsernameDoesntExist(){
        DemoEntity newEntity = new DemoEntity();
        newEntity.setId(2L);
        newEntity.setUsername("lubowa");

        given(repository.save(ArgumentMatchers.any(DemoEntity.class))).willReturn(newEntity);

        DemoEntity saved = service.saveEntity(newEntity);

        assertEquals(saved.getId(), newEntity.getId());
    }

    @Test
    public void shouldThrowInvalidIdentifierExceptionIfStringCannotBeConvertedToLong(){

        assertThrows(InvalidIdentifierException.class, () -> {
            service.getEntityById("dxndjk");
        });
    }

}
