package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameHintTest {
	@DisplayName("스트라이크 갯수를 센다.")
	@ParameterizedTest
	@CsvSource(value = {"456:0", "425:1", "423:2", "315:0"}, delimiter = ':')
	void countStrike(String input, int count) throws Exception {
		// Given
		String answer = "123";

		// When
		GameHint gameHint = new GameHint(answer, input);

		// Then
		assertThat(gameHint.countStrike()).isEqualTo(count);
	}

	@DisplayName("볼 갯수를 센다.")
	@ParameterizedTest
	@CsvSource(value = {"456:0", "415:1", "315:2", "231:3", "132:2"}, delimiter = ':')
	void countBall(String input, int count) throws Exception {
		// Given
		String answer = "123";

		// When
		GameHint gameHint = new GameHint(answer, input);

		// Then
		assertThat(gameHint.countBall()).isEqualTo(count);
	}

	@DisplayName("스트라이크나 볼이 없으면 나싱이다.")
	@Test
	void isNothing() throws Exception {
		// Given
		String answer = "123";
		String input = "456";

		// When
		GameHint gameHint = new GameHint(answer, input);

		// Then
		assertThat(gameHint.isNothing()).isTrue();
	}
}
