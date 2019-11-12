package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/greeting/time")
    public Greeting  contagem(@RequestParam(value="hour", defaultValue="1") int hour) {  

        if (hour <= 12) {
            return new Greeting(counter.incrementAndGet(), "bom dia"); 
        } else if (hour <=  19) {
            return new Greeting(counter.incrementAndGet(), "boa tarde");
        } else {
            return new Greeting(counter.incrementAndGet(), "boa noite");
        } 

    }

    @RequestMapping("/greeting/{id}")
    public Greeting greetingId(@PathVariable(value="id") int id) {
        
        ArrayList<String> motivacao = new ArrayList<>();

        motivacao.add("penso. logo desisto!");
        motivacao.add("pra que desistir amanha se vc pode desistir hoje");
        motivacao.add("a cada tentativa uma nova derrota");
        motivacao.add("na hora certa tudo vai dar errado");
        motivacao.add("dias de luta. dias de derrota");
        motivacao.add("o pior ainda esta por vir");
        motivacao.add("nunca deixe alguem dizer q vc nao é capaz, va la e diga vc mesmo");
        motivacao.add("pare de tentar e comece a desistir");
        motivacao.add("quanto maior sua luta maior sua derrota");
        motivacao.add("fui brincar de lutinha com a vida e to apanhando ate hoje");
        motivacao.add("se ainda nao deu errado é porque não acabou");

      return new Greeting(counter.incrementAndGet(), motivacao.get(id));

    }
}