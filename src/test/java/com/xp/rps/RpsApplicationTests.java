package com.xp.rps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RpsApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		System.out.println(Throw.PAPER);
	}

	@Test
	void play() {
		ResponseEntity<Round> response = restTemplate.postForEntity("/play",new Round(Throw.ROCK, Throw.PAPER), Round.class);
		assertEquals(Result.P2_WINS, response.getBody().getResult());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void createGame() {
		ResponseEntity<Integer> response = restTemplate.postForEntity("/game", new Game("Ray","James",3,"Buy a coffee machine"),Integer.class);
		ResponseEntity<Game>  game = restTemplate.getForEntity("/game/"+response.getBody(),Game.class);
		assertEquals("Ray",game.getBody().getPlayer1());
	}

	@Test
	void playGame() {
		ResponseEntity<Integer> response = restTemplate.postForEntity("/game", new Game("Ray","James",3,"Buy a coffee machine"),Integer.class);
		int gameID=response.getBody();

		restTemplate.postForEntity("/game/"+gameID+"/round",new Round(Throw.ROCK, Throw.PAPER),Integer.class);
		restTemplate.postForEntity("/game/"+gameID+"/round",new Round(Throw.ROCK, Throw.PAPER),Integer.class);

		ResponseEntity<Game>  game = restTemplate.getForEntity("/game/"+gameID,Game.class);
		assertEquals("Ray",game.getBody().getPlayer1());
		assertEquals(Result.P2_WINS,game.getBody().getResult());

		System.out.println("===>"+game.getBody().toString());
	}
}
