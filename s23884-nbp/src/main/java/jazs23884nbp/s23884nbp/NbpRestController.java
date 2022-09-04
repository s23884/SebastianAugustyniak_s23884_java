package jazs23884nbp.s23884nbp;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dom")
public class NbpRestController {

    final NbpSerivce nbpSerivce;

    public NbpRestController(NbpSerivce nbpSerivce) {
        this.nbpSerivce = nbpSerivce;
    }


    @GetMapping("/waluta/{code}/{waluta}/{startDate}/{endDate}")
    public NbpEntity all(@PathVariable String code, @PathVariable String waluta, @PathVariable  String startDate, @PathVariable String endDate){
        return nbpSerivce.getWaluta(code,waluta,startDate,endDate);
    }
    @GetMapping("/zloto")
    public String sam23(){
        return nbpSerivce.getZloto();
    }

}

