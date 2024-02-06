package ba.edu.ibu.exams.finals.final3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExam {
    public static void main(String[] args) throws IOException {
        socketServer(2345);
    }

    public static void socketServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket connection = serverSocket.accept();
                OutputStream outputStream = connection.getOutputStream();

                outputStream.write(("rank;cca3;country;continent;2023 population;2022 population;2020 population;area (km²);density (km²);growth rate;world percentage\n" + "1;IND;India;Asia;1428627663;1417173173;1396387127;3287590;481;0.81%;17.85%\n" + "2;CHN;China;Asia;1425671352;1425887337;1424929781;9706961;151;-0.02%;17.81%\n" + "3;USA;United States;North America;339996563;338289857;335942003;9372610;37;0.50%;4.25%\n" + "4;IDN;Indonesia;Asia;277534122;275501339;271857970;1904569;148;0.74%;3.47%").getBytes());

                connection.close();
                outputStream.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
