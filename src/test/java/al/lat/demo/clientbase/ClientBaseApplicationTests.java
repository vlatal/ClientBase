package al.lat.demo.clientbase;

import al.lat.demo.clientbase.controller.AddressController;
import al.lat.demo.clientbase.controller.ClientController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClientBaseApplicationTests {

    @Autowired
    private ClientController clientController;
    @Autowired
    private AddressController addressController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(clientController).isNotNull();
        assertThat(addressController).isNotNull();
    }
}