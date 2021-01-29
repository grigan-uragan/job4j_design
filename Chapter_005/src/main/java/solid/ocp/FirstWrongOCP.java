package solid.ocp;

public class FirstWrongOCP {
    private static class ClientWeb {
        private Server server;

        public ClientWeb(Server server) {
            this.server = server;
        }

        public void sendRequest(String request) {
            server.doGet(request);
        }

    }

    private static class Server {
        public void doGet(String request) {
            System.out.println("Hello " + request);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        ClientWeb client = new ClientWeb(server);
        client.sendRequest("Ivan");
    }
}
