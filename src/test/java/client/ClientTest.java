package client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {

    Client client;

    @BeforeEach
    public void init(){
        client = new Client();
    }

    @Test
    public void testAccumulator(){
        client.send();

        assertThat(client.getAccumulator()).isEqualTo(5050);
    }

    @Test
    public void testAccumulatorWithSize5(){
        Client client1 = new Client(5);
        client1.send();

        assertThat(client1.getAccumulator()).isEqualTo(15);
    }

    @Test
    public void testSizeRequestList(){
        client.send();

        assertThat(client.getRequestList().size()).isEqualTo(0);
    }

}