package pl.mgorski.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import pl.mgorski.Message;
import pl.mgorski.MessageDTO;
import pl.mgorski.mapper.MessageMapper;
import pl.mgorski.repository.MessageRepository;

import javax.inject.Singleton;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Singleton
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public void putCorrected(MessageDTO messageDTO) {
        Message message = messageMapper.fromDto(messageDTO);
        // business logic simulation: convert to lowercase and capitalize
        message.setName(StringUtils.capitalize(StringUtils.lowerCase(messageDTO.getName())));
        messageRepository.put(message);
    }

    public List<MessageDTO> findAll() {
        return messageRepository
                .findAll()
                .stream()
                .map(messageMapper::toDto)
                .collect(toList());
    }

}
