package org.example;
/*
import javax.swing.*; // Importă biblioteca pentru interfața grafică
import java.awt.*; // Importă componentele pentru layout și dimensiuni
import java.awt.event.ActionListener; // Importă interfața pentru gestionarea evenimentelor de buton
import java.sql.Connection; // Importă clasa pentru conexiunea la baza de date
import java.sql.DriverManager; // Importă clasa pentru gestionarea conexiunii
import java.sql.SQLException; // Importă clasa pentru tratarea erorilor SQL
import org.example.Entities.Client; // Importă entitatea Client
import org.example.Entities.Car; // Importă entitatea Car
import org.example.Entities.CompanyDAO; // Importă clasa DAO pentru operațiuni pe baza de date

public class Main2 {
    public static void main(String[] args) {
        // Setează parametrii de conexiune la baza de date
        String url = "jdbc:mysql://localhost:3306/Rent_A_Car";
        String user = "root";
        String password = "SDA123";

        try (Connection connection = DriverManager.getConnection(url, user, password)) { // Creează conexiunea la baza de date
            CompanyDAO companyDAO = new CompanyDAO(connection); // Inițializează obiectul DAO pentru manipularea datelor

            JFrame frame = new JFrame("Rent a Car"); // Creează fereastra principală
            frame.setSize(1024, 768); // Setează dimensiunea ferestrei
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setează comportamentul la închiderea ferestrei
            frame.setLayout(new GridLayout(8, 1, 10, 10)); // Aranjează componentele într-o grilă cu 8 rânduri și 1 coloană, cu spațiere de 10px

            // Definește opțiunile meniului
            String[] options = {
                    "Register a Car", "Display all Cars", "Register a Client", "Display all Clients",
                    "Register a Review", "Display all Reviews", "Add a Rent"
            };

            // Creează acțiunile pentru fiecare buton
            ActionListener[] actions = new ActionListener[] {
                    e -> {
                        String carModel = JOptionPane.showInputDialog("Enter car model:"); // Afișează o fereastră pentru introducerea modelului
                        if (carModel != null) companyDAO.insertCar(new Car(carModel)); // Adaugă mașina în baza de date dacă utilizatorul introduce un model
                    },
                    e -> JOptionPane.showMessageDialog(frame, "Displaying all cars..."), // Mesaj pentru afișarea mașinilor
                    e -> {
                        String clientName = JOptionPane.showInputDialog("Enter client name:"); // Introducerea numelui clientului
                        String carModel = JOptionPane.showInputDialog("Enter car model:"); // Introducerea modelului de mașină
                        if (clientName != null && carModel != null)
                            companyDAO.registerClient(new Client(clientName), carModel); // Înregistrează clientul în baza de date
                    },
                    e -> JOptionPane.showMessageDialog(frame, "Displaying all clients..."), // Mesaj pentru afișarea clienților
                    e -> JOptionPane.showMessageDialog(frame, "Registering a review..."), // Mesaj pentru înregistrarea unei recenzii
                    e -> JOptionPane.showMessageDialog(frame, "Displaying all reviews..."), // Mesaj pentru afișarea recenziilor
                    e -> JOptionPane.showMessageDialog(frame, "Adding a rent...") // Mesaj pentru adăugarea unei închirieri
            };

            // Creează butoanele și le adaugă în fereastră
            for (int i = 0; i < options.length; i++) {
                JButton button = new JButton(options[i]); // Creează un buton cu textul din options[i]
                button.setFont(new Font("Arial", Font.BOLD, 20)); // Setează fontul butonului
                button.setPreferredSize(new Dimension(300, 80)); // Setează dimensiunea butonului
                button.addActionListener(actions[i]); // Adaugă acțiunea corespunzătoare butonului
                frame.add(button); // Adaugă butonul în fereastră
            }

            frame.setVisible(true); // Face fereastra vizibilă
        } catch (SQLException e) { // Prinde eventualele erori SQL
            e.printStackTrace(); // Afișează eroarea în consolă
        }
    }
}
*/