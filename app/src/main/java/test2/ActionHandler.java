package test2;

public class ActionHandler {
    Service service;

    ActionHandler(Service service) {
        this.service = service;
    }

    public void doAction() {
        service.doAction("our-request", new Callback<Response>() {
            @Override
            public void reply(Response response) {
                handleResponse(response);
            }
        });
    }

    private void handleResponse(Response response) {
        if (response.isValid()) {
            response.setData(new Data("Successful data response"));
        }
    }
}
