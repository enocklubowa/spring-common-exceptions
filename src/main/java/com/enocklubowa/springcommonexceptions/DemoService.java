package com.enocklubowa.springcommonexceptions;

import com.enocklubowa.springcommonexceptions.exception.AlreadyExistsException;
import com.enocklubowa.springcommonexceptions.exception.InvalidIdentifierException;
import com.enocklubowa.springcommonexceptions.exception.NotFoundException;
import com.enocklubowa.springcommonexceptions.model.DemoEntity;
import com.enocklubowa.springcommonexceptions.repository.DemoEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private final DemoEntityRepository repository;

    public DemoService(DemoEntityRepository repository){
        this.repository = repository;
    }

    /**
     * Check if an entity with the speicified id exits
     * @param id
     * @return
     */
    public DemoEntity getEntityById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException(DemoEntity.class, id));
    }

    /**
     * Check an entity with the specified username already exits
     * @param entity
     * @return
     */
    public DemoEntity saveEntity(DemoEntity entity){
        if(repository.findByUsernameEquals(entity.getUsername()).isPresent()){
            throw new AlreadyExistsException(DemoEntity.class, entity.getUsername());
        }
        return repository.save(entity);
    }

    /**
     * When some clients provide a String Identifier then it should be
     * converted to a Long and that fails then throw an InvalidIdentifierException
     * @param id
     * @return
     */
    public DemoEntity getEntityById(String id){
        try{
            Long.parseLong(id);
        }
        catch(Exception e){
            throw new InvalidIdentifierException(id);
        }

        return repository.findById(Long.parseLong(id)).orElseThrow(
                () -> new NotFoundException(DemoEntity.class, id));
    }
}
