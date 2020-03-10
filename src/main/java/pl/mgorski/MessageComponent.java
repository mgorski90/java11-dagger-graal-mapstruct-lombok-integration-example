package pl.mgorski;

import dagger.Component;
import pl.mgorski.service.MessageService;

import javax.inject.Singleton;

@Component(modules = MessageModule.class)
@Singleton
public interface MessageComponent {

    MessageService messageService();

}
