import java.util.Random;
import java.util.Scanner;

class Black {

    private static final Random saisieUtilisateur = null;

    public static int randomise() {
        int min = 1;
        int max = 10;

        Random random = new Random();
        return random.nextInt(max + 1 - min) + min;
    }

    public static void main(String[] args) {

        // étape1
        System.out.println("Prenez une carte");
        int min = 1;
        int max = 10;

        /*
         * int value;
         * value = randomise();
         * System.out.println("votre carte est le numéro " + value);
         */

        // étape2 création compte 1

        int compte1;

        int value1;
        value1 = randomise();
        System.out.println("votre première carte est" + " " + value1);

        int value2;
        value2 = randomise();
        System.out.println("votre deuxième carte est" + " " + value2);

        compte1 = value1 + value2;

        System.out.println("le compte du joueur est de" + " " + compte1);

        // étape2 création compte 2

        int compte2;

        int value3;
        value3 = randomise();
        System.out.println("votre première carte est " + value3);

        int value4;
        value4 = randomise();
        // System.out.println("votre deuxième carte est " + value4);
        value4 = value4;

        compte2 = value3;

        System.out.println("le compte du croupier est de" + " " + compte2);

        // étape 3 Début du jeu

        Scanner sc = new Scanner(System.in);

        System.out.println("Débuter le jeu ? o/n");
        String reponse = sc.nextLine();

        if (reponse == "Oui") {
            int a = sc.nextInt();
            int b = 1;

            System.out.println("Souhaitez vous tirer une carte ? (si non, le jeu s'arrête.)");

            System.out.println("Vous avez saisi le nombre : " + a);

        } else if (reponse == "Non") {

            System.out.println("Dommage, une prochaine fois alors !");

        } else {
            System.out.println("Je n'ai pas compris, Oui ou Non ?");

        }

        if (a > b) {
            Random random5 = new Random();

            int value5 = random5.nextInt(max + min) + min;
            System.out.println("votre troisième carte est" + " " + value5);

            compte1 = compte1 + value5;

            System.out.println("le compte du joueur est de" + " " + compte1);
        } else {
            compte1 = value2 + value3;
            System.out.println("Le joueur arrête de tirer");

        }
        // Scanner sc = new Scanner(System.in);

        if (compte1 > 21) {
            System.out.println("le joueur a perdu");
        } else {
            System.out.println("Si le joueur veut tirer une nouvelle carte saisies 2 sinon saisies 0:");
            int c = sc.nextInt();
            System.out.println("Vous avez saisi le nombre : " + c);

            if (c > b) {
                Random random6 = new Random();

                int value6 = random6.nextInt(max + min) + min;
                System.out.println("votre quatrième carte est" + " " + value6);

                compte1 = compte1 + value6;

                System.out.println("le compte du joueur est de" + " " + compte1);
            } else {
                compte1 = compte1;
                if (compte1 > 21) {
                    System.out.println("Le joueur arrête de tirer");
                }
            }

            System.out.println("Si le joueur veut tirer une nouvelle carte saisies 2 sinon saisies 0:");
            int d = sc.nextInt();
            System.out.println("Vous avez saisi le nombre : " + d);

            if (d > b) {
                Random random8 = new Random();

                int value8 = random8.nextInt(max + min) + min;
                System.out.println("votre cinquième carte est" + " " + value8);

                compte1 = compte1 + value8;

                System.out.println("le compte du joueur est de" + " " + compte1);
            } else {
                compte1 = compte1;
                if (compte1 > 21) {
                    System.out.println("Le joueur arrête de tirer");
                }

            }

            System.out.println("la carte cachée est " + value4);
            compte2 = value3 + value4;
            System.out.println("le compte du croupier est de " + compte2);
            if (compte2 >= 17) {
                compte2 = value3 + value4;
                System.out.println("le croupier ne peut pas tirer de nouvelle carte");
            }
            if (compte2 <= 16) {
                System.out.println("le croupier doit piocher une nouvelle carte");

                Random random7 = new Random();

                int value7 = random7.nextInt(max + min) + min;
                System.out.println("votre troisième carte est" + " " + value7);

                compte2 = compte2 + value7;

                System.out.println("le compte du croupier est de" + " " + compte2);

            }

            if (compte2 > 21) {
                System.out.println("le croupier a perdu");
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
}