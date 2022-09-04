package jazs23884nbp.s23884nbp;

import org.springframework.web.client.RestTemplate;

public class NbpSerivce {
        final Repository2 repository2;
        final RestTemplate restTemplate;


        public NbpSerivce(Repository2 repository2, RestTemplate restTemplate) {
            this.repository2 = repository2;
            this.restTemplate = restTemplate;
        }


    public NbpEntity getWaluta(  String code,String waluta, String startDate, String endDate) {
        NbpEntity exchange = restTemplate.getForEntity("http://api.nbp.pl/api/exchangerates/rates/" + code
                +"/"+waluta+"/"+startDate+"/"+endDate+"/", NbpEntity.class).getBody();
        return repository2.save(exchange);

    }

    public String getZloto() {
        String exchange = restTemplate.getForEntity("https://api.nbp.pl/api/cenyzlota/", String.class).getBody();

        return exchange;

    }

}
