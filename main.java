import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Black {

    public static int randomise() {
        int min = 1;
        int max = 10;

        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    public static void main(String[] args) {

        ArrayList<Integer> carteCompte1 = new ArrayList<Integer>();
        ArrayList<Integer> carteCompte2 = new ArrayList<Integer>();

        // Étape 1 - Création compte 1.
        System.out.println("Prenez une carte");

        int compte1 = 0;

        carteCompte1.add(randomise());
        System.out.println("Votre première carte est " + carteCompte1.get(0));
        carteCompte1.add(randomise());
        System.out.println("Votre deuxième carte est " + carteCompte1.get(1));

        compte1 = carteCompte1.stream().reduce(0, (a, b) -> a + b);

        System.out.println("Le compte du joueur est de " + compte1);

        // Étape 2 - Création compte 2.

        int compte2 = 0;

        carteCompte2.add(randomise());
        System.out.println("La première carte du croupier est " + carteCompte2.get(0));
        carteCompte2.add(randomise());
        System.out.println("La deuxième carte du croupier est en face caché.");

        compte2 = carteCompte2.stream().reduce(0, (a, b) -> a + b);

        // Étape 3 - Début du jeu.

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Souhaitez vous tirer une carte ? (si non, le jeu s'arrête.)");
            String reponse = sc.nextLine();
            // System.out.println(reponse);
            if (reponse.equals("Oui")) {
                // System.out.println("coucoiu");

                // for (int i = 2; i < carteCompte1.size(); i++) {

                while (reponse.equals("Oui")) {
                    // int i = carteCompte1.size();
                    System.out.println("Vous avez voter : Oui");
                    carteCompte1.add(randomise());
                    System.out.println(
                            "Votre " + carteCompte1.size() + " éme carte est "
                                    + carteCompte1.get(carteCompte1.size() - 1));

                    compte1 += carteCompte1.get(carteCompte1.size() - 1);

                    System.out.println("La sommes de vos cartes est de " + compte1);

                    if (compte1 > 21) {
                        System.out.println("Vous avez perdu !!!");
                    }
                    if (compte2 <= 16) {
                        System.out.println("Le croupier pioche une nouvelle carte");

                        carteCompte2.add(randomise());
                        System.out.println(
                                "La " + carteCompte2.size() + " éme carte du croupier est le " + carteCompte2.get(
                                        carteCompte2.size() - 1));

                        compte2 += carteCompte2.get(carteCompte2.size() - 1);

                        System.out.println("Le compte du croupier est de " + compte2);
                    }

                    if (compte2 >= 17) {
                        System.out.println("Le croupier ne peut pas tirer de nouvelle carte");
                    }

                    if (compte2 > 21) {
                        System.out.println("Le croupier a perdu");
                        break;
                    }

                    System.out.println("Souhaitez vous tirer une carte ? (si non, le jeu s'arrête.)");
                    reponse = sc.nextLine();
                }
                // }
            } else if (reponse.equals("Non")) {

                System.out.println("Vous avez voter : Non");
                System.out.println("Vous arrête de tirer des cartes");
                System.out.println("Le compte du joueur est de : " + compte1);
                System.out.println("Le compte du croupier est de : " + compte2);

                if (compte1 < 21 && compte2 < 21) {
                    if (compte1 > compte2) {
                        System.out.println("Vous avez gagné !!!");
                    } else {
                        System.out.println("Le croupier a gagné");
                    }
                }

            } else {
                System.out.println("Je n'ai pas compris votre réponse, Oui ou Non ?");
            }

        }

        if (compte1 < 21 && compte2 < 21) {
            if (compte1 > compte2) {
                System.out.println("Le joueur a gagné");
            } else {
                System.out.println("Le croupier a gagné");
            }
        }

    }
}
