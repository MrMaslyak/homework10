
public class Bank {
    private Client[] clients;
    private int numberClients;

    public Bank(int maxClients) {
        this.clients = new Client[maxClients];
        this.numberClients = 0;
    }
    public void addClient(Client client) {
        if (numberClients < clients.length) {
            clients[numberClients] = client;
            numberClients++;
        } else {
            System.out.println("Банк заповнений. Неможливо додати нового клієнта.");
        }
    }
    public Client findClientName(String name) {
        for (int i = 0; i < numberClients; i++) {
            if (clients[i].getName().equals(name)) {
                return clients[i];
            }
        }
        return null;
    }
    public boolean transferMoney(Client sender, int senderScoreNumber, Client receiver, int receiverScoreNumber, int amount) {
        Score senderScore = null;
        Score receiverScore = null;
        for (Score score : sender.getScores()) {
            if (score.getNumberScore() == senderScoreNumber) {
                senderScore = score;
                break;
            }
        }
        for (Score score : receiver.getScores()) {
            if (score.getNumberScore() == receiverScoreNumber) {
                receiverScore = score;
                break;
            }
        }
        if (senderScore != null && receiverScore != null && senderScore.getBalance() >= amount) {

            senderScore.setBalance(senderScore.getBalance() - amount);
            receiverScore.setBalance(receiverScore.getBalance() + amount);


            String senderOperation = "Transfer to " + receiver.getName() + ": -" + amount;
            String receiverOperation = "Transfer from " + sender.getName() + ": +" + amount;

            String senderOperations = senderScore.getListOperation();
            senderScore.setListOperation(senderOperations + "\n" + senderOperation);

            String receiverOperations = receiverScore.getListOperation();
            receiverScore.setListOperation(receiverOperations + "\n" + receiverOperation);

            return true;
        }
        return false;
    }

}
class Score{
    private int numberScore;
    private int balance;
    private String listOperation;

    public Score(int numberScore, int balance, String listOperation) {
        this.numberScore = numberScore;
        this.balance = balance;
        this.listOperation = listOperation;
    }

    public int getNumberScore() {
        return numberScore;
    }

    public void setNumberScore(int numberScore) {
        this.numberScore = numberScore;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getListOperation() {
        return listOperation;
    }

    public void setListOperation(String listOperation) {
        this.listOperation = listOperation;
    }
    public void printOperationsHistory() {
        String[] operations = this.getListOperation().split("\n");
        System.out.println("Історія операцій для рахунку " + this.getNumberScore() + ":");
        for (String operation : operations) {
            System.out.println(operation);
        }
    }
}
    class Client{
    private String name;
    private String adress;
    private int listScore;
        private Score[] scores;

        public Client(String name, String address, int listScore) {
            this.name = name;
            this.adress = address;
            this.listScore = listScore;
            this.scores = new Score[listScore];
        }

        public Score[] getScores() {
            return scores;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }



        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public int getListScore() {
            return listScore;
        }

        public void setListScore(int listScore) {
            this.listScore = listScore;
        }

        public void setScores(int i, Score score) {
           scores[i] = score;
        }
    }
