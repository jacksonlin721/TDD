package test2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

public class ActionHandlerTest {
    @Mock
    Service service;
    @Captor
    ArgumentCaptor<Callback<Response>> callbackCaptor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenServiceWithValidResponse_whenCallbackReceived_thenProcessed() {
        ActionHandler handler = new ActionHandler(service);
        handler.doAction();

        verify(service).doAction(anyString(), callbackCaptor.capture());

        Callback<Response> callback = callbackCaptor.getValue();
        Response response = new Response();
        callback.reply(response);

        String expectedMessage = "Successful data response";
        Data data = response.getData();
        assertEquals(
                "Should receive a successful message: ",
                expectedMessage, data.getMessage());
    }
}