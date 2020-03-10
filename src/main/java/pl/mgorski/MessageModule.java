package pl.mgorski;

import dagger.Module;
import dagger.Provides;
import pl.mgorski.mapper.PersonMapper;
import pl.mgorski.mapper.PersonMapperImpl;
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
    PersonMapper producePersonMapper() {
        return new PersonMapperImpl();
    }

    @Provides
    @Singleton
    MessageService messageService() {
        return new MessageService(produceMessageRepository(), producePersonMapper());
    }

}
