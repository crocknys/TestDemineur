class Mines {

    static int[][] tabMines(Tableau tableau) {
        int[][] grille = new int[tableau.getHauteur()][tableau.getLargeur()];
        return grille;
    }

    static int[][] minageTerrain(int[][] grille, int nbrMines) {

        for (int a = 0; a < nbrMines; a++) {

            int mineHauteur = (int) (Math.random() * grille.length);
            int mineLargeur = (int) (Math.random() * grille[0].length);

            if (grille[mineHauteur][mineLargeur] != 8) {
                grille[mineHauteur][mineLargeur] = 8;
            } else {
                a--;
            }
        }

        return grille;
    }

    static void printGrille(int[][] grille) {

        for (int a = 0; a < grille.length; a++) {
            for (int b = 0; b < grille[a].length; b++) {
                System.out.print(grille[b][a]);
            }
            System.out.println();
        }
    }

    static void rendering(int hauteur, int largeur, int nmbrMines) {

        Tableau game = new Tableau(hauteur, largeur);

        int[][] games = Mines.tabMines(game);
        Mines.minageTerrain(games, nmbrMines);

        System.out.println("Longeur: " + games[0].length);
        System.out.println("hauteur: " + games.length);
        System.out.println("nombre de mines: " + nmbrMines);
        System.out.println(" ");

        Mines.printGrille(games);

    }

}
