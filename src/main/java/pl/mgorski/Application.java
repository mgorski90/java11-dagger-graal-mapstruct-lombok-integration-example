package pl.mgorski;

import pl.mgorski.service.MessageService;

public class Application {

    public static void main(String[] args) {
        MessageService messageService = DaggerMessageComponent
                .builder()
                .build()
                .messageService();

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setName("cONTent");
        messageService.putCorrected(messageDTO);

        MessageDTO differentDTO = new MessageDTO();
        differentDTO.setName("cONTent");
        messageService.putCorrected(differentDTO);

        System.out.println(messageService.findAll());
    }

}
