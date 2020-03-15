package pl.mgorski.mapper;

import org.mapstruct.Mapper;
import pl.mgorski.Message;
import pl.mgorski.MessageDTO;

import javax.inject.Singleton;

@Singleton
@Mapper
public interface MessageMapper {

    Message fromDto(MessageDTO input);

    MessageDTO toDto(Message message);

}
