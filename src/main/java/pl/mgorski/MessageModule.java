package pl.mgorski;

import dagger.Module;
import dagger.Provides;
import org.mapstruct.factory.Mappers;
import pl.mgorski.mapper.MessageMapper;
import pl.mgorski.repository.MessageRepository;
import pl.mgorski.service.MessageService;

import javax.inject.Singleton;

@Module
public class MessageModule {

    @Provides
    @Singleton
    MessageRepository produceMessageRepository() {
        return new MessageRepository();
    }

    @Provides
    @Singleton
    MessageMapper producePersonMapper() {
        // to support this native-image.properties was added (educational purpose) and reflection_config.json, but you can go without this
        // just returning plain compile-time dependency new MessageMapperImpl()
        // than you can remove reflection_config.json
        return Mappers.getMapper(MessageMapper.class);
    }

    @Provides
    @Singleton
    MessageService messageService() {
        return new MessageService(produceMessageRepository(), producePersonMapper());
    }

}
