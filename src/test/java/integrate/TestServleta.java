package integrate;

import client.Client;
import model.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import server.Server;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

public class TestServleta {

    Client client;

    private static Stream<Arguments> dataArgumentsProvider(){
        return Stream.of(
                Arguments.of(new Data(1))
        );
    }

    @BeforeEach
    public void init(){
        client = new Client();
    }

    @ParameterizedTest
    @MethodSource("dataArgumentsProvider")
    public void sendAndAcceptTest(Data data){
        client = new Client(1);
        client.send();

        Server.processing(data);

        assertThat(Server.getResponseList().size()).isEqualTo(client.getAccumulator() + 1);
    }
}
