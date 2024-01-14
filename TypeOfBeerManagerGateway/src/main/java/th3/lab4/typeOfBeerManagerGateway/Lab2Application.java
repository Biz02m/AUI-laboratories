package th3.lab4.typeOfBeerManagerGateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab2Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${meneger.beer.url}") String beerUrl,
			@Value("${meneger.typeOfBeer.url}") String typeOfBeerUrl,
			@Value("${meneger.gateway.host}") String host
	){
		return builder.routes()
				.route("typeOfBeers",route->route
						.host(host)
						.and()
						.path(
								"/api/typeOfBeers/{uuid}",
								"/api/typeOfBeers"
						)
						.uri(typeOfBeerUrl)
				)
				.route("beers",route->route
						.host(host)
						.and()
						.path(
								"/api/beers/**",
								"/api/beers",
								"/api/typeOfBeers/{uuid}/beers",
								"/api/typeOfBeers/{uuid}/beers/**"

						)
						.uri(beerUrl)
				)
				.build();
	}

}
