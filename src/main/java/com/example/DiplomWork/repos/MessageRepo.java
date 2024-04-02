package com.example.DiplomWork.repos;

import com.example.DiplomWork.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {
}
