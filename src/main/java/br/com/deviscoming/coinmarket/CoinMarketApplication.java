package br.com.deviscoming.coinmarket;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import br.com.deviscoming.domain.Coin;

@SpringBootApplication
public class CoinMarketApplication {

	private static final Logger log = LoggerFactory.getLogger(CoinMarketApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CoinMarketApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{		
		return args -> {
			Coin[] coins = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/", Coin[].class);
			
			// VERGE
			Object[] vergeArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("verge")).toArray();
			log.info("Name : " + ((Coin) vergeArray[0]).getName());
			
			log.info(" Price USD :" + Double.valueOf(((Coin) vergeArray[0]).getPrice_usd()));
			
			log.info("-----------------------------------------------------------------");
			
			
			// DIGIBYTE
			Object[] digibyteArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("digibyte")).toArray();
			log.info("Name : " + ((Coin) digibyteArray[0]).getName());
			
			log.info("Price USD: " + Double.valueOf(((Coin) digibyteArray[0]).getPrice_usd()));
			
			log.info("-----------------------------------------------------------------");
			
			// CARDANO
			Object[] cardanoArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("cardano")).toArray();
			log.info("Name : " + ((Coin) cardanoArray[0]).getName());
			
			log.info("Price USD: " + Double.valueOf(((Coin) cardanoArray[0]).getPrice_usd()));
			
			log.info("-----------------------------------------------------------------");
					
			// BTC
			Object[] btcArray = Arrays.stream(coins).filter(x -> x.getName().equalsIgnoreCase("bitcoin")).toArray();
			log.info("Name : " + ((Coin) btcArray[0]).getName());
			
			log.info("Price USD: " + Double.valueOf(((Coin) btcArray[0]).getPrice_usd()));
			
			log.info("-----------------------------------------------------------------");
		};
	}
	
}
