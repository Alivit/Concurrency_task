package server;

import java.util.stream.Stream;

import client.Client;
import model.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ServerTest {

    private static Stream<Arguments> dataArgumentsProvider(){
        return Stream.of(
                Arguments.of(new Data(12)),
                Arguments.of(new Data(13)),
                Arguments.of(new Data(14)),
                Arguments.of(new Data(15))
        );
    }

    @ParameterizedTest
    @MethodSource("dataArgumentsProvider")
    public void testProcessing(Data data){
        Server.processing(data);

        assertThat(Server.getResponseList()).isNotEmpty();
    }

}